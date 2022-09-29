package com.mobiler.mplayer.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPref constructor(context: Context) {

    private val preferences: SharedPreferences = context.getSharedPreferences(NAME, MODE)

    companion object {

        private const val NAME = "AudioBookApp"
        private const val MODE = Context.MODE_PRIVATE
        private var instance: SharedPref? = null
        fun getInstance(context: Context): SharedPref {
            return if (instance != null) {
                instance as SharedPref
            } else {
                instance = SharedPref(context)
                instance as SharedPref
            }
        }
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var token: String?
        get() = preferences.getString("access_token", "")
        set(value) = preferences.edit {
            if (value != null) {
                it.putString("access_token", value)
            }
        }

    var audioList: String?
        get() = preferences.getString("audio_list", "")
        set(value) = preferences.edit {
            if (value != null) {
                it.putString("audio_list", value)
            }
        }

    var novel: String?
        get() = preferences.getString("novel", "")
        set(value) = preferences.edit {
            if (value != null) {
                it.putString("novel", value)
            }
        }

    var guest: Boolean?
        get() = preferences.getBoolean("guest", false)
        set(value) = preferences.edit {
            if (value != null) {
                it.putBoolean("guest", value)
            }
        }

    var music: Boolean?
        get() = preferences.getBoolean("music", false)
        set(value) = preferences.edit {
            if (value != null) {
                it.putBoolean("music", value)
            }
        }

    var exit: Boolean?
        get() = preferences.getBoolean("exit", false)
        set(value) = preferences.edit {
            if (value != null) {
                it.putBoolean("exit", value)
            }
        }

    var numbers: String?
        get() = preferences.getString("numbers", "")
        set(value) = preferences.edit {
            if (value != null) {
                it.putString("numbers", value)
            }
        }

    var fileAbsolutePath: String?
        get() = preferences.getString("image", "")
        set(value) = preferences.edit {
            if (value != null) {
                it.putString("image", value)
            }
        }

    var language: String?
        get() = preferences.getString("language", "uz")
        set(value) = preferences.edit {
            if (value != null) {
                it.putString("language", value)
            }
        }

    var pasword: String?
        get() = preferences.getString("pasword", "")
        set(value) = preferences.edit {
            if (value != null) {
                it.putString("pasword", value)
            }
        }

    var spinnerPosition: Int?
        get() = preferences.getInt("position", 0)
        set(value) = preferences.edit {
            if (value != null) {
                it.putInt("position", value)
            }
        }
}