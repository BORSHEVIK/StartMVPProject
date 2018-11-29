package com.example.aliaksandrmirashnichenka.myconductormvp.abs

import android.content.Context
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.BaseDialogEventListener
import com.example.aliaksandrmirashnichenka.myconductormvp.service.Navigator
import com.example.aliaksandrmirashnichenka.myconductormvp.service.ToastManager

interface PAbs : Abs {

    fun getToastManager(): ToastManager;
    fun getNavigator(): Navigator;
    fun getControllerEventListnerByTag(controllerTag: String): BaseDialogEventListener;

}