package hackeru.zakalinskyevgeny.mycinemaapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.cast.Cast
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.primary_info.PrimaryMovieInfo
import hackeru.zakalinskyevgeny.mycinemaapp.databinding.CastItemBinding

class CastAdapter(private val persons: List<Cast>,
                  private val onCastClick: (Cast) -> Unit)
    : RecyclerView.Adapter<CastAdapter.CastVH>() {
        class CastVH(val binding: CastItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastVH {
        return CastVH(
            CastItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = persons.size

    override fun onBindViewHolder(holder: CastVH, position: Int) {
        val cast = persons[position]
        Picasso.get().load(cast.personPhoto)
            .into(holder.binding.personPhoto)
        holder.binding.personName.text = cast.name
        holder.binding.personCharacter.text = cast.character

//        holder.binding.castCard.setOnClickListener {
//            onCastClick.invoke(cast)
//        }
    }
}