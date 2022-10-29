package com.hasanali.kotlinrunnable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.hasanali.kotlinrunnable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var runnable: Runnable
    private var handler = Handler(Looper.getMainLooper())
    private var number = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val v = binding.root
        setContentView(v)
    }

    fun start(v: View) {
        //Runnable initialize
        runnable = object: Runnable {
            override fun run() {
                binding.textView.text = number.toString()
                handler.postDelayed(this,1000)
                number++
            }
        }
        binding.buttonStart.visibility = View.INVISIBLE
        handler.post(runnable)
    }

    fun stop(v: View) {
        handler.removeCallbacks(runnable)
        number = 0
        binding.textView.text = number.toString()
        binding.buttonStart.visibility = View.VISIBLE
    }
}