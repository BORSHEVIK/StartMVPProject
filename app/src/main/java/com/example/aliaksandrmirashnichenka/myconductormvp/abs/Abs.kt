package com.example.aliaksandrmirashnichenka.myconductormvp.abs

import android.content.Context
import com.example.aliaksandrmirashnichenka.myconductormvp.abs.dialog.BaseDialogEventListener
import com.example.aliaksandrmirashnichenka.myconductormvp.service.Navigator
import com.example.aliaksandrmirashnichenka.myconductormvp.service.PermissionsService
import com.example.aliaksandrmirashnichenka.myconductormvp.service.ToastManager
import java.io.Serializable

interface Abs : Serializable {

    fun getPermissionService(): PermissionsService;
    fun getContext(): Context;

}