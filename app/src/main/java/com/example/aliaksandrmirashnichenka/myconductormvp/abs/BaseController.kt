package com.example.aliaksandrmirashnichenka.myconductormvp.abs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.model.BaseModel
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.Arguments
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.BasePresenter
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.DataHolder
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.view.BaseView
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.view.ViewHolder
import com.example.aliaksandrmirashnichenka.myconductormvp.activity.MainActivity
import java.io.Serializable

open abstract class BaseController<H: ViewHolder, V: BaseView, M: BaseModel, D: DataHolder, P: BasePresenter, A: Arguments>(args: Bundle?) : Controller(args), PresenterProvider<P> {

    private val BUNDLE_DATA_HOLDER = "BUNDLE_DATA_HOLDER";

    private var viewHolder: H? = null;
    private var view: V? = null;
    private var presenter: P? = null;
    private var model: M? = null;
    private var dataHolder: D? = null;
    private lateinit var arguments: A;
    private lateinit var abs: Abs;


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view: View = inflater.inflate(getViewLayoutId(), container, false);

        if (this.dataHolder == null) {
            val serializeble: Serializable? = args.getSerializable(BUNDLE_DATA_HOLDER);

            if (serializeble == null) {
                this.dataHolder = createDataHolder();
            } else {
                this.dataHolder = args.getSerializable(BUNDLE_DATA_HOLDER) as D;
            }
        }

        this.abs = activity as Abs;

        this.arguments = args.getSerializable(Screens.SCREEN_ARGUMENTS) as A;

        this.viewHolder = createViewHolder(view);
        this.view = createView(this.viewHolder!!);
        this.model = createModel();
        this.presenter = createPresenter(this.view!!, this.model!!, this.dataHolder!!, this.arguments!!, abs);

        this.presenter!!.onCreate();

        return view;
    }

    override fun onAttach(view: View) {
        super.onAttach(view);
        this.presenter!!.onResume();
    }

    override fun onDetach(view: View) {
        super.onDetach(view);
        this.presenter!!.onStop();
    }

    override fun onDestroyView(view: View) {
        presenter!!.onDestroy();

        this.viewHolder = null;
        this.view = null;
        this.presenter = null;
        this.model = null;

        super.onDestroyView(view);
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    override fun onSaveInstanceState(outState: Bundle) {
        args.putSerializable(BUNDLE_DATA_HOLDER, presenter!!.onSaveInstanceState());
        super.onSaveInstanceState(outState);
    }

    open abstract fun createDataHolder(): D;
    open abstract fun createViewHolder(view: View): H;
    open abstract fun createView(viewHolder: H): V;
    open abstract fun createPresenter(view: V, model: M, dataHolder: D, arguments: A, abs: Abs): P;
    open abstract fun createModel(): M;
    open abstract fun getViewLayoutId(): Int;

    override fun getPresenter(): P {
        return this.presenter!!;
    }

}