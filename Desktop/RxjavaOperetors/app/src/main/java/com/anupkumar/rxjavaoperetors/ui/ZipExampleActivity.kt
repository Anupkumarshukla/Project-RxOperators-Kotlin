package com.anupkumar.rxjavaoperetors.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.anupkumar.rxjavaoperetors.R
import com.anupkumar.rxjavaoperetors.model.User
import com.anupkumar.rxjavaoperetors.utils.AppConstant
import com.anupkumar.rxjavaoperetors.utils.Utils
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

class ZipExampleActivity:AppCompatActivity() {

    companion object{
        const val TAG = "ZipExampleActivity"
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
        Observable.zip(getCricketFansObservable(), getFootballFansObservable(),
            BiFunction<List<User>, List<User>, List<User>> { cricketFans, footballFans ->
                Utils.filterUserWhoLovesBoth(
                    cricketFans,
                    footballFans
                )
            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getObserver())
    }

    private fun getCricketFansObservable(): Observable<List<User>> {
        return Observable.create<List<User>> { e ->
            if (!e.isDisposed) {
                e.onNext(Utils.getUserListWhoLovesCricket())
                e.onComplete()
            }
        }.subscribeOn(Schedulers.io())
    }

    private fun getFootballFansObservable(): Observable<List<User>> {
        return Observable.create<List<User>> { e ->
            if (!e.isDisposed) {
                e.onNext(Utils.getUserListWhoLovesFootball())
                e.onComplete()
            }
        }.subscribeOn(Schedulers.io())
    }

    private fun getObserver(): Observer<List<User>> {
        return object : Observer<List<User>> {

            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed)
            }

            override fun onNext(userList: List<User>) {
                textView.append(" onNext")
                textView.append(AppConstant.LINE_SEPARATOR)
                for (user in userList) {
                    textView.append(" firstname : " + user.firstname)
                    textView.append(AppConstant.LINE_SEPARATOR)
                }
                Log.d(TAG, " onNext : " + userList.size)
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