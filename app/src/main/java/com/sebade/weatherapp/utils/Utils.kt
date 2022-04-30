package com.sebade.weatherapp.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

class Utils {
    companion object {
        @SuppressLint("SimpleDateFormat")
        fun updatedAt(dt: Long, timezone: Int): String =
            SimpleDateFormat(
                "dd/MM/yyyy hh:mm a"
            ).also {
                it.timeZone = TimeZone.getTimeZone("UTC")
            }.format(Date(unixTimeToDate(dt, timezone)))

        fun unixTimeToDate(unix: Long, timezone: Int): Long {
            return (timezone.plus(unix).toString() + "000").toLong()
        }

        fun kelvinToCelsius(temp: Double): String {
            return (temp - 273.15).roundToInt().toString()
        }

        @SuppressLint("SimpleDateFormat")
        fun unixToTime(sunrise: Int, timezone: Int): String =
            SimpleDateFormat("hh:mm a").also {
                it.timeZone = TimeZone.getTimeZone("UTC")
            }.format(Date(unixTimeToDate(sunrise.toLong(),timezone)))

        @SuppressLint("SimpleDateFormat")
        fun test() :String = SimpleDateFormat("dd/MM/yyyy hh:mm a").also {
            it.timeZone = TimeZone.getTimeZone("UTC")
        }.format(Date(1651208150000))
    }
}