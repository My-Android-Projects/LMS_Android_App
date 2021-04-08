package com.srs.lms.model

data class CourseSessions
    (
    val results:List<CourseSession>
            )

data class CourseSession(
var id:Int,
var courseId:Int,
var courseName:String,
var courseCategory:String,
var courseCredits:Int,
var courseDuration:Int,
var takenBy:String,
var totSeats:Int,
var remainingSeats:Int,
var courseStartDate:String,
var courseEndDate:String



)
