package com.mobiler.mplayer.utils


import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.navigation.NavOptions
import com.google.android.material.snackbar.Snackbar
import com.mobiler.mplayer.R
import java.util.*


fun getNavOptions(): NavOptions.Builder {
    return NavOptions.Builder()
        .setEnterAnim(R.anim.slide_in_right)
        .setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left)
        .setPopExitAnim(R.anim.slide_out_right)

}

/*fun showLoading(context: Context): AlertDialog {
    val alertDialog = AlertDialog
        .Builder(context)
        .setView(
            DialogLoaderBinding.inflate(
                LayoutInflater.from(context),
                null,
                false
            ).root
        ).create()
    alertDialog.setCancelable(false)
    alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    return alertDialog
}*/

fun showMessage(v: View, message: String) =
    Snackbar.make(v, message, Snackbar.LENGTH_LONG).show()

/*
class GenericTextWatcherFunctions {


    class GenericKeyEvent internal constructor(
        private val currentView: EditText,
        private val previousView: EditText?
    ) : View.OnKeyListener {
        override fun onKey(p0: View?, keyCode: Int, event: KeyEvent?): Boolean {
            if (event!!.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL && currentView.id != R.id.etCode1 && currentView.text.isEmpty()) {
                previousView!!.text = null
                previousView.requestFocus()
                return true
            }
            return false
        }


    }

    class GenericTextWatcher internal constructor(
        private val currentView: View,
        private val nextView: View?
    ) : TextWatcher {
        override fun afterTextChanged(editable: Editable) {
            val text = editable.toString()
            when (currentView.id) {
                R.id.etCode1 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.etCode2 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.etCode3 -> if (text.length == 1) nextView!!.requestFocus()
            }
        }

        override fun beforeTextChanged(
            arg0: CharSequence,
            arg1: Int,
            arg2: Int,
            arg3: Int
        ) { // TODO Auto-generated method stub
        }

        override fun onTextChanged(
            arg0: CharSequence,
            arg1: Int,
            arg2: Int,
            arg3: Int
        ) { // TODO Auto-generated method stub
        }
    }
}
*/


/*fun checkPermissions(context: Context) {
    Dexter.withContext(context).withPermissions(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    ).withListener(object : MultiplePermissionsListener {
        override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
            if (p0?.isAnyPermissionPermanentlyDenied == true) {
                showSettingsDialog(context)
            }
        }

        override fun onPermissionRationaleShouldBeShown(
            p0: MutableList<PermissionRequest>?,
            p1: PermissionToken?
        ) {
            p1?.continuePermissionRequest()
        }

    }).check()
}*/

private fun showSettingsDialog(context: Context) {
    val builder: androidx.appcompat.app.AlertDialog.Builder =
        androidx.appcompat.app.AlertDialog.Builder(context)
    builder.setTitle("Need Permissions")
    builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.")
    builder.setPositiveButton(
        "GOTO SETTINGS"
    ) { dialog, which ->
        dialog.cancel()
        openSettings(context)
    }
    builder.setNegativeButton(
        "Cancel"
    ) { dialog, which -> dialog.cancel() }
    builder.show()
}

private fun openSettings(context: Context) {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
    val uri: Uri = Uri.fromParts("package", context.packageName, null)
    intent.data = uri
    context.startActivity(intent)
}

fun checkPermission(context: Context): Boolean {
    val result: Int =
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
    val result1: Int =
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED
}


object Constants {
    const val url = "https://ftp.uzal.uz/api/upload-file"
    const val key = "Agro2022-qwedsajWE551hASDdbwqk231dywkgdqq"
}

class NetworkHelper constructor(private val context: Context) {
    fun isNetworkConnected(): Boolean {
        var result = false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val activeNetwork =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            result = when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.run {
                connectivityManager.activeNetworkInfo?.run {
                    result = when (type) {
                        ConnectivityManager.TYPE_WIFI -> true
                        ConnectivityManager.TYPE_MOBILE -> true
                        ConnectivityManager.TYPE_ETHERNET -> true
                        else -> false
                    }

                }
            }
        }
        return result
    }
}


/*fun showLoading(context: Context): AlertDialog {
    val alertDialog = AlertDialog
        .Builder(context)
        .setView(
            DialogLoaderBinding.inflate(
                LayoutInflater.from(context),
                null,
                false
            ).root
        ).create()
    alertDialog.setCancelable(false)
    alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    return alertDialog
}*/

/*fun showInternetError(context: Context): AlertDialog {
    val alertDialog = AlertDialog
        .Builder(context)
        .setView(
            DialogNotInternetConnectedBinding.inflate(
                LayoutInflater.from(context),
                null,
                false
            ).root
        ).create()
    alertDialog.setCancelable(true)
    alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    return alertDialog
}*/

fun setLocale(context: Context) {
    val sharedPref = SharedPref(context)
    val locale = Locale(sharedPref.language.toString())
    Locale.setDefault(locale)
    val config: Configuration = context.resources.configuration
    config.locale = locale
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
}
