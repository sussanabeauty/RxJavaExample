package org.sussanacode.rxjavaapplication.retrofitcall.holderNadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.sussanacode.rxjavaapplication.retrofitcall.entity.response.Property
import org.sussanacode.rxjavaapplication.R
import org.sussanacode.rxjavaapplication.databinding.HolderPropertyBinding

class PropertyAdapter(val properties: List<Property>?) : RecyclerView.Adapter<PropertyListHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyListHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: HolderPropertyBinding = DataBindingUtil.inflate(layoutInflater, R.layout.holder_property, parent, false)
        return PropertyListHolder(binding)
    }

    override fun onBindViewHolder(holder: PropertyListHolder, position: Int) {
        properties?.let {
            holder.bind(it[position])
            //holder.binding.properties = it[position]
        }

    }


    override fun getItemCount() = properties?.size?:0


}