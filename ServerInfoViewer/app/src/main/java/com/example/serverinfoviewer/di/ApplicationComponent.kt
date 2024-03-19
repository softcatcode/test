package com.example.serverinfoviewer.di

import android.app.Application
import com.example.serverinfoviewer.di.modules.DomainModule
import com.example.serverinfoviewer.di.modules.ViewModelModule
import com.example.serverinfoviewer.presentation.ui.users.UsersFragment
import com.example.serverinfoviewer.presentation.ui.video.VideoFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ViewModelModule::class, DomainModule::class])
interface ApplicationComponent {

    fun inject(fragment: UsersFragment)

    fun inject(fragment: VideoFragment)

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}