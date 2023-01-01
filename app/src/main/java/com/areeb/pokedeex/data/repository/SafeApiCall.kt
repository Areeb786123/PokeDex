package com.areeb.pokedeex.data.repository

import com.areeb.pokedeex.data.Resource
import retrofit2.HttpException

interface SafeApiCall {
    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {
        return try {
            Resource.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> {
                    Resource.Error(
                        false,
                        throwable.code(),
                        throwable.response()?.errorBody()
                    )
                } else -> Resource.Error(false, null, null)
            }
        }
    }
}
