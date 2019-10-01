package com.anupkumar.rxjavaoperetors.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.anupkumar.rxjavaoperetors.R
import com.anupkumar.rxjavaoperetors.utils.AppConstant
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.AsyncSubject

class AsyncSubjectExampleActivity:AppCompatActivity() {


    companion object{
        const val TAG = "AsyncSubjectExampleActivity"
    }

    lateinit var btn:Button
    lateinit var textView:TextView



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
        val source = AsyncSubject.create<Int>()

        source.subscribe(getFirstObserver())
        source.onNext(1)
        source.onNext(2)
        source.onNext(3)

        source.subscribe(getSecondObserver())
        source.onNext(4)
        source.onComplete()


    }
    @SuppressLint("LongLogTag")
    private fun getSecondObserver(): Observer<Int> {
        return object : Observer<Int>{
            override fun onComplete() {
                textView.append(" First onComplete")
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " First onComplete")
            }

            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, " First onSubscribe : " + d.isDisposed)
            }

            override fun onNext(t: Int) {
                textView.append(" First onNext : value : $t")
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " First onNext value : $t")
            }

            override fun onError(e: Throwable) {
                textView.append(" First onError : " + e.message)
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " First onError : " + e.message)
            }

        }
    }

    @SuppressLint("LongLogTag")
    fun getFirstObserver(): Observer<Int>{
        return object : Observer<Int>{

            override fun onComplete() {
                textView.append(" First onComplete")
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " First onComplete")
            }

            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, " First onSubscribe : " + d.isDisposed)
            }

            override fun onNext(t: Int) {
                textView.append(" First onNext : value : $t")
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " First onNext value : $t")
            }

            override fun onError(e: Throwable) {
                textView.append(" First onError : " + e.message)
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " First onError : " + e.message)
            }

        }
    }
}