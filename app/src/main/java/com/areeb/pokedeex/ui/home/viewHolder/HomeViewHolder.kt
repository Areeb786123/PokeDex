package com.areeb.pokedeex.ui.home.viewHolder

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.areeb.pokedeex.R
import com.areeb.pokedeex.data.models.Pokemon
import com.areeb.pokedeex.databinding.ItemLayoutBinding
import com.areeb.pokedeex.utils.setImageView

class HomeViewHolder(private val bindingAdapter: ItemLayoutBinding) :
    RecyclerView.ViewHolder(bindingAdapter.root) {

    private lateinit var pokemonDto: Pokemon
    private lateinit var context: Context

    fun bind(pokemonDto: Pokemon, context: Context) {
        this.pokemonDto = pokemonDto
        this.context = context
        bindingAdapter.itemName.text = pokemonDto.name
        bindingAdapter.itemId.text = pokemonDto.id.toString()

        setImageView(bindingAdapter.itemImage, pokemonDto.img)
        bindingAdapter.itemBackground.setCardBackgroundColor(
            if (pokemonDto.id % 2 == 0) {
                ContextCompat.getColor(context, R.color.odd)
            } else {
                ContextCompat.getColor(context, R.color.even)
            }
        )
    }
}
