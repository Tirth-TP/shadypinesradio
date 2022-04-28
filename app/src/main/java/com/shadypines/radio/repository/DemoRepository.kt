package com.shadypines.radio.repository

import android.content.Context
import com.shadypines.radio.data.remote.model.response.PostResponse
import com.shadypines.radio.network.ApiRestService
import com.shadypines.radio.network.SafeApiRequest
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class DemoRepository @Inject constructor(
    @ApplicationContext context: Context,
    private val api: ApiRestService
) : SafeApiRequest(context) {

    suspend fun getWeather(): PostResponse {
        return apiRequest { api.getWeather() }
    }
}