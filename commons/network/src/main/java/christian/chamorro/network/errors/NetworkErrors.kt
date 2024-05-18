package christian.chamorro.network.errors

import retrofit2.HttpException
import java.io.IOException

sealed class NetworkErrors(val msg: String) {
    data object NoInternetException : NetworkErrors("Connection error")

    data class ApiException(val code: String) : NetworkErrors("Api error: $code")

    data object UnknownException : NetworkErrors("Unknown exception")

    companion object {
        fun fromException(remoteException: Exception): NetworkErrors {
            return when (remoteException) {
                is IOException -> NetworkErrors.NoInternetException
                is HttpException -> NetworkErrors.ApiException(remoteException.code().toString())
                else -> UnknownException
            }
        }
    }
}
