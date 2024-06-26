package christian.chamorro.network.errors

import retrofit2.HttpException
import java.io.IOException

/**
 * Specify possible network errors.
 */
sealed class NetworkErrors(val msg: String) {
    data object NoInternetException : NetworkErrors("Connection error")

    data class ApiException(val code: String) : NetworkErrors("Api error: $code")

    data object UnknownException : NetworkErrors("Unknown exception")

    companion object {
        /**
         * Returns NetworkErrors depending on an remote exception.
         */
        fun fromException(remoteException: Exception): NetworkErrors {
            return when (remoteException) {
                is IOException -> NoInternetException
                is HttpException -> ApiException(remoteException.code().toString())
                else -> UnknownException
            }
        }
    }
}
