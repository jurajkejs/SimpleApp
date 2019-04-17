package com.example.jurajsolarml.simpleapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu_main.*
import kotlinx.android.synthetic.main.app_bar_menu_main.*

class MenuMain : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view_code.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu_contacts_detail; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.navmenu_main_contacts -> {  // Handle the Contacts action
                val intent = Intent(this, ContactsDetail::class.java)
                startActivity(intent)        //activity_contacts_detail
            }
            R.id.navmenu_main_mapa -> {
                val intent = Intent(this, MapsActivity::class.java)
                startActivity(intent)
            }
            R.id.navmenu_main_logout -> {
                val btLoginActivity = Intent(
                    applicationContext,
                    MainActivity::class.java
                )

                startActivity(btLoginActivity)
                Toast.makeText(this, "Ste odhlasený", Toast.LENGTH_SHORT).show()
                finish()

            }
            R.id.navmenu_version -> {
                Toast.makeText(this, "Verzia 1.0", Toast.LENGTH_SHORT).show()
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
