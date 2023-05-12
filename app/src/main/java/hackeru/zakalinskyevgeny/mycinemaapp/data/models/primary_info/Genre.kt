package hackeru.zakalinskyevgeny.mycinemaapp.data.models.primary_info


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Genre(
    val id: Int,
    val name: String
) : Parcelable