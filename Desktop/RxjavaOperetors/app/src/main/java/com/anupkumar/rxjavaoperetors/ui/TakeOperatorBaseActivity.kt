package com.anupkumar.rxjavaoperetors.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.anupkumar.rxjavaoperetors.utils.AppConstant
import com.anupkumar.rxjavaoperetors.R
import com.anupkumar.rxjavaoperetors.utils.ObserverAdapter
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class TakeOperatorBaseActivity:AppCompatActivity() {

    companion object{
        const val TAG = "TakeExampleActivity"
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

     abstract fun doSomeWork()

    protected fun getStringObservable(): Observable<String> {
        return Observable.just(
            "Alpha", "Beta", "Cupcake", "Doughnut", "Eclair", "Froyo", "GingerBread",
            "Honeycomb", "Ice cream sandwich"
        )
    }

    protected fun getObserver(): Observer<in String> {
        return object : ObserverAdapter<String>() {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed)
            }

            override fun onNext(value: String) {
                textView.append(" onNext : value : $value")
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " onNext value : $value")
            }

            override fun onComplete() {
                textView.append(" onComplete")
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " onComplete")
            }
        }
    }



}