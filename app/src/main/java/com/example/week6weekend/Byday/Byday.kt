package com.example.week6weekend.Byday

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Byday : Parcelable {

    @SerializedName("cod")
    @Expose
    var cod: String? = null
    @SerializedName("message")
    @Expose
    var message: Float? = null
    @SerializedName("cnt")
    @Expose
    var cnt: Int? = null
    @SerializedName("list")
    @Expose
    var list: kotlin.collections.List<List>? = null
    @SerializedName("city")
    @Expose
    var city: City? = null

    protected constructor(`in`: Parcel) {
        this.cod = `in`.readValue(String::class.java.classLoader) as String
        this.message = `in`.readValue(Float::class.java.classLoader) as Float
        this.cnt = `in`.readValue(Int::class.java.classLoader) as Int
        `in`.readList(this.list!!, List::class.java!!.getClassLoader())
        this.city = `in`.readValue(City::class.java.classLoader) as City
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param message
     * @param cnt
     * @param cod
     * @param list
     * @param city
     */
    constructor(
        cod: String,
        message: Float?,
        cnt: Int?,
        list: kotlin.collections.List<List>,
        city: City
    ) : super() {
        this.cod = cod
        this.message = message
        this.cnt = cnt
        this.list = list
        this.city = city
    }

    fun withCod(cod: String): Byday {
        this.cod = cod
        return this
    }

    fun withMessage(message: Float?): Byday {
        this.message = message
        return this
    }

    fun withCnt(cnt: Int?): Byday {
        this.cnt = cnt
        return this
    }

    fun withList(list: kotlin.collections.List<List>): Byday {
        this.list = list
        return this
    }

    fun withCity(city: City): Byday {
        this.city = city
        return this
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(cod)
        dest.writeValue(message)
        dest.writeValue(cnt)
        dest.writeList(list)
        dest.writeValue(city)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Creator<Byday> = object : Creator<Byday> {


            override fun createFromParcel(`in`: Parcel): Byday {
                return Byday(`in`)
            }

            override fun newArray(size: Int): Array<Byday?> {
                return arrayOfNulls(size)
            }

        }
    }

}
