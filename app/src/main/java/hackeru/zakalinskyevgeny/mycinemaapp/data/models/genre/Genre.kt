package hackeru.zakalinskyevgeny.mycinemaapp.data.models.genre

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity (tableName = "genres")
data class Genre(
    @PrimaryKey
    @SerializedName("id")
    val genreId: Int,
    val name: String
)