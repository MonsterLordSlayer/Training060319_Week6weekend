package com.example.week6weekend

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Main : Parcelable {

    @SerializedName("temp")
    @Expose
    var temp: Float? = null
    @SerializedName("pressure")
    @Expose
    var pressure: Float? = null
    @SerializedName("humidity")
    @Expose
    var humidity: Float? = null
    @SerializedName("temp_min")
    @Expose
    var tempMin: Float? = null
    @SerializedName("temp_max")
    @Expose
    var tempMax: Float? = null

    protected constructor(`in`: Parcel) {
        this.temp = `in`.readValue(Float::class.java.classLoader) as Float
        this.pressure = `in`.readValue(Float::class.java.classLoader) as Float
        this.humidity = `in`.readValue(Float::class.java.classLoader) as Float
        this.tempMin = `in`.readValue(Float::class.java.classLoader) as Float
        this.tempMax = `in`.readValue(Float::class.java.classLoader) as Float
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param humidity
     * @param pressure
     * @param tempMax
     * @param temp
     * @param tempMin
     */
    constructor(temp: Float?, pressure: Float?, humidity: Float?, tempMin: Float?, tempMax: Float?) : super() {
        this.temp = temp
        this.pressure = pressure
        this.humidity = humidity
        this.tempMin = tempMin
        this.tempMax = tempMax
    }

    fun withTemp(temp: Float?): Main {
        this.temp = temp
        return this
    }

    fun withPressure(pressure: Float?): Main {
        this.pressure = pressure
        return this
    }

    fun withHumidity(humidity: Float?): Main {
        this.humidity = humidity
        return this
    }

    fun withTempMin(tempMin: Float?): Main {
        this.tempMin = tempMin
        return this
    }

    fun withTempMax(tempMax: Float?): Main {
        this.tempMax = tempMax
        return this
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(temp)
        dest.writeValue(pressure)
        dest.writeValue(humidity)
        dest.writeValue(tempMin)
        dest.writeValue(tempMax)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Parcelable.Creator<Main> = object : Creator<Main> {


            override fun createFromParcel(`in`: Parcel): Main {
                return Main(`in`)
            }

            override fun newArray(size: Int): Array<Main?> {
                return arrayOfNulls(size)
            }

        }
    }

}
