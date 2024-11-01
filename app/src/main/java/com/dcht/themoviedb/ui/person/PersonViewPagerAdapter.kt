package com.dcht.themoviedb.ui.person

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dcht.themoviedb.ui.person.images.PersonImagesFragment
import com.dcht.themoviedb.ui.person.movies.PersonMoviesFragment
import com.dcht.themoviedb.ui.person.series.PersonSeriesFragment

class PersonViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val id: Int
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return PersonImagesFragment.createBundle(id)
            1 -> return PersonMoviesFragment.createBundle(id)
            2 -> return PersonSeriesFragment.createBundle(id)
        }
        return PersonImagesFragment.createBundle(id)
    }
}