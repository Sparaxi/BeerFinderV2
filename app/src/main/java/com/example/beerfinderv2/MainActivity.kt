package com.example.beerfinderv2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beerfinderv2.databinding.ActivityMainBinding
import okio.IOException
import retrofit2.HttpException



const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var todoAdapter: TodoAdapter

    private lateinit var Todo : Todo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()

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

        val beerArrayStorage = arrayOf(Todo.toString())



    }




    private fun setupRecyclerView() = binding.RecycleView.apply {
        todoAdapter = TodoAdapter()
        adapter = todoAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)

    }
}

