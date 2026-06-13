package com.androidengineer.tiffunapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchRepository: SearchRepository
) : ViewModel() {

    private val mutableStateFlow = MutableStateFlow<Place>(Place())
    val stateFlow: StateFlow<Place> = mutableStateFlow.asStateFlow()

    fun searchResults(query: String) {
        viewModelScope.launch {
            searchRepository.searchResults(query).collect { result ->
                mutableStateFlow.value = result
            }
        }
    }
}