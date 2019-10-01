package com.anupkumar.rxjavaoperetors.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.anupkumar.rxjavaoperetors.utils.AppConstant
import com.anupkumar.rxjavaoperetors.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class FilterExampleActivity:AppCompatActivity() {

    companion object{
        const val TAG = "FilterExampleActivity"
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

    private fun doSomework() {

        Observable.just(1, 2, 3, 4, 5, 6)
            .filter { value -> value%2 == 0}.subscribe(getObserver())

    }

    @SuppressLint("LongLogTag")
    private fun getObserver(): Observer<Int> {
        return object : Observer<Int> {

            override fun onNext(value: Int) {
                textView.append(" onNext : ")
                textView.append(AppConstant.LINE_SEPARATOR)
                textView.append(" value : " + value!!)
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " onNext ")
                Log.d(TAG, " value : $value")
            }

            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed)
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