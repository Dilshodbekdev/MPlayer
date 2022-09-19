package com.mobiler.mplayer.presenter.main.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.mobiler.mplayer.databinding.FragmentFavoritesBinding
import com.mobiler.mplayer.utils.BindingFragment

class FavoritesFragment: BindingFragment<FragmentFavoritesBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentFavoritesBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}