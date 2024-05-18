package christian.chamorro.search.di

import christian.chamorro.search.data.SearchRepositoryImpl
import christian.chamorro.search.data.datasources.SearchLocalDataSource
import christian.chamorro.search.data.datasources.SearchRemoteDataSource
import christian.chamorro.search.data.local.SearchLocalDataSourceImpl
import christian.chamorro.search.data.remote.SearchRemoteDataSourceImpl
import christian.chamorro.search.domain.repositories.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class SearchBinderModule {

    @Binds
    abstract fun bindLocalDataSource(datasourceImpl: SearchLocalDataSourceImpl): SearchLocalDataSource

    @Binds
    abstract fun bindRemoteDataSource(datasourceImpl: SearchRemoteDataSourceImpl): SearchRemoteDataSource

    @Binds
    abstract fun bindSearchRepository(repositoryImpl: SearchRepositoryImpl): SearchRepository
}