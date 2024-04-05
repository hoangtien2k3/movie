package com.hoangtien2k3.themoviedb.ui.mylist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hoangtien2k3.themoviedb.R
import com.hoangtien2k3.themoviedb.common.*
import com.hoangtien2k3.themoviedb.common.enums.MediaTypeEnum
import com.hoangtien2k3.themoviedb.databinding.FragmentMyListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import www.sanju.motiontoast.MotionToastStyle

@AndroidEntryPoint
class MyListFragment : Fragment(R.layout.fragment_my_list) {
    private val binding by viewBinding(FragmentMyListBinding::bind)
    private val viewModel: MyListViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        collectData()
    }

    fun initUI() {
        with(viewModel) {
            getBookmarks()
        }
    }

    private fun onClickItem(id: Int, mediaType: MediaTypeEnum) {
        val action = MyListFragmentDirections.actionMyListFragmentToDetailsFragment(id, mediaType)
        findNavController().navigate(action)
    }

    private fun collectData() {
        with(viewModel) {
            with(binding) {

                viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                    bookmarks.collectLatest { response ->
                        when (response) {
                            is Resource.Loading -> {
                                bookmarksLoading.visible()
                                bookmarksLoading.startShimmer()
                                myListRecyclerView.gone()
                                emptyList.gone()
                            }

                            is Resource.Error -> {
                                myListRecyclerView.gone()

                                requireActivity().showToast(
                                    getString(R.string.error),
                                    response.throwable.localizedMessage ?: "Error",
                                    MotionToastStyle.ERROR
                                )

                            }

                            is Resource.Success -> {
                                bookmarksLoading.gone()
                                bookmarksLoading.stopShimmer()


                                if (response.data.isEmpty()) {
                                    myListRecyclerView.gone()
                                    emptyList.visible()

                                } else {
                                    myListRecyclerView.visible()
                                    emptyList.gone()

                                    val myListAdapter =
                                        MyListAdapter(response.data)
                                    myListRecyclerView.adapter = myListAdapter
                                    myListAdapter.onClickHigh = ::onClickItem
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}