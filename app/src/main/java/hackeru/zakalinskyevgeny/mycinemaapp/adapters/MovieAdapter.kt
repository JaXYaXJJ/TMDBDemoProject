package hackeru.zakalinskyevgeny.mycinemaapp.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import hackeru.zakalinskyevgeny.mycinemaapp.R
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Movie
import hackeru.zakalinskyevgeny.mycinemaapp.databinding.MovieItemBinding
import hackeru.zakalinskyevgeny.mycinemaapp.ui.film.FILM

class MovieAdapter(private val movies: List<Movie>, private var listener: Listener)
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

        holder.binding.movieCard.setOnClickListener { view ->
            listener.onClick(movie)
            view.findNavController().navigate(
                R.id.action_from_home_to_filmInfoFragment
            )
        }
    }

    interface Listener {
        fun onClick(movie: Movie)
    }
}