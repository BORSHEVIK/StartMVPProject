package com.example.aliaksandrmirashnichenka.myconductormvp.screen.testscreen.view

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.PresenterProvider
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.BasePresenter
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.view.BaseViewImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.presenter.MainControllerPresenter
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.view.MainControllerViewHolder

class TestControllerViewImpl : BaseViewImpl<TestControllerViewHolder, BasePresenter>, TestControllerView  {

    constructor(myControllerViewHolder: TestControllerViewHolder, presenterProvider: PresenterProvider<BasePresenter>)
            : super(myControllerViewHolder, presenterProvider) {
    }

    override fun updateMeessage(message: String) {
        viewHolder.messageTextView.setText("This is second screen with shared value: " + message);
    }

}