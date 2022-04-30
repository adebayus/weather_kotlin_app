package com.sebade.weatherapp.bindingadapter

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.sebade.weatherapp.R
import com.sebade.weatherapp.network.model.ResponseAllWeatherData
import com.sebade.weatherapp.utils.Utils


@SuppressLint("SetTextI18n")
@BindingAdapter("app:setText")
fun setText(tv: TextView, response: ResponseAllWeatherData?) {
    if (response != null) {
        when (tv.id) {
            R.id.address -> tv.text = response.name
            R.id.updated_at -> tv.text =
                "Updated at ${Utils.updatedAt(response.dt!!, response.timezone!!)}"
            R.id.sunrise -> tv.text =
                Utils.unixToTime(response.sys!!.sunrise!!, response.timezone!!)
            R.id.sunset -> tv.text = Utils.unixToTime(response.sys!!.sunset!!, response.timezone!!)
            R.id.status -> tv.text = response.weather!![0]!!.description
            R.id.temp -> tv.text = "${Utils.kelvinToCelsius(response.main!!.temp!!)}℃"
            R.id.temp_min -> tv.text =
                "Temp Min ${Utils.kelvinToCelsius(response.main!!.tempMin!!)}℃"
            R.id.temp_max -> tv.text =
                "Temp Max ${Utils.kelvinToCelsius(response.main!!.tempMax!!)}℃"
            R.id.humidity -> tv.text = "${response.main!!.humidity}"
            R.id.presure -> tv.text = "${response.main!!.pressure}"
            R.id.wind -> tv.text = "${response.wind!!.speed}"
            R.id.info -> tv.text = "Created By Debs"
        }
    }
}

