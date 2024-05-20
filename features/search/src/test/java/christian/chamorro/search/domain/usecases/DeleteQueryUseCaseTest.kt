package christian.chamorro.search.domain.usecases

import christian.chamorro.search.domain.repositories.SearchRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class DeleteQueryUseCaseTest {
    @Test
    fun `invoke when is called should call deleteQuery from repository`() =
        runBlocking {
            // Given
            val repository = mockk<SearchRepository>(relaxed = true)
            val sut = DeleteQueryUseCase(repository)

            // When
            sut.invoke("")

            // Then
            coVerify(exactly = 1) { repository.deleteQuery(any()) }
        }
}
