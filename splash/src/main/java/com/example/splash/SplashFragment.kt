package com.example.splash

import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onResume() {
        super.onResume()
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(com.example.themealcollection.R.id.action_global_to_list)
        }, 2000)
    }
}