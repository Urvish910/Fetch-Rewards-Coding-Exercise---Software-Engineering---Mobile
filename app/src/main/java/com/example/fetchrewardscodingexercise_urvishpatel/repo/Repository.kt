package com.example.fetchrewardscodingexercise_urvishpatel.repo

import com.example.fetchrewardscodingexercise_urvishpatel.data.DataResponseItem
import com.example.fetchrewardscodingexercise_urvishpatel.model.remote.ApiService
import retrofit2.Response

class Repository {
    val apiInstance = ApiService.getInstance()

    suspend fun getData() =apiInstance.getDataFromServer()


}
