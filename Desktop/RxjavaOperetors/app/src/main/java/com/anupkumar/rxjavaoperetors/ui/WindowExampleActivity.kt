package com.anupkumar.rxjavaoperetors.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.anupkumar.rxjavaoperetors.utils.AppConstant
import com.anupkumar.rxjavaoperetors.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class WindowExampleActivity:AppCompatActivity() {

    companion object{
        const val TAG = "WindowExampleActivity"
    }

    lateinit var btn: Button
    lateinit var textView: TextView


    val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)

        btn = findViewById(R.id.btn)
        textView = findViewById(R.id.textView)

        btn.setOnClickListener {
            doSomeWork()
        }
    }

    protected fun doSomeWork() {

        Observable.interval(1, TimeUnit.SECONDS).take(12)
            .window(3, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getConsumer())
    }

    fun getConsumer(): Consumer<Observable<Long>> {
        return Consumer { observable ->
            Log.d(TAG, "Sub Divide begin....")
            textView.append("Sub Divide begin ....")
            textView.append(AppConstant.LINE_SEPARATOR)
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { value ->
                    Log.d(TAG, "Next:" + value!!)
                    textView.append("Next:$value")
                    textView.append(AppConstant.LINE_SEPARATOR)
                }
        }
    }

}