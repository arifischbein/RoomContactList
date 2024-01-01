package com.example.roomcontactlist.listFeature.adapters

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.roomcontactlist.databinding.ItemContactBinding
import com.example.roomcontactlist.listFeature.framework.database.ContactEntity

class ContactViewHolder(private val binding: ItemContactBinding) : ViewHolder(binding.cardContact) {
    fun render(
        contact: ContactEntity,
        deleteClickListener: (ContactEntity) -> Unit
    ) {
        binding.txtName.text = contact.firstName
        binding.txtLastName.text = contact.lastName
        binding.txtPhone.text = contact.phoneNumber

        binding.imgDelete.setOnClickListener {
            deleteClickListener(contact)
        }
    }
}
