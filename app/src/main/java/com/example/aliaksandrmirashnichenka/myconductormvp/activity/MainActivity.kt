package com.example.aliaksandrmirashnichenka.myconductormvp.activity

import android.content.Context
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.example.aliaksandrmirashnichenka.myconductormvp.R
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.Abs
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.BaseDialogEventListener
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.DialogEventListenerStub
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.DialogEventProvider
import com.example.aliaksandrmirashnichenka.myconductormvp.service.Navigator
import com.example.aliaksandrmirashnichenka.myconductormvp.service.PermissionsService
import com.example.aliaksandrmirashnichenka.myconductormvp.service.ToastManager


class MainActivity : AppCompatActivity(), Abs, PermissionsService.PermissionsCallbacks {

    private lateinit var router: Router;
    private lateinit var dialogRouter: Router;
    private lateinit var navigator: Navigator;
    private lateinit var toastManager: ToastManager;
    private lateinit var permissionsService: PermissionsService;
    private var pendingPermission: PermissionsService.Permission? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = findViewById(R.id.container) as ViewGroup
        val dialogContainer = findViewById(R.id.dialogContainer) as ViewGroup;

        router = Conductor.attachRouter(this, container, savedInstanceState)
        dialogRouter = Conductor.attachRouter(this, dialogContainer, savedInstanceState)
        navigator = Navigator(router, dialogRouter);
        toastManager = ToastManager(applicationContext);
        permissionsService = PermissionsService(applicationContext);
    }

    override fun onStart() {
        super.onStart();
        permissionsService.setListener(this)
    }

    override fun onStop() {
        permissionsService.removeListener(this);
        super.onStop()
    }

    override fun onBackPressed() {
        if (dialogRouter.backstackSize > 1 && dialogRouter.handleBack()) {
        } else if (!router.handleBack()) {
            super.onBackPressed()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        permissionsService.handlePermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onPermissionNeedShowExplanation(key: String, explanation: String?): Boolean {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, key)) {
            showPermisionMessage(explanation!!);
            return true
        }
        return false
    }

    override fun onPermissionRequest(keys: Array<String>, requestCode: Int) {
        ActivityCompat.requestPermissions(this, keys, requestCode)
    }

    override fun onPermissionPending(permission: PermissionsService.Permission) {
        pendingPermission = permission
    }

    override fun onPermissionShowExplanation(key: String, explanation: String?): Boolean {
        showPermisionMessage(explanation!!);
        return false
    }

    override fun getNavigator(): Navigator {
        return navigator;
    }

    override fun getToastManager(): ToastManager {
        return toastManager;
    }

    override fun getPermissionService(): PermissionsService {
        return permissionsService;
    }

    //TODO how to move it in navigator without problems or it not needed?
    override fun getControllerEventListnerByTag(controllerTag: String): BaseDialogEventListener {
        val controller: Controller = router.getControllerWithTag(controllerTag)!!;
        return if (controller is DialogEventProvider) controller.provideEvent() else DialogEventListenerStub();
    }

    override fun getContext(): Context {
        return applicationContext;
    }

    private fun showPermisionMessage(message: String) {
        val builder: AlertDialog.Builder
        builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.message_title)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, { dialog, which ->
                    if (pendingPermission != null) {
                        val p = pendingPermission
                        pendingPermission = null
                        permissionsService.requestPermission(p!!);
                    }
                })
                .setCancelable(false)
                .show()
    }

}
