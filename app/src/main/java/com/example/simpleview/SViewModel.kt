package com.example.simpleview

import android.view.View
import android.widget.CompoundButton
import androidx.databinding.Bindable
import androidx.fragment.app.commit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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


    val userName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
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