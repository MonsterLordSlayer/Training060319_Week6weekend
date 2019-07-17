package com.example.week6weekend.Byday

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Rain : Parcelable {

    @SerializedName("_3h")
    @Expose
    var _3h : Int? = null

    protected constructor(`in`: Parcel) {
        this._3h = (`in`.readValue((Int::class.java!!.getClassLoader())) as Int)
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param _3h
     */
    constructor(_3h: Int?) : super() {
        this._3h = _3h
    }

    fun with3h(_3h: Int?): Rain {
        this._3h = _3h
        return this
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(_3h)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Creator<Rain> = object : Creator<Rain> {


            override fun createFromParcel(`in`: Parcel): Rain {
                return Rain(`in`)
            }

            override fun newArray(size: Int): Array<Rain?> {
                return arrayOfNulls(size)
            }

        }
    }

}
