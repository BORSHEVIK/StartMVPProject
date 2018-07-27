package com.example.aliaksandrmirashnichenka.myconductormvp.abs

open class BaseModelImpl <P : BasePresenter> : BaseModel {

    internal val presenterProvider: PresenterProvider<P>;

    constructor(presenterProvider: PresenterProvider<P>) {
        this.presenterProvider = presenterProvider
    }
}