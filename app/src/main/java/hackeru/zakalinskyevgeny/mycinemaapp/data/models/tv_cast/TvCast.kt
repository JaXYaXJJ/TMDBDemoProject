package hackeru.zakalinskyevgeny.mycinemaapp.data.models.tv_cast

import com.google.gson.annotations.SerializedName

data class TvCast(
    @SerializedName("id")
    val id: Int,
    val cast: List<Cast>,
    val crew: List<Crew>
)