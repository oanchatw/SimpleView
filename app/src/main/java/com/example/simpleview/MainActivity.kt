package com.example.simpleview

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.simpleview.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    val vModel: SViewModel by lazy { SViewModel() };


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)



        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(binding.fragmentContentMain.id, FirstFragment())


        }


//
        vModel.swapFrag.observe(this) { swapFragNext(it) }

        vModel.countText.observe(this) {

            binding.textMain1.text = it.toString();
        }

        binding.buttonMain1.setOnClickListener { vModel.addone() }
        binding.buttonSwap.setOnClickListener { vModel.changeFrag() }

    }


    private fun swapFragNext(isFirst: Boolean) {

        lifecycle.coroutineScope.launch {
            delay(100)
            supportFragmentManager.commit {
                setReorderingAllowed(true)

                replace(
                    binding.fragmentContentMain.id,
                    if (isFirst) FirstFragment() else SecondFragment()
                )
            }
        }

    }


}