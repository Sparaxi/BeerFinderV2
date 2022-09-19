package com.example.beerfinderv2

import android.os.Parcel
import android.os.Parcelable

data class Todo(
//    val abv: Double,
//
//    val brewers_tips: String,
//
//    val description: String,
//    val ebc: Float,
//
//    val food_paring: List<String>,
//    val ibu: Float,
//    val id: Float,
    val image_url: String,
    val name: String,
//
//    val srm: Float,
//    val tagline: String,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(image_url)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Todo> {
        override fun createFromParcel(parcel: Parcel): Todo {
            return Todo(parcel)
        }

        override fun newArray(size: Int): Array<Todo?> {
            return arrayOfNulls(size)
        }
    }
}
