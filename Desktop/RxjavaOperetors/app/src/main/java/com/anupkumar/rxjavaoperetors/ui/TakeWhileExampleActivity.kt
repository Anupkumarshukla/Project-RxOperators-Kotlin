package com.anupkumar.rxjavaoperetors.ui

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Predicate
import java.util.concurrent.TimeUnit

class TakeWhileExampleActivity: TakeOperatorBaseActivity() {

    companion object {
        const val TAG = "TakeUntilExampleActivity"
    }

     override fun doSomeWork() {
        getStringObservable()
            //Delay item emission by one second
            .zipWith(Observable.interval(0, 1, TimeUnit.SECONDS), object :
                io.reactivex.functions.BiFunction<String, Long, String> {
                @Throws(Exception::class)
                override fun apply(s: String, t2: Long): String {
                    return s
                }
            })
            //Take the items until the condition is met.
            .takeWhile { s -> !s.toLowerCase().contains("honey") }
            //We need to observe on MainThread because delay works on background thread to avoid UI blocking.
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getObserver())
    }
}