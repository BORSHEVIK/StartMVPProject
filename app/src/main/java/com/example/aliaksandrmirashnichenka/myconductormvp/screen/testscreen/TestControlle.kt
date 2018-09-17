package com.example.aliaksandrmirashnichenka.myconductormvp.screen.testscreen

import android.os.Bundle
import android.view.View
import com.example.aliaksandrmirashnichenka.myconductormvp.R
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.Abs
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.BaseController
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.PresenterProvider
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.model.BaseModel
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.model.BaseModelImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.BasePresenter
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.DataHolder
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.view.BaseView
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.testscreen.presenter.TestArguments
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.testscreen.presenter.TestControllerPresenterImpl
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.testscreen.view.TestControllerView
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.testscreen.view.TestControllerViewHolder
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.testscreen.view.TestControllerViewImpl

class TestControlle(args: Bundle?) : BaseController<TestControllerViewHolder, TestControllerView, BaseModel, DataHolder, BasePresenter, TestArguments>(args), PresenterProvider<BasePresenter> {

    override fun createDataHolder(): DataHolder {
        return DataHolder()
    }

    override fun createViewHolder(view: View): TestControllerViewHolder {
        return TestControllerViewHolder(view)
    }

    override fun createView(viewHolder: TestControllerViewHolder): TestControllerView {
        return TestControllerViewImpl(viewHolder, this)
    }

    override fun createPresenter(view: TestControllerView, model: BaseModel, dataHolder: DataHolder, arguments: TestArguments, abs: Abs): BasePresenter {
        return TestControllerPresenterImpl(view, model, dataHolder, arguments, abs)
    }

    override fun createModel(): BaseModel {
        return BaseModelImpl(this)
    }

    override fun getViewLayoutId(): Int {
        return R.layout.test_controller
    }
}