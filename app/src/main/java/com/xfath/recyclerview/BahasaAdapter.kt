package com.xfath.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xfath.recyclerview.databinding.ItemBahasaBinding

class BahasaAdapter(
    private val bahasaPemprogramanModelList: ArrayList<BahasaPemprogramanModel>,
    private val listener: (BahasaPemprogramanModel) -> Unit
) : RecyclerView.Adapter<BahasaAdapter.BahasaViewHolder>() {

    inner class BahasaViewHolder(val binding: ItemBahasaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BahasaViewHolder {
        val binding = ItemBahasaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BahasaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BahasaViewHolder, position: Int) {
        holder.binding.tvMacam.text = bahasaPemprogramanModelList[position].namaBahasa
        holder.binding.image.setImageResource(bahasaPemprogramanModelList[position].image)

        val item = bahasaPemprogramanModelList[position]
        holder.itemView.setOnClickListener { listener(item)
        }
    }

    override fun getItemCount(): Int = bahasaPemprogramanModelList.size
}