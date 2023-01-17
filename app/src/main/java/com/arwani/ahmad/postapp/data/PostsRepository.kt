package com.arwani.ahmad.postapp.data

import com.arwani.ahmad.postapp.data.local.entity.PostsEntity
import com.arwani.ahmad.postapp.data.local.room.PostsDao
import com.arwani.ahmad.postapp.data.network.retrofit.ApiService
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class PostsRepository @Inject constructor(
    private val apiService: ApiService,
    private val postsDao: PostsDao
) {
    fun getPostsData(): Flow<List<PostsEntity>> = postsDao.getPosts()

    fun getPostsResponse(): Flow<List<PostsEntity>> = flow {
        val posts = apiService.getPostComments()
        val newPosts = posts.map {
            PostsEntity(
                name = it.name,
                body = it.body,
                email = it.email
            )
        }
        postsDao.insertPosts(newPosts)
    }
}