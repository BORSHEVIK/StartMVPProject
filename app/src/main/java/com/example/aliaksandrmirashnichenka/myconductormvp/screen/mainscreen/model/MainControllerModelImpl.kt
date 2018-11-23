package com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.model

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.Abs
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.PresenterProvider
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.model.BaseModelImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.presenter.MainControllerPresenter

class MainControllerModelImpl : BaseModelImpl<MainControllerPresenter>, MainControllerModel {

    constructor(myControllerPresenterProvider: PresenterProvider<MainControllerPresenter>, abs: Abs) : super(myControllerPresenterProvider, abs) {

    }

}