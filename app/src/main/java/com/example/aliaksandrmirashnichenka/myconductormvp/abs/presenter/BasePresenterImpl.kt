package com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.model.BaseModel
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.view.BaseView

abstract open class BasePresenterImpl<V: BaseView, M: BaseModel, D: DataHolder> : BasePresenter {

    internal val view: V;
    internal val model: M;
    internal val dataHolder: D;

    constructor(view: V, model: M, dataHolder: D) {
        this.view = view;
        this.model = model;
        this.dataHolder = dataHolder;
    }

    override fun onDestroy() {

    }

    override fun onCreate() {

    }

    override fun onResume() {

    }

    override fun onStop() {

    }

    override fun onSaveInstanceState(): DataHolder {
        return dataHolder;
    }
}