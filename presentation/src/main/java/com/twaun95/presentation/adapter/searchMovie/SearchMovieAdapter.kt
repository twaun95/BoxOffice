package com.twaun95.presentation.adapter.searchMovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.twaun95.domain.model.entity.movie.MovieEntity
import com.twaun95.presentation.base.BaseViewHolder
import com.twaun95.presentation.databinding.ItemSearchMovieBinding

class SearchMovieAdapter(
    var onItemClickListener: (item: MovieEntity) -> Unit
) : ListAdapter<MovieEntity, SearchMovieAdapter.SearchMovieViewHolder>(diffUtil){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMovieViewHolder {
        return SearchMovieViewHolder(
            ItemSearchMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onClickListener = onItemClickListener
        )
    }

    override fun onBindViewHolder(holder: SearchMovieViewHolder, position: Int) {
        return holder.bind(getItem(position))
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

    inner class SearchMovieViewHolder(
        private val binding: ItemSearchMovieBinding,
        private val onClickListener: (item: MovieEntity) -> Unit
    ) : BaseViewHolder<MovieEntity>(binding.root) {
        override fun bind(data: MovieEntity) {
            binding.data = data
            binding.buttonItem.setOnClickListener {
                onClickListener.invoke(data)
            }
        }
    }
}