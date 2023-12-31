package com.example.roomcontactlist.listFeature.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.roomcontactlist.databinding.FragmentContactListBinding
import com.example.roomcontactlist.listFeature.ui.viewmodels.ContactListViewModel

class ContactListFragment : Fragment() {

    private lateinit var binding: FragmentContactListBinding
    private val viewModel: ContactListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactListBinding.inflate(layoutInflater)
        return binding.root
    }

}
