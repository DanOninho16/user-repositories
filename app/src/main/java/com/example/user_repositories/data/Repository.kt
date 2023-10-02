package com.example.user_repositories.data

import com.google.gson.annotations.SerializedName

data class Repository(
   @SerializedName("name") val name: String,
   @SerializedName("description") val description: String?,
   @SerializedName("html_url") val url: String
)