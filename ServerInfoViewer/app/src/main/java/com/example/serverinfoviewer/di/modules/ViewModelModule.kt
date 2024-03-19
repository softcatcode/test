package com.example.serverinfoviewer.di.modules

import androidx.lifecycle.ViewModel
import com.example.serverinfoviewer.di.ViewModelKey
import com.example.serverinfoviewer.presentation.ui.users.UsersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(UsersViewModel::class)
    @Binds
    fun bindUsersViewModel(impl: UsersViewModel): ViewModel
}