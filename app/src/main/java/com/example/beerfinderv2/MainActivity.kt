package com.example.beerfinderv2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SearchView

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beerfinderv2.databinding.ActivityMainBinding
import okio.IOException
import retrofit2.HttpException



const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var todoAdapter: TodoAdapter

    private lateinit var todo: Todo



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()

        binding.editTextSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(query != null) {

                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })

        binding.RecycleView.addItemDecoration(

            MarginItemDecoration(resources.getDimensionPixelSize(R.dimen.padding_medium))
        )

        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.api.getTodos()
            } catch (e: IOException) {
                Log.e(TAG, "IOException, you might not have internet connection")
                return@launchWhenCreated

            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, unexpected response")
                return@launchWhenCreated

            }
            if(response.isSuccessful && response.body() != null) {
                todoAdapter.todos = response.body()!!
            } else {
                Log.e(TAG, "Response not successful")
            }

        }

        todoAdapter.onItemClick = {
            val intent = Intent(this@MainActivity, DetailScreen::class.java)
            intent.putExtra("description", it)
            intent.putExtra("Image", it)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() = binding.RecycleView.apply {
        todoAdapter = TodoAdapter()
        adapter = todoAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)

    }
}



