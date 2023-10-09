package com.example.project6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    private lateinit var bindingMain: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}