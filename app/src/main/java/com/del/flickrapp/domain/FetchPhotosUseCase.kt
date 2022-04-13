package com.del.flickrapp.domain

import com.del.flickrapp.model.Photo
import com.del.flickrapp.model.PhotoApiResponse
import com.del.flickrapp.repository.FlickrRepository
import com.del.flickrapp.utils.DataState
import io.reactivex.Observable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FetchPhotosUseCase(private val photoRepository: FlickrRepository) {

//    suspend operator fun invoke(): DataState<PhotoApiResponse?> = withContext(Dispatchers.IO) {
//        return@withContext photoRepository.fetchPhotos()
//    }
}