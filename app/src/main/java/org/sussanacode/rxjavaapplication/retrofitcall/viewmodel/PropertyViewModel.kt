package org.sussanacode.rxjavaapplication.retrofitcall.viewmodel

import android.database.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sussanacode.rxjavaapplication.retrofitcall.api.ApiClient
import org.sussanacode.rxjavaapplication.retrofitcall.api.ApiService
import org.sussanacode.rxjavaapplication.retrofitcall.entity.response.Property
import org.sussanacode.rxjavaapplication.retrofitcall.entity.response.PropertyResponseData
import retrofit2.Call


class PropertyViewModel(val apiService: ApiService): ViewModel() {

    val propertyResponses = ObservableField<List<Property>>()

    val addproductResponse = MutableLiveData<PropertyResponseData>()
    val error = ObservableField<String>()
    val loading = ObservableField<Boolean>()
    //val error = MutableLiveData<String>()


    //get all properties
    fun loadProperties() {

//        error.set("")
//
//        val call : Call<PropertyResponseData> = apiService.getProperty()
//
//
//        call.enqueue(object: Callback<PropertyResponseData> {
//
//            override fun onResponse(call: Call<PropertyResponseData>, response: Response<PropertyResponseData>
//            ) {
//                loading.set(false)
//
//                if(!response.isSuccessful){
//                    error.set("Failed to get properties. Error code: ${response.code()}")
//                    return
//                }
//
//                val getProperties = response.body()
//
//                getProperties?.let { propertiesData ->
//
//                    if(propertiesData.error) {
//                        error.set("Failed to get properties.")
//                        return
//                    }
//
//                    propertyResponses.set(propertiesData.data)
//                }
//
//            }
//
//            override fun onFailure(call: Call<PropertyResponseData>, t: Throwable) {
//               loading.set(false)
//               // t.printStackTrace()
//                error.set("Failed to get properties. Error: ${t.toString()}")
//            }
//
//        })
//        loading.set(true)
//    }
    }
}