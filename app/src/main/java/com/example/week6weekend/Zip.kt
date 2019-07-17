package com.example.week6weekend

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Zip : Parcelable {

    @SerializedName("coord")
    @Expose
    var coord: Coord? = null
    @SerializedName("weather")
    @Expose
    var weather: List<Weather>? = null
    @SerializedName("base")
    @Expose
    var base: String? = null
    @SerializedName("main")
    @Expose
    var main: Main? = null
    @SerializedName("visibility")
    @Expose
    var visibility: Int? = null
    @SerializedName("wind")
    @Expose
    var wind: Wind? = null
    @SerializedName("clouds")
    @Expose
    var clouds: Clouds? = null
    @SerializedName("dt")
    @Expose
    var dt: Int? = null
    @SerializedName("sys")
    @Expose
    var sys: Sys? = null
    @SerializedName("timezone")
    @Expose
    var timezone: Int? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("cod")
    @Expose
    var cod: Int? = null

    protected constructor(`in`: Parcel) {
        this.coord = `in`.readValue(Coord::class.java!!.getClassLoader()) as Coord
        `in`.readList(this.weather!!, com.example.week6weekend.Weather::class.java!!.getClassLoader())
        this.base = `in`.readValue(String::class.java.classLoader) as String
        this.main = `in`.readValue(Main::class.java!!.getClassLoader()) as Main
        this.visibility = `in`.readValue(Int::class.java.classLoader) as Int
        this.wind = `in`.readValue(Wind::class.java!!.getClassLoader()) as Wind
        this.clouds = `in`.readValue(Clouds::class.java!!.getClassLoader()) as Clouds
        this.dt = `in`.readValue(Int::class.java.classLoader) as Int
        this.sys = `in`.readValue(Sys::class.java!!.getClassLoader()) as Sys
        this.timezone = `in`.readValue(Int::class.java.classLoader) as Int
        this.id = `in`.readValue(Int::class.java.classLoader) as Int
        this.name = `in`.readValue(String::class.java.classLoader) as String
        this.cod = `in`.readValue(Int::class.java.classLoader) as Int
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param id
     * @param dt
     * @param clouds
     * @param coord
     * @param wind
     * @param timezone
     * @param cod
     * @param visibility
     * @param sys
     * @param name
     * @param base
     * @param weather
     * @param main
     */
    constructor(
        coord: Coord,
        weather: List<Weather>,
        base: String,
        main: Main,
        visibility: Int?,
        wind: Wind,
        clouds: Clouds,
        dt: Int?,
        sys: Sys,
        timezone: Int?,
        id: Int?,
        name: String,
        cod: Int?
    ) : super() {
        this.coord = coord
        this.weather = weather
        this.base = base
        this.main = main
        this.visibility = visibility
        this.wind = wind
        this.clouds = clouds
        this.dt = dt
        this.sys = sys
        this.timezone = timezone
        this.id = id
        this.name = name
        this.cod = cod
    }

    fun withCoord(coord: Coord): Zip {
        this.coord = coord
        return this
    }

    fun withWeather(weather: List<Weather>): Zip {
        this.weather = weather
        return this
    }

    fun withBase(base: String): Zip {
        this.base = base
        return this
    }

    fun withMain(main: Main): Zip {
        this.main = main
        return this
    }

    fun withVisibility(visibility: Int?): Zip {
        this.visibility = visibility
        return this
    }

    fun withWind(wind: Wind): Zip {
        this.wind = wind
        return this
    }

    fun withClouds(clouds: Clouds): Zip {
        this.clouds = clouds
        return this
    }

    fun withDt(dt: Int?): Zip {
        this.dt = dt
        return this
    }

    fun withSys(sys: Sys): Zip {
        this.sys = sys
        return this
    }

    fun withTimezone(timezone: Int?): Zip {
        this.timezone = timezone
        return this
    }

    fun withId(id: Int?): Zip {
        this.id = id
        return this
    }

    fun withName(name: String): Zip {
        this.name = name
        return this
    }

    fun withCod(cod: Int?): Zip {
        this.cod = cod
        return this
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(coord)
        dest.writeList(weather)
        dest.writeValue(base)
        dest.writeValue(main)
        dest.writeValue(visibility)
        dest.writeValue(wind)
        dest.writeValue(clouds)
        dest.writeValue(dt)
        dest.writeValue(sys)
        dest.writeValue(timezone)
        dest.writeValue(id)
        dest.writeValue(name)
        dest.writeValue(cod)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Parcelable.Creator<Zip> = object : Creator<Zip> {


            override fun createFromParcel(`in`: Parcel): Zip {
                return Zip(`in`)
            }

            override fun newArray(size: Int): Array<Zip?> {
                return arrayOfNulls(size)
            }

        }
    }

}
