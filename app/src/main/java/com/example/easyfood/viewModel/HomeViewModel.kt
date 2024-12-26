package com.example.easyfood.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.easyfood.Retrofit.RetrofitInstance
import com.example.easyfood.data_class.Category
import com.example.easyfood.data_class.CategoryList
import com.example.easyfood.data_class.MealsbyCategoryList
import com.example.easyfood.data_class.MealsbyCategory
import com.example.easyfood.data_class.Meal
import com.example.easyfood.data_class.MealList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel():ViewModel() {
    private var randomMealLiveData = MutableLiveData<Meal>()

    private var popularItemLiveData = MutableLiveData<List<MealsbyCategory>>()

    private var categoriesLiveData = MutableLiveData<List<Category>>()
    fun getRandomMeal(){
        RetrofitInstance.api.getRandomMeal().enqueue(object : Callback<MealList> {
            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                if (response.body() != null) {
                    val randomMeal: Meal = response.body()!!.meals[0]
                    randomMealLiveData.value = randomMeal
                } else {
                    return
                }
            }

            override fun onFailure(call: Call<MealList>, t: Throwable) {
                Log.d("HomeFragment",t.message.toString())
            }
        })
    }

    fun getPopularItems(){
        RetrofitInstance.api.getPopularItems("Seafood").enqueue(object : Callback<MealsbyCategoryList> {
            override fun onResponse(call: Call<MealsbyCategoryList>, response: Response<MealsbyCategoryList>) {
                if (response.body() != null) {
                    popularItemLiveData.value = response.body()!!.meals
                }
            }

            override fun onFailure(call: Call<MealsbyCategoryList>, t: Throwable) {
                Log.d("HomeFragment",t.message.toString())
            }


        })
    }

    fun getCategories(){
        RetrofitInstance.api.getCategories().enqueue(object  : Callback<CategoryList>{
            override fun onResponse(call: Call<CategoryList>, response: Response<CategoryList>) {
                response.body()?.let { categoryList ->
                    categoriesLiveData.postValue(categoryList.categories)
                }
            }

            override fun onFailure(call: Call<CategoryList>, t: Throwable) {
                Log.e("HomeViewModel",t.message.toString())
            }

        })
    }

    fun observeRandomMealLiveData():LiveData<Meal>{
        return randomMealLiveData
    }
    fun observePopularItemLiveData():LiveData<List<MealsbyCategory>>{
        return popularItemLiveData
    }

    fun observeCategoriesLiveData():LiveData<List<Category>>{
        return categoriesLiveData
    }

}




