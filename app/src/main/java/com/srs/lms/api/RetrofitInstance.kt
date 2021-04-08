package com.srs.lms.api

import com.srs.lms.utlity.Constants.Companion.BASE_URL1
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val simpleApiClient: lmsAPI = Retrofit.Builder()
        .baseUrl(BASE_URL1)
        .addConverterFactory(GsonConverterFactory.create())//JSON-Object conversion
        .build()
        .create(lmsAPI::class.java)
}