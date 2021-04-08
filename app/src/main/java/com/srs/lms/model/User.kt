package com.srs.lms.model

data class User(
var id:Int?,
var type:String,
var name:String,
var email:String,
var password:String,
var address:String,
var city:String,
var pincode:String,
var phone:String
)