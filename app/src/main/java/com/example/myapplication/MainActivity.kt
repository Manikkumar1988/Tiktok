package com.example.myapplication

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.luseen.spacenavigation.SpaceItem
import com.luseen.spacenavigation.SpaceNavigationView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.luseen.spacenavigation.SpaceOnClickListener





class MainActivity : AppCompatActivity() {

    lateinit var spaceNavigationView: SpaceNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spaceNavigationView = findViewById(R.id.space) as SpaceNavigationView
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState)
        spaceNavigationView.addSpaceItem(SpaceItem("HOME", R.drawable.ic_home_black_24dp))
        spaceNavigationView.changeCenterButtonIcon(R.drawable.ic_launcher_foreground)
        spaceNavigationView.addSpaceItem(SpaceItem("PROFILE", R.drawable.ic_home_black_24dp))


        spaceNavigationView.setSpaceOnClickListener(object : SpaceOnClickListener {
            override fun onCentreButtonClick() {

            }

            override fun onItemClick(itemIndex: Int, itemName: String) {
                if(itemIndex == 1)
                findNavController(R.id.my_nav_host_fragment).navigate(R.id.action_firstFragment_to_secondFragment)
                else
                {
                    onBackPressed()
                }
            }

            override fun onItemReselected(itemIndex: Int, itemName: String) {
                Toast.makeText(this@MainActivity, "$itemIndex $itemName", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
