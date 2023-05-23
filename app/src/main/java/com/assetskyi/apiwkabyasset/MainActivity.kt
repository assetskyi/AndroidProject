package com.assetskyi.apiwkabyasset

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.assetskyi.apiwkabyasset.data.repository.ApiRepository
import com.assetskyi.apiwkabyasset.data.repository.ApiRepositoryImpl
import com.assetskyi.apiwkabyasset.data.retrofit.RetrofitBuilder
import com.assetskyi.apiwkabyasset.databinding.ActivityMainBinding
import com.assetskyi.apiwkabyasset.presentation.adapter.MainActivityAdapter
import com.assetskyi.apiwkabyasset.presentation.viewmodel.UserViewModel
import com.assetskyi.apiwkabyasset.presentation.viewmodel.UserViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UserViewModel
    private lateinit var adapter: MainActivityAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MainActivityAdapter()

        binding.rcViewAdapter.adapter = adapter

        val apiService = RetrofitBuilder.retrofitCall
        val repository: ApiRepository = ApiRepositoryImpl(apiService)
        viewModel = ViewModelProvider(this, UserViewModelFactory(repository)).get(UserViewModel::class.java)

        viewModel.user.observe(this) { user ->
            adapter.submitList(user.nobelPrizes)
            adapter.notifyDataSetChanged()
        }

        viewModel.getUser()
    }
}






//
//class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        CoroutineScope(Dispatchers.Main).launch {
//            kotlin.runCatching {
//                RetrofitBuilder.retrofitCall.getNobels()
//            }.onSuccess {
//                val adapter = MainActivityAdapter()
//                adapter.submitList(it.nobelPrizes)
//                binding.rcViewAdapter.adapter = adapter
//            }.onFailure {
//                Toast.makeText(applicationContext,"$it",Toast.LENGTH_LONG).show()
//            }
//        }
//    }
//}