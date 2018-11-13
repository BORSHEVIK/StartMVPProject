package com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen

import android.os.Bundle
import android.view.View
import com.example.aliaksandrmirashnichenka.myconductormvp.R
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.Abs
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.BaseController
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.BaseDialogEventListener
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.Arguments
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.model.MainControllerModel
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.model.MainControllerModelImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.presenter.MainControllerDataHolder
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.presenter.MainControllerPresenter
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.presenter.MainControllerPresenterImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.view.MainControllerView
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.view.MainControllerViewHolder
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.view.MainControllerViewImpl

class MainController(args: Bundle?) : BaseController<MainControllerViewHolder, MainControllerView, MainControllerModel, MainControllerDataHolder, MainControllerPresenter, Arguments>(args) {

    override fun getViewLayoutId(): Int {
        return R.layout.main_controller;
    }

    override fun createViewHolder(view: View): MainControllerViewHolder {
        return MainControllerViewHolder(view);
    }

    override fun createDataHolder(): MainControllerDataHolder {
        return MainControllerDataHolder();
    }

    override fun createView(viewHolder: MainControllerViewHolder): MainControllerView {
        return MainControllerViewImpl(viewHolder, this);
    }

    override fun createModel(): MainControllerModel {
        return MainControllerModelImpl(this);
    }

    override fun createPresenter(view: MainControllerView, model: MainControllerModel, dataHolder: MainControllerDataHolder, arguments: Arguments, abs: Abs): MainControllerPresenter {
        return MainControllerPresenterImpl(view, model, dataHolder, arguments, abs);
    }

    override fun provideEvent(): BaseDialogEventListener {
        return getPresenter();
    }

}
