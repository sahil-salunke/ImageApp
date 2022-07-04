package com.example.imageapp.data.containers


import com.google.gson.annotations.SerializedName

/**
 * Data class for main common container in response
 * @author Sahil Salunke
 * @since 4/7/2022
 */
data class ImageMain(
    @SerializedName("content")
    val content: List<Content>
)