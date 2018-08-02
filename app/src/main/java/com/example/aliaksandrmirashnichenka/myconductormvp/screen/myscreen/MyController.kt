package com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen

import android.os.Bundle
import android.view.View

import com.example.aliaksandrmirashnichenka.myconductormvp.R
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.BaseController
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.DataHolder

class MyController(args: Bundle?) : BaseController<MyControlleViewHolder, MyControllerView, MyControllerModel, MyController.LocalDataHolder, MyControllerPresenter>(args) {

    override fun getViewLayoutId(): Int {
        return R.layout.my_controller;
    }

    override fun createViewHolder(view: View): MyControlleViewHolder {
        return MyControlleViewHolder(view);
    }

    override fun createDataHolder(bundle: MutableMap<String, Any>): LocalDataHolder {
        return LocalDataHolder(bundle);
    }

    override fun createView(viewHolder: MyControlleViewHolder): MyControllerView {
        return MyControllerViewImpl(viewHolder, this);
    }

    override fun createModel(): MyControllerModel {
        return MyControllerModelImpl(this);
    }

    override fun createPresenter(view: MyControllerView, model: MyControllerModel, dataHolder: LocalDataHolder): MyControllerPresenter {
        return MyControllerPresenterImpl(view, model, dataHolder);
    }

    inner class LocalDataHolder: DataHolder {

        private val BUNDLE_VALUE = "BUNDLE_VALUE";

        public var value: Int = 30;

        constructor(bundle: MutableMap<String, Any>): super(bundle) {
            if (bundle.containsKey(BUNDLE_VALUE)) {
                this.value = bundle.get(BUNDLE_VALUE) as Int;
            }
        }

        override fun save() {
            bundle.put(BUNDLE_VALUE, value);
        }

    }

}
