package com.example.aliaksandrmirashnichenka.myconductormvp.abs

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.BasePresenter

interface PresenterProvider<P : BasePresenter> {

    fun getPresenter(): P;

}