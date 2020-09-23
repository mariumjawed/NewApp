package com.appsnado.decodingk12.manager

import com.appsnado.decodingk12.model.wrapper.WebResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface WebServiceProxy {


    @POST("api/v1/{path}")
    fun webServiceRequestAPIForJustObject(
        @Path(value = "path", encoded = true) postfix: String,
        @Body requestData: RequestBody
    ): Call<Any>


    @DELETE("api/v1/{path}")
    fun deleteAPIWebResponseAnyObject(
        @Path(value = "path", encoded = true) postfix: String
    ): Call<WebResponse<Any>>

    @POST("api/v1/{path}")
    fun postAPIWebResponseAnyObject(
        @Path(value = "path", encoded = true) postfix: String,
        @Body requestData: RequestBody
    ): Call<WebResponse<Any>>


    @Multipart
    @POST("api/v1/{path}")
    fun postMultipartAPI(
        @Path(value = "path", encoded = true) postfix: String,
        @Part body: ArrayList<MultipartBody.Part>
    ): Call<WebResponse<Any>>


    @Multipart
    @POST("api/v1/{path}")
    fun postMultipartWithSameKeyAPI(
        @Path(value = "path", encoded = true) postfix: String,
        @Part body: ArrayList<MultipartBody.Part>,
        @Part attachment: Array<MultipartBody.Part>
    ): Call<WebResponse<Any>>


    /**
     * @param postfix
     * @param queryMap
     * @return
     *//*

    @GET("api/v1/{path}")
    fun getAPIForWebresponseAnyObject(
        @Path(value = "path", encoded = true) postfix: String,
        @QueryMap queryMap: Map<String, Any>
    ): Call<WebResponse<Any>>
*/

}