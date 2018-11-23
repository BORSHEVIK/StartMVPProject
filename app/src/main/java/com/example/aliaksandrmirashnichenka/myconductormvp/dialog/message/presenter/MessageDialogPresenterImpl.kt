package com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.presenter

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.Abs
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.PAbs
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.presenter.BaseDialogPresenterImlp
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.model.BaseModel
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.DataHolder
import com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.MessageCallback
import com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.view.MessageDialogView

class MessageDialogPresenterImpl(view: MessageDialogView, model: BaseModel, dataHolder: DataHolder, arguments: MessageDialogArguments, abs: PAbs) :
        BaseDialogPresenterImlp<MessageDialogView, BaseModel, DataHolder, MessageDialogArguments, MessageCallback>(view, model, dataHolder, arguments, abs), MessageDialogPresenter {

    override fun onResume() {
        super.onResume();
        view.setMeessage(arguments.value);
    }

    override fun okButtonClick() {
        abs.getNavigator().closeCurrentDialog(getControllerTag());
        eventListener.okPressed();
    }
}