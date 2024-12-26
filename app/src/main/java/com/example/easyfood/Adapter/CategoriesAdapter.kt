package com.example.easyfood.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easyfood.data_class.Category

import com.example.easyfood.databinding.CategoryItemBinding

class CategoriesAdapter():RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>(){

    inner class CategoryViewHolder(val binding: CategoryItemBinding):RecyclerView.ViewHolder(binding.root)

    private var categoriesList = ArrayList<Category>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.CategoryViewHolder {
        return CategoryViewHolder(
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.CategoryViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(categoriesList[position].strCategoryThumb)
            .into(holder.binding.imgCategory)
        holder.binding.tvCategoryName.text = categoriesList[position].idCategory
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }
}