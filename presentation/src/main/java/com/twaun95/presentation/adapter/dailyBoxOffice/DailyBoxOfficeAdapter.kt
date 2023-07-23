package com.twaun95.presentation.adapter.dailyBoxOffice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.twaun95.domain.model.entity.movie.BoxOfficeEntity
import com.twaun95.presentation.base.BaseViewHolder
import com.twaun95.presentation.databinding.ItemDailyBoxOfficeBinding

class DailyBoxOfficeAdapter(
    var onItemClickListener: (item: BoxOfficeEntity) -> Unit
) : ListAdapter<BoxOfficeEntity, DailyBoxOfficeAdapter.DailyBoxOfficeViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyBoxOfficeViewHolder {
        return DailyBoxOfficeViewHolder(
            ItemDailyBoxOfficeBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onClickListener = onItemClickListener
        )
    }

    override fun onBindViewHolder(holder: DailyBoxOfficeViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    companion object {
        val diffUtil = object: DiffUtil.ItemCallback<BoxOfficeEntity>() {
            override fun areContentsTheSame(oldItem: BoxOfficeEntity, newItem: BoxOfficeEntity): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: BoxOfficeEntity, newItem: BoxOfficeEntity): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }

    inner class DailyBoxOfficeViewHolder(
        private val binding: ItemDailyBoxOfficeBinding,
        private val onClickListener: (item: BoxOfficeEntity) -> Unit
    ) : BaseViewHolder<BoxOfficeEntity>(binding.root) {
        override fun bind(data: BoxOfficeEntity) {
            binding.data = data
            binding.buttonItem.setOnClickListener {
                onClickListener.invoke(data)
            }
        }
    }
}

