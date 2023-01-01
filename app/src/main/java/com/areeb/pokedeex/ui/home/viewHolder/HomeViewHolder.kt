package com.areeb.pokedeex.ui.home.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.areeb.pokedeex.data.models.Pokemon
import com.areeb.pokedeex.databinding.ItemLayoutBinding
import com.areeb.pokedeex.utils.setImageView

class HomeViewHolder(private val bindingAdapter: ItemLayoutBinding) :
    RecyclerView.ViewHolder(bindingAdapter.root) {

    private lateinit var pokemonDto: Pokemon
    fun bind(pokemonDto: Pokemon) {
        this.pokemonDto = pokemonDto
        bindingAdapter.itemName.text = pokemonDto.name
        bindingAdapter.itemId.text = pokemonDto.id.toString()

        setImageView(bindingAdapter.itemImage, pokemonDto.img)
    }
}
