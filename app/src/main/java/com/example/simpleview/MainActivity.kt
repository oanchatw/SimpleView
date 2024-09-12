package com.example.simpleview

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.coroutineScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.simpleview.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

//import com.example.simpleview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val vModel: SViewModel by lazy { SViewModel() };
    lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewmodel = vModel

        binding.lifecycleOwner = this

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(binding.fragmentContentMain.id, FirstFragment())


        }


//
        vModel.swapFrag.observe(this) { swapFragNext(it) }


    }

    private fun swapFragNext(isFirst: Boolean) {

        lifecycle.coroutineScope.launch {
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