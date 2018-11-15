package com.example.aliaksandrmirashnichenka.myconductormvp.service

import android.content.Context
import android.widget.Toast
import java.io.Serializable

class ToastManager(applicationContext: Context) : Serializable  {

    private val applicationContext: Context = applicationContext;

    fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show();
    }
}