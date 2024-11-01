package com.dcht.themoviedb.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dcht.themoviedb.common.Constants.STARTING_PAGE
import com.dcht.themoviedb.common.MovieRequestOptionsMapper
import com.dcht.themoviedb.common.enums.MovieEnum
import com.dcht.themoviedb.data.model.FilterResult
import com.dcht.themoviedb.data.model.remote.movies.Movie
import com.dcht.themoviedb.data.source.remote.MovaService
import okio.IOException
import retrofit2.HttpException

class MoviePagingSource(
    private val movieService: MovaService,
    private val movieEnum: MovieEnum,
    private val searchQuery: String = "",
    movieRequestOptionsMapper: MovieRequestOptionsMapper,
    filterResult: FilterResult? = null,
    private val includeAdult: Boolean = false,
    private val movieId: Int = 0

) : PagingSource<Int, Movie>() {
    private val options = movieRequestOptionsMapper.map(filterResult)


    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: STARTING_PAGE

        return try {
            val response =
                when (movieEnum) {
                    MovieEnum.DISCOVER_MOVIES -> {
                        movieService.getDiscoverMovies(
                            page = page,
                            options = options
                        )
                    }
                    MovieEnum.NOW_PLAYING_MOVIES -> {
                        movieService.getNowPlayingMovies(page = page)
                    }
                    MovieEnum.SEARCH_MOVIES -> {
                        movieService.getSearchMovie(
                            page = page,
                            query = searchQuery,
                            includeAdult = includeAdult
                        )
                    }
                    MovieEnum.SIMILAR_MOVIES -> {
                        movieService.getSimilarMovies(
                            page = page,
                            movieId = movieId
                        )
                    }
                }

            LoadResult.Page(
                data = response.results,
                prevKey = if (page == STARTING_PAGE) null else page.minus(1),
                nextKey = if (response.results.isEmpty()) null else page.plus(1)
            )
        } catch (e: IOException) {
            LoadResult.Error(throwable = e)
        } catch (e: HttpException) {
            LoadResult.Error(throwable = e)
        }
    }
}