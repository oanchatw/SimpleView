package com.example.simpleview

import androidx.fragment.app.commit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.delayEach
import kotlinx.coroutines.flow.delayFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.timeout
import kotlinx.coroutines.launch

class SViewModel : ViewModel() {

    private val _countText: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }


    val countText: LiveData<Int> = _countText

    private val _swapFrag: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val swapFrag: LiveData<Boolean> = _swapFrag
        fun setCount(cou:Int) {
            _countText.value = cou
        }

    fun addone() {


        _countText.apply {
            value = (value ?: 0) + 1
        }
        println("press_countText")

    }

    fun changeFrag() {
        _swapFrag.value = !(_swapFrag.value ?: true)


    }


}