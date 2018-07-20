package com.example.aliaksandrmirashnichenka.myconductormvp.abs

open class BaseViewImpl<V : ViewHolder, P : BasePresenter> : BaseView {

    internal val viewHolder: V;
    internal val presenterProvider: PresenterProvider<P>;

    constructor(viewHolder: V, presenterProvider: PresenterProvider<P>) {
        this.viewHolder = viewHolder;
        this.presenterProvider = presenterProvider;
    }

}