package com.hoangtien2k3.themoviedb.ui.home.now_playing_movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hoangtien2k3.themoviedb.common.base.BasePagingAdapter
import com.hoangtien2k3.themoviedb.common.enums.ImageTypeEnum
import com.hoangtien2k3.themoviedb.common.format
import com.hoangtien2k3.themoviedb.common.loadImage
import com.hoangtien2k3.themoviedb.databinding.ItemMovieSerieNowPlayingBinding
import com.hoangtien2k3.themoviedb.domain.model.MovieUI

class NowPlayingMoviesAdapter(
    private val onClickMovie: ((movieId: Int) -> Unit)
) : BasePagingAdapter<MovieUI>(
    itemsSame = { old, new -> old.id == new.id },
    contentsSame = { old, new -> old == new }
) {

    class MovieViewHolder(
        private val binding: ItemMovieSerieNowPlayingBinding,
        private val onClickMovie: ((movieId: Int) -> Unit)
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieUI) = binding.apply {

            imageView.loadImage(item.posterPath, imageTypeEnum = ImageTypeEnum.POSTER)
            voteAverageTV.text = item.voteAverage.format(1)
            root.setOnClickListener {
                onClickMovie(item.id)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder =
        MovieViewHolder(
            ItemMovieSerieNowPlayingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onClickMovie
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MovieViewHolder -> {
                getItem(position)?.let { movie -> holder.bind(movie) }
            }
        }
    }


}