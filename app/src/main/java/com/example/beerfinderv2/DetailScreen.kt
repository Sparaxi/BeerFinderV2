package com.example.beerfinderv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.beerfinderv2.databinding.ActivityDetailScreenBinding
import com.squareup.picasso.Picasso

@Suppress("DEPRECATION")
class DetailScreen : AppCompatActivity() {

    private lateinit var binding: ActivityDetailScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val beer = intent.getParcelableExtra<BeerDataStorage>("description")
        if (beer !=null){
            binding.detailText.text = beer.name
            binding.tagLine.text = beer.tagline
            binding.abv.text = "abv: " + beer.abv
            binding.srm.text = "srm: " + beer.srm
            binding.ebc.text = "ebc: " + beer.ebc
            binding.ibu.text = "ibu: " + beer.ibu
            binding.descriptionBeer.text = beer.description

            Picasso.get().load(beer.image_url).into(binding.imageviewdetail)
        }
    }
}