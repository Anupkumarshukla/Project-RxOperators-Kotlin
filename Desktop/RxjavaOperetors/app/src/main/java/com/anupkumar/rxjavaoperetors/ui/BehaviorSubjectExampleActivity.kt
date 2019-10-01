package com.anupkumar.rxjavaoperetors.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.anupkumar.rxjavaoperetors.R
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import com.anupkumar.rxjavaoperetors.utils.AppConstant

class BehaviorSubjectExampleActivity:AppCompatActivity() {

    companion object{
        const val TAG = "BehaviorSubjectExampleActivity"
    }

    lateinit var btn: Button
    lateinit var textView: TextView



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

        val source = BehaviorSubject.create<Int>()

        source.subscribe(getFirstObserver()) // it will get 1, 2, 3, 4 and onComplete

        source.onNext(1)
        source.onNext(2)
        source.onNext(3)

        source.subscribe(getSecondObserver())

        source.onNext(4)
        source.onComplete()

    }
    @SuppressLint("LongLogTag")
    private fun getFirstObserver() :Observer<Int> {
        return object : Observer<Int>{
            override fun onComplete() {
                textView.append(" Second onComplete")
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " Second onComplete")
            }

            override fun onSubscribe(d: Disposable) {
                textView.append(" Second onSubscribe : isDisposed :" + d.isDisposed)
                Log.d(TAG, " Second onSubscribe : " + d.isDisposed)
                textView.append(AppConstant.LINE_SEPARATOR)
            }

            override fun onNext(t: Int) {
                textView.append(" Second onNext : value : $t")
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " Second onNext value : $t")
            }

            override fun onError(e: Throwable) {
                textView.append(" Second onError : " + e.message)
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " Second onError : " + e.message)
            }


        }

    }
    @SuppressLint("LongLogTag")
    private fun getSecondObserver():Observer<Int> {
        return object : Observer<Int>{
            override fun onComplete() {
                textView.append(" Second onComplete")
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " Second onComplete")
            }

            override fun onSubscribe(d: Disposable) {
                textView.append(" Second onSubscribe : isDisposed :" + d.isDisposed)
                Log.d(TAG, " Second onSubscribe : " + d.isDisposed)
                textView.append(AppConstant.LINE_SEPARATOR)
            }

            override fun onNext(t: Int) {
                textView.append(" Second onNext : value : $t")
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " Second onNext value : $t")
            }

            override fun onError(e: Throwable) {
                textView.append(" Second onError : " + e.message)
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " Second onError : " + e.message)
            }

        }

    }
}