package com.del.flickrapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.del.flickrapp.presentation.viewmodels.PhotoListViewModel
import com.del.flickrapp.repository.FlickrRepository
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.del.flickrapp.model.PhotoApiResponse
import com.del.flickrapp.utils.DataState
import io.reactivex.Maybe
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var userService: FlickrRepository
    lateinit var mainViewModel: PhotoListViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.mainViewModel = PhotoListViewModel(this.userService)
    }

    @Test
    fun searchPhoto() {

//        Mockito.`when`(this.userService.fetchPhotos())
////        this.mainViewModel.searchImage(ArgumentMatchers.anyString())
//
//        assertNotNull(this.mainViewModel.resultState.value)
//        assertEquals(DataState.Success(this), this.mainViewModel.resultState.value)
    }
}