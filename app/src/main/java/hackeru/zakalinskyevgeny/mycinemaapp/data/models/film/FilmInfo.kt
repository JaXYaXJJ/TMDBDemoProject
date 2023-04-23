package hackeru.zakalinskyevgeny.mycinemaapp.data.models.film

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity (tableName = "film")
data class FilmInfo(
    @PrimaryKey
    @SerializedName("id")
    val filmId: Int,
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
//    @SerializedName("belongs_to_collection")
//    val belongsToCollection: Any?,
    val budget: Int,
//    val genres: List<Genre>,
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
    val posterPath: String?,
//    @SerializedName("production_companies")
//    val productionCompanies: List<ProductionCompany>,
//    @SerializedName("production_countries")
//    val productionCountries: List<ProductionCountry>,
    @SerializedName("release_date")
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
//    @SerializedName("spoken_languages")
//    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)