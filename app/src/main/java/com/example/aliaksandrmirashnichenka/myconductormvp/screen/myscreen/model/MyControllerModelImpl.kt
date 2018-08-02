package com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen.model

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.model.BaseModelImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.PresenterProvider
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen.presenter.MyControllerPresenter

class MyControllerModelImpl : BaseModelImpl<MyControllerPresenter>, MyControllerModel {

    constructor(myControllerPresenterProvider: PresenterProvider<MyControllerPresenter>) : super(myControllerPresenterProvider) {
    }

}