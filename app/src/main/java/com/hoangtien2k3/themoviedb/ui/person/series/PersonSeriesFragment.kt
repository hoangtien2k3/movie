package com.hoangtien2k3.themoviedb.ui.person.series

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hoangtien2k3.themoviedb.R
import com.hoangtien2k3.themoviedb.common.*
import com.hoangtien2k3.themoviedb.common.enums.MediaTypeEnum
import com.hoangtien2k3.themoviedb.databinding.FragmentPersonSeriesBinding
import com.hoangtien2k3.themoviedb.ui.person.PersonDetailFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class PersonSeriesFragment : Fragment(R.layout.fragment_person_series) {
    private val binding by viewBinding(FragmentPersonSeriesBinding::bind)
    private val viewModel: PersonSeriesViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        collectData()
    }

    fun initUI() {
        with(binding) {
            with(viewModel) {

            }
        }
    }

    private fun onClick(id: Int) {
        val action = PersonDetailFragmentDirections.actionPersonDetailFragmentToDetailsFragment(
            id,
            MediaTypeEnum.SERIE
        )
        findNavController().navigate(action)
    }

    fun collectData() {
        with(viewModel) {
            with(binding) {

                lifecycleScope.launchWhenCreated {
                    series.collectLatest { response ->
                        when (response) {
                            is Resource.Loading -> {
                                recyclerViewSeries.gone()
                            }
                            is Resource.Error -> {
                                recyclerViewSeries.gone()

                                requireActivity().showToast(
                                    getString(com.hoangtien2k3.themoviedb.R.string.error),
                                    response.throwable.localizedMessage ?: "Error",
                                    www.sanju.motiontoast.MotionToastStyle.ERROR
                                )

                            }
                            is Resource.Success -> {
                                recyclerViewSeries.visible()

                                val adapter =
                                    PersonSeriesAdapter(response.data)
                                recyclerViewSeries.adapter = adapter
                                adapter.onClick = ::onClick

                            }
                        }

                    }
                }


            }
        }
    }

    companion object {
        fun createBundle(id: Int) =
            PersonSeriesFragment().apply {
                arguments = Bundle().apply {
                    putInt(Constants.Arguments.ID, id)
                }
            }
    }
}