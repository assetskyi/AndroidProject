package com.assetskyi.apiwkabyasset.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assetskyi.apiwkabyasset.data.model.Nobels
import com.assetskyi.apiwkabyasset.data.repository.ApiRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: ApiRepository) : ViewModel() {
    private val _user = MutableLiveData<Nobels>()
    val user: LiveData<Nobels> get() = _user

    fun getUser() {
        viewModelScope.launch {
            try {
                val nobels = repository.getNobels()
                _user.value = nobels
            } catch (e: Exception) {
                // Обработка ошибки
            }
        }
    }
}
