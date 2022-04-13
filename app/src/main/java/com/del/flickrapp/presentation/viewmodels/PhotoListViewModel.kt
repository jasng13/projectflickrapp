package com.del.flickrapp.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.del.flickrapp.domain.FetchPhotosUseCase
import com.del.flickrapp.model.PhotoApiResponse
import com.del.flickrapp.repository.FlickrRepository
import com.del.flickrapp.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class PhotoListViewModel @Inject constructor(private val repository: FlickrRepository) :
    ViewModel() {

    private val _resultState: MutableLiveData<DataState<PhotoApiResponse?>> = MutableLiveData()

    val resultState: MutableLiveData<DataState<PhotoApiResponse?>>
        get() = _resultState

    init {
        getPhotoList()
    }

    //todo handle exceptions & usecase instead of direct access to repository
     fun getPhotoList() {
        viewModelScope.launch {
            repository.fetchPhotos().subscribe {
                resultState.postValue(DataState.Success(it))
            }
        //            repository.fetchPhotos().subscribe{
//                when(val result = fetchPhotosUseCase.invoke()) {
//                    is DataState.Loading -> {
//                        resultState.postValue(DataState.Loading)
//                    }
//                    is DataState.Success -> {
//                        resultState.postValue(DataState.Success((resultState.value as DataState.Success<PhotoApiResponse?>).data))
//                    }
//                    is DataState.Error -> {
//                        resultState.postValue(DataState.Error(Exception("Something went wrong")))
//                    }
//                }
//            }
        }

     }

    fun searchImage(name:String){
        viewModelScope.launch {
            resultState.value = repository.searchImage(name)
        }
    }

}


