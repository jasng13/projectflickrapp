package com.del.flickrapp.model


import com.google.gson.annotations.SerializedName

data class PhotoApiResponse(
    @SerializedName("photos")
    val photos: Photos,
    @SerializedName("stat")
    val stat: String
)