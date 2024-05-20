package christian.chamorro.product.data.local

import christian.chamorro.product.data.local.adapters.AttributeAdapter
import christian.chamorro.product.data.local.adapters.CommonEntityToProductAdapter
import christian.chamorro.product.data.local.adapters.ProductToEntitiesAdapter
import christian.chamorro.product.data.local.daos.ProductDao
import christian.chamorro.product.data.local.entities.ProductEntity
import christian.chamorro.product.data.local.entities.ProductWithAttributes
import christian.chamorro.product.domain.models.Product
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ProductLocalDataSourceImplTest {

    lateinit var sut: ProductLocalDataSourceImpl
    lateinit var dao: ProductDao
    lateinit var attributeAdapter: AttributeAdapter
    lateinit var commonAdapter: CommonEntityToProductAdapter
    lateinit var productAdapter: ProductToEntitiesAdapter

    @Before
    fun setUp() {
        attributeAdapter = AttributeAdapter()
        commonAdapter =  CommonEntityToProductAdapter(attributeAdapter)
        productAdapter = ProductToEntitiesAdapter(attributeAdapter)
        dao = mockk(relaxed = true)
        sut = ProductLocalDataSourceImpl(dao, commonAdapter, productAdapter)
    }
    @Test
    fun `addFavorite when it is called should call insertProductAndAttributes from dao`() = runBlocking {
        // Given
        val product = givenAProduct()

        // When
        sut.addFavorite(product)

        // Then
        val expected = productAdapter.fromModel(product)
        coVerify(exactly = 1) { dao.insertProductAndAttributes(expected.first, expected.second) }
    }

    @Test
    fun `removeFavorite when it is called should call removeFromFavorites from dao`() = runBlocking{
        // Given
        val product = givenAProduct()

        // When
        sut.removeFavorite(product)

        // Then
        val expected = productAdapter.fromModel(product)
        coVerify(exactly = 1) { dao.removeFromFavorites(expected.first) }
    }

    @Test
    fun `getFavorites when it is called should return favorite products`() = runBlocking{
        // Given
        val productsWithAttributes = givenAProductWithAttributesList()
        coEvery { dao.getFavorites() } returns productsWithAttributes

        // When
        val result = sut.getFavorites()

        // Then
        val expected = commonAdapter.toModelList(productsWithAttributes)
        assertEquals(expected, result)
    }

    @Test
    fun `listenProductFavorite when it is called and it exist should emit true`() = runBlocking{
        // Given
        val productEntity = givenAProductEntity()
        coEvery { dao.listenProductById("") } returns flow<ProductEntity>{ emit(productEntity) }

        // When
        val result = sut.listenProductFavorite("").first()

        // Then
        assertEquals(true, result)
    }

    @Test
    fun `listenProductFavorite when it is called and not exist should emit false `() = runBlocking{
        // Given
        coEvery { dao.listenProductById("") } returns flow{ emit(null) }

        // When
        val result = sut.listenProductFavorite("").first()

        // Then
        assertEquals(false, result)
    }

    private fun givenAProduct(): Product{
        return Product(
            id = "",
            title = "",
            condition = "",
            thumbnail = "",
            price = 0.0,
            initialQuantity = 0,
            acceptsMercadopago = false,
            warranty = null,
            attributes = listOf(),
            pictures = listOf()
        )
    }

    private fun givenAProductWithAttributesList(): List<ProductWithAttributes>{
        return listOf(ProductWithAttributes(
            product = ProductEntity(
                id = "",
                title = "",
                condition = "",
                thumbnail = "",
                originalPrice = 0.0,
                initialQuantity = 0,
                acceptsMercadopago = false,
                warranty = null,
                pictures = listOf()
            ), attributes = listOf()
        ))
    }

    private fun givenAProductEntity(): ProductEntity{
        return ProductEntity(
            id = "",
            title = "",
            condition = "",
            thumbnail = "",
            originalPrice = 0.0,
            initialQuantity = 0,
            acceptsMercadopago = false,
            warranty = null,
            pictures = listOf()
        )
    }
}