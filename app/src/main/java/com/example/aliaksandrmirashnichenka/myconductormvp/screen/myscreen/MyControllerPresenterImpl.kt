package com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.BasePresenterImpl
import java.util.*

class MyControllerPresenterImpl(view: MyControllerView) : BasePresenterImpl<MyControllerView>(view), MyControllerPresenter {

    override fun updateButtonClick() {
        view.updateMeessage("Message form presenter and randome int value = " + (0 .. 1000000).random());
    }

    private fun ClosedRange<Int>.random() =
            Random().nextInt((endInclusive + 1) - start) +  start;

}