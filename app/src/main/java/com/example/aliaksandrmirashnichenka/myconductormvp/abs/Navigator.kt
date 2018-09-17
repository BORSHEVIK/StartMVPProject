package com.example.aliaksandrmirashnichenka.myconductormvp.abs

import android.os.Bundle
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.SimpleSwapChangeHandler
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.Abs
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.Arguments
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.MainController

class Navigator(router: Router) {

    private val router: Router = router;

    init {
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(getRootController(Bundle())))
        }
    }

    fun showScreen(screenId: Int) {
        this.showScreen(screenId, Arguments());
    }

    fun showScreen(screenId: Int, arguments: Arguments) {
        this.showScreen(screenId, arguments, SimpleSwapChangeHandler(), SimpleSwapChangeHandler());
    }

    fun showScreen(screenId: Int, arguments: Arguments, popChangeHandler: ControllerChangeHandler, pushChangeHandler: ControllerChangeHandler) {

        var bundle: Bundle = Bundle();
        bundle.putSerializable(Abs.SCREEN_ARGUMENTS, arguments);
        var controller: Controller = getRootController(bundle);

        when (screenId) {
            Abs.SCREEN_MYSCREEN -> {
                controller = MainController(bundle);
            }
        }

        val routerTransaction: RouterTransaction = RouterTransaction.with(controller).popChangeHandler(popChangeHandler).pushChangeHandler(pushChangeHandler);
        router.pushController(routerTransaction);
    }

    private fun getRootController(bundle: Bundle): Controller {
        bundle.putSerializable(Abs.SCREEN_ARGUMENTS, Arguments());
        return MainController(bundle);
    }

}