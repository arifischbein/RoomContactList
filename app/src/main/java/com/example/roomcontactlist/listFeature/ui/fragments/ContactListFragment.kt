package com.example.roomcontactlist.listFeature.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomcontactlist.databinding.FragmentContactListBinding
import com.example.roomcontactlist.listFeature.adapters.ContactAdapter
import com.example.roomcontactlist.listFeature.framework.database.ContactEntity
import com.example.roomcontactlist.listFeature.ui.NewContactDialog
import com.example.roomcontactlist.listFeature.ui.viewmodels.ContactListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ContactListFragment : Fragment() {

    private lateinit var binding: FragmentContactListBinding
    private val viewModel: ContactListViewModel by viewModels()

    @Inject
    lateinit var newContactDialog: NewContactDialog

    @Inject
    lateinit var contactAdapter: ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupObservers()

        binding.fabAddContact.setOnClickListener {
            newContactDialog.setCallback(object : NewContactDialog.NewContactDialogCallback {
                override fun onPositiveClick(data: ContactEntity) {
                    viewModel.addNewContact(data)
                }
            })
            newContactDialog.show(requireActivity().supportFragmentManager, "NewContactDialog")
        }
    }

    private fun setupRecycler() {
        with(binding) {
            recyclerContact.adapter = contactAdapter
            recyclerContact.layoutManager = LinearLayoutManager(requireContext())
            recyclerContact.setHasFixedSize(true)
        }
        contactAdapter.deleteClickListener = { viewModel.deleteContact(it) }
    }

    private fun setupObservers() {
        viewModel.contactListLD.observe(viewLifecycleOwner) {
            contactAdapter.setData(it)
        }
    }


}
