package christian.chamorro.product.di

import android.content.Context
import androidx.room.Room
import christian.chamorro.product.data.local.daos.ProductDao
import christian.chamorro.product.data.local.db.ProductDataBase
import christian.chamorro.product.data.remote.api.ProductApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductModule {


    @Provides
    @Singleton
    fun provideProductApi(retrofit: Retrofit): ProductApi =
        retrofit.create(
            ProductApi::class.java,
        )

    @Provides
    @Singleton
    fun provideProductDataBase(@ApplicationContext context: Context): ProductDataBase {
        return Room.databaseBuilder(context, ProductDataBase::class.java, "productDB").build()
    }

    @Provides
    @Singleton
    fun provideProductDao(productDataBase: ProductDataBase): ProductDao {
        return productDataBase.dao
    }
}
