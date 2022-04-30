package com.sebade.weatherapp.network

import com.sebade.weatherapp.network.model.ResponseAllWeatherData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("weather?lat=35&lon=139&appid=273b6f91c7d5d0c07f84cf12fc86ea74")
    fun getWeatherData() : Call<ResponseAllWeatherData>
}
