package com.inditrade.graphql.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inditrade.graphql.data.api.GraphQlService
import com.inditrade.graphql.data.api.Resource
import com.inditrade.movietestapp.data.model.MovieResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var apiService: GraphQlService) : ViewModel() {

    val _moviesLiveData = MutableLiveData<Resource<MovieResponseModel>>()
    var moviesLiveData: LiveData<Resource<MovieResponseModel>> = _moviesLiveData

    val _moviesLiveDataNew = MutableLiveData<MovieResponseModel>()
    var moviesLiveDataNew: LiveData<MovieResponseModel> = _moviesLiveDataNew

    fun getMoviesData() {
        CoroutineScope(Dispatchers.IO).launch {
            _moviesLiveData.postValue(Resource.loading(null))
            apiService.getMovies().let {
                if (it.isSuccessful) {
                    _moviesLiveData.postValue(Resource.success(it.body()))
                } else _moviesLiveData.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }

    fun getMoviesDataNew() {
        CoroutineScope(Dispatchers.IO).launch {
            apiService.getMovies().let {
                if (it.isSuccessful) {
                    _moviesLiveDataNew.postValue(it.body())
                } /*else _moviesLiveDataNew.postValue(it.errorBody())*/
            }
        }
    }
}