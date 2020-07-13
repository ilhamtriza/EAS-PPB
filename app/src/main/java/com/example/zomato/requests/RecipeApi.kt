package com.example.zomato.requests

import com.example.zomato.requests.response.CategoryResponse
import com.example.zomato.requests.response.SearchResponse
import retrofit2.Call
import retrofit2.http.*

public interface RecipeApi {
    @Headers("user_key: c4abc96f2c3c1aff3183426640d4145d")
    @GET("api/v2.1/categories")
    fun searchCategories(): Call<CategoryResponse>

    @Headers("user_key: c4abc96f2c3c1aff3183426640d4145d")
    @GET("api/v2.1/search")
    fun searchApi(
        @Query("lat") queryParameters1: String,
        @Query("lon") queryParams2: String,
        @Query("sort") queryParams3: String
    ): Call<SearchResponse>
}