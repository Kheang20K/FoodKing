package com.example.easyfood.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easyfood.data_class.MealsbyCategory
import com.example.easyfood.databinding.PopularItemBinding

class MostPopularAdapter(): RecyclerView.Adapter<MostPopularAdapter.PopularMealViewHolder>() {
    lateinit var onItemClick:((MealsbyCategory)->Unit)
    private var mealsList = ArrayList<MealsbyCategory>()


    fun setMeals(mealsList:ArrayList<MealsbyCategory>){
        this.mealsList = mealsList
        notifyDataSetChanged()
    }

    class PopularMealViewHolder(val binding:PopularItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMealViewHolder {
        return PopularMealViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return mealsList.size
    }

    override fun onBindViewHolder(holder: PopularMealViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(mealsList[position].strMealThumb)
            .into(holder.binding.imgPopularMealItem)

        holder.itemView.setOnClickListener {
            onItemClick.invoke(mealsList[position])
        }
    }
}