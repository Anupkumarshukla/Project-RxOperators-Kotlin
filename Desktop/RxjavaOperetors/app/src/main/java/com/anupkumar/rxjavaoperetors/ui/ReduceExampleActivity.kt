package com.anupkumar.rxjavaoperetors.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.anupkumar.rxjavaoperetors.utils.AppConstant
import com.anupkumar.rxjavaoperetors.R
import io.reactivex.MaybeObserver
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction

class ReduceExampleActivity:AppCompatActivity() {

    companion object{
        const val TAG = "ReduceExampleActivity"
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

    private fun doSomeWork() {
        getObservable()
            .reduce(object : BiFunction<Int, Int, Int> {
                override fun apply(t1: Int, t2: Int): Int {
                    return t1 + t2
                }
            })
            .subscribe(getObserver())
    }

    private fun getObservable(): Observable<Int> {
        return Observable.just(1, 2, 3, 4)
    }

    @SuppressLint("LongLogTag")
    private fun getObserver(): MaybeObserver<Int> {
        return object : MaybeObserver<Int> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed)
            }


            override fun onSuccess(value: Int) {
                textView.append(" onSuccess : value : " + value!!)
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " onSuccess : value : $value")
            }

            override fun onError(e: Throwable) {
                textView.append(" onError : " + e.message)
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " onError : " + e.message)
            }

            override fun onComplete() {
                textView.append(" onComplete")
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " onComplete")
            }
        }
    }


}