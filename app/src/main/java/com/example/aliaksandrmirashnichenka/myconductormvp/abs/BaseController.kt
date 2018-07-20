package com.example.aliaksandrmirashnichenka.myconductormvp.abs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.example.aliaksandrmirashnichenka.myconductormvp.R

open abstract class BaseController<H : ViewHolder, V : BaseView, P : BasePresenter>: Controller(), PresenterProvider<P> {

    private var viewHolder: H? = null;
    private var viewImpl: V? = null;
    private var presenter: P? = null;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view: View = inflater.inflate(getViewLayoutId(), container, false);

        this.viewHolder = createViewHolder(view);
        this.viewImpl = createView(this.viewHolder!!);
        this.presenter = createPresenter(this.viewImpl!!);

        return view;
    }

    override fun onDestroyView(view: View) {
        super.onDestroyView(view);
        this.viewHolder = null;
        this.viewImpl = null;
        this.presenter = null;
    }

    open abstract fun createViewHolder(view: View): H;
    open abstract fun createView(viewHolder: H): V;
    open abstract fun createPresenter(view: V): P;
    open abstract fun getViewLayoutId(): Int;

    override fun getPresenter(): P {
        return this.presenter!!;
    }

}