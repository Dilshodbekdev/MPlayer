package com.mobiler.mplayer.presenter.main.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.mobiler.mplayer.databinding.FragmentAlbumsBinding
import com.mobiler.mplayer.utils.BindingFragment

class AlbumsFragment: BindingFragment<FragmentAlbumsBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentAlbumsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}