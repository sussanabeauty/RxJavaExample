package org.sussanacode.rxjavaapplication.retrofitcall.holderNadapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import org.sussanacode.rxjavaapplication.R
import org.sussanacode.rxjavaapplication.retrofitcall.entity.response.Property
import org.sussanacode.rxjavaapplication.databinding.HolderPropertyBinding
import java.lang.Exception

class PropertyListHolder(val binding: HolderPropertyBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(property: Property){
        binding.tvpropertyname.text = property._id
        binding.tvpropertyaddress.text = property.address
        binding.tvpropertycity.text = property.city
        binding.tvpropertystate.text = property.state
        binding.tvpropertycounty.text = property.country
        binding.tvpropertyprice.text = property.purchasePrice



        Picasso.get().load(property.image).placeholder(R.drawable.property_placeholder)
            .into(binding.ivpropertyImg, object : Callback {
                override fun onSuccess() {
                    Log.d("Picasso", "onSuccess: Image Loaded Successfully")
                }

                override fun onError(e: Exception?) {
                    e?.printStackTrace()
                    Log.d("Picasso", "onError: Failed to load image")
                }

            })
    }

}