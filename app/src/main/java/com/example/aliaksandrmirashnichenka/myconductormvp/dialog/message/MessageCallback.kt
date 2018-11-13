package com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.BaseDialogEventListener

interface MessageCallback : BaseDialogEventListener {

    fun okPressed();

}