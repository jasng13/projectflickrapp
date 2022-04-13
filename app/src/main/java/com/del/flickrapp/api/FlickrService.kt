package com.del.flickrapp.api

import com.del.flickrapp.model.PhotoApiResponse
import com.del.flickrapp.utils.Constants.Companion.API_KEY
import com.del.flickrapp.utils.Constants.Companion.BASE_URL
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface FlickrService{

    //approach 1 - use observable
    @GET("?method=flickr.photos.search&format=json&nojsoncallback=1&text=kittens&api_key=$API_KEY")
    fun fetchPhotos(): Observable<PhotoApiResponse>

//  approach 2 - use suspend function and Retrofit Response
    @GET("?method=flickr.photos.search&format=json&nojsoncallback=1&api_key=$API_KEY")
    suspend fun searchImage(@Query(value = "text") searchTerm: String): Response<PhotoApiResponse>

    companion object {
        fun create(): FlickrService {
            val logger = HttpLoggingInterceptor().apply { level =
                HttpLoggingInterceptor.Level.BASIC
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FlickrService::class.java)
        }
    }
}