package com.dcht.themoviedb.ui.profile.helpcenter

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.dcht.themoviedb.R
import com.dcht.themoviedb.common.viewBinding
import com.dcht.themoviedb.databinding.FragmentDialogContactBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HelpCenterContactFragment : BottomSheetDialogFragment(R.layout.fragment_dialog_contact) {

    private val binding by viewBinding(FragmentDialogContactBinding::bind)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStart() {
        super.onStart()

        val window = dialog?.window
        window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        context?.let {
            if (window != null) {
                window.statusBarColor = it.getColor(android.R.color.transparent)
            }
        }
        if (dialog is BottomSheetDialog) {
            val behaviour = (dialog as BottomSheetDialog).behavior
            behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            behaviour.skipCollapsed = true

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        close()
        floatingTab()
    }

    private fun close() {
        with(binding) {
            overlay.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun floatingTab() {
        binding.apply {
            menuZalo.setOnClickListener {
                val zaloID = "0828007853"
                val url = "http://zalo.me/$zaloID"
                openUrl(url)
            }
            menuFacebook.setOnClickListener {
                val facebookID = "100053705482952"
                val url = "http://m.me/$facebookID"
                openUrl(url)
            }
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
