package hackeru.zakalinskyevgeny.mycinemaapp.data.models.info


import com.google.gson.annotations.SerializedName

data class Reviews(
    val page: Int,
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)