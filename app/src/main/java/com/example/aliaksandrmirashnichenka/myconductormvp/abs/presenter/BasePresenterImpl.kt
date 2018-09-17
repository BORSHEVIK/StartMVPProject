package com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.Abs
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.Navigator
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.model.BaseModel
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.view.BaseView

abstract open class BasePresenterImpl<V: BaseView, M: BaseModel, D: DataHolder, A: Arguments> : BasePresenter {

    internal val view: V;
    internal val model: M;
    internal val dataHolder: D;
    internal val arguments: A;
    internal val abs: Abs;

    constructor(view: V, model: M, dataHolder: D, arguments: A, abs: Abs) {
        this.view = view;
        this.model = model;
        this.dataHolder = dataHolder;
        this.arguments = arguments;
        this.abs = abs;
    }

    override fun onDestroy() {

    }

    override fun onCreate() {

    }

    override fun onResume() {

    }

    override fun onStop() {

    }
}