package com.areeb.pokedeex.ui.common.callBack

import androidx.recyclerview.widget.DiffUtil
import com.areeb.pokedeex.data.models.Pokemon

class DiffCallBack: DiffUtil.ItemCallback<Pokemon>(){
    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return  oldItem == newItem
    }
}