package com.omar.jsonplaceholder_android.api

import com.omar.jsonplaceholder_android.models.PostModel
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("posts")
    suspend fun getPosts(): Response<List<PostModel>>
}