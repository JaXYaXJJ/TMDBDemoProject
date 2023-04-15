package hackeru.zakalinskyevgeny.mycinemaapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Movie
import hackeru.zakalinskyevgeny.mycinemaapp.databinding.MovieItemBinding

class MovieAdapter(private val movies: List<Movie>)
    : RecyclerView.Adapter<MovieAdapter.MovieVH>() {
        class MovieVH(val binding: MovieItemBinding)
            : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        return MovieVH(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        val movie = movies[position]
        Picasso.get().load(movie.posterUrl)
            .into(holder.binding.movieCover)
        holder.binding.movieTitle.text = movie.title
    }
}