package com.srs.lms.activity

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.srs.lms.R
import com.srs.lms.`interface`.CourseSearchDataCommunicator
import com.srs.lms.fragment.AboutUsFragment
import com.srs.lms.fragment.CourseSearchFragment
import com.srs.lms.fragment.CourseSearchResultFragment
import com.srs.lms.fragment.DashBoardFragment
import com.srs.lms.service.CurrentTimeService
import java.security.KeyStore

class HomeActivity : AppCompatActivity(), CourseSearchDataCommunicator {
    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView
    //lateinit var txtCurrentTime: TextView
    var previousMenuItem: MenuItem?=null
    /*
    var myService:CurrentTimeService?=null
    var isBound=false

    private val myConnection=object: ServiceConnection {
        override fun onServiceConnected(className:ComponentName,service: IBinder)
        {
            val binder=service as CurrentTimeService.MyLocalBinder
            myService=binder.getService()
            isBound=true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound=false

        }
    }

    override fun onStart()
    {
        super.onStart()
        val timeIntent= Intent(this,CurrentTimeService::class.java)
        bindService(timeIntent,myConnection, Context.BIND_AUTO_CREATE)
    }
    override fun onStop()
    {
        super.onStop()
        unbindService(myConnection)
    }
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        drawerLayout=findViewById(R.id.drawerLayout)
        coordinatorLayout=findViewById(R.id.coordinatorLayout)
        toolbar=findViewById(R.id.toolbar)
        frameLayout=findViewById(R.id.frameLayout)
        navigationView=findViewById(R.id.navigationView)
    //   txtCurrentTime=findViewById(R.id.txtCurrentTime)
        //  ***********************************8


        // ******************************
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

    override fun sendCourseFilterData(
        courseName: String,
        courseCategory: String,
        courseCredits: String,
        courseStartDate: String,
        courseEndDate: String
    ) {
      val bundle=Bundle()
        bundle.putString("courseName",courseName)
        bundle.putString("courseCategory",courseCategory)
        bundle.putString("courseCredits",courseCredits)
        bundle.putString("courseStartDate",courseStartDate)
        bundle.putString("courseEndDate",courseEndDate)
        val courseSearchResultFragment=CourseSearchResultFragment.newInstance(
        )
        val transaction=supportFragmentManager.beginTransaction()
        courseSearchResultFragment.arguments=bundle
        transaction.replace(R.id.frameLayout,courseSearchResultFragment).commit()
    }

   /* fun showTime(view: View)
    {
        val currentTime=myService?.getCurrentTime()
        txtCurrentTime.text=currentTime

    }

    */
}