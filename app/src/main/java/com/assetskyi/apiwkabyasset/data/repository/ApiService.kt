package com.assetskyi.apiwkabyasset.data.repository

import com.assetskyi.apiwkabyasset.data.model.Nobels
import retrofit2.http.GET

interface ApiService {
    @GET("nobelPrizes")
    suspend fun getNobels(): Nobels
}
