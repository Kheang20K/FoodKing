package com.example.easyfood

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.easyfood.Category.CategoryFragment
import com.example.easyfood.Favorite.FavoriteFragment
import com.example.easyfood.Home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val BottomNav : BottomNavigationView = findViewById(R.id.btn_nav)
        loadFragment(HomeFragment())

        BottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homefragment ->{
                    loadFragment(HomeFragment())
                    true
                }
                R.id.favoritefragment ->{
                    loadFragment(FavoriteFragment())
                    true
                }
                R.id.categoryfragment ->{
                    loadFragment(CategoryFragment())
                    true
                }else ->{
                    loadFragment(HomeFragment())
                    true
                }

            }
        }
    }

    private fun loadFragment( fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.hostFragment,fragment)
        transaction.commit()
    }


}