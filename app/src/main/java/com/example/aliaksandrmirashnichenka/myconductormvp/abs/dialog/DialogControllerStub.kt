package com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller

class DialogControllerStub(args: Bundle?) : Controller(args) {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return View(applicationContext);
    }
}