package com.example.aliaksandrmirashnichenka.myconductormvp.screen.testscreen.presenter

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.Abs
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.PAbs
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.model.BaseModel
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.BasePresenter
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.BasePresenterImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.DataHolder
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.testscreen.view.TestControllerView

class TestControllerPresenterImpl(view: TestControllerView, model: BaseModel, dataHolder: DataHolder, arguments: TestArguments, abs: PAbs)
    : BasePresenterImpl<TestControllerView, BaseModel, DataHolder, TestArguments>(view, model, dataHolder, arguments, abs), BasePresenter {

    override fun onResume() {
        super.onResume();

        view.updateMeessage(arguments.value.toString());
    }
}