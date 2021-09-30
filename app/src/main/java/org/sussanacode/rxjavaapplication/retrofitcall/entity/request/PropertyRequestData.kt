package org.sussanacode.rxjavaapplication.retrofitcall.entity.request

data class PropertyRequestData (
    val address: String?,
    val city: String?,
    val country: String?,
    val image: String?,
    val latitude: String?,
    val longitude: String?,
    val mortageInfo: Boolean?,
    val propertyStatus: Boolean?,
    val purchasePrice: String?,
    val state: String?,
    val userId: String?,
    val userType: String?
)