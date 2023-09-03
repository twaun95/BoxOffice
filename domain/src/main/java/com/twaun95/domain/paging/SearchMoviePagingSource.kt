package com.twaun95.domain.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.twaun95.domain.model.Result
import com.twaun95.domain.model.entity.movie.MovieEntity
import com.twaun95.domain.repository.movie.MovieRepository
import com.twaun95.domain.utils.SearchPagingConfig
import com.twaun95.domain.utils.SearchPagingConfig.SEARCH_MOVIE_STARTING_PAGE_INDEX
import javax.inject.Inject

class SearchMoviePagingSource @Inject constructor(
    private val movieRepository: MovieRepository,
    private val keyword: String
) : PagingSource<Int, MovieEntity>(){
    override fun getRefreshKey(state: PagingState<Int, MovieEntity>): Int? {
        return state.anchorPosition?.let {position ->
            state.closestPageToPosition(position)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieEntity> {
        val page = params.key ?: SEARCH_MOVIE_STARTING_PAGE_INDEX
        return try {
            val response = movieRepository.getMovies(
                movieName = keyword,
                page = page,
                pageSize = params.loadSize
            )
            val success = response as Result.Success
            LoadResult.Page(
                data = success.data,
                prevKey = if (page > 1) page - 1 else null,
                nextKey = if (response.data.isNotEmpty()) page + 1 else null
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }
}