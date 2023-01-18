package com.arwani.ahmad.postapp.ui.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.arwani.ahmad.postapp.data.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

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
