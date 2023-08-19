package com.twaun95.presentation.adapter.searchPeople

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.twaun95.domain.model.entity.movie.PeopleEntity
import com.twaun95.presentation.base.BaseViewHolder
import com.twaun95.presentation.databinding.ItemSearchPeopleBinding

class SearchPeopleAdapter(
    var onItemClickListener: (item: PeopleEntity) -> Unit
) : ListAdapter<PeopleEntity, SearchPeopleAdapter.SearchPeopleViewHolder>(diffUtil){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchPeopleViewHolder {
        return SearchPeopleViewHolder(
            ItemSearchPeopleBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onClickListener = onItemClickListener
        )
    }

    override fun onBindViewHolder(holder: SearchPeopleViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    companion object {
        val diffUtil = object: DiffUtil.ItemCallback<PeopleEntity>() {
            override fun areContentsTheSame(oldItem: PeopleEntity, newItem: PeopleEntity): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: PeopleEntity, newItem: PeopleEntity): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }

    inner class SearchPeopleViewHolder(
        private val binding: ItemSearchPeopleBinding,
        private val onClickListener: (item: PeopleEntity) -> Unit
    ) : BaseViewHolder<PeopleEntity>(binding.root) {
        override fun bind(data: PeopleEntity) {
            binding.data = data
            binding.layoutItem.setOnClickListener {
                onClickListener.invoke(data)
            }
        }
    }
}