package com.example.week6weekend.Byday

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Main : Parcelable {

    @SerializedName("temp")
    @Expose
    var temp: Float? = null
    @SerializedName("temp_min")
    @Expose
    var tempMin: Float? = null
    @SerializedName("temp_max")
    @Expose
    var tempMax: Float? = null
    @SerializedName("pressure")
    @Expose
    var pressure: Float? = null
    @SerializedName("sea_level")
    @Expose
    var seaLevel: Float? = null
    @SerializedName("grnd_level")
    @Expose
    var grndLevel: Float? = null
    @SerializedName("humidity")
    @Expose
    var humidity: Float? = null
    @SerializedName("temp_kf")
    @Expose
    var tempKf: Float? = null

    protected constructor(`in`: Parcel) {
        this.temp = `in`.readValue(Float::class.java.classLoader) as Float
        this.tempMin = `in`.readValue(Float::class.java.classLoader) as Float
        this.tempMax = `in`.readValue(Float::class.java.classLoader) as Float
        this.pressure = `in`.readValue(Float::class.java.classLoader) as Float
        this.seaLevel = `in`.readValue(Float::class.java.classLoader) as Float
        this.grndLevel = `in`.readValue(Float::class.java.classLoader) as Float
        this.humidity = `in`.readValue(Float::class.java.classLoader) as Float
        this.tempKf = `in`.readValue(Int::class.java.classLoader) as Float
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param seaLevel
     * @param humidity
     * @param pressure
     * @param grndLevel
     * @param tempMax
     * @param temp
     * @param tempKf
     * @param tempMin
     */
    constructor(
        temp: Float?,
        tempMin: Float?,
        tempMax: Float?,
        pressure: Float?,
        seaLevel: Float?,
        grndLevel: Float?,
        humidity: Float?,
        tempKf: Float?
    ) : super() {
        this.temp = temp
        this.tempMin = tempMin
        this.tempMax = tempMax
        this.pressure = pressure
        this.seaLevel = seaLevel
        this.grndLevel = grndLevel
        this.humidity = humidity
        this.tempKf = tempKf
    }

    fun withTemp(temp: Float?): Main {
        this.temp = temp
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

    fun withPressure(pressure: Float?): Main {
        this.pressure = pressure
        return this
    }

    fun withSeaLevel(seaLevel: Float?): Main {
        this.seaLevel = seaLevel
        return this
    }

    fun withGrndLevel(grndLevel: Float?): Main {
        this.grndLevel = grndLevel
        return this
    }

    fun withHumidity(humidity: Float?): Main {
        this.humidity = humidity
        return this
    }

    fun withTempKf(tempKf: Float?): Main {
        this.tempKf = tempKf
        return this
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(temp)
        dest.writeValue(tempMin)
        dest.writeValue(tempMax)
        dest.writeValue(pressure)
        dest.writeValue(seaLevel)
        dest.writeValue(grndLevel)
        dest.writeValue(humidity)
        dest.writeValue(tempKf)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Creator<Main> = object : Creator<Main> {


            override fun createFromParcel(`in`: Parcel): Main {
                return Main(`in`)
            }

            override fun newArray(size: Int): Array<Main?> {
                return arrayOfNulls(size)
            }

        }
    }

}
