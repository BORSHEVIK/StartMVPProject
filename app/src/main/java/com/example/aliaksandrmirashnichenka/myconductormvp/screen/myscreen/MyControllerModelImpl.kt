package com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.BaseModelImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.PresenterProvider

class MyControllerModelImpl : BaseModelImpl<MyControllerPresenter>, MyControllerModel {

    constructor(myControllerPresenterProvider: PresenterProvider<MyControllerPresenter>) : super(myControllerPresenterProvider) {
    }

}