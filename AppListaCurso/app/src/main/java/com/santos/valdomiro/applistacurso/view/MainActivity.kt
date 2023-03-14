package com.santos.valdomiro.applistacurso.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.santos.valdomiro.applistacurso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}