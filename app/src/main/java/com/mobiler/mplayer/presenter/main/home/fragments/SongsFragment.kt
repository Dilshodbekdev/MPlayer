package com.mobiler.mplayer.presenter.main.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.mobiler.mplayer.databinding.FragmentSongsBinding
import com.mobiler.mplayer.utils.BindingFragment

class SongsFragment: BindingFragment<FragmentSongsBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentSongsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}