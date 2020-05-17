package com.slashmobility.seleccion.matias.deandrea.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.await

// MAIN VIEW MODEL: Made actions to main fragment
class MainViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    private val _reversed = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response
    val reversed: LiveData<String>
        get() = _reversed

    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    // Get origin from httpbin api, verify errors and populate MainFragment strings
    fun getOrigin() {
        coroutineScope.launch {
            // Get the Deferred object for our Retrofit request
            val getData = Api.retrofitService.getData()
            try {
                // this will run on a thread managed by Retrofit
                val data = getData.await()
                _response.value = data.origin
                _reversed.value = _response.value?.reversed()
            } catch (e: Exception) {
                _response.value = "Fail :("
                _reversed.value = "Fail too :("
            }
        }
    }

    // Cancel job when dispatch view model
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}