package com.example.themealcollection.fragments.areas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.themealcollection.databinding.FragmentAreasBinding

class AreasFragment : Fragment() {

    private var _binding: FragmentAreasBinding? = null
    private val binding get() = requireNotNull(_binding) {
        "View was destroyed!"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentAreasBinding.inflate(inflater, container, false)
            .also { binding ->
                _binding = binding }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}