package com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen.presenter

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.BasePresenterImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen.view.MyControllerView
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen.model.MyControllerModel
import java.util.*

class MyControllerPresenterImpl(view: MyControllerView, model: MyControllerModel, dataHolder: MyControllerDataHolder) :
        BasePresenterImpl<MyControllerView, MyControllerModel, MyControllerDataHolder>(view, model, dataHolder), MyControllerPresenter {

    private val MESSAGE = "Message form presenter and randome int value = ";

    override fun onResume() {
        super.onResume();
        view.updateMeessage(MESSAGE + dataHolder.value);
    }

    override fun updateButtonClick() {
        dataHolder.value = (0 .. 1000000).random();
        view.updateMeessage(MESSAGE + dataHolder.value);
    }

    private fun ClosedRange<Int>.random() =
            Random().nextInt((endInclusive + 1) - start) +  start;

}