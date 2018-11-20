package com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter

import android.content.Intent
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.AndroidLifeCycle

interface BasePresenter : AndroidLifeCycle {

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)

}