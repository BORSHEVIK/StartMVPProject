package com.example.aliaksandrmirashnichenka.myconductormvp.abs

import java.util.*

interface AndroidLifeCycle {

    fun onDestroy();
    fun onCreate();
    fun onResume();
    fun onStop();
    fun onSaveInstanceState(): MutableMap<String, Any>;

}