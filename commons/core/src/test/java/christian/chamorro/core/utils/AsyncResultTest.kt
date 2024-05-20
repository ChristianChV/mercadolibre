package christian.chamorro.core.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class AsyncResultTest {
    @Test
    fun `isSuccess when result is failure should return false`() {
        // Given
        val sut: AsyncResult<Int, Int> = AsyncResult.Failure(0)

        // When
        val result = sut.isSuccess()

        // Then
        assertEquals(false, result)
    }

    @Test
    fun `isSuccess when result is success should return true`() {
        // Given
        val sut: AsyncResult<Int, Int> = AsyncResult.Success(0)

        // When
        val result = sut.isSuccess()

        // Then
        assertEquals(true, result)
    }

    @Test
    fun `isFailure when result is failure should return true`() {
// Given
        val sut: AsyncResult<Int, Int> = AsyncResult.Failure(0)

        // When
        val result = sut.isFailure()

        // Then
        assertEquals(true, result)
    }

    @Test
    fun `isFailure when result is success should return false`() {
        // Given
        val sut: AsyncResult<Int, Int> = AsyncResult.Success(0)

        // When
        val result = sut.isFailure()

        // Then
        assertEquals(false, result)
    }

    @Test
    fun `getValueOrNull when result is success should return value`() {
        // Given
        val sut: AsyncResult<Int, Int> = AsyncResult.Success(0)

        // When
        val result = sut.getValueOrNull()

        // Then
        assertEquals(0, result)
    }

    @Test
    fun `getValueOrNull when result is failure should return null`() {
        // Given
        val sut: AsyncResult<Int, Int> = AsyncResult.Failure(0)

        // When
        val result = sut.getValueOrNull()

        // Then
        assertEquals(null, result)
    }

    @Test
    fun `getErrorOrNull when result is success should return null`() {
        // Given
        val sut: AsyncResult<Int, Int> = AsyncResult.Success(0)

        // When
        val result = sut.getErrorOrNull()

        // Then
        assertEquals(null, result)
    }

    @Test
    fun `getErrorOrNull when result is failure should return error`() {
        // Given
        val sut: AsyncResult<Int, Int> = AsyncResult.Failure(0)

        // When
        val result = sut.getErrorOrNull()

        // Then
        assertEquals(0, result)
    }
}
