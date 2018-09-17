package com.example.aliaksandrmirashnichenka.myconductormvp.abs

import android.os.Bundle
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.SimpleSwapChangeHandler
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.Navigator.Companion.PROPERTY_ROUTER
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.Arguments
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.MainController
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.testscreen.TestControlle
import org.koin.dsl.module.module

class Navigator(router: Router) {

    companion object {
        val PROPERTY_ROUTER = "PROPERTY_ROUTER";
    }

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
        var controller: Controller = getRootController(bundle);
        bundle.putSerializable(Screens.SCREEN_ARGUMENTS, arguments);

        when (screenId) {
            Screens.SCREEN_MAIN -> {
                controller = MainController(bundle);
            }
            Screens.SCREEN_TEST -> {
                controller = TestControlle(bundle);
            }
        }

        val routerTransaction: RouterTransaction = RouterTransaction.with(controller).popChangeHandler(popChangeHandler).pushChangeHandler(pushChangeHandler);
        router.pushController(routerTransaction);
    }

    private fun getRootController(bundle: Bundle): Controller {
        bundle.putSerializable(Screens.SCREEN_ARGUMENTS, Arguments());
        return MainController(bundle);
    }

}

val navigatorModule = module {
    single { Navigator(getProperty(PROPERTY_ROUTER)) }
}