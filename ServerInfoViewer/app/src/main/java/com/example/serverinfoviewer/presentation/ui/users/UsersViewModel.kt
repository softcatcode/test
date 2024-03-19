package com.example.serverinfoviewer.presentation.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.serverinfoviewer.domain.entities.User
import com.example.serverinfoviewer.domain.useCases.GetUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
): ViewModel() {

    private val _userList = MutableLiveData(listOf<User>())
    val userList: LiveData<List<User>>
        get() = _userList

    init {
        update()
    }

    fun update() {
        val job = viewModelScope.async(Dispatchers.IO) {
            val list = getUsersUseCase()
            _userList.postValue(list)
        }
    }
}