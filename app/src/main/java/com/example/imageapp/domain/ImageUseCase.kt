package com.example.imageapp.domain

import com.example.imageapp.data.ApiService
import com.example.imageapp.data.containers.ImageMain
import javax.inject.Inject

/**
 * UseCase class to represent images data api
 * @author Sahil Salunke
 * @since 4/7/2022
 */
class ImageUseCase @Inject constructor(
    private val apIs: ApiService
) {
    suspend operator fun invoke(): ImageMain {
        return apIs.getImages()
    }

}