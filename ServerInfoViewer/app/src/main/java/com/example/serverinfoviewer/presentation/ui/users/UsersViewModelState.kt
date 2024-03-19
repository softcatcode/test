package com.example.serverinfoviewer.presentation.ui.users

import com.example.serverinfoviewer.domain.entities.User

sealed class UsersViewModelState

data object Loading : UsersViewModelState()

data class UserListState(
    val list: List<User>
): UsersViewModelState()

data class Error(
    val message: String = ""
): UsersViewModelState()