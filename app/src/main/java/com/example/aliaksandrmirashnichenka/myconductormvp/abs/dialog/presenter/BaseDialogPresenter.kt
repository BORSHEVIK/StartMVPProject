package com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.presenter

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.BaseDialogEventListener
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.BasePresenter

interface BaseDialogPresenter<L: BaseDialogEventListener> : BasePresenter {

    fun attachEventListener(eventListener: L)

}