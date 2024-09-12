package com.example.simpleview

import androidx.fragment.app.commit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SViewModel : ViewModel() {

   private val _countText: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val countText: LiveData<Int> = _countText

    private   val _swapFrag: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val swapFrag: LiveData<Boolean> = _swapFrag




    fun addone() {
        _countText.value  =( _countText.value ?: 0) +1;
        println("press_countText")

    }

    fun changeFrag() {
        _swapFrag.value = !(_swapFrag.value ?: true)
    }


}