package com.example.serverinfoviewer.di

import com.example.serverinfoviewer.di.modules.ViewModelModule
import com.example.serverinfoviewer.presentation.ui.users.UsersFragment
import com.example.serverinfoviewer.presentation.ui.video.VideoFragment
import dagger.Component

@Component(modules = [ViewModelModule::class])
interface ApplicationComponent {

    fun inject(fragment: UsersFragment)

    fun inject(fragment: VideoFragment)
}