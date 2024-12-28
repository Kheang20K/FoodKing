package com.example.easyfood.Retrofit


import com.example.easyfood.data_class.CategoryList
import com.example.easyfood.data_class.Meal
import com.example.easyfood.data_class.MealsbyCategoryList
import com.example.easyfood.data_class.MealList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
    @GET("random.php")
    fun getRandomMeal(): Call<MealList>


    @GET("lookup.php?")
    fun getMealDetails(@Query("i") id:String) : Call<MealList>

    @GET("filter.php")
    fun getPopularItems(@Query("c") categoryName:String) : Call<MealsbyCategoryList>

    @GET("categories.php")
    fun getCategories() : Call<CategoryList>

    @GET("filter.php")
    fun getMealsByCategory(@Query("c") categoryName: String):Call<MealsbyCategoryList>
}