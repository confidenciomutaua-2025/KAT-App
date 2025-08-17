package org.aena.kat.network

import org.aena.kat.data.FormEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("api/v1/forms")
    suspend fun sendForm(@Body form: FormEntity): Response<Unit>
}
