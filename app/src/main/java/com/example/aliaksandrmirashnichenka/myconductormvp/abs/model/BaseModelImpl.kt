package com.example.aliaksandrmirashnichenka.myconductormvp.abs.model

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.Abs
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.PresenterProvider
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.BasePresenter

open class BaseModelImpl <P : BasePresenter> : BaseModel {

    internal val presenterProvider: PresenterProvider<P>;
    internal val abs: Abs;

    constructor(presenterProvider: PresenterProvider<P>, abs: Abs) {
        this.presenterProvider = presenterProvider
        this.abs = abs;
    }
}