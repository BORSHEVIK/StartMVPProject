package com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.presenter

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.presenter.BaseDialogPresenter
import com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.MessageCallback

interface MessageDialogPresenter : BaseDialogPresenter<MessageCallback> {

    fun okButtonClick();

}