package com.srs.lms.model

data class EnrolledCourseSession (
    var enrollmentId:Int,
    var sessionId:Int,
    var courseId:Int,
    var courseName:String,
    var courseCategory:String,
    var courseCredit:Int,
    var courseDuration:Int,
    var courseStartDate:String,
    var courseEndDate:String,
    var facultyId:Int,
    var takenBy:String,
    var studentId:Int,
    var enrolledBy:String
)