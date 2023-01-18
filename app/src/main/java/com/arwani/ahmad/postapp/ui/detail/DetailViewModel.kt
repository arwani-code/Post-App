package com.arwani.ahmad.postapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arwani.ahmad.postapp.data.PostsRepository
import com.arwani.ahmad.postapp.data.local.entity.PostsEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val postsRepository: PostsRepository): ViewModel() {

    fun updatePosts(posts: PostsEntity){
        viewModelScope.launch {
            postsRepository.updatePosts(posts)
        }
    }

    fun deletePosts(posts: PostsEntity){
        viewModelScope.launch {
            postsRepository.deletePosts(posts)
        }
    }
}