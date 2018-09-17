package com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.presenter

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.BasePresenterImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.model.MainControllerModel
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.view.MainControllerView
import java.util.*

class MainControllerPresenterImpl(view: MainControllerView, model: MainControllerModel, dataHolder: MainControllerDataHolder) :
        BasePresenterImpl<MainControllerView, MainControllerModel, MainControllerDataHolder>(view, model, dataHolder), MainControllerPresenter {

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