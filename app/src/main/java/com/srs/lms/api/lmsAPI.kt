package com.srs.lms.api

import com.srs.lms.model.*
import retrofit2.Response
import retrofit2.http.*

interface lmsAPI {
    //********************** Login/Register*****************************************
    @Headers("Content-Type: application/json")
    @POST("api/login")
    suspend fun getLogin(@Body userData: User): Response<User>

    @Headers("Content-Type: application/json")
    @POST("api/register")
    suspend fun registerUser(@Body userData: User): Response<User>

//*****************************Sessions**************************************************************
    @GET("api/sessions/")
    suspend fun getCourseSessions(): Response<CourseSessions>

    @GET("api/sessions/{id}")
    suspend fun getCourseSession(@Path("id") id: Int): Response<CourseSession>

    @Headers("Content-Type: application/json")
    @POST("api/sessions")
    suspend fun addCourseSession(@Body userData: CourseSession): Response<CourseSession>

    @Headers("Content-Type: application/json")
    @PUT("api/sessions/{id}")
    suspend fun updateCourseSession(@Path("id") id: Int,@Body userData: CourseSession): Response<CourseSession>

    @DELETE("api/sessions/{id}")
    suspend fun deleteCourseSession(@Path("id") id: Int): Response<CourseSession>
//************************************Enrolled Sessions ********************************************
    @GET("api/enrolledsessions/")
    suspend fun getEnrolledCourseSessions(): Response<EnrolledCourseSessions>

    @GET("api/enrolledsessions/{id}")
    suspend fun getEnrolledCourseSession(@Path("id") id: Int): Response<EnrolledCourseSession>

    @Headers("Content-Type: application/json")
    @POST("api/enrolledsessions")
    suspend fun addEnrolledCourseSession(@Body userData: EnrolledCourseSession): Response<EnrolledCourseSession>

    @Headers("Content-Type: application/json")
    @PUT("api/enrolledsessions/{id}")
    suspend fun updateCourseSession(@Path("id") id: Int,@Body userData: EnrolledCourseSession): Response<EnrolledCourseSession>

    @DELETE("api/enrolledsessions/{id}")
    suspend fun deleteEnrolledCourseSession(@Path("id") id: Int): Response<EnrolledCourseSession>

}