package org.sussanacode.rxjavaapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.sussanacode.rxjavaapplication.databinding.ActivityPropertyBinding
import org.sussanacode.rxjavaapplication.retrofitcall.api.ApiClient
import org.sussanacode.rxjavaapplication.retrofitcall.entity.response.Property
import org.sussanacode.rxjavaapplication.retrofitcall.entity.response.PropertyResponseData


class PropertyActivity : AppCompatActivity() {
    lateinit var binding: ActivityPropertyBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropertyBinding.inflate(layoutInflater)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_property)

        val obproperty1 = ApiClient.apiService.getProperty()


        obproperty1.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith( getObservers()) //bonding b/t observable and observers

    }



    private fun getObservers(): Observer<PropertyResponseData> {
        return object: Observer<PropertyResponseData> {

            //defines the bonding b/t the observable and the observer
            override fun onSubscribe(d: Disposable) {
                Log.d("OnSubscribe", d.toString())
            }

            //call the items in the observable one by one
            override fun onNext(t: PropertyResponseData) {
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

}