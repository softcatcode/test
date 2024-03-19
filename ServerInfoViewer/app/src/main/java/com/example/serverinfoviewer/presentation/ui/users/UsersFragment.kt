package com.example.serverinfoviewer.presentation.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.serverinfoviewer.MainActivity
import com.example.serverinfoviewer.ServerInfoApplication
import com.example.serverinfoviewer.databinding.FragmentUsersBinding
import com.example.serverinfoviewer.di.ApplicationComponent
import com.example.serverinfoviewer.presentation.ViewModelFactory
import com.example.serverinfoviewer.presentation.adapters.UserListAdapter
import javax.inject.Inject

class UsersFragment : Fragment() {

    private var _binding: FragmentUsersBinding? = null
    val binding: FragmentUsersBinding
            get() = _binding ?: throw RuntimeException("Users fragment binding is null")

    private lateinit var userListAdapter: UserListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as ServerInfoApplication).component
    }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[UsersViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        component.inject(this)
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun onUserClicked() {

    }

    private fun setupObservers() {
        viewModel.userList.observe(viewLifecycleOwner) {
            userListAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView() = with(binding) {
        recyclerView.recycledViewPool.setMaxRecycledViews(UserListAdapter.VIEW_TYPE, 10)
        userListAdapter = UserListAdapter().apply {
            onClickListener = ::onUserClicked
        }
        binding.recyclerView.adapter = userListAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}