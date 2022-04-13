package com.del.flickrapp.model


import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("farm")
    val farm: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("isfamily")
    val isfamily: Int,
    @SerializedName("isfriend")
    val isfriend: Int,
    @SerializedName("ispublic")
    val ispublic: Int,
    @SerializedName("owner")
    val owner: String,
    @SerializedName("secret")
    val secret: String,
    @SerializedName("server")
    val server: String,
    @SerializedName("title")
    val title: String
){
//    https://farm5.static.flickr.com/4740/39593986652_0ec416669f.jpg
    fun formatImageSource () =
        "https://farm"+farm.toString()+".static.flickr.com/"+server+"/"+id+"_"+secret+".jpg"
}
