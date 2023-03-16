package com.example.dish_details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import coil.size.Scale
import coil.size.ViewSizeResolver
import com.example.core.utils.viewBinding
import com.example.dish_details.databinding.FragmentDetailsBinding
import com.example.navigation.BaseFragment


class DetailsFragment : BaseFragment(R.layout.fragment_details) {

    init {
        needShowBottomBar = false
    }

    private val binding by viewBinding(FragmentDetailsBinding::bind)

    private val args by navArgs<DetailsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mealDetails = args.meal


        with(binding) {
            toolbarDetail.setNavigationOnClickListener { findNavController().popBackStack() }

            image.load(mealDetails?.imageUrl) {
                scale(Scale.FIT)
                size(ViewSizeResolver(root))
            }
            tvTitle.text = mealDetails?.name
            val subTitle = mealDetails?.category + " " + mealDetails?.area
            tvSubTitle.text = subTitle
            tvInstructions.text= "line\nline\nline\nline\nline\nline\nline\nline\nline\nline" +
                    "\nline\nline\nline\nline\nline\nline\nline\nline\nline\nline\nline\nline" +
                    "\nline\nline\nline\nline\nline\nline\nline\nline\nline\nline\nline\nline" +
                    "\nline\nline\nline\nline\nline\nline\nline\nline\nline\nline\nline\nline" +
                    "\nline\nline\nline\nline\nline\nline\nline\nline\nline\nline\nline\nline" +
                    "\nline\nline\nline\nline\nline\nline\nline\nline\nline\nline\nline\nline" +
                    "\nline\n"
        }
    }
}