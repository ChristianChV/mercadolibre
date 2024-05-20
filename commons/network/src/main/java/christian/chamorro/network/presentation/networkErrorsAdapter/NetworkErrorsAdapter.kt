package christian.chamorro.network.presentation.networkErrorsAdapter

import android.content.Context
import christian.chamorro.network.R
import christian.chamorro.network.errors.NetworkErrors

/**
 * Return a pair of strings depending on network error, first value is main title and second value is subtitle.
 */
fun NetworkErrors.getDescription(context: Context): Pair<String, String> {
    return when (this) {
        is NetworkErrors.ApiException ->
            context.getString(R.string.api_error) to "${
                context.getString(
                    R.string.error,
                )
            } ${this.code}"

        NetworkErrors.NoInternetException ->
            context.getString(R.string.network_error) to
                context.getString(
                    R.string.verify_network_connection,
                )

        NetworkErrors.UnknownException ->
            context.getString(R.string.unknown_error) to
                context.getString(
                    R.string.try_again,
                )
    }
}
