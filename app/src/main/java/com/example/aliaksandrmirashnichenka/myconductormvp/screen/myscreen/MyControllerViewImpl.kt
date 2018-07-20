package com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.BaseViewImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.PresenterProvider

class MyControllerViewImpl : BaseViewImpl<MyControlleViewHolder, MyControllerPresenter>, MyControllerView {

    constructor(myControllerViewHolder: MyControlleViewHolder, presenterProvider: PresenterProvider<MyControllerPresenter>)
            : super(myControllerViewHolder, presenterProvider) {
        viewHolder.updateButton.setOnClickListener { presenterProvider.getPresenter().updateButtonClick() };
    }

    override fun updateMeessage(message: String) {
        viewHolder.messageTextView.setText(message);
    }

}