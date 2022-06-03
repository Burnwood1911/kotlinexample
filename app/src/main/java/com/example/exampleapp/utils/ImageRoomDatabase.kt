import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.exampleapp.models.FImage
import com.example.exampleapp.utils.ImageDao



@Database(entities = [FImage::class], version = 1, exportSchema = false)
abstract class ImageDatabase : RoomDatabase() {
    abstract val imageDao: ImageDao
}