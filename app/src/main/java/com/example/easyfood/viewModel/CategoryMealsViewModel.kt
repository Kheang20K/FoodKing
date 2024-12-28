package com.example.easyfood.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.easyfood.Retrofit.RetrofitInstance
import com.example.easyfood.data_class.MealsbyCategory
import com.example.easyfood.data_class.MealsbyCategoryList
import com.example.easyfood.databinding.MealItemBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryMealsViewModel: ViewModel() {
    val mealsLiveData = MutableLiveData<List<MealsbyCategory>>()

    fun getMealsByCategory(categoryName:String){
        RetrofitInstance.api.getMealsByCategory(categoryName).enqueue(object : Callback<MealsbyCategoryList>{
            override fun onResponse(
                call: Call<MealsbyCategoryList>,
                response: Response<MealsbyCategoryList>
            ) {
                response.body()?.let { mealsList->
                    mealsLiveData.postValue(mealsList.meals)
                }
            }

            override fun onFailure(call: Call<MealsbyCategoryList>, t: Throwable) {
                Log.e("CategoryMealsViewModel",t.message.toString())
            }

        })
    }
    fun observeMealsLiveData():MutableLiveData<List<MealsbyCategory>>{
        return mealsLiveData
    }
}