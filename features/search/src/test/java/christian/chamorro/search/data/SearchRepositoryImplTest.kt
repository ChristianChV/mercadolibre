package christian.chamorro.search.data

import christian.chamorro.core.utils.AsyncResult
import christian.chamorro.network.errors.NetworkErrors
import christian.chamorro.search.data.datasources.SearchLocalDataSource
import christian.chamorro.search.data.datasources.SearchRemoteDataSource
import christian.chamorro.search.domain.models.SearchResult
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SearchRepositoryImplTest {
    lateinit var sut: SearchRepositoryImpl
    lateinit var local: SearchLocalDataSource
    lateinit var remote: SearchRemoteDataSource

    @Before
    fun setUp() {
        local = mockk(relaxed = true)
        remote = mockk(relaxed = true)
        sut = SearchRepositoryImpl(local, remote)
    }

    @Test
    fun `getProductsByQuery when it is called should save query in local storage and return AsyncResult`() =
        runBlocking {
            // Given
            val query = ""
            val expectedResult: AsyncResult<SearchResult, NetworkErrors> = AsyncResult.Failure(NetworkErrors.NoInternetException)
            coEvery { remote.getProductsByQuery(query) } returns expectedResult

            // When
            val result = sut.getProductsByQuery(query)

            // Then
            coVerify(exactly = 1) { remote.getProductsByQuery(query) }
            assertEquals(expectedResult, result)
        }

    @Test
    fun `deleteQuery when it is called should call deleteQuery from local data source`() =
        runBlocking {
            // Given
            val query = ""

            // When
            sut.deleteQuery(query)

            // Then
            coVerify(exactly = 1) { local.deleteQuery(query) }
        }

    @Test
    fun `getQueries when it is called should call getQueries from local data source`() =
        runBlocking {
            // When
            sut.getQueries()

            // Then
            coVerify(exactly = 1) { local.getQueries() }
        }
}
