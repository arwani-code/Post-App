package com.arwani.ahmad.postapp.di

import android.content.Context
import androidx.room.Room
import com.arwani.ahmad.postapp.data.local.room.PostDao
import com.arwani.ahmad.postapp.data.local.room.PostDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): PostDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("postscomments".toCharArray())
        val factory = SupportFactory(passphrase)

        return Room.databaseBuilder(
            context,
            PostDatabase::class.java,
            "Posts.Db"
        ).fallbackToDestructiveMigration().openHelperFactory(factory).build()
    }

    @Provides
    fun provideDao(database: PostDatabase): PostDao = database.postsDao()
}