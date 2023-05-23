package com.assetskyi.apiwkabyasset.data.repository

import com.assetskyi.apiwkabyasset.data.model.Nobels

interface ApiRepository {
    suspend fun getNobels(): Nobels
}
