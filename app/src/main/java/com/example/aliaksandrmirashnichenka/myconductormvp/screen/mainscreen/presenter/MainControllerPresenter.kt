package com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.presenter

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.BasePresenter
import com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.MessageCallback

interface MainControllerPresenter : BasePresenter, MessageCallback {

    fun updateButtonClick();
    fun nextButtonClick();
    fun dialogButtonClick();

}