package christian.chamorro.network.errors

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import christian.chamorro.network.R
import retrofit2.HttpException
import java.io.IOException

sealed class NetworkErrors(val msg: String) {
    data object NoInternetException : NetworkErrors("Connection error")

    data class ApiException(val code: String) : NetworkErrors("Api error: $code")

    data object UnknownException : NetworkErrors("Unknown exception")

    companion object {
        fun fromException(remoteException: Exception): NetworkErrors {
            return when (remoteException) {
                is IOException -> NoInternetException
                is HttpException -> ApiException(remoteException.code().toString())
                else -> UnknownException
            }
        }
    }
}
