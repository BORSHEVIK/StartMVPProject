package com.example.aliaksandrmirashnichenka.myconductormvp.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.example.aliaksandrmirashnichenka.myconductormvp.R
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.Abs
import com.example.aliaksandrmirashnichenka.myconductormvp.service.Navigator
import com.example.aliaksandrmirashnichenka.myconductormvp.service.ToastManager
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.BaseDialogEventListener
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.DialogEventListenerStub
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.DialogEventProvider

class MainActivity : AppCompatActivity(), Abs {

    private lateinit var router: Router;
    private lateinit var dialogRouter: Router;
    private lateinit var navigator: Navigator;
    private lateinit var toastManager: ToastManager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = findViewById(R.id.container) as ViewGroup
        val dialogContainer = findViewById(R.id.dialogContainer) as ViewGroup;

        router = Conductor.attachRouter(this, container, savedInstanceState)
        dialogRouter = Conductor.attachRouter(this, dialogContainer, savedInstanceState)
        navigator = Navigator(router, dialogRouter);
        toastManager = ToastManager(applicationContext);
    }

    override fun onBackPressed() {
        if (dialogRouter.backstackSize > 1 && dialogRouter.handleBack()) {
        } else if (!router.handleBack()) {
            super.onBackPressed()
        }
    }

    override fun getNavigator(): Navigator {
        return navigator;
    }

    override fun getToastManager(): ToastManager {
        return toastManager;
    }

    //TODO how to move it in navigator without problems or it not needed?
    override fun getControllerEventListnerByTag(controllerTag: String): BaseDialogEventListener {
        val controller: Controller = router.getControllerWithTag(controllerTag)!!;
        return if (controller is DialogEventProvider) controller.provideEvent() else DialogEventListenerStub();
    }

}
