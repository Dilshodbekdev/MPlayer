package com.mobiler.mplayer.presenter.main.playlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.mobiler.mplayer.databinding.FragmentPlaylistsBinding
import com.mobiler.mplayer.utils.BindingFragment

class PlaylistsFragment: BindingFragment<FragmentPlaylistsBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentPlaylistsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}