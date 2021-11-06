package com.mindorks.kotlinlecture4.util

import android.content.Context
import android.net.ConnectivityManager

object NetworkUtils {

    fun isInternetConnected(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null;
    }
}