package com.example.roomcontactlist

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomcontactlist.listFeature.framework.database.ContactDAO
import com.example.roomcontactlist.listFeature.framework.database.ContactDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val CONTACT_DATABASE_NAME = "contactDatabase"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): ContactDataBase {
        return Room.databaseBuilder(context, ContactDataBase::class.java, CONTACT_DATABASE_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(db: ContactDataBase): ContactDAO {
        return db.contactDao
    }
}
