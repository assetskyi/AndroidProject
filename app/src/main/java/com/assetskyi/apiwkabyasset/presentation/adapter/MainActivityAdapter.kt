package com.assetskyi.apiwkabyasset.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assetskyi.apiwkabyasset.data.model.Nobels
import com.assetskyi.apiwkabyasset.databinding.AdapterMainItemBinding


class MainActivityAdapter(
    private var listApi: List<Nobels.NobelPrize> = emptyList()
): RecyclerView.Adapter<MainActivityAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: AdapterMainItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun initContent(item: Nobels.NobelPrize) {
            binding.fullNameView.text = item.categoryFullName.en
            binding.categoryView.text = String.format("Category: %s", item.category.en)
            binding.awardYearView.text = String.format("Award year: %s", item.awardYear)
            binding.dateAwardedView.text = String.format("Date awarded: %s", item.dateAwarded)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterMainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.initContent(listApi[position])
    }

    override fun getItemCount(): Int = listApi.size

    fun submitList(list: List<Nobels.NobelPrize>){
        listApi = list
    }

}