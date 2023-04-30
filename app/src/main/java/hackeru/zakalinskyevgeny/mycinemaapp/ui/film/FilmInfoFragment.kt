package hackeru.zakalinskyevgeny.mycinemaapp.ui.film

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Movie
import hackeru.zakalinskyevgeny.mycinemaapp.databinding.FragmentFilmInfoBinding

const val FILM = "hackeru.zakalinskyevgeny.data.models.film"

class FilmInfoFragment : Fragment() {

    private lateinit var viewModel: FilmInfoViewModel
    private var _binding: FragmentFilmInfoBinding? = null
    private val binding: FragmentFilmInfoBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[FilmInfoViewModel::class.java]
        _binding = FragmentFilmInfoBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movie = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelable(FILM, Movie::class.java)
        } else {
            requireArguments().getParcelable(FILM) as Movie?
        } ?: return

        binding.filmTitle.text = movie.title
        Picasso.get().load(movie.backdropUrl).into(binding.filmBackdrop)
        Picasso.get().load(movie.posterUrl).into(binding.filmPoster)
        binding.filmRelease.text = movie.releaseDate
        binding.filmOverview.text = movie.overview
        binding.filmRating.text = movie.voteAverage.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}