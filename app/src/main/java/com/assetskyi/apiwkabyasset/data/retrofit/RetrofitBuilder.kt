package com.assetskyi.apiwkabyasset.data.retrofit

import com.assetskyi.apiwkabyasset.data.repository.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private var retrofit: Retrofit? = null

    private val BASE_URL = "https://api.nobelprize.org/2.1/"
    val retrofitCall = getClient(BASE_URL).create(ApiService::class.java)

    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}