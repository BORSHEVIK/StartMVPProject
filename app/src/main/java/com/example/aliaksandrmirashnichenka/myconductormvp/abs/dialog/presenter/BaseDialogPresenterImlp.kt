package com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.presenter

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.Abs
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.PAbs
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.BaseDialogEventListener
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.model.BaseModel
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.BasePresenterImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.DataHolder
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.view.BaseView

abstract open class BaseDialogPresenterImlp<V: BaseView, M: BaseModel, D: DataHolder, A: DialogArguments, L: BaseDialogEventListener>(view: V, model: M, dataHolder: D, arguments: A, abs: PAbs) :
        BasePresenterImpl<V, M, D, A>(view, model, dataHolder, arguments, abs), BaseDialogPresenter<L> {

    internal lateinit var eventListener: L;

    override fun attachEventListener(eventListener: L) {
        this.eventListener = eventListener;
    }

    fun getControllerTag(): String {
        return arguments.controllerTag;
    }
}