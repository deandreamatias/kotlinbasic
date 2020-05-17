package com.slashmobility.seleccion.matias.deandrea.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

// LIST VIEW MODEL: Made actions to list fragment
class ListViewModel : ViewModel() {

    private val _randomValues = MutableLiveData<Array<Int>>()

    val randomValues: LiveData<Array<Int>>
        get() = _randomValues

    // Create list with [number] items, each of one with a random number
    fun createList(number: Int){
        _randomValues.value = Array(number) { Random.nextInt(1, 999) }
    }

    // Delete all list items
    fun clearList(){
        _randomValues.value = emptyArray()
    }

    // Delete a single item on list
    fun deleteItemList(index: Int): Array<Int> {
        if (index < 0 || index >= _randomValues.value!!.size) {
            return _randomValues.value!!
        }
        val result = _randomValues.value!!.toMutableList()
        result.removeAt(index)
        _randomValues.value = result.toTypedArray()
        return _randomValues.value!!
    }

    // Order list items in increasing order
    fun orderList(){
        if (_randomValues.value!!.isNotEmpty() && _randomValues.value != null){
            _randomValues.value = _randomValues.value!!.sortedArray()
        }
    }
}