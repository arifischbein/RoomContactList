package com.example.roomcontactlist.listFeature.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomcontactlist.databinding.FragmentContactListBinding
import com.example.roomcontactlist.listFeature.adapters.ContactAdapter
import com.example.roomcontactlist.listFeature.ui.viewmodels.ContactListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactListFragment : Fragment() {

    private lateinit var binding: FragmentContactListBinding
    private val viewModel: ContactListViewModel by viewModels()

    private val contactAdapter = ContactAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupObservers()
    }

    private fun setupRecycler() {
        with(binding) {
            recyclerContact.adapter = contactAdapter
            recyclerContact.layoutManager = LinearLayoutManager(requireContext())
            recyclerContact.setHasFixedSize(true)
        }
    }

    private fun setupObservers() {
        viewModel.contactListLD.observe(viewLifecycleOwner) {
            contactAdapter.setData(it)
        }
    }


}
