package org.sussanacode.rxjavaapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.sussanacode.rxjavaapplication.databinding.ActivityPropertyBinding
import org.sussanacode.rxjavaapplication.retrofitcall.api.ApiClient
import org.sussanacode.rxjavaapplication.retrofitcall.entity.response.PropertyResponseData
import org.sussanacode.rxjavaapplication.retrofitcall.holderNadapter.PropertyAdapter


class PropertyActivity : AppCompatActivity() {
    lateinit var binding: ActivityPropertyBinding
    lateinit var adapter: PropertyAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropertyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvProperties.layoutManager = LinearLayoutManager(baseContext)


        val obproperty1 = ApiClient.apiService.getProperty()


//        obproperty1.subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeWith( getObservers()) //bonding b/t observable and observers


        getObservableProperties().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith( getObservers()) //bo

    }



    private fun getObservers(): Observer<PropertyResponseData>? {
        return object: Observer<PropertyResponseData> {

            //defines the bonding b/t the observable and the observer
            override fun onSubscribe(d: Disposable) {
                Log.d("OnSubscribe", d.toString())
            }

            //call the items in the observable one by one
            override fun onNext(t: PropertyResponseData) {
                displayData(t)
                Log.d("OnNext", t.data.toString())
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

    private fun displayData(t: PropertyResponseData) {

        adapter = PropertyAdapter(t.data!!)
        binding.rvProperties.adapter = adapter

    }

    fun getObservableProperties(): Observable<PropertyResponseData> {
        return ApiClient.apiService.getProperty()

    }

}