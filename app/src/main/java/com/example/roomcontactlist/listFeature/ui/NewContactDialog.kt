package com.example.roomcontactlist.listFeature.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.DialogFragment
import com.example.roomcontactlist.databinding.DialogNewContactBinding
import com.example.roomcontactlist.listFeature.framework.database.ContactEntity

class NewContactDialog : DialogFragment() {

    interface NewContactDialogCallback {
        fun onPositiveClick(data: ContactEntity)
    }

    fun setCallback(callback: NewContactDialogCallback) {
        this.callback = callback
    }

    private lateinit var binding: DialogNewContactBinding
    private var callback: NewContactDialogCallback? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogNewContactBinding.inflate(inflater, container, false)
        val view = binding.root
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextListeners()
        binding.btnAddContact.setOnClickListener {
            onAddContactButtonClick()
        }
    }

    private fun editTextListeners() {
        with(binding) {
            edtFirstName.editText?.doAfterTextChanged {
                edtFirstName.error = null
            }
            edtLastname.editText?.doAfterTextChanged {
                edtLastname.error = null
            }
            edtPhone.editText?.doAfterTextChanged {
                edtPhone.error = null
            }
        }
    }

    private fun onAddContactButtonClick() {
        val name = binding.edtFirstName.editText?.text.toString()
        val lastName = binding.edtLastname.editText?.text.toString()
        val phone = binding.edtPhone.editText?.text.toString()

        if (areInputsEmpty()) {
            showInputErrors()
        } else {
            val contact = ContactEntity(
                firstName = name,
                lastName = lastName,
                phoneNumber = phone
            )
            callback?.onPositiveClick(contact)
            dismiss()
        }
    }

    private fun areInputsEmpty(): Boolean {
        return (
                binding.edtFirstName.editText?.text.toString().isEmpty() ||
                        binding.edtLastname.editText?.text.toString().isEmpty() ||
                        binding.edtPhone.editText?.text.toString().isEmpty()
                )
    }

    private fun showInputErrors() {
        binding.edtFirstName.error = when {
            binding.edtFirstName.editText?.text.toString()
                .isEmpty() -> "Por favor, completar el campo"

            else -> null
        }

        binding.edtLastname.error = when {
            binding.edtLastname.editText?.text.toString()
                .isEmpty() -> "Por favor, completar el campo"

            else -> null
        }

        binding.edtPhone.error = when {
            binding.edtPhone.editText?.text.toString().isEmpty() -> "Por favor, completar el campo"
            else -> null
        }
    }

}
