package com.inditrade.movietestapp.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponseModel(
    @SerializedName("data")
    var dataModel: DataModel? = null
)

data class DataModel(
    @SerializedName("cards")
    var cardsList: ArrayList<MovieModel>? = null
)

data class MovieModel(
    @SerializedName("content")
    var contentModel: ContentModel? = null

)

data class ContentModel(
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("movie_logo")
    var movieLogo: String? = null
)
