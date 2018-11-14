package com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message

import android.os.Bundle
import android.view.View
import com.example.aliaksandrmirashnichenka.myconductormvp.R
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.Abs
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.BaseDialogController
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.model.BaseModel
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.DataHolder
import com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.presenter.MessageDialogArguments
import com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.presenter.MessageDialogPresenter
import com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.presenter.MessageDialogPresenterImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.view.MessageDialogView
import com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.view.MessageDialogViewHolder
import com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.view.MessageDialogViewImpl

class MessageDialogController(args: Bundle?) : BaseDialogController<MessageDialogViewHolder, MessageDialogView, DataHolder, MessageDialogPresenter, MessageDialogArguments, MessageCallback>(args) {

    override fun createDataHolder(): DataHolder {
        return DataHolder()
    }

    override fun createViewHolder(view: View): MessageDialogViewHolder {
        return MessageDialogViewHolder(view)
    }

    override fun createView(viewHolder: MessageDialogViewHolder): MessageDialogView {
        return MessageDialogViewImpl(viewHolder, this)
    }

    override fun createPresenter(view: MessageDialogView, model: BaseModel, dataHolder: DataHolder, arguments: MessageDialogArguments, abs: Abs): MessageDialogPresenter {
        return MessageDialogPresenterImpl(view, model, dataHolder, arguments, abs)
    }

    override fun getViewLayoutId(): Int {
        return R.layout.message_dialog
    }

}