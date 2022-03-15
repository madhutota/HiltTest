package com.inditrade.graphql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.inditrade.graphql.data.api.Status
import com.inditrade.graphql.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindUI()
    }

    private fun bindUI() {
        mainViewModel.getMoviesData()
        mainViewModel.getMoviesDataNew()
        mainViewModel.moviesLiveDataNew.observe(this, Observer {
            var model = it

        })
        /*mainViewModel.moviesLiveData.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {

                }
                Status.LOADING -> {

                }
                Status.ERROR -> {

                }
            }
        })*/
    }
}