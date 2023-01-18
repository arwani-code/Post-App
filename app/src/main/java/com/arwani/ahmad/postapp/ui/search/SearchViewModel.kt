package com.arwani.ahmad.postapp.ui.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.arwani.ahmad.postapp.data.PostsRepository
import com.arwani.ahmad.postapp.data.local.entity.PostsEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val postsRepository: PostsRepository) :
    ViewModel() {

    var query by mutableStateOf("")

    fun updateUserPosts(name: String) {
        query = name
    }

    fun getPosts(): Flow<List<PostsEntity>> = postsRepository.searchPosts("%$query%")

    fun setEmptyQuery() {
        query = ""
    }


}