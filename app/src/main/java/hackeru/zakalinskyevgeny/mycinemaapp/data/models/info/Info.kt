package hackeru.zakalinskyevgeny.mycinemaapp.data.models.info

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.movie.DEFAULT
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "info")
data class Info(
    @PrimaryKey
    val id: Int,
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
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
    val posterPath: String?,
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

    val backdropUrl
        get() = if (backdropPath != null)
            "https://image.tmdb.org/t/p/w780${backdropPath}"
        else DEFAULT

    val posterUrl
        get() = if (posterPath != null)
            "https://image.tmdb.org/t/p/w342${posterPath}"
        else DEFAULT

//    @SerializedName("belongs_to_collection")
//    val belongsToCollection: Any,
    @Ignore
    val genres: List<Genre> = mutableListOf()
//    val images: Images,
    @Ignore
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany> = mutableListOf()
    @Ignore
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry> = mutableListOf()
//    val reviews: Reviews,
    @Ignore
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage> = mutableListOf()
}