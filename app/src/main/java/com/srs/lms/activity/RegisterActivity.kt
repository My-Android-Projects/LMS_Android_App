package com.srs.lms.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.srs.lms.R
import com.srs.lms.api.RetrofitInstance
import com.srs.lms.model.User
import com.srs.lms.utlity.URIPathHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterActivity : AppCompatActivity() {
    val TAG = "RESTAPI"
    lateinit var btn_register:Button
    lateinit var imgPhoto:ImageView
    lateinit var btnUploadPhoto:Button
    lateinit var et_filePath: TextView

    lateinit var rd_userType:RadioGroup
    lateinit var et_username:EditText
    lateinit var et_email:EditText
    lateinit var et_password:EditText
    lateinit var et_address:EditText
    lateinit var et_city:EditText
    lateinit var et_pincode:EditText
    lateinit var et_phone:EditText

    val REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btn_register=findViewById(R.id.btn_register)
        imgPhoto=findViewById(R.id.imgPhoto)
        btnUploadPhoto=findViewById(R.id.btnUploadPhoto)
        et_filePath=findViewById(R.id.et_filePath)

        rd_userType=findViewById(R.id.rd_userType)
        et_username=findViewById(R.id.et_username)
        et_email=findViewById(R.id.et_email)
        et_password=findViewById(R.id.et_password)
        et_address=findViewById(R.id.et_address)
        et_city=findViewById(R.id.et_city)
        et_pincode=findViewById(R.id.et_pincode)
        et_phone=findViewById(R.id.et_phone)

        btn_register.setOnClickListener()
        {
            var id: Int = rd_userType.checkedRadioButtonId
            val selectedType:RadioButton = findViewById(id)
            var userType = selectedType.text.toString()
            var userName=et_username.text.toString()
            var email=et_email.text.toString()
            var password=et_password.text.toString()
            var address=et_address.text.toString()
            var city=et_city.text.toString()
            var pincode=et_pincode.text.toString()
            var phone=et_phone.text.toString()
            postUser(userType,userName,email,password,address,city,pincode,phone)

            val intent= Intent(this@RegisterActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        btnUploadPhoto.setOnClickListener()
        {

            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_CODE)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            imgPhoto.setImageURI(data?.data) // handle chosen image
            val uriPathHelper = URIPathHelper()
            val filePath = uriPathHelper.getPath(this, data?.data as Uri)
            et_filePath.setText(filePath)

        }
    }
    private fun postUser(userType:String,userName:String,email:String,password:String,address:String,
                         city:String,pincode:String,phone:String){
        Log.d(TAG, "Inside POST")
        val userCustomer = User(
            id = null,
             type=userType,
             name=userName,
            email=email,
            password=password,
            address=address,
             city=city,
            pincode=pincode,
             phone=phone)

        CoroutineScope(Dispatchers.IO).launch{
            try {
                println("step1")
                val response = RetrofitInstance.simpleApiClient.registerUser(userCustomer)
                println("step2")
                withContext(Dispatchers.Main){
                    if (response.isSuccessful && response.body()!=null){
                        println("step3")
                        Log.d(TAG, "Post: ${response.body().toString()}")
                    } else {
                        println("step3b")
                        Log.d(TAG,response.message())
                    }
                }
            }catch (e: Exception){
                println("stepn")
                e.message?.let { Log.d("API", it) }
            }
        }
        println("stepx")
    }
}