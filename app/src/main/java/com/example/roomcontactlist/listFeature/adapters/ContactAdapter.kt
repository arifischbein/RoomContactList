package com.example.roomcontactlist.listFeature.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomcontactlist.databinding.ItemContactBinding
import com.example.roomcontactlist.listFeature.framework.database.ContactEntity
import kotlin.properties.Delegates

class ContactAdapter : RecyclerView.Adapter<ContactViewHolder>() {
    private var contacts: MutableList<ContactEntity> by Delegates.observable(mutableListOf()) { _, _, _ -> notifyDataSetChanged() }

    fun setData(contacts: List<ContactEntity>) {
        this.contacts = contacts.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.render(contacts[position])
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}
