package com.example.myapplication

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ModalBottomSheetDialogFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.dialog_fragment_modal_bottom_sheet, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // We can't inflate the NavHostFragment from XML because it will crash the 2nd time the dialog is opened
        val navHost = NavHostFragment()
        childFragmentManager.beginTransaction().replace(R.id.filterNavHost, navHost).commitNow()
        navHost.navController.setGraph(R.navigation.filter_nav)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            // Normally the dialog would close on back press. We override this behaviour and check if we can navigate back
            // If we can't navigate back we return false triggering the default implementation closing the dialog
            setOnKeyListener { _, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP) {
                    view?.findNavController()?.popBackStack() == true
                } else {
                    false
                }
            }
        }
    }
}