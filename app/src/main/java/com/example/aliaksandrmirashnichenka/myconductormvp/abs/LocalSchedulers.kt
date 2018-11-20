package com.example.aliaksandrmirashnichenka.myconductormvp.abs

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object LocalSchedulers {

    fun networking(): Scheduler {
        return Schedulers.io()
    }

    fun io(): Scheduler {
        return Schedulers.io()
    }

    fun images(): Scheduler {
        return Schedulers.computation()
    }

    fun computation(): Scheduler {
        return Schedulers.computation()
    }

    fun mainThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}
