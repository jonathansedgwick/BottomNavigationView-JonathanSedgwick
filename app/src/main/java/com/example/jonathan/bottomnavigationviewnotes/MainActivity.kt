package com.example.jonathan.bottomnavigationviewnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    lateinit var fragmentFrame: FrameLayout
    lateinit var myBottomNavMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myBottomNavMenu = findViewById(R.id.bottom_navigation_view)
        fragmentFrame = findViewById(R.id.my_fragments_framelayout)

        val homeFragment = HomeFragment()
        val messagesFragment = MessagesFragment()
        val profileFragment = ProfileFragment()
        val settingsFragment = SettingsFragment()

        setCurrentFragment(homeFragment)
        myBottomNavMenu.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {
            when(it.itemId){
                R.id.myHomeMenuItem -> setCurrentFragment(homeFragment)
                R.id.myMessagesMenuItem -> setCurrentFragment(messagesFragment)
                R.id.myProfileMenuItem -> setCurrentFragment(profileFragment)
                R.id.mySettingsMenuItem -> setCurrentFragment(settingsFragment)
            }
            true
        })

        myBottomNavMenu.getOrCreateBadge(R.id.myMessagesMenuItem).apply {
            number = 10
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.my_fragments_framelayout, fragment)
            commit()
        }



}