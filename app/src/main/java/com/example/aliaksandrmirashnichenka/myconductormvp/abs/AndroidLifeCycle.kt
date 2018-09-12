package com.example.aliaksandrmirashnichenka.myconductormvp.abs

import com.example.aliaksandrmirashnichenka.myconductormvp.abs.presenter.DataHolder

interface AndroidLifeCycle {

    fun onDestroy();
    fun onCreate();
    fun onResume();
    fun onStop();
    fun onSaveInstanceState(): DataHolder;

}