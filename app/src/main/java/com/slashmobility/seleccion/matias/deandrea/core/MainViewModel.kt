package com.slashmobility.seleccion.matias.deandrea.core

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val tag: String = this.javaClass.toString()

    private val _response = MutableLiveData<String>()
    private val _reversed = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response
    val reversed: LiveData<String>
        get() = _reversed

    // Get origin from httpbin api, verify errors and populate MainFragment strings
    fun getOrigin() {
        Api.retrofitService.getData().enqueue( object: Callback<Data> {
            override fun onFailure(call: Call<Data>, t: Throwable) {
                _response.value = "Failure: " + t.message
                Log.d(tag, "Fail + ${t.message}" )
            }

            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                _response.value = response.body()?.origin
                _reversed.value = _response.value?.reversed()
                Log.d(tag, "Success" )
            }
        })
    }
}