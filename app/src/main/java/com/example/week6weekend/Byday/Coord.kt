package com.example.week6weekend.Byday

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coord : Parcelable {

    @SerializedName("lat")
    @Expose
    var lat: Float? = null
    @SerializedName("lon")
    @Expose
    var lon: Float? = null

    protected constructor(`in`: Parcel) {
        this.lat = `in`.readValue(Float::class.java.classLoader) as Float
        this.lon = `in`.readValue(Float::class.java.classLoader) as Float
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param lon
     * @param lat
     */
    constructor(lat: Float?, lon: Float?) : super() {
        this.lat = lat
        this.lon = lon
    }

    fun withLat(lat: Float?): Coord {
        this.lat = lat
        return this
    }

    fun withLon(lon: Float?): Coord {
        this.lon = lon
        return this
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(lat)
        dest.writeValue(lon)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Creator<Coord> = object : Creator<Coord> {


            override fun createFromParcel(`in`: Parcel): Coord {
                return Coord(`in`)
            }

            override fun newArray(size: Int): Array<Coord?> {
                return arrayOfNulls(size)
            }

        }
    }

}
