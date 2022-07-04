package com.example.imageapp.data

import com.example.imageapp.data.containers.ImageMain
import retrofit2.http.GET

/**
 * Interface to write api calls for retrofit
 * @author Sahil Salunke
 * @since 4/7/2022
 */
interface ApiService {

    @GET("content")
    suspend fun getImages(): ImageMain

}