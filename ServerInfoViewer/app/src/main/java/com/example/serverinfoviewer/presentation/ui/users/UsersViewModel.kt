package com.example.serverinfoviewer.presentation.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.serverinfoviewer.domain.entities.User
import com.example.serverinfoviewer.domain.useCases.GetUsersUseCase
import javax.inject.Inject

class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
): ViewModel() {

    private val _userList = MutableLiveData(getUsersUseCase())
    val userList: LiveData<List<User>>
        get() = _userList

    fun update() {
        _userList.value = getUsersUseCase()
    }
}