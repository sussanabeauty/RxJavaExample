package org.sussanacode.rxjavaapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.sussanacode.rxjavaapplication.databinding.ActivityMainBinding

/**
 * Date: 9/30/2021
 * Author: Sussana B Kwabi
 *
 * Observables: It is something with will do perform some work and emit data
 * Observer: is something which receive data from the observable
 * Schedulers: is class in jxjava Provides thread to the observable for execution to carryout heavy operation in the background (background thread I/O thread), and also
 * provides the threads to the observer to return the main thread.
 *
 */
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        getObservable().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith( getObservers()) //bonding b/t observable and observers


    }




    private fun getObservers(): Observer<String> {
        return object:Observer<String>{

            //defines the bonding b/t the observable and the observer
            override fun onSubscribe(d: Disposable) {
                Log.d("OnSubscribe", d.toString())
            }

            //call the items in the observable one by one
            override fun onNext(t: String) {
                Log.d("OnNext", t.toString())
            }

            //throws any exception if there is an error whiles emitting the data in the observable
            override fun onError(e: Throwable) {
                Log.d("OnError", e.toString())
            }

            override fun onComplete() {
                Log.d("OnComplete", "Task Completed!!!")
            }

        }
    }

    private fun getObservable(): Observable<String> {
        return Observable.just("Beans", "Banana", "Yogurt", "Honey")
    }
}