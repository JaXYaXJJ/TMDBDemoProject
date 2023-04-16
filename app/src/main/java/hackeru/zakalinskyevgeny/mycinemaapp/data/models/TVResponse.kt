package hackeru.zakalinskyevgeny.mycinemaapp.data.models


import com.google.gson.annotations.SerializedName

data class TVResponse(
    val page: Int,
    @SerializedName("results")
    val tv: List<TV>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int,

    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("status_message")
    val statusMessage: String?
)