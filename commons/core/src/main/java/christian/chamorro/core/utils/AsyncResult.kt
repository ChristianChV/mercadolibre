package christian.chamorro.core.utils

/**
 * Class to manage asynchronous results.
 */
sealed class AsyncResult<R, E> {
    data class Success<R, E>(val value: R) : AsyncResult<R, E>()

    data class Failure<R, E>(val error: E) : AsyncResult<R, E>()

    /**
     * Return true if result is success, otherwise false.
     */
    fun isSuccess(): Boolean = this is Success

    /**
     * Return true if result is failure, otherwise false.
     */
    fun isFailure(): Boolean = this is Failure

    /**
     * Return value associated with success result, otherwise null.
     */
    fun getValueOrNull(): R? {
        return (this as? Success)?.value
    }

    /**
     * Return error associated with failure result, otherwise null.
     */
    fun getErrorOrNull(): E? {
        return (this as? Failure)?.error
    }
}
