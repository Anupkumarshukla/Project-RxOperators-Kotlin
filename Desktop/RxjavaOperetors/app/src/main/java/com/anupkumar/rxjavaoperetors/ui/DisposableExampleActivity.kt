package com.anupkumar.rxjavaoperetors.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.anupkumar.rxjavaoperetors.utils.AppConstant
import com.anupkumar.rxjavaoperetors.R
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class DisposableExampleActivity:AppCompatActivity() {


    companion object{
        const val TAG = "DisposableExampleActivity"
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
            doSomework()
        }
    }
    @SuppressLint("LongLogTag")
    private fun doSomework() {
        disposables.add(sampleObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<String>(){

                override fun onComplete() {
                    textView.append(" onComplete")
                    textView.append(AppConstant.LINE_SEPARATOR)
                    Log.d(TAG, " onComplete")
                }

                override fun onNext(t: String) {
                    textView.append(" onNext : value : $t")
                    textView.append(AppConstant.LINE_SEPARATOR)
                    Log.d(TAG, " onNext value : $t")
                }

                override fun onError(e: Throwable) {
                    textView.append(" onError : " + e.message)
                    textView.append(AppConstant.LINE_SEPARATOR)
                    Log.d(TAG, " onError : " + e.message)
                }

            }))
    }


     fun sampleObservable(): Observable<String> {
        return Observable.defer {
            // Do some long running operation
            SystemClock.sleep(2000)
            Observable.just("one", "two", "three", "four", "five")
        }
    }
}