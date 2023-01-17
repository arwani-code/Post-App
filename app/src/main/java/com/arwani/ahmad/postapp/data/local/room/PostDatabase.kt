package com.arwani.ahmad.postapp.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arwani.ahmad.postapp.data.local.entity.PostEntity

@Database(entities = [PostEntity::class], version = 1, exportSchema = false)
abstract class PostDatabase : RoomDatabase() {
    abstract fun postsDao(): PostDao
}