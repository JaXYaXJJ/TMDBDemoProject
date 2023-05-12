package hackeru.zakalinskyevgeny.mycinemaapp.data.models.primary_info

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.IgnoredOnParcel

@Parcelize
@Entity (tableName = "primaryInfo")
data class PrimaryMovieInfo(
    @PrimaryKey
    val id: Int,
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    val budget: Int,
    val homepage: String,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
) : Parcelable {

    @Ignore
    @SerializedName("belongs_to_collection")
    val belongsToCollection: List<Any> = mutableListOf()
    @Ignore
    val genres: List<Any> = mutableListOf()
    @Ignore
    @SerializedName("production_companies")
    val productionCompanies: List<Any> = mutableListOf()
    @Ignore
    @SerializedName("production_countries")
    val productionCountries: List<String> = mutableListOf()
    @Ignore
    @SerializedName("spoken_languages")
    val spokenLanguages: List<String> = mutableListOf()
}