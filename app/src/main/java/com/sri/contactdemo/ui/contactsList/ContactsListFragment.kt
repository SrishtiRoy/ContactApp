package com.sri.contactdemo.ui.contactsList

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.MenuItemCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.sri.contactdemo.MainActivity
import com.sri.contactdemo.OPTIONS
import com.sri.contactdemo.R
import com.sri.contactdemo.di.ViewModelProviderFactory

import dagger.android.support.AndroidSupportInjection

import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ContactsListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var viewModel: ContactsListViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = com.sri.contactdemo.databinding.FragmentContactsListBinding.inflate(inflater, container, false)

        viewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(ContactsListViewModel::class.java)

        val adapter = ContactsAdapter(context!!, ContactsClickListener {
            val id = it.id
            this.findNavController().navigate(
                ContactsListFragmentDirections
                .actionContactsListFragmentToContactDetailsFragment(id))
        })

        binding.contactList.adapter = adapter

        subscribeUI(adapter)

        binding.fab.setOnClickListener {
            it.findNavController().navigate(R.id.action_contactsListFragment_to_addContactFragment, null, OPTIONS)
        }

        return binding.root

    }



    private fun subscribeUI(adapter: ContactsAdapter) {
        viewModel.getAllContacts.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).supportActionBar?.title = "Contacts Pro"
    }
}
