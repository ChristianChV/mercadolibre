package christian.chamorro.search.di

import christian.chamorro.search.data.datasources.SearchLocalDataSource
import christian.chamorro.search.data.datasources.SearchRemoteDataSource
import christian.chamorro.search.data.local.SearchLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class SearchBinderModule {

    @Binds
    abstract fun bindLocalDataSource(datasource: SearchLocalDataSource): SearchLocalDataSourceImpl

    @Binds
    abstract fun bindRemoteDataSource(datasource: SearchRemoteDataSource): SearchRemoteDataSource
}