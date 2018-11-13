package com.example.aliaksandrmirashnichenka.myconductormvp.abs

import android.os.Bundle
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.DialogControllerStub
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.presenter.DialogArguments
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.Arguments
import com.example.aliaksandrmirashnichenka.myconductormvp.dialog.message.MessageDialogController
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.mainscreen.MainController
import com.example.aliaksandrmirashnichenka.myconductormvp.screen.testscreen.TestControlle
import java.io.Serializable
import java.util.*


class Navigator : Serializable {

    companion object {
        private var sInstance: Navigator? = null;

        fun getInstance(router: Router, dialogRouter: Router): Navigator {
            sInstance = Navigator(router, dialogRouter);
            return sInstance as Navigator;
        }
    }

    private val router: Router;
    private val dialogRouter: Router;

    private constructor(router: Router, dialogRouter: Router) {
        this.router = router;
        this.dialogRouter = dialogRouter;

        if (!router.hasRootController()) {
            router.setRoot(createScreenTransaction(getRootController(Bundle()), Arguments()));
        }
        if (!dialogRouter.hasRootController()) {
            dialogRouter.setRoot(RouterTransaction.with(DialogControllerStub(Bundle())));
        }
    }

    fun showScreen(screenId: Int) {
        this.showScreen(screenId, Arguments());
    }

    fun showScreen(screenId: Int, arguments: Arguments) {
        this.showScreen(screenId, arguments, FadeChangeHandler(), FadeChangeHandler());
    }

    fun showScreen(screenId: Int, arguments: Arguments, popChangeHandler: ControllerChangeHandler, pushChangeHandler: ControllerChangeHandler) {

        var bundle = Bundle();
        var controller: Controller = getRootController(bundle);

        when (screenId) {
            Screen.SCREEN_MAIN -> {
                controller = MainController(bundle);
            }
            Screen.SCREEN_TEST -> {
                controller = TestControlle(bundle);
            }
        }

        val routerTransaction: RouterTransaction = createScreenTransaction(controller, arguments)
                .popChangeHandler(popChangeHandler).pushChangeHandler(pushChangeHandler);
        router.pushController(routerTransaction);
    }

    private fun createScreenTransaction(controller: Controller, arguments: Arguments): RouterTransaction {
        arguments.controllerTag = createTag(controller);
        controller.args.putSerializable(Screen.SCREEN_ARGUMENTS, arguments);
        return RouterTransaction.with(controller).tag(arguments.controllerTag);
    }

    fun showDialog(dialogId: Int, parrentTag: String) {
        this.showDialog(dialogId, DialogArguments(parrentTag));
    }

    fun showDialog(dialogId: Int, arguments: DialogArguments) {
        val bundle = Bundle();

        var controller: Controller? = null;

        when (dialogId) {
            Screen.DIALOG_MESSAGE -> {
                controller = MessageDialogController(bundle);
            }
        }

        if (controller != null) {
            arguments.controllerTag = createTag(controller);
            controller.args.putSerializable(Screen.SCREEN_ARGUMENTS, arguments)

            val routerTransaction: RouterTransaction = RouterTransaction.with(controller)
                    .tag(arguments.controllerTag)
                    .popChangeHandler(FadeChangeHandler())
                    .pushChangeHandler(FadeChangeHandler());
            dialogRouter.pushController(routerTransaction);
        }
    }

    fun closeCurrentDialog(tag: String) {
        val controller = dialogRouter.getControllerWithTag(tag)
        if (controller != null) {
            dialogRouter.popController(controller)
        }
    }

    fun getRootController(bundle: Bundle): Controller {
        bundle.putSerializable(Screen.SCREEN_ARGUMENTS, Arguments());
        return MainController(bundle);
    }

    fun getControllerByTag(controllerTag: String): Controller {
        return router.getControllerWithTag(controllerTag)!!;
    }

    private fun createTag(controller: Controller): String {
        return controller.javaClass.simpleName + UUID.randomUUID();
    }

}