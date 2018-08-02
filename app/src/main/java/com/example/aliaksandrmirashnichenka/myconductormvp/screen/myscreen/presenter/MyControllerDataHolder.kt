package com.example.aliaksandrmirashnichenka.myconductormvp.screen.myscreen.presenter

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.DataHolder

class MyControllerDataHolder: DataHolder {

    private val BUNDLE_VALUE = "BUNDLE_VALUE";

    public var value: Int = 30;

    constructor(bundle: MutableMap<String, Any>): super(bundle) {
        if (bundle.containsKey(BUNDLE_VALUE)) {
            this.value = bundle.get(BUNDLE_VALUE) as Int;
        }
    }

    override fun save() {
        bundle.put(BUNDLE_VALUE, value);
    }

}