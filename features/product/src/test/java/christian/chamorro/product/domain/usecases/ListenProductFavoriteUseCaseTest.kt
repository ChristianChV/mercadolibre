package christian.chamorro.product.domain.usecases

import christian.chamorro.product.domain.repositories.ProductRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ListenProductFavoriteUseCaseTest {
    @Test
    fun `invoke when is called should call listenProductFavorite`() =
        runBlocking {
            // Given
            val repository = mockk<ProductRepository>(relaxed = true)
            val sut = ListenProductFavoriteUseCase(repository)

            // When
            sut.invoke("")

            // Then
            coVerify(exactly = 1) { repository.listenProductFavorite(any()) }
        }
}
