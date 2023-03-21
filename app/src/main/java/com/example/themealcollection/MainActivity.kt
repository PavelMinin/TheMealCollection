package com.example.themealcollection

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.BottomBarHideable

class MainActivity : AppCompatActivity(), BottomBarHideable {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun hide() {
        findViewById<View>(R.id.bottom_nav_bar).visibility = View.GONE
        findViewById<View>(R.id.toolbar).visibility = View.GONE
    }

    override fun show() {
        findViewById<View>(R.id.bottom_nav_bar).visibility = View.VISIBLE
        findViewById<View>(R.id.toolbar).visibility = View.VISIBLE
    }
}