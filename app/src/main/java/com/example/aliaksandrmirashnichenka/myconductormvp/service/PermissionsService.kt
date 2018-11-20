package com.example.aliaksandrmirashnichenka.myconductormvp.service

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import com.example.aliaksandrmirashnichenka.myconductormvp.R
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.LocalSchedulers
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import timber.log.Timber
import java.util.*
import java.util.concurrent.ConcurrentHashMap

class PermissionsService(private val context: Context) {

    companion object {
        private val TAG = PermissionsService.javaClass.simpleName
    }

    private var granted = 0
    private var requesting = 0

    private val grantedSubject = BehaviorSubject.createDefault(granted)

    private val disposables = ConcurrentHashMap<Permission, Container>()

    private var listener: PermissionsCallbacks? = null

    enum class Permission private constructor(val mask: Int, @param:StringRes @field:StringRes
    val requestText: Int, vararg keys: String) {
        CAMERA(1, R.string.camera, Manifest.permission.CAMERA);

        val keys: Array<String>

        init {
            this.keys = keys as Array<String>
        }
    }

    fun getGrantedPermissionObservable(permission: Permission): Observable<Int> {
         return Observable.create { subscriber ->
             val disposable = grantedSubject
                     .observeOn(LocalSchedulers.mainThread())
                     .filter({ permissions ->
                         checkPermission(permission)
                     })
                     .subscribe({ permissions ->
                         subscriber.onNext(permissions)
                         subscriber.onComplete()
                     })
             disposables.put(permission, Container(disposable, subscriber))
        }
    }

    private fun checkPermission(permission: Permission): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true
        }

        if (granted and permission.mask == permission.mask) {
            return true
        }

        // check granted permissions
        val keys = ArrayList<String>()
        for (i in permission.keys.indices) {
            if (ContextCompat.checkSelfPermission(context, permission.keys[i]) != PackageManager.PERMISSION_GRANTED) {
                keys.add(permission.keys[i])
            }
        }

        // no permissions to request
        if (keys.size == 0) {
            updateGrantedPermissions(permission.mask)
            return false
        }

        if (listener != null) {
            var needExplanation = false
            // Should we show an explanation?
            for (i in permission.keys.indices) {
                if (keys.contains(permission.keys[i])) {
                    val explanation = if (permission.requestText == 0) null else context.getString(permission.requestText)
                    if (listener!!.onPermissionNeedShowExplanation(permission.keys[i], explanation)) {
                        needExplanation = true
                        break
                    }
                }
            }

            if (needExplanation) {
                // if not requested
                listener!!.onPermissionPending(permission)
            } else {
                // No explanation needed, we can request the permission.
                requestPermission(permission)
            }
        }

        return false
    }

    fun requestPermission(permission: Permission) {
        if (requesting and permission.mask == permission.mask) {
            // already in request
            return
        }
        requesting = requesting or permission.mask
        listener!!.onPermissionRequest(permission.keys, permission.ordinal)
    }

    fun handlePermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        Timber.i("Result %s", requestCode)
        //Timber.i("Permissions %s", ArrayUtils.join(permissions, permissions.size, ","))
        //Timber.i("Results %s", ArrayUtils.join(grantResults, grantResults.size, ","))

        val values = Permission.values()
        if (requestCode < 0 || requestCode > values.size - 1) {
            return
        }
        val permission = values[requestCode]

        requesting = requesting and permission.mask.inv()

        if (permissions.size < 1 || grantResults.size < 1) {
            return
        }

        var granted = true
        for (grantResult in grantResults) {
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                granted = false
                break
            }
        }

        if (granted) {
            updateGrantedPermissions(permission.mask)
        } else {
            updateNoneGrantedPermissions(permission)
        }
    }

    private fun updateNoneGrantedPermissions(permission: Permission) {
        val container = disposables.get(permission)
        if (container != null) {
            val disposable = container!!.disposable;
            val subscriber = container!!.subscriber;
            if (subscriber != null) {
                subscriber!!.onError(Throwable())
            }
            if (disposable != null) {
                disposable!!.dispose()
            }
            disposables.remove(permission)
        }
    }

    private fun updateGrantedPermissions(permissions: Int) {
        granted = granted or permissions
        grantedSubject.onNext(granted)
    }

    fun setListener(callbacks: PermissionsCallbacks) {
        listener = callbacks
    }

    fun removeListener(callbacks: PermissionsCallbacks) {
        if (listener === callbacks) {
            listener = null
        }
    }

    private class Container(val disposable: Disposable, val subscriber: ObservableEmitter<Int>)

    interface PermissionsCallbacks {

        fun onPermissionNeedShowExplanation(key: String, explanation: String?): Boolean

        fun onPermissionRequest(keys: Array<String>, requestCode: Int)

        fun onPermissionPending(permission: Permission)

        fun onPermissionShowExplanation(key: String, explanation: String?): Boolean
    }
}
