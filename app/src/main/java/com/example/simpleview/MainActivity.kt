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
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController

//import com.example.simpleview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    var id1: Int = 1;
    var id2: Int = 1;

    var currentFragIsFisrt = true;

    //    lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.inflate(
//            layoutInflater,
//            R.layout.activity_main,
//            null,
//            false
//        )

//    setContentView(binding.root)
        setContentView(R.layout.activity_main)
//    LayoutInflater.from(this).inflate(R.layout.fragment_content_main,null,false)

        drawUI()
      val btn1 = findViewById<Button>(R.id.button_main_1)
        btn1.setOnClickListener{addone()}

        val btn2 = findViewById<Button>(R.id.button_swap)
        btn2.setOnClickListener{swapFrag()}

        supportFragmentManager.commit {
            setReorderingAllowed(true)

            replace(R.id.fragment_content_main, if (currentFragIsFisrt)   FirstFragment() else  SecondFragment())
        }
    }

    fun swapFrag() {


        supportFragmentManager.commit {
            setReorderingAllowed(true)

            replace(R.id.fragment_content_main, if (currentFragIsFisrt)   FirstFragment() else  SecondFragment())
            currentFragIsFisrt =!currentFragIsFisrt
        }
    }



   fun drawUI() {
       val text1 = findViewById<TextView>(R.id.text_main_1)
       text1.text=id1.toString()

    }
    fun addone() {
        id1+=1;
        println("press")
        drawUI()
    }

}