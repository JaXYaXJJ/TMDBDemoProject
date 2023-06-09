package hackeru.zakalinskyevgeny.mycinemaapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.tv_cast.Cast
import hackeru.zakalinskyevgeny.mycinemaapp.databinding.CastItemBinding

class TvCastAdapter(private val person: List<Cast>)
    : RecyclerView.Adapter<TvCastAdapter.TvCastVH>() {
        class TvCastVH(val binding: CastItemBinding)
            : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvCastVH {
        return TvCastVH(
            CastItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = person.size

    override fun onBindViewHolder(holder: TvCastVH, position: Int) {
        val tvCast = person[position]
        Picasso.get().load(tvCast.personPhoto)
            .into(holder.binding.personPhoto)
        holder.binding.personName.text = tvCast.name
        holder.binding.personCharacter.text = tvCast.character
    }
}