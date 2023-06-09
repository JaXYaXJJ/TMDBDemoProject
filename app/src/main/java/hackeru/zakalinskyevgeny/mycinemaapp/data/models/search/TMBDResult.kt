package hackeru.zakalinskyevgeny.mycinemaapp.data.models.search

import android.os.Parcelable
import android.view.View
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import hackeru.zakalinskyevgeny.mycinemaapp.R
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.movie.DEFAULT
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tmbd_result")
data class TMBDResult(
    @PrimaryKey
    val id: Int,
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
) : Parcelable {

    val backdropUrl
        get() = if (backdropPath != null)
            "https://image.tmdb.org/t/p/w780${backdropPath}"
        else DEFAULT

    val posterUrl
        get() = if (posterPath != null)
            "https://image.tmdb.org/t/p/w500${posterPath}"
        else DEFAULT

    @Ignore
    @SerializedName("genre_ids")
    val genreIds: List<Int> = mutableListOf()
}