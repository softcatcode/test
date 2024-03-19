package com.example.serverinfoviewer.di.modules

import com.example.serverinfoviewer.data.GetDataImplementation
import com.example.serverinfoviewer.domain.interfaces.GetDataInterface
import dagger.Binds

interface DomainModule {
    @Binds
    fun bindGetDataInterface(impl: GetDataImplementation): GetDataInterface
}