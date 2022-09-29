package com.mobiler.mplayer.presenter.main.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.mobiler.mplayer.databinding.FragmentFoldersBinding
import com.mobiler.mplayer.utils.BindingFragment

class FoldersFragment: BindingFragment<FragmentFoldersBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentFoldersBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}