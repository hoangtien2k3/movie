package com.hoangtien2k3.movie.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hoangtien2k3.movie.common.base.BasePagingAdapter
import com.hoangtien2k3.movie.common.enums.ImageTypeEnum
import com.hoangtien2k3.movie.common.format
import com.hoangtien2k3.movie.common.loadImage
import com.hoangtien2k3.movie.databinding.ItemMovieSerieBinding
import com.hoangtien2k3.movie.domain.model.SerieUI


class SerieAdapter(
    private val onClick: ((id: Int) -> Unit)?
) : BasePagingAdapter<SerieUI>(
    itemsSame = { old, new -> old.id == new.id },
    contentsSame = { old, new -> old == new }
) {

    class SerieViewHolder(
        private val binding: ItemMovieSerieBinding,
        private val onClick: ((id: Int) -> Unit)?
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SerieUI) = binding.apply {

            imageView.loadImage(item.posterPath, imageTypeEnum = ImageTypeEnum.POSTER)
            voteAverageTV.text = item.voteAverage.format(1)

            root.setOnClickListener {
                onClick?.invoke(item.id)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder =
        SerieViewHolder(
            ItemMovieSerieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onClick
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SerieViewHolder -> {
                getItem(position)?.let { movie -> holder.bind(movie) }
            }
        }
    }


}