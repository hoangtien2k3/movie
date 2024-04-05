package com.hoangtien2k3.themoviedb.ui.home.now_playing_series

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hoangtien2k3.themoviedb.R
import com.hoangtien2k3.themoviedb.common.enums.MediaTypeEnum
import com.hoangtien2k3.themoviedb.common.gone
import com.hoangtien2k3.themoviedb.common.showToast
import com.hoangtien2k3.themoviedb.common.viewBinding
import com.hoangtien2k3.themoviedb.common.visible
import com.hoangtien2k3.themoviedb.databinding.FragmentNowPlayingSeriesBinding
import com.hoangtien2k3.themoviedb.ui.home.LoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class NowPlayingSeriesFragment : Fragment(R.layout.fragment_now_playing_series) {
    private val binding by viewBinding(FragmentNowPlayingSeriesBinding::bind)
    private val viewModel: NowPlayingSeriesViewModel by viewModels()
    private val adapter: NowPlayingSeriesAdapter by lazy { NowPlayingSeriesAdapter(::onClickItem) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        collectData()
    }

    private fun initUI() {
        with(binding) {
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }

            recyclerViewNowPlayingSeries.let {
                it.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                        if (firstVisibleItemPosition == 0) {
                            binding.fab.visibility = View.GONE
                        } else {
                            with(binding) {
                                fab.visibility = View.VISIBLE

                                fab.setOnClickListener {
                                    recyclerViewNowPlayingSeries.smoothScrollToPosition(0)
                                }
                            }
                        }
                    }
                })
            }
        }
    }

    private fun onClickItem(id: Int) {
        val action =
            NowPlayingSeriesFragmentDirections.actionNowPlayingSeriesFragmentToDetailsFragment(
                id,
                MediaTypeEnum.SERIE
            )
        findNavController().navigate(action)
    }

    private fun collectData() {
        with(viewModel) {
            with(binding) {

                viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                    nowPlayingSeries.collectLatest { response ->
                        // Creating Contact Adapter For Paging Footer Span Count
                        val contactAdapter = adapter.withLoadStateFooter(
                            footer = LoadStateAdapter { adapter.retry() }
                        )

                        recyclerViewNowPlayingSeries.layoutManager =
                            GridLayoutManager(context, 2).apply {
                                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                                    override fun getSpanSize(position: Int): Int {
                                        return if (contactAdapter.getItemViewType(position) in
                                            arrayOf(1)
                                        ) spanCount else 1
                                    }

                                }
                            }

                        recyclerViewNowPlayingSeries.adapter = contactAdapter
                        adapter.submitData(lifecycle, response)

                        adapter.loadStateFlow.collectLatest { loadStates ->
                            when (loadStates.refresh) {
                                is LoadState.Loading -> {
                                    nowPlayingSeriesLoading.visible()
                                    nowPlayingSeriesLoading.startShimmer()
                                    recyclerViewNowPlayingSeries.gone()
                                }
                                is LoadState.NotLoading -> {
                                    nowPlayingSeriesLoading.gone()
                                    nowPlayingSeriesLoading.stopShimmer()
                                    recyclerViewNowPlayingSeries.visible()
                                }
                                is LoadState.Error -> {
                                    requireActivity().showToast(
                                        getString(R.string.error),
                                        (loadStates.refresh as LoadState.Error).error.localizedMessage
                                            ?: "Error",
                                        www.sanju.motiontoast.MotionToastStyle.ERROR
                                    )
                                }

                            }
                        }
                    }
                }

            }
        }
    }

}