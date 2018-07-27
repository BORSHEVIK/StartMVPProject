package com.example.aliaksandrmirashnichenka.myconductormvp.abs

abstract open class BasePresenterImpl<V : BaseView, M : BaseModel> : BasePresenter{

    internal val view: V;
    internal val model: M;

    constructor(view: V, model: M) {
        this.view = view;
        this.model = model;
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