package com.example.beerfinderv2

import android.os.Parcel
import android.os.Parcelable

data class Todo(
    val abv: Float,

    val brewers_tips: String,

    val description: String,
    val ebc: Float,

//    val food_paring: String, // doesnt seem to work as List<String> need to fix this later
    val ibu: Float,
    val image_url: String,
    val name: String,
//
    val srm: Float,
    val tagline: String,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readFloat(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readFloat(),
//        parcel.readString()!!,
        parcel.readFloat(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readFloat(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeFloat(abv)
        parcel.writeString(brewers_tips)
        parcel.writeString(description)
        parcel.writeFloat(ebc)
        parcel.writeFloat(ibu)
        parcel.writeString(image_url)
        parcel.writeString(name)
        parcel.writeFloat(srm)
        parcel.writeString(tagline)
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


