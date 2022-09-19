package com.mobiler.mplayer.presenter.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.mobiler.mplayer.databinding.FragmentHomeBinding
import com.mobiler.mplayer.utils.BindingFragment

class HomeFragment: BindingFragment<FragmentHomeBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}