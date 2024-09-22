package com.dcht.themoviedb.ui.person.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dcht.themoviedb.common.enums.ImageTypeEnum
import com.dcht.themoviedb.common.format
import com.dcht.themoviedb.common.loadImage
import com.dcht.themoviedb.databinding.ItemMovieSerieNowPlayingBinding
import com.dcht.themoviedb.domain.model.MovieUI

class PersonMoviesAdapter(private val list: List<MovieUI>) :
    RecyclerView.Adapter<PersonMoviesAdapter.ViewHolder>() {
    var onClick: (Int) -> Unit = {}


    inner class ViewHolder(private val binding: ItemMovieSerieNowPlayingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieUI) {
            with(binding) {
                item.posterPath?.let {
                    imageView.loadImage(
                        it,
                        imageTypeEnum = ImageTypeEnum.POSTER
                    )
                }
                voteAverageTV.text = item.voteAverage.format(1)
                root.setOnClickListener {
                    onClick.invoke(item.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemMovieSerieNowPlayingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


}