package hackeru.zakalinskyevgeny.mycinemaapp.data.models

import com.google.gson.annotations.SerializedName

data class GenreResponse(
    val genres: List<Genre>,
    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("status_message")
    val statusMessage: String?
)