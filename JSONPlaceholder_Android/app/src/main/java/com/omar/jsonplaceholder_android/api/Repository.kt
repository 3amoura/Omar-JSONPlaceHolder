package com.omar.jsonplaceholder_android.api

class Repository(private val apiService: APIService) {
    suspend fun getPosts() = apiService.getPosts().body()
}