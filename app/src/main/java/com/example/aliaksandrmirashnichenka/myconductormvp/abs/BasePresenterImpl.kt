package com.example.aliaksandrmirashnichenka.myconductormvp.abs

abstract open class BasePresenterImpl<V : BaseView> : BasePresenter{

    internal val view: V;

    constructor(view: V) {
        this.view = view;
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