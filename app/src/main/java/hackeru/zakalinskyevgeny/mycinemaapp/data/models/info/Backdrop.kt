package hackeru.zakalinskyevgeny.mycinemaapp.data.models.info

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

const val BACKDROP_DEFAULT =
    "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Placeholder_view_vector.svg" +
            "/681px-Placeholder_view_vector.svg.png"

data class Backdrop(
    @SerializedName("aspect_ratio")
    val aspectRatio: Double,
    @SerializedName("file_path")
    val filePath: String?,
    val height: Int,
    @SerializedName("iso_639_1")
    val iso6391: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int,
    val width: Int
) {

    val backdropUrl
        get() = if (filePath != null)
            "https://image.tmdb.org/t/p/w780${filePath}"
        else BACKDROP_DEFAULT
}
