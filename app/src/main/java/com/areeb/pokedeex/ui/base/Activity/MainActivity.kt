package com.areeb.pokedeex.ui.base.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.areeb.pokedeex.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
