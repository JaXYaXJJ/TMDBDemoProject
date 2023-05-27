package hackeru.zakalinskyevgeny.mycinemaapp.data.models.search

import com.google.gson.annotations.SerializedName

data class SearchMovie(
    val page: Int,
    val results: List<TMBDResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)