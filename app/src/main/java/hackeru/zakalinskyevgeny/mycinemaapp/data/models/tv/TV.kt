package hackeru.zakalinskyevgeny.mycinemaapp.data.models.tv

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

private const val DEFAULT_IMG =
    "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Placeholder_view_vector.svg/681px-Placeholder_view_vector.svg.png"

@Parcelize
@Entity (tableName = "shows")
data class TV(
    @PrimaryKey
    @SerializedName("id")
    val tvId: Int,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    val name: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_name")
    val originalName: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
) : Parcelable {
    val backdropUrl
        get() = if (backdropPath != null)
            "https://image.tmdb.org/t/p/w780${backdropPath}"
        else DEFAULT_IMG

    val posterUrl
        get() = if (posterPath != null)
            "https://image.tmdb.org/t/p/w342${posterPath}"
        else DEFAULT_IMG

//    @Ignore
//    @SerializedName("genre_ids")
//    val genreIds: List<Int> = mutableListOf()
//    @SerializedName("origin_country")
//    val originCountry: List<String> = mutableListOf()
}