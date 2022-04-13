package com.del.flickrapp.repository

import com.del.flickrapp.api.FlickrService
import com.del.flickrapp.model.PhotoApiResponse
import com.del.flickrapp.utils.DataState
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@Module
@InstallIn(ActivityRetainedComponent::class)
class FlickrRepository @Inject constructor(private val apiService: FlickrService)  {

    /*
    * 1st approach - subscribe to observable
    * */
    fun fetchPhotos(
    ): Observable<PhotoApiResponse> {
        return apiService.fetchPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    /*
    * 2nd approach - use dispatchers
    * */
    suspend fun searchImage(name: String)= withContext(Dispatchers.IO) {
        DataState.Loading
        try {
            val result =  apiService.searchImage(name)
            if (result.isSuccessful) {
                DataState.Success(result.body())
            } else {
                DataState.Error(Exception(result.message()))
            }
        }catch (e: java.lang.Exception){
            DataState.Error(java.lang.Exception(e.message))
        }
    }
}