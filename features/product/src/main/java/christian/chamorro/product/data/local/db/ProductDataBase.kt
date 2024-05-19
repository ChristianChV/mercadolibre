package christian.chamorro.product.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import christian.chamorro.product.data.local.daos.ProductDao
import christian.chamorro.product.data.local.entities.AttributeEntity
import christian.chamorro.product.data.local.entities.ProductEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Database(
    entities = [ProductEntity::class, AttributeEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(PicturesTypeConverter::class)
abstract class ProductDataBase : RoomDatabase() {

    abstract val dao: ProductDao
}