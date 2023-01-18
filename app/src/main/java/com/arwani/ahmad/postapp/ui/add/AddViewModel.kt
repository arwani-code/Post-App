package com.arwani.ahmad.postapp.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arwani.ahmad.postapp.data.PostsRepository
import com.arwani.ahmad.postapp.data.local.entity.PostsEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(private val postsRepository: PostsRepository) : ViewModel() {
    fun addPosts(posts: PostsEntity) {
        viewModelScope.launch {
            postsRepository.insertPosts(posts)
        }
    }
}