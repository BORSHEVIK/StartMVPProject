package com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen

import android.os.Bundle
import android.view.View

import com.example.aliaksandrmirashnichenka.myconductormvp.R
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.BaseController
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen.model.MyControllerModel
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen.model.MyControllerModelImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen.presenter.MyControllerDataHolder
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen.presenter.MyControllerPresenter
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen.presenter.MyControllerPresenterImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen.view.MyControlleViewHolder
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen.view.MyControllerView
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen.view.MyControllerViewImpl

class MyController(args: Bundle?) : BaseController<MyControlleViewHolder, MyControllerView, MyControllerModel, MyControllerDataHolder, MyControllerPresenter>(args) {

    override fun getViewLayoutId(): Int {
        return R.layout.my_controller;
    }

    override fun createViewHolder(view: View): MyControlleViewHolder {
        return MyControlleViewHolder(view);
    }

    override fun createDataHolder(): MyControllerDataHolder {
        return MyControllerDataHolder();
    }

    override fun createView(viewHolder: MyControlleViewHolder): MyControllerView {
        return MyControllerViewImpl(viewHolder, this);
    }

    override fun createModel(): MyControllerModel {
        return MyControllerModelImpl(this);
    }

    override fun createPresenter(view: MyControllerView, model: MyControllerModel, dataHolder: MyControllerDataHolder): MyControllerPresenter {
        return MyControllerPresenterImpl(view, model, dataHolder);
    }

}
