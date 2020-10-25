package com.example.myapplication

import com.google.gson.annotations.SerializedName


class UserResponse {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("createdAt")
    var createdAt: String? = null

    @SerializedName("avatar")
    var avatar: String? = null



}

