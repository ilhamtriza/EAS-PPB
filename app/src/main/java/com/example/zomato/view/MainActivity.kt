package com.example.zomato.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.zomato.R
import com.example.zomato.models.Restaurants
import com.example.zomato.view.adapter.RestaurantAdapter
import com.example.zomato.viewModels.RecipeViewModel
import com.example.zomato.viewModels.RestaurantsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "RecipeActivity"
    private var mRecipeViewModel: RecipeViewModel? = null
    private var mRestaurantsViewModel: RestaurantsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        window.statusBarColor = resources.getColor(R.color.white)

        mRestaurantsViewModel = ViewModelProviders.of(this).get(RestaurantsViewModel::class.java)

        subscribeObservers()
        mRestaurantsViewModel!!.searchRestApi()
    }

    private fun subscribeObservers() {

        Log.i("check", "working1")

        mRestaurantsViewModel!!.getRest()
        mRestaurantsViewModel!!.getRest()!!
            .observe(this, Observer<List<Restaurants>> { t: List<Restaurants>? ->
                if (t != null) {
                    Log.i("Check", t.get(0).restaurant!!.name)

                    val adapter = RestaurantAdapter(t, this)
                    recyclerView.adapter = adapter

                    if (t.equals(mRestaurantsViewModel!!.getRest())) {
                        mRestaurantsViewModel!!.setRetrievedRest(true)
                    }
                } else {
                    Log.i("Status", "Failed")
                }
            })
    }
}
