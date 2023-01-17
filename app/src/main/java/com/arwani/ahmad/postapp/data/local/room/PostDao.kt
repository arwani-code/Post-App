package com.arwani.ahmad.postapp.data.local.room

import androidx.room.Dao
import androidx.room.Query
import com.arwani.ahmad.postapp.data.local.entity.PostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Query("SELECT * FROM posts")
    fun getPosts(): Flow<List<PostEntity>>

}