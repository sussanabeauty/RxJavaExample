package org.sussanacode.rxjavaapplication.retrofitcall.holderNadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sussanacode.rxjavaapplication.databinding.HolderPropertyBinding
import org.sussanacode.rxjavaapplication.retrofitcall.entity.response.Property
import org.sussanacode.rxjavaapplication.retrofitcall.entity.response.PropertyResponseData

class PropertyAdapter(val properties: List<Property>) : RecyclerView.Adapter<PropertyListHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyListHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: HolderPropertyBinding = HolderPropertyBinding.inflate(layoutInflater, parent, false)
        return PropertyListHolder(binding)
    }

    override fun onBindViewHolder(holder: PropertyListHolder, position: Int) {
        holder.bind(properties[position])


    }

    override fun getItemCount() = properties.size


}