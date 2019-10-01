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
import io.reactivex.disposables.Disposable

class BufferExampleActivity:AppCompatActivity() {

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

        val buffered =getObservable().buffer(3,1)
        buffered.subscribe(getObserver())

    }

    fun getObservable(): Observable<String>{
        return  Observable.just("one","two","three","four","five")
    }

    @SuppressLint("LongLogTag")
    fun getObserver():Observer<List<String>>{

        return object : Observer<List<String>>{


            override fun onNext(stringList: List<String>) {
                textView.append(" onNext size : " + stringList.size)
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " onNext : size :" + stringList.size)
                for (value in stringList) {
                    textView.append(" value : $value")
                    textView.append(AppConstant.LINE_SEPARATOR)
                    Log.d(TAG, " : value :$value")
                }

            }

            override fun onComplete() {
                textView.append(" onComplete")
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " onComplete")
            }

            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed)
            }

            override fun onError(e: Throwable) {
                textView.append(" onError : " + e.message)
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " onError : " + e.message)
            }

        }
    }

}