package com.example.serverinfoviewer.domain.useCases

import com.example.serverinfoviewer.domain.entities.User
import com.example.serverinfoviewer.domain.interfaces.GetDataInterface
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: GetDataInterface
) {
    operator fun invoke(): List<User> {
        return repository.getUserList()
    }
}