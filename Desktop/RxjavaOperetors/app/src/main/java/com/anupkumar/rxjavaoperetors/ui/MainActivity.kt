package com.anupkumar.rxjavaoperetors.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.anupkumar.rxjavaoperetors.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startSimpleActivity(view: View) {
        startActivity(Intent(this@MainActivity, SimpleExampleActivity::class.java))
    }

    fun startMapActivity(view: View) {
        startActivity(Intent(this@MainActivity, MapExampleActivity::class.java))
    }

    fun startZipActivity(view: View) {
        startActivity(Intent(this@MainActivity, ZipExampleActivity::class.java))
    }

    fun startDisposableActivity(view: View) {
        startActivity(Intent(this@MainActivity, DisposableExampleActivity::class.java))
    }

    fun startTakeActivity(view: View) {
        startActivity(Intent(this@MainActivity, TakeExampleActivity::class.java))
    }

    fun startTimerActivity(view: View) {
        startActivity(Intent(this@MainActivity, TimerExampleActivity::class.java))
    }

    fun startIntervalActivity(view: View) {
        startActivity(Intent(this@MainActivity, IntervalExampleActivity::class.java))
    }

    fun startSingleObserverActivity(view: View) {
        startActivity(Intent(this@MainActivity, SingleObserverExampleActivity::class.java))
    }

    fun startCompletableObserverActivity(view: View) {
        startActivity(Intent(this@MainActivity, CompletableObserverExampleActivity::class.java))
    }

    fun startFlowableActivity(view: View) {
        startActivity(Intent(this@MainActivity, FlowableExampleActivity::class.java))
    }

    fun startReduceActivity(view: View) {
        startActivity(Intent(this@MainActivity, ReduceExampleActivity::class.java))
    }

    fun startBufferActivity(view: View) {
        startActivity(Intent(this@MainActivity, BufferExampleActivity::class.java))
    }

    fun startFilterActivity(view: View) {
        startActivity(Intent(this@MainActivity, FilterExampleActivity::class.java))
    }

    fun startSkipActivity(view: View) {
        startActivity(Intent(this@MainActivity, SkipExampleActivity::class.java))
    }

    fun startScanActivity(view: View) {
        startActivity(Intent(this@MainActivity, ScanExampleActivity::class.java))
    }

    fun startReplayActivity(view: View) {
        startActivity(Intent(this@MainActivity, ReplayExampleActivity::class.java))
    }

    fun startConcatActivity(view: View) {
        startActivity(Intent(this@MainActivity, ConcatExampleActivity::class.java))
    }

    fun startMergeActivity(view: View) {
        startActivity(Intent(this@MainActivity, MergeExampleActivity::class.java))
    }

    fun startDeferActivity(view: View) {
        startActivity(Intent(this@MainActivity, DeferExampleActivity::class.java))
    }

    fun startDistinctActivity(view: View) {
        startActivity(Intent(this@MainActivity, DistinctExampleActivity::class.java))
    }

    fun startLastOperatorActivity(view: View) {
        startActivity(Intent(this@MainActivity, LastOperatorExampleActivity::class.java))
    }

    fun startReplaySubjectActivity(view: View) {
        startActivity(Intent(this@MainActivity, ReplaySubjectExampleActivity::class.java))
    }

    fun startPublishSubjectActivity(view: View) {
        startActivity(Intent(this@MainActivity, PublishSubjectExampleActivity::class.java))
    }

    fun startBehaviorSubjectActivity(view: View) {
        startActivity(Intent(this@MainActivity, BehaviorSubjectExampleActivity::class.java))
    }

    fun startAsyncSubjectActivity(view: View) {
        startActivity(Intent(this@MainActivity, AsyncSubjectExampleActivity::class.java))
    }

    fun startThrottleFirstActivity(view: View) {
        startActivity(Intent(this@MainActivity, ThrottleFirstExampleActivity::class.java))
    }

    fun startThrottleLastActivity(view: View) {
        startActivity(Intent(this@MainActivity, ThrottleLastExampleActivity::class.java))
    }

    fun startDebounceActivity(view: View) {
        startActivity(Intent(this@MainActivity, DebounceExampleActivity::class.java))
    }

    fun startWindowActivity(view: View) {
        startActivity(Intent(this@MainActivity, WindowExampleActivity::class.java))
    }

    fun startDelayActivity(view: View) {
        startActivity(Intent(this@MainActivity, DelayExampleActivity::class.java))
    }



    fun startTakeWhileActivity(view: View) {
        startActivity(Intent(this@MainActivity, TakeWhileExampleActivity::class.java))
    }

}
