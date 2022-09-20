package com.example.beerfinderv2


import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.beerfinderv2.databinding.ItemTodoBinding
import com.squareup.picasso.Picasso

class BeerRVAdapter : RecyclerView.Adapter<BeerRVAdapter.TodoViewHolder>(){

    var onItemClick : ((BeerDataStorage) -> Unit)? = null

    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    private  val diffCallback = object : DiffUtil.ItemCallback<BeerDataStorage>() {
        override fun areItemsTheSame(oldItem: BeerDataStorage, newItem: BeerDataStorage): Boolean {
            return  oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: BeerDataStorage, newItem: BeerDataStorage): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var todos: List<BeerDataStorage>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

    override fun getItemCount() = todos.size



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(ItemTodoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            val todo = todos[position]
            beerNameCardView.text = todo.name
            taglineCardView.text = todo.tagline
            abvCardView.text = "abv: " + todo.abv.toString()
            Picasso.get().load(todo.image_url).into(apiImgGoesHere)
            holder.itemView.setOnClickListener{
                onItemClick?.invoke(todo)
            }

        }
    }


}