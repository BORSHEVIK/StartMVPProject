package com.example.aliaksandrmirashnichenka.myconductormvp.abs

interface PresenterProvider<P : BasePresenter> {

    fun getPresenter(): P;

}