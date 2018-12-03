package com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter

import java.io.Serializable

open class Arguments() : Serializable {

    lateinit var controllerTag: String;
    var parrentTag: String? = null;

    constructor(parrentTag: String) : this() {
        this.parrentTag = parrentTag
    }

}