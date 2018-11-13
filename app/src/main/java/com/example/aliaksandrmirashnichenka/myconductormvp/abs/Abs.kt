package com.example.aliaksandrmirashnichenka.myconductormvp.abs

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.BaseDialogEventListener
import java.io.Serializable

interface Abs : Serializable {

    fun getNavigator(): Navigator;
    fun getToastManager(): ToastManager;
    fun getControllerEventListnerByTag(controllerTag: String): BaseDialogEventListener;

}