package com.titan.test.external

import com.google.gson.JsonObject
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface Endpoints {

    @FormUrlEncoded
    @Headers("Authorization: Basic Wm1Ga0xXTXlZeTF3YjNKMFlXdz06TWpoa04yUTNNbUppWVRWbVpHTTBObVl4Wmpka1lXSmpZbVEyTmpBMVpEVXpaVFZoT1dNMVpHVTROakF4TldVeE9EWmtaV0ZpTnpNd1lUUm1ZelV5WWc9PQ==")
    @POST("authorization-server/oauth/token")
    fun oAuthToken(@Field("grant_type") grantType: String, @Field("username") userName: String, @Field("password") password: String): Call<JsonObject>

}