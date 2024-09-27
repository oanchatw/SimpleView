package com.example.simpleview

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.activity.compose.setContent
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
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

  lateinit  var vModel: SViewModel

    lateinit  var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        vModel = ViewModelProvider.create(this).get(SViewModel::class)
        binding.vm = vModel

        binding.lifecycleOwner =this

        vModel.swapFrag.observe(this) { swapFragNext(it) }

        supportFragmentManager.commit {
            setReorderingAllowed(true)

            replace(
                R.id.fragment_content_main,
                 FirstFragment()
            )
        }


    }



    private fun swapFragNext(isFirst: Boolean) {

        lifecycle.coroutineScope.launch {
            delay(100)
            supportFragmentManager.commit {
                setReorderingAllowed(true)

                replace(
                    R.id.fragment_content_main,
                    if (isFirst) FirstFragment() else SecondFragment()
                )
            }
        }

    }


}


//
//        vModel.swapFrag.observe(this) { swapFragNext(it) }
//
//        vModel.countText.observe(this) {
//
//          val p=   findViewById<TextView>(R.id.text_main_1)
//
//            p.text = it.toString();
//        }
//        val b1=   findViewById<TextView>(R.id.button_main_1)
//
//        b1.setOnClickListener { vModel.addone() }
//        val b2=   findViewById<TextView>(R.id.button_swap)
//        b2.setOnClickListener { vModel.changeFrag() }



//compose binding
//binding.composeView.apply {
//    setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
//    setContent {
//        // In Compose world
//        MaterialTheme {
//            CCompose()
//        }
//    }
//}
