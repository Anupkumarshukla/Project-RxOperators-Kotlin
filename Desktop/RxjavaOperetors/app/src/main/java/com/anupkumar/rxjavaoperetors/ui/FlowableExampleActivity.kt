package com.anupkumar.rxjavaoperetors.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.anupkumar.rxjavaoperetors.utils.AppConstant
import com.anupkumar.rxjavaoperetors.R
import io.reactivex.Flowable
import io.reactivex.Observer
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction

class FlowableExampleActivity:AppCompatActivity() {


    companion object{
        const val TAG = "FlowableExampleActivity"
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
        val observable:Flowable<Int> = Flowable.just(1, 2, 3, 4)

        observable.reduce(30, BiFunction<Int,Int,Int>{t1,t2->
            return@BiFunction t1+t2
        }).subscribe(getObserver())
    }

    @SuppressLint("LongLogTag")
    fun getObserver(): SingleObserver<Int>{
        return object : SingleObserver<Int>{

            override fun onSuccess(value: Int) {
                textView.append(" onSuccess : value : $value")
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " onSuccess : value : $value")
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