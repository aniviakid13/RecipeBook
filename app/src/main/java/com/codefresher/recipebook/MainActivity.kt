package com.codefresher.recipebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.codefresher.recipebook.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val createFragment = CreateFragment()
        val tagFragment = TagFragment()
        val profileFragment = ProfileFragment()
        val favoriteFragment = FavoriteFragment()

        makeCurrentFragment(homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.itemHome -> makeCurrentFragment(homeFragment)
                R.id.itemCreate -> makeCurrentFragment(createFragment)
                R.id.itemTag -> makeCurrentFragment(tagFragment)
                R.id.itemProfile -> makeCurrentFragment(profileFragment)
                R.id.itemFavorite -> makeCurrentFragment(favoriteFragment)
            }
          false
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fram_nav,fragment)
                commit()

            }
    }
}