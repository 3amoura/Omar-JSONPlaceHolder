package com.omar.jsonplaceholder_android.fragments.posts

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omar.jsonplaceholder_android.api.Repository
import com.omar.jsonplaceholder_android.models.PostModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val postsLiveData = MutableLiveData<List<PostModel>?>()
    val error = MutableLiveData<String>()

    fun loadPosts() {
        viewModelScope.launch {
            try {
                postsLiveData.value = repository.getPosts()
            } catch (e: Exception) {
                error.value = "No Internet"
            }
        }
    }
}