package com.mobiler.mplayer.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

abstract class BindingFragment<out T : ViewBinding> : Fragment() {

    private var _binding: ViewBinding? = null
    protected val binding: T
        get() = _binding as T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater(inflater)
        setLocale(requireContext())
        return _binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun navigate(direction: NavDirections) {
        findNavController().navigate(direction)
    }

    fun navigate(id: Int) {
        findNavController().navigate(id)
    }

    fun back() {
        findNavController().popBackStack()
    }

    protected abstract val bindingInflater: (LayoutInflater) -> ViewBinding

}