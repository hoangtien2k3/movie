package com.hoangtien2k3.movie.ui.details.similar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hoangtien2k3.movie.common.base.BasePagingAdapter
import com.hoangtien2k3.movie.common.enums.ImageTypeEnum
import com.hoangtien2k3.movie.common.format
import com.hoangtien2k3.movie.common.loadImage
import com.hoangtien2k3.movie.databinding.ItemMovieSerieNowPlayingBinding
import com.hoangtien2k3.movie.domain.model.SerieUI

class SimilarSeriesAdapter(
    private val onClickMovie: ((movieId: Int) -> Unit)?
) : BasePagingAdapter<SerieUI>(
    itemsSame = { old, new -> old.id == new.id },
    contentsSame = { old, new -> old == new }
) {

    class MovieViewHolder(
        private val binding: ItemMovieSerieNowPlayingBinding,
        private val onClickMovie: ((movieId: Int) -> Unit)?
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SerieUI) = binding.apply {

            item.posterPath?.let { imageView.loadImage(it, imageTypeEnum = ImageTypeEnum.POSTER) }
            voteAverageTV.text = item.voteAverage.format(1)
            root.setOnClickListener {
                onClickMovie?.invoke(item.id)
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