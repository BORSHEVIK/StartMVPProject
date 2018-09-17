package com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen

import android.os.Bundle
import android.view.View

import com.example.aliaksandrmirashnichenka.myconductormvp.R
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.BaseController
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.Arguments
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.model.MainControllerModel
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.model.MainControllerModelImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.presenter.MainControllerDataHolder
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.presenter.MainControllerPresenter
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.presenter.MainControllerPresenterImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.view.MainControlleViewHolder
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.view.MainControllerView
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.view.MainControllerViewImpl

class MainController(args: Bundle?) : BaseController<MainControlleViewHolder, MainControllerView, MainControllerModel, MainControllerDataHolder, MainControllerPresenter, Arguments>(args) {

    override fun getViewLayoutId(): Int {
        return R.layout.main_controller;
    }

    override fun createViewHolder(view: View): MainControlleViewHolder {
        return MainControlleViewHolder(view);
    }

    override fun createDataHolder(): MainControllerDataHolder {
        return MainControllerDataHolder();
    }

    override fun createView(viewHolder: MainControlleViewHolder): MainControllerView {
        return MainControllerViewImpl(viewHolder, this);
    }

    override fun createModel(): MainControllerModel {
        return MainControllerModelImpl(this);
    }

    override fun createPresenter(view: MainControllerView, model: MainControllerModel, dataHolder: MainControllerDataHolder): MainControllerPresenter {
        return MainControllerPresenterImpl(view, model, dataHolder);
    }

}
