package com.example.roomcontactlist.listFeature.di

import com.example.roomcontactlist.listFeature.adapters.ContactAdapter
import com.example.roomcontactlist.listFeature.ui.NewContactDialog
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ContactModule {

    @Provides
    @Singleton
    fun provideNewContactDialog(): NewContactDialog {
        return NewContactDialog()
    }

    @Provides
    @Singleton
    fun provideContactAdapter(): ContactAdapter {
        return ContactAdapter()
    }
}
