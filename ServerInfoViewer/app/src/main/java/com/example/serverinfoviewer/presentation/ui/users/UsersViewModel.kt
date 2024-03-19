package com.example.serverinfoviewer.presentation.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.serverinfoviewer.domain.useCases.GetUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
): ViewModel() {

    private val _userList = MutableLiveData<UsersViewModelState>(Loading)
    val userList: LiveData<UsersViewModelState>
        get() = _userList

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = getUsersUseCase()
            _userList.postValue(UserListState(list))
        }
    }
}