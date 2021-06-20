package com.example.shoestore.viewmodel

import androidx.lifecycle.*
import com.example.shoestore.model.Item
import com.example.shoestore.model.ItemRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ShoeViewModel(private val repository: ItemRepository): ViewModel() {

    val allShoeList: LiveData<List<Item>> = repository.allShoeList.asLiveData()

    fun insert(item: Item) = viewModelScope.launch {
        repository.insert(item)
    }
}

class ShoeViewModelFactory(private val repository: ItemRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ShoeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}