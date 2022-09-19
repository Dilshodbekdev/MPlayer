package com.mobiler.mplayer.presenter.main.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.mobiler.mplayer.databinding.FragmentSettingsBinding
import com.mobiler.mplayer.utils.BindingFragment

class SettingsFragment: BindingFragment<FragmentSettingsBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentSettingsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}