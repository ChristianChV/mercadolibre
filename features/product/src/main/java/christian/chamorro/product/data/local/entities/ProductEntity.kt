package christian.chamorro.product.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val title: String,
    val condition: String,
    val thumbnail: String,
    val originalPrice: Long,
    val initialQuantity: Long,
    val acceptsMercadopago: Boolean,
    val warranty: String,
    val pictures: List<String>,
)