package com.example.imageapp.data.containers


import com.google.gson.annotations.SerializedName

/**
 * Data class for images data
 * @author Sahil Salunke
 * @since 4/7/2022
 */
data class Image(
    @SerializedName("format")
    val format: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)