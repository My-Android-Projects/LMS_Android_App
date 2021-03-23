package com.srs.lms.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.srs.lms.R
import com.srs.lms.fragment.AboutUsFragment
import com.srs.lms.fragment.CourseSearchFragment
import com.srs.lms.fragment.DashBoardFragment

class HomeActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView
    var previousMenuItem: MenuItem?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        drawerLayout=findViewById(R.id.drawerLayout)
        coordinatorLayout=findViewById(R.id.coordinatorLayout)
        toolbar=findViewById(R.id.toolbar)
        frameLayout=findViewById(R.id.frameLayout)
        navigationView=findViewById(R.id.navigationView)
        setUpToolBar()
        openDashboard()
        val actionBarDrawerToggle= ActionBarDrawerToggle(this@HomeActivity,drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        navigationView.setNavigationItemSelectedListener {

            if(previousMenuItem!=null)
            {
                previousMenuItem?.isChecked=false
            }
            it.isCheckable=true
            it.isChecked=true
            previousMenuItem=it
            when(it.itemId)
            {
                R.id.dashboard ->{
                    openDashboard()
                    drawerLayout.closeDrawers()

                }
                R.id.courses ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, CourseSearchFragment())

                        .commit()
                    supportActionBar?.title="Courses"
                    drawerLayout.closeDrawers()

                }
                R.id.logoff ->{
                  //Log off
                    drawerLayout.closeDrawers()
                }
                R.id.aboutus ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, AboutUsFragment())

                        .commit()
                    supportActionBar?.title="About Us"
                    drawerLayout.closeDrawers()
                }
            }
            return@setNavigationItemSelectedListener true
        }
    }
    fun setUpToolBar()
    {
        setSupportActionBar(toolbar)
        supportActionBar?.title="Toolbar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    fun openDashboard()
    {
        val fragment= DashBoardFragment()
        val transaction=supportFragmentManager.beginTransaction()

        transaction.replace(R.id.frameLayout,fragment)
        transaction.commit()
        supportActionBar?.title="Dashboard"
        navigationView.setCheckedItem(R.id.dashboard)

    }
    override fun onBackPressed() {
        val frag=supportFragmentManager.findFragmentById(R.id.frameLayout)
        when(frag)
        {
            !is DashBoardFragment ->openDashboard()
            else ->super.onBackPressed()
        }
    }
}