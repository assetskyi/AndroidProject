package com.assetskyi.apiwkabyasset.data.repository

import com.assetskyi.apiwkabyasset.data.model.Nobels

class ApiRepositoryImpl(private val apiService: ApiService) : ApiRepository {
    override suspend fun getNobels(): Nobels {
        return apiService.getNobels()
    }
}