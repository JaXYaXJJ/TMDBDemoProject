package hackeru.zakalinskyevgeny.mycinemaapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.movie.Movie
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.tv.TV
import hackeru.zakalinskyevgeny.mycinemaapp.databinding.TvItemBinding

class TVAdapter(private val shows: List<TV>,
                private val callback: (show: TV) -> Unit)
    : RecyclerView.Adapter<TVAdapter.TVVH>() {
        class TVVH(val binding: TvItemBinding)
            : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVVH {
        return TVVH(
            TvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = shows.size

    override fun onBindViewHolder(holder: TVVH, position: Int) {
        val show = shows[position]
        Picasso.get().load(show.posterUrl)
            .into(holder.binding.tvCover)
        holder.binding.tvTitle.text = show.name

        holder.binding.tvCard.setOnClickListener {
            callback(show)
        }
    }
}