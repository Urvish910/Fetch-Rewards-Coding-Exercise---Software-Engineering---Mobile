package com.example.fetchrewardscodingexercise_urvishpatel.model.remote

import com.example.fetchrewardscodingexercise_urvishpatel.data.DataResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constant.END_POINT)
    suspend fun getDataFromServer():Response<List<DataResponseItem>>

    companion object{
        fun getInstance() = ApiClient.myRetrofit.create(ApiService::class.java)
    }
}