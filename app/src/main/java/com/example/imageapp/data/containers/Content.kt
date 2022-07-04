package com.example.imageapp.data.containers


import com.google.gson.annotations.SerializedName

/**
 * Data class for image containers data
 * @author Sahil Salunke
 * @since 4/7/2022
 */
data class Content(
    @SerializedName("cols")
    val cols: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("show")
    val show: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)