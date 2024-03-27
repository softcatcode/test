package com.example.serverinfoviewer.presentation.ui.users

import android.app.Application
import androidx.core.content.ContextCompat.getString
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.serverinfoviewer.R
import com.example.serverinfoviewer.domain.useCases.GetUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.util.Timer
import java.util.TimerTask
import javax.inject.Inject

class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    application: Application
): AndroidViewModel(application) {

    private val _userList = MutableLiveData<UsersViewModelState>()
    val userList: LiveData<UsersViewModelState>
        get() = _userList

    private var timer = Timer()

    init {
        load()
    }

    private fun processInternetError() {
        timer.schedule(
            object: TimerTask() {
                override fun run() {
                    load()
                }
            },
            RETRY_TIME_GAP
        )
    }

    private fun load() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) { _userList.value = Loading }
            try {
                val list = getUsersUseCase()
                _userList.postValue(UserListState(list))
            } catch (e: IOException) {
                processInternetError()
                val msg = getString(getApplication(), R.string.internet_error_message)
                _userList.postValue(Error(msg))
            } catch (e: Exception) {
                val msg = getString(getApplication(), R.string.other_error_message)
                _userList.postValue(Error(msg))
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }

    companion object {
        private const val RETRY_TIME_GAP = 5000L
    }
}