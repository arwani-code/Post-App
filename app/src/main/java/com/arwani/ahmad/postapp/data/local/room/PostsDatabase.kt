package com.arwani.ahmad.postapp.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arwani.ahmad.postapp.data.local.entity.PostsEntity

@Database(entities = [PostsEntity::class], version = 1, exportSchema = false)
abstract class PostsDatabase : RoomDatabase() {
    abstract fun postsDao(): PostsDao
}