package com.appsnado.newapp.model

import com.google.gson.annotations.SerializedName


class WebResponse<T> {
    @SerializedName("message")
    var message: String? = null

    @SerializedName("success")
    val isSuccess = false

    @SerializedName("data")
    var result: T? = null
/*
    @SerializedName("errors")
    var errorList: ArrayList<ErrorModel>? = null*/
}