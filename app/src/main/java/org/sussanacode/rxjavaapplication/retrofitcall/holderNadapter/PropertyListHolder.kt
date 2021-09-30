package org.sussanacode.rxjavaapplication.retrofitcall.holderNadapter

import androidx.recyclerview.widget.RecyclerView
import org.sussanacode.rxjavaapplication.retrofitcall.entity.response.Property
import org.sussanacode.rxjavaapplication.databinding.HolderPropertyBinding

class PropertyListHolder(val binding: HolderPropertyBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(property: Property){
        binding.properties = property
    }

}