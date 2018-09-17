package com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.presenter

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.BasePresenter

interface MainControllerPresenter : BasePresenter {

    fun updateButtonClick();
    fun nextButtonClick();

}