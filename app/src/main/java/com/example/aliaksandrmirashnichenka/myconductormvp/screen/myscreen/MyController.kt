package com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen

import android.view.View

import com.example.aliaksandrmirashnichenka.myconductormvp.R
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.BaseController

class MyController : BaseController<MyControlleViewHolder, MyControllerView, MyControllerPresenter>() {

    override fun getViewLayoutId(): Int {
        return R.layout.my_controller;
    }

    override fun createViewHolder(view: View): MyControlleViewHolder {
        return MyControlleViewHolder(view);
    }

    override fun createView(viewHolder: MyControlleViewHolder): MyControllerView {
        return MyControllerViewImpl(viewHolder, this);
    }

    override fun createPresenter(view: MyControllerView): MyControllerPresenter {
        return MyControllerPresenterImpl(view);
    }

}
