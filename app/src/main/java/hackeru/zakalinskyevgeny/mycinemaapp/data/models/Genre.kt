package hackeru.zakalinskyevgeny.mycinemaapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Genre(
    @PrimaryKey
    @SerializedName("id")
    val genreId: Int,
    val name: String
)