package com.arwani.ahmad.postapp.ui.detail

import androidx.lifecycle.ViewModel
import com.arwani.ahmad.postapp.data.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val postsRepository: PostsRepository): ViewModel() {

}