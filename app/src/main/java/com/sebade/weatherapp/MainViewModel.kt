package com.sebade.weatherapp

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sebade.weatherapp.network.model.ResponseAllWeatherData
import com.sebade.weatherapp.utils.Utils
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.*

class MainViewModel : ViewModel() {
    init {
        getAll()
    }

    private var _isMoved= MutableLiveData<Boolean>()
    val isMoved = _isMoved

    private var _response = MutableLiveData<ResponseAllWeatherData>()
    var response = _response

    companion object {
        val TAG = "MainViewModel"
    }

    fun getAll(){
        val client = Apiconfig.retrofitService.getWeatherData()
        client.enqueue(object : retrofit2.Callback<ResponseAllWeatherData>{
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onResponse(
                call: Call<ResponseAllWeatherData>,
                response: Response<ResponseAllWeatherData>
            ) {
                if (response.isSuccessful){
                    if (response.body() != null) {

                    }
                    _response.value = response.body()
                    Log.d(TAG, "onResponse: ")

                }
            }

            override fun onFailure(call: Call<ResponseAllWeatherData>, t: Throwable) {

                Log.d(TAG, "onFailure: ${t.message}")
            }

        })
    }

    fun onClick(){
        _isMoved.value = true
    }
    fun isDoneMoving(){
        isMoved.value = false
    }

}


/*Log.d(TAG, "onResponse: ${
                            SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(
                                Date(Utils.unixTimeToDate(response.body()!!.dt!!))
                            )
                        } || ${response.body()!!.dt?.let { Date(1651201963*1000) }} || ${response!!.body()!!.dt} || ${response!!.body()!!.dt?.times(
                            1000
                        )} || ${DateTimeFormatter.ISO_INSTANT.format(response.body()!!.dt?.let {
                            Instant.ofEpochSecond(
                                it
                            )
                        })} || ${Utils.unixTimeToDate(1651201963)}")*/