package christian.chamorro.product.di

import christian.chamorro.product.data.ProductRepositoryImpl
import christian.chamorro.product.data.datasources.ProductLocalDataSource
import christian.chamorro.product.data.datasources.ProductRemoteDataSource
import christian.chamorro.product.data.local.ProductLocalDataSourceImpl
import christian.chamorro.product.data.remote.ProductRemoteDataSourceImpl
import christian.chamorro.product.domain.repositories.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductBinderModule {
    @Binds
    abstract fun bindProductLocalDataSource(datasourceImpl: ProductLocalDataSourceImpl): ProductLocalDataSource

    @Binds
    abstract fun bindProductRemoteDataSource(datasourceImpl: ProductRemoteDataSourceImpl): ProductRemoteDataSource

    @Binds
    abstract fun bindProductRepository(repositoryImpl: ProductRepositoryImpl): ProductRepository
}
