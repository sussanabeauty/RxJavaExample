package org.sussanacode.rxjavaapplication.retrofitcall.viewmodel

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

import org.sussanacode.rxjavaapplication.retrofitcall.entity.response.Property
import org.sussanacode.rxjavaapplication.retrofitcall.holderNadapter.PropertyAdapter
import java.lang.Exception

class CommonBinding {

    companion object{
        @JvmStatic
        @BindingAdapter("remote_source", "place_holder", requireAll = false)

        fun loadPropertyImage(imageView: ImageView, url: String?, placeholder: Drawable?){

            url?.let {

                if(placeholder == null){
                    Picasso.get().load(it).into(imageView)

                }else {
                    try{
                        Picasso.get().load(it).placeholder(placeholder).into(imageView)
                    }catch (e: Exception){
                        e.printStackTrace()
                    }
                }
            }

        }

        @JvmStatic
        @BindingAdapter("properties")
        fun setProperties(recyclerView: RecyclerView, list: List<Property>?) {
            list?.let {
                recyclerView.adapter = PropertyAdapter(it)
            }
        }
    }
}