package com.example.newsapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    data class NewsState(
        val loading:Boolean = true,
        val list:List<News> = emptyList(),
        val error:String? = null
    )

    private val _newsState = mutableStateOf(NewsState())
    val newsState: State<NewsState> = _newsState

    init {
        fetchNews()
    }

    private fun fetchNews(){
        viewModelScope.launch {
            try {
                val response = newsService.getNewsLatest()
                _newsState.value = _newsState.value.copy(
                    loading = false,
                    list = response.data,
                    error = null
                )
            }catch (e:Exception){
                _newsState.value = _newsState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }
}