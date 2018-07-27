package com.example.aliaksandrmirashnichenka.myconductormvp.abs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller

open abstract class BaseController<H : ViewHolder, V : BaseView, M : BaseModel, P : BasePresenter>: Controller(), PresenterProvider<P> {

    private var viewHolder: H? = null;
    private var view: V? = null;
    private var presenter: P? = null;
    private var model: M? = null;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view: View = inflater.inflate(getViewLayoutId(), container, false);

        this.viewHolder = createViewHolder(view);
        this.view = createView(this.viewHolder!!);
        this.model = createModel();
        this.presenter = createPresenter(this.view!!, this.model!!);

        return view;
    }

    override fun onDestroyView(view: View) {
        super.onDestroyView(view);
        this.viewHolder = null;
        this.view = null;
        this.presenter = null;
    }

    open abstract fun createViewHolder(view: View): H;
    open abstract fun createView(viewHolder: H): V;
    open abstract fun createPresenter(view: V, model: M): P;
    open abstract fun createModel(): M;
    open abstract fun getViewLayoutId(): Int;

    override fun getPresenter(): P {
        return this.presenter!!;
    }

}