package com.example.fetchrewardscodingexercise_urvishpatel.data

import com.google.gson.annotations.SerializedName

data class DataResponseItem(
    @SerializedName("id") val id: Int,
    @SerializedName("listId") val listId: Int,
    @SerializedName("name") val name: String
)