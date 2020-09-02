package com.appsnado.newapp.manager

import com.appsnado.newapp.constants.WebServiceConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit


object WebServiceFactory {

    private var retrofitBase: Retrofit? = null
    private var retrofiltXML: Retrofit? = null
    private var staticToken = ""

    /***
     * SINGLETON Design Pattern
     */
    fun getInstanceBaseURL(_token: String): WebServiceProxy? {
        if (retrofitBase == null || staticToken.isEmpty() || staticToken != _token) {
            staticToken = _token

//            Gson gson = new GsonBuilder()
//                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
//                    .create();
            val interceptor = HttpLoggingInterceptor()
            // set your desired log level
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            httpClient.connectTimeout(60, TimeUnit.SECONDS)
            httpClient.readTimeout(60, TimeUnit.SECONDS)


//             add your other interceptors …
            httpClient.addInterceptor(object : Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): Response? {
                    val original: Request = chain.request()
                    val requestBuilder: Request.Builder = original.newBuilder()
                    requestBuilder.addHeader("Authorization", "Bearer $staticToken")
                    requestBuilder.addHeader("Accept", "application/json")

                    // Request customization: add request headers
                    val request: Request = requestBuilder.build()
                    return chain.proceed(request)
                }
            })

            // add logging as last interceptor
//            httpClient.addNetworkInterceptor(interceptor).addInterceptor(interceptor);  // <-- this is the important line!
            httpClient.addInterceptor(interceptor) // <-- this is the important line!
            retrofitBase =
                Retrofit.Builder() //                    .baseUrl(WebServiceConstants.BASE_URL_LIVE)
                    .baseUrl(WebServiceConstants.BASE_URL)
                   // .addConverterFactory(GsonConverterFactory.create(GsonFactory.getSimpleGson()))
                    .client(httpClient.build())
                    .build()
        }
        return retrofitBase!!.create(WebServiceProxy::class.java)
    }


    fun getInstanceXML(): WebServiceProxy? {
        if (retrofiltXML == null) {
            val interceptor = HttpLoggingInterceptor()
            // set your desired log level
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            httpClient.connectTimeout(120, TimeUnit.SECONDS)
            httpClient.readTimeout(121, TimeUnit.SECONDS)


//             add your other interceptors …
            httpClient.addInterceptor(object : Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): Response? {
                    val original: Request = chain.request()
                    val requestBuilder: Request.Builder = original.newBuilder()
                    //                    requestBuilder.addHeader("_token", _token + "");

                    // Request customization: add request headers
                    val request: Request = requestBuilder.build()
                    return chain.proceed(request)
                }
            })

            // add logging as last interceptor
//            httpClient.addNetworkInterceptor(interceptor).addInterceptor(interceptor);  // <-- this is the important line!
            httpClient.addInterceptor(interceptor) // <-- this is the important line!
            retrofiltXML = Retrofit.Builder()
                .baseUrl(WebServiceConstants.BASE_URL)
                .addConverterFactory(
                    SimpleXmlConverterFactory.createNonStrict(
                        Persister(
                            AnnotationStrategy() // important part!
                        )
                    )
                )
                .client(httpClient.build())
                .build()
        }
        return retrofiltXML!!.create(WebServiceProxy::class.java)
    }

}