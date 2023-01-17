package com.arwani.ahmad.postapp.data.network.retrofit

import com.arwani.ahmad.postapp.data.network.response.PostResponseItem
import com.arwani.ahmad.postapp.utils.Constant
import retrofit2.http.GET

interface ApiService {
    @GET(Constant.PARAMS_URL)
    suspend fun getPostComments(): List<PostResponseItem>
}