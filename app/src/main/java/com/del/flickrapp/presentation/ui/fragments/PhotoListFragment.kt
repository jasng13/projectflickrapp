package com.del.flickrapp.presentation.ui.fragments

import android.app.ActionBar
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.del.flickrapp.R
import com.del.flickrapp.databinding.FragmentPhotoListsBinding
import com.del.flickrapp.presentation.ui.adapters.PhotoListAdapter
import com.del.flickrapp.presentation.viewmodels.PhotoListViewModel
import com.del.flickrapp.utils.DataState
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PhotoListFragment : Fragment(){

    private val viewModel: PhotoListViewModel by viewModels()
    private lateinit var binding: FragmentPhotoListsBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPhotoListsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.progressBar.visibility = View.VISIBLE

        setupUi()
        subscribeObservers()
        return root
    }

    //created a dynamic search bar that displays default images if no input was found
    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupUi() {
        binding.searchView.layoutParams = ActionBar.LayoutParams(Gravity.RIGHT)
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {

                if (newText.isNullOrBlank()){
                    viewModel.getPhotoList()
                }else {
                    viewModel.searchImage(newText.toString())
                }
                return false
            }
        })
    }


    private fun subscribeObservers() {
        viewModel.resultState.observe(viewLifecycleOwner){ dataState ->
            when (dataState) {
                is DataState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is DataState.Success -> {

                    binding.progressBar.visibility = View.GONE

                    val result = dataState.data

                    binding.photoListRecyclerView.layoutManager = GridLayoutManager(activity,3)
                    val adapter: PhotoListAdapter? =
                        result?.photos?.let{
                            PhotoListAdapter(it.photo)
                        }
                    adapter?.let {
                        binding.photoListRecyclerView.adapter = adapter
                    }

                }
                is DataState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(context, getString(R.string.default_error_message),Toast.LENGTH_LONG).show()
                }
                else -> {
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }

}