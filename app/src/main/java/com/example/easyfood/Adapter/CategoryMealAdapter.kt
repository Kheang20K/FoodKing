package com.example.easyfood.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easyfood.data_class.Category
import com.example.easyfood.data_class.MealsbyCategory
import com.example.easyfood.databinding.MealItemBinding


class CategoryMealAdapter : RecyclerView.Adapter<CategoryMealAdapter.CategoryMealViewModel>(){
    private var mealsList = ArrayList<MealsbyCategory>()


    inner class CategoryMealViewModel(var binding:MealItemBinding):RecyclerView.ViewHolder(binding.root)

    fun setMealsList(mealsList: List<MealsbyCategory>){
        this.mealsList = mealsList as ArrayList<MealsbyCategory>
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryMealViewModel {
        return CategoryMealViewModel(
            MealItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun getItemCount(): Int {
        return mealsList.size
    }

    override fun onBindViewHolder(holder: CategoryMealViewModel, position: Int) {
        Glide.with(holder.itemView)
            .load(mealsList[position].strMealThumb)
            .into(holder.binding.imgMeal)
        holder.binding.tvMealName.text = mealsList[position].strMeal
    }


}