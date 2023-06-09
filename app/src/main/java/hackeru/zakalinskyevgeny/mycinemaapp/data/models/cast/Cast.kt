package hackeru.zakalinskyevgeny.mycinemaapp.data.models.cast

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import hackeru.zakalinskyevgeny.mycinemaapp.R
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.movie.DEFAULT
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity (tableName = "movieCast")
data class Cast(
    @PrimaryKey
    val id: Int,
    @SerializedName("cast_id")
    val castId: Int,
    val adult: Boolean,
    val character: String,
    @SerializedName("credit_id")
    val creditId: String,
    val gender: Int,
    @SerializedName("known_for_department")
    val knownForDepartment: String,
    val name: String,
    val order: Int,
    @SerializedName("original_name")
    val originalName: String,
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String?
) : Parcelable {

    val personPhoto
        get() = if (profilePath != null)
            "https://image.tmdb.org/t/p/w342${profilePath}"
        else DEFAULT
}