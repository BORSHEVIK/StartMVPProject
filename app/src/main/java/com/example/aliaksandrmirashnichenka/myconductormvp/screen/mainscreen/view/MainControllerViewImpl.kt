package com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.view

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.PresenterProvider
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.view.BaseViewImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.presenter.MainControllerPresenter

class MainControllerViewImpl : BaseViewImpl<MainControlleViewHolder, MainControllerPresenter>, MainControllerView {

    constructor(myControllerViewHolder: MainControlleViewHolder, presenterProvider: PresenterProvider<MainControllerPresenter>)
            : super(myControllerViewHolder, presenterProvider) {
        viewHolder.updateButton.setOnClickListener { presenterProvider.getPresenter().updateButtonClick() };
    }

    override fun updateMeessage(message: String) {
        viewHolder.messageTextView.setText(message);
    }

}