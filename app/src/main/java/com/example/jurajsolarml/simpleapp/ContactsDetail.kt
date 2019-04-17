package com.example.jurajsolarml.simpleapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_contacts_detail.*
import kotlinx.android.synthetic.main.app_bar_contacts_detail.*

class ContactsDetail : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_detail)
        setSupportActionBar(toolbar)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter
        var userList: ArrayList<String> = arrayListOf("Janko Hraško", "Milan Boss", "Ján Cap", "Daniel Vlk", "Iveta Milá", "Ján Vlk", "Samo Bohatý", "Marcel Koza", "Erik Chalupa")

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

    }

    override fun onBackPressed() {
        //This method is added to handle situations whereby
        //the activity has a “back” button to return to a previous activity screen.
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu_contacts_detail; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_search, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.search_bar -> true
            else -> super.onOptionsItemSelected(item)

        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.navDetailCon_MainMenu -> {
                val intent = Intent(this, MenuMain::class.java)
                startActivity(intent)

            }
            R.id.navDetailCon_map -> {
                val intent = Intent(this, MapsActivity::class.java)
                startActivity(intent)

            }
            R.id.navDetailCon_help -> {
                Toast.makeText(this, "Čoskoro :))", Toast.LENGTH_SHORT).show()

            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}