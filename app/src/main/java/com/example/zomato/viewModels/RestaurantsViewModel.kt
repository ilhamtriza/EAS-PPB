package com.example.zomato.viewModels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.zomato.models.Restaurants
import com.example.zomato.repository.SearchRepository

class RestaurantsViewModel : ViewModel() {
    var mSearchRepository = SearchRepository()
    var mDidRetreiveRest: Boolean = false

    fun RestaurantsViewModel() {
        mSearchRepository = SearchRepository.getInstance()
        mDidRetreiveRest = false
    }

    fun getRest(): LiveData<List<Restaurants>>? {
        return mSearchRepository.getRest()
    }

    fun setRetrievedRest(retrievedRest: Boolean) {
        mDidRetreiveRest = retrievedRest
    }

    fun searchRestApi() {
        mSearchRepository.mSearchRestApi()
    }
}