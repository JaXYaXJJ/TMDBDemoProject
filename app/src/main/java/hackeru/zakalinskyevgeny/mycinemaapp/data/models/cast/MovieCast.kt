package hackeru.zakalinskyevgeny.mycinemaapp.data.models.cast

import com.google.gson.annotations.SerializedName

data class MovieCast(
    @SerializedName("id")
    val movieId: Int,
    val cast: List<Cast>,
    val crew: List<Crew>
)