package com.example.nativeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.nativeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /**
         * 1. Calling native method to initialise OpenCV SDK
         * 2. We have called this method inside onCreate() because onCreate() is only called once
         *   and we want the initOpenCVSDK() to be called only when the activity is created first time
         */
        val result=initOpenCVSDK()
        displayMessage(result)
    }

    private fun displayMessage(initStatus:Boolean){
        val message=if(initStatus){
            "OpenCV SDK Initialised successfully"
        }
        else{
            "Something went wrong while initialising OpenCV SDK"
        }
        binding.statusText.text=message
    }

    external fun initOpenCVSDK(): Boolean

    companion object {
        // Used to load the 'nativeapp' library on application startup.
        init {
            System.loadLibrary("nativeapp")
        }
    }
}