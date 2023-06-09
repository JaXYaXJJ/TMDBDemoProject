package hackeru.zakalinskyevgeny.mycinemaapp.data.models.info


import com.google.gson.annotations.SerializedName

data class AuthorDetails(
    @SerializedName("avatar_path")
    val avatarPath: String,
    val name: String,
    val rating: Double,
    val username: String
)