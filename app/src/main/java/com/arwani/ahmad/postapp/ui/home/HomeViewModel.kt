package com.arwani.ahmad.postapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.arwani.ahmad.postapp.data.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val postsRepository: PostsRepository) :
    ViewModel() {

    val getPosts = postsRepository.getPostsData().asLiveData()


    fun fetchPosts() {
        viewModelScope.launch {
            postsRepository.getPostsResponse()
                .flowOn(Dispatchers.IO)
                .catch {}
                .collect {}
        }
    }
}
