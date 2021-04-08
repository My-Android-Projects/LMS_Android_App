package com.srs.lms.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.srs.lms.R
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
lateinit var txtUserName:EditText
lateinit var txtPassword:EditText
lateinit var btnLogin:Button
lateinit var lnkForgotPassword: TextView
lateinit var lnkRegister:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="LMS"
        txtUserName=findViewById(R.id.txtUserName)
        txtPassword=findViewById(R.id.txtPassword)
        btnLogin=findViewById(R.id.btn_Login)
        lnkForgotPassword=findViewById(R.id.lnk_ForgotPassword)
        lnkRegister=findViewById(R.id.lnk_NewUser)
        btnLogin.setOnClickListener()
        {
            val intent= Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
        }
        lnkRegister.setOnClickListener()
        {
            val intent= Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}