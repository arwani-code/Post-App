package com.arwani.ahmad.postapp.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arwani.ahmad.postapp.data.local.entity.PostsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PostsDao {

    @Query("SELECT * FROM posts")
    fun getPosts(): Flow<List<PostsEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPosts(postEntity: List<PostsEntity>)
}