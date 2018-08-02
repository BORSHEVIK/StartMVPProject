package com.example.aliaksandrmirashnichenka.myconductormvp.abs

import android.view.View

open class DataHolder {

    internal val bundle: MutableMap<String, Any>;

    constructor(bundle: MutableMap<String, Any>) {
        this.bundle = bundle;
    }

    open fun save(): MutableMap<String, Any> {
        return bundle;
    }

}