package com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.view

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.PresenterProvider
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.view.BaseViewImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.presenter.MessageDialogPresenter

class MessageDialogViewImpl : BaseViewImpl<MessageDialogViewHolder, MessageDialogPresenter>, MessageDialogView {

    constructor(messageDialogViewHolder: MessageDialogViewHolder, presenterProvider: PresenterProvider<MessageDialogPresenter>)
            : super(messageDialogViewHolder, presenterProvider) {
        viewHolder.okButton.setOnClickListener { presenterProvider.getPresenter().okButtonClick() };
    }

    override fun setMeessage(message: String) {
        viewHolder.messageTextView.setText(message);
    }

}