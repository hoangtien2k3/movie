package com.dcht.themoviedb.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dcht.themoviedb.data.model.remote.genres.Genre
import com.dcht.themoviedb.databinding.ItemGenreDetailsBinding

class GenresAdapter(private val genreList: List<Genre>) :
    RecyclerView.Adapter<GenresAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemGenreDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Genre) {
            with(binding) {
                genreTv.text = item.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemGenreDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(genreList[position])
    }

    override fun getItemCount(): Int {
        return genreList.size
    }


}