package com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.BasePresenterImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.DataHolder
import java.util.*

class MyControllerPresenterImpl(view: MyControllerView, model: MyControllerModel, dataHolder: MyController.LocalDataHolder) : BasePresenterImpl<MyControllerView, MyControllerModel, MyController.LocalDataHolder>(view, model, dataHolder), MyControllerPresenter {

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