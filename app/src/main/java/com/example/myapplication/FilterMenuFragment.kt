package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_filter_menu.*

class FilterMenuFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_filter_menu, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonShowSearch.setOnClickListener {
            // it.findNavController() traverses the view hierarchy up and will take the first NavHost found: filterNavHost
            it.findNavController().navigate(R.id.action_filterMenuFragment_to_searchFragment)
        }

        buttonShowTagList.setOnClickListener {
            // it.findNavController() traverses the view hierarchy up and will take the first NavHost found: filterNavHost
            it.findNavController().navigate(R.id.action_filterMenuFragment_to_tagListFragment)
        }
    }
}