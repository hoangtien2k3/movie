package com.dcht.themoviedb.ui.images

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.dcht.themoviedb.common.enums.ImageTypeEnum
import com.dcht.themoviedb.common.loadImage
import com.dcht.themoviedb.databinding.ItemImagePreviewBinding
import com.dcht.themoviedb.domain.model.ImageUI

class ImagesViewPagerAdapter(
    private val itemList: Array<ImageUI>
) : PagerAdapter() {

    override fun instantiateItem(parent: ViewGroup, position: Int): Any {

        val itemBinding =
            ItemImagePreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        with(itemBinding) {
            with(itemList[position]) {

                imageView.loadImage(filePath, imageTypeEnum = ImageTypeEnum.POSTER)

            }
        }


        parent.addView(itemBinding.root, 0)

        return itemBinding.root
    }

    override fun getCount(): Int = itemList.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean =
        view == (`object` as ImageView)

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        container.removeView(`object` as ConstraintLayout)
    }
}