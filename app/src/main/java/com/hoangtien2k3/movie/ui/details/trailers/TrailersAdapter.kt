package com.hoangtien2k3.movie.ui.details.trailers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hoangtien2k3.movie.common.enums.ImageTypeEnum
import com.hoangtien2k3.movie.common.getReformatDate
import com.hoangtien2k3.movie.common.loadImage
import com.hoangtien2k3.movie.databinding.ItemTrailerBinding
import com.hoangtien2k3.movie.domain.model.VideoUI

class TrailersAdapter(
    private val trailerList: List<VideoUI>
) :
    RecyclerView.Adapter<TrailersAdapter.ViewHolder>() {
    var onClick: (String) -> Unit = {}

    inner class ViewHolder(private val binding: ItemTrailerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: VideoUI) {
            with(binding) {
                titleTv.text = item.name
                dateTv.text = getReformatDate(item.publishedAt)
                imageView.loadImage(item.key, imageTypeEnum = ImageTypeEnum.YOUTUBE)

                root.setOnClickListener {
                    onClick(item.key)
                }
                cardView.setOnClickListener {
                    onClick(item.key)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemTrailerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(trailerList[position])
    }

    override fun getItemCount(): Int {
        return trailerList.size
    }


}