package com.areeb.pokedeex.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.areeb.pokedeex.data.models.Pokemon
import com.areeb.pokedeex.databinding.ItemLayoutBinding
import com.areeb.pokedeex.ui.common.callBack.DiffCallBack
import com.areeb.pokedeex.ui.home.viewHolder.HomeViewHolder

class HomeAdapter : ListAdapter<Pokemon, HomeViewHolder>(DiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: HomeViewHolder, position: Int) {
        viewHolder.bind(
            getItem(position)
        )
    }
}
