package org.sussanacode.rxjavaapplication.retrofitcall.api


import io.reactivex.Observable
import org.sussanacode.rxjavaapplication.retrofitcall.entity.request.PropertyRequestData
import org.sussanacode.rxjavaapplication.retrofitcall.entity.response.PropertyResponseData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("Content-type: application/json")
    @POST("property")
    fun postProperty(@Body propertyData: PropertyRequestData): Call<PropertyResponseData>


    @GET("property")
    fun getProperty(): Observable<PropertyResponseData>


}