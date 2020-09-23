package com.appsnado.decodingk12.constants

object WebServiceConstants {

    private var headers: MutableMap<String, String>? = null

    fun getHeaders(token: String): Map<String, String>? {
        if (headers == null) {
            headers = HashMap()
            (headers as HashMap<String, String>)["_token"] = token
        }
        return headers
    }

    val BASE_URL = ""

}