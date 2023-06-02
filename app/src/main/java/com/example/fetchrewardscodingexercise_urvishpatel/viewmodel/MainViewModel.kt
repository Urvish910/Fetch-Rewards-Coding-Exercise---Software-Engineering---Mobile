package com.example.fetchrewardscodingexercise_urvishpatel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchrewardscodingexercise_urvishpatel.data.DataResponseItem
import com.example.fetchrewardscodingexercise_urvishpatel.repo.Repository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val repo: Repository) : ViewModel() {

    var data = MutableLiveData<List<DataResponseItem>>()
    var message = MutableLiveData<String>()

    fun getDataVM() {

        val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            message.postValue(throwable.message)
            return@CoroutineExceptionHandler
        }
        viewModelScope.launch { Dispatchers.IO + coroutineExceptionHandler
            val response = repo.getData()
            if (!response.isSuccessful){
                message.postValue("Sorry, Something Went Wrong.")
                return@launch
            }
            else if(response.body().isNullOrEmpty()){
                message.postValue("Data is Empty")
                return@launch
            }
            response.body()?.sortedBy { it.id }
            message.postValue("Success")
            val a  = removeEmptyData(response.body()!!)
            data.postValue(a)
            return@launch
        }
    }

    // remove any null or empty values
    private fun removeEmptyData(body: List<DataResponseItem>): List<DataResponseItem> {
        var list  = body
        list = list.filter { !it.name.isNullOrBlank() }
        list = sortListbyIdandName(list)
        return list

    }

    //sort with will sort the listId then name
    private fun sortListbyIdandName(list: List<DataResponseItem>): List<DataResponseItem> {
        return list.sortedWith(compareBy<DataResponseItem> {item ->
            item.listId
        }.thenBy { item ->
            extractInt(item.name)
        })
    }

    private fun extractInt(name: String): Int {
        val num = name.replace("Item ", "")
        return num.toInt()
    }
}