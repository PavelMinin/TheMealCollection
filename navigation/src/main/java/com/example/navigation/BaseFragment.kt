package com.example.navigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment(layoutId: Int) : Fragment(layoutId){
    open var needShowBottomBar = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null && activity is BottomBarHideable){
            with(activity as BottomBarHideable){
                if(needShowBottomBar) show()
                else hide()
            }
        }
    }
}