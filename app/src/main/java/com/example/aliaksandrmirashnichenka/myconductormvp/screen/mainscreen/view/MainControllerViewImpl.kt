package com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.view

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.PresenterProvider
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.view.BaseViewImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.presenter.MainControllerPresenter

class MainControllerViewImpl : BaseViewImpl<MainControllerViewHolder, MainControllerPresenter>, MainControllerView {

    constructor(myControllerViewHolder: MainControllerViewHolder, presenterProvider: PresenterProvider<MainControllerPresenter>)
            : super(myControllerViewHolder, presenterProvider) {
        viewHolder.updateButton.setOnClickListener { presenterProvider.getPresenter().updateButtonClick() }
        viewHolder.nextButton.setOnClickListener { presenterProvider.getPresenter().nextButtonClick() }
        viewHolder.showDialog.setOnClickListener { presenterProvider.getPresenter().dialogButtonClick() }
    }

    override fun updateMeessage(message: String) {
        viewHolder.messageTextView.setText(message);
    }

}