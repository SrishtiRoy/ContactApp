package com.sri.contactdemo.ui.contactDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI

import com.sri.contactdemo.MainActivity
import com.sri.contactdemo.OPTIONS
import com.sri.contactdemo.R
import com.sri.contactdemo.databinding.FragmentContactDetailsBinding
import com.sri.contactdemo.di.ViewModelProviderFactory
import dagger.android.support.DaggerFragment

import javax.inject.Inject

class ContactDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    private lateinit var viewModel: ContactDetailsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentContactDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contact_details, container, false)

        binding.setLifecycleOwner(this.viewLifecycleOwner)

        viewModel = ViewModelProviders.of(this, factory).get(ContactDetailsViewModel::class.java)

        val args = ContactDetailsFragmentArgs.fromBundle(arguments!!)
        val contact = viewModel.getContactByInt(args.id)

        contact.observe(this, Observer {
            binding.data.contact = it
        })

        binding.editContactFab.setOnClickListener {
            it.findNavController().navigate(
                ContactDetailsFragmentDirections
                    .actionContactDetailsFragmentToAddContactFragment(args.id)
            )
        }

        binding.deleteButton.setOnClickListener {
            viewModel.deleteContact(binding.data.contact)
            it.findNavController().navigate(
                ContactDetailsFragmentDirections
                    .actionContactDetailsFragmentToContactsListFragment()
            )
        }

        requireActivity().onBackPressedDispatcher.addCallback(this)
        {
            // handling back button
            findNavController().navigate(ContactDetailsFragmentDirections.actionContactDetailsFragmentToContactsListFragment(), OPTIONS)
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).supportActionBar?.title = "Contact Details"
    }

}