package com.example.aliaksandrmirashnichenka.myconductormvp.abs.model

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.PresenterProvider
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.BasePresenter

open class BaseModelImpl <P : BasePresenter> : BaseModel {

    internal val presenterProvider: PresenterProvider<P>;

    constructor(presenterProvider: PresenterProvider<P>) {
        this.presenterProvider = presenterProvider
    }
}