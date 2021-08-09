package com.naat.yaapp.data.models

import com.google.gson.annotations.SerializedName

data class UserSession(
    @SerializedName("access_token")
    var accessToken: String = "",
    @SerializedName("token_type")
    var tokenType: String = "",
    @SerializedName("refresh_token")
    var refreshToken: String = "",
    @SerializedName("expires_in")
    var expiresIn: Int = 0,
    @SerializedName("scope")
    var scope: String = "",
    @SerializedName("jti")
    var jti: String = ""
)
