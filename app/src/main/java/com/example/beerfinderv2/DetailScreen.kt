package com.example.beerfinderv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)

        val beer = intent.getParcelableExtra<Todo>("description")
        if (beer !=null){
            val textView : TextView = findViewById(R.id.detailText)
            val imageView : ImageView = findViewById(R.id.imageviewdetail)
            textView.text = beer.name
            Picasso.get().load(beer.image_url).into(imageView)
        }
    }
}