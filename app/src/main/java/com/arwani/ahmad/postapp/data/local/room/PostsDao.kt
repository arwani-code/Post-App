package com.arwani.ahmad.postapp.data.local.room

import androidx.room.*
import com.arwani.ahmad.postapp.data.local.entity.PostsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PostsDao {

    @Query("SELECT * FROM posts ORDER BY id DESC")
    fun getPosts(): Flow<List<PostsEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPosts(postEntity: List<PostsEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(posts: PostsEntity)

    @Update
    suspend fun updatePosts(posts: PostsEntity)

    @Delete
    suspend fun deletePosts(posts: PostsEntity)

    @Query("SELECT * FROM POSTS WHERE name LIKE :name")
    fun searchPosts(name: String): Flow<List<PostsEntity>>
}