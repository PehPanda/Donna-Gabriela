package com.example.donnagabriela

import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.example.donnagabriela.databinding.CategoryItemBinding
import com.squareup.picasso.Picasso

class CategoryView(viewGroup: ViewGroup) : ATViewHolder<Category, CategoryItemBinding> (
    CategoryItemBinding::inflate,
    viewGroup
){
    override fun bind(item: Category) {
        binding.txtCategory.text = item.name

        Picasso.get()
            .load(item.logoUrl)
            .into(binding.imgCategory)
    }
}