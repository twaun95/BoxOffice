package com.twaun95.presentation.adapter.dailyBoxOffice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.twaun95.domain.model.MovieEntity
import com.twaun95.presentation.databinding.ItemDailyBoxOfficeBinding

class DailyBoxOfficeAdapter(
    var onItemClickListener: (()->Unit)? = null
) : ListAdapter<MovieEntity, DailyBoxOfficeAdapter.DailyBoxOfficeViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyBoxOfficeViewHolder {
        return DailyBoxOfficeViewHolder(ItemDailyBoxOfficeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DailyBoxOfficeViewHolder, position: Int) {
        return holder.bind(getItem(position)){ onItemClickListener?.invoke() }
    }

    companion object {
        val diffUtil = object: DiffUtil.ItemCallback<MovieEntity>() {
            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }

    inner class DailyBoxOfficeViewHolder(
        private val binding: ItemDailyBoxOfficeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            data: MovieEntity,
            onClickListener: (()->Unit)? = null
        ) {
            binding.data = data
            binding.buttonItem.setOnClickListener {
                onClickListener?.invoke()
            }
        }
    }
}

