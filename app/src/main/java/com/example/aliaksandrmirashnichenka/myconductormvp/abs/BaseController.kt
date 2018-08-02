package com.example.aliaksandrmirashnichenka.myconductormvp.abs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import java.io.Serializable

open abstract class BaseController<H: ViewHolder, V: BaseView, M: BaseModel, D: DataHolder, P: BasePresenter>(args: Bundle?) : Controller(args), PresenterProvider<P> {

    private val BUNDLE_DATA_HOLDER = "BUNDLE_DATA_HOLDER";

    private var viewHolder: H? = null;
    private var view: V? = null;
    private var presenter: P? = null;
    private var model: M? = null;
    private var dataHolder: D? = null;


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view: View = inflater.inflate(getViewLayoutId(), container, false);

        var dataBundle: MutableMap<String, Any> = HashMap();
        val serializeble: Serializable? = args.getSerializable(BUNDLE_DATA_HOLDER);
        if (serializeble == null) {
            dataBundle = HashMap();
        } else {
            dataBundle = args.getSerializable(BUNDLE_DATA_HOLDER) as MutableMap<String, Any>;
        }
        this.dataHolder = createDataHolder(dataBundle);

        this.viewHolder = createViewHolder(view);
        this.view = createView(this.viewHolder!!);
        this.model = createModel();
        this.presenter = createPresenter(this.view!!, this.model!!, this.dataHolder!!);

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

        super.onDestroyView(view);
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val map: HashMap<String, Any> = HashMap(presenter!!.onSaveInstanceState());
        args.putSerializable(BUNDLE_DATA_HOLDER, map);
        super.onSaveInstanceState(outState);
    }

    open abstract fun createDataHolder(bundle: MutableMap<String, Any>): D;
    open abstract fun createViewHolder(view: View): H;
    open abstract fun createView(viewHolder: H): V;
    open abstract fun createPresenter(view: V, model: M, dataHolder: D): P;
    open abstract fun createModel(): M;
    open abstract fun getViewLayoutId(): Int;

    override fun getPresenter(): P {
        return this.presenter!!;
    }

}