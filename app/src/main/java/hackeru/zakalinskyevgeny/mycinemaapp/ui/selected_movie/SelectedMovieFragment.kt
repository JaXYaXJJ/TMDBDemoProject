package hackeru.zakalinskyevgeny.mycinemaapp.ui.selected_movie

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.search.TMBDResult
import hackeru.zakalinskyevgeny.mycinemaapp.databinding.FragmentSelectedMovieBinding
import hackeru.zakalinskyevgeny.mycinemaapp.ui.film.FILM

class SelectedMovieFragment : Fragment() {

    private var _binding: FragmentSelectedMovieBinding? = null
    private val binding: FragmentSelectedMovieBinding get() = _binding!!
    private lateinit var selectedViewModel: SelectedMovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        selectedViewModel =
            ViewModelProvider(this)[SelectedMovieViewModel::class.java]

        _binding = FragmentSelectedMovieBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedMovie = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelable(FILM, TMBDResult::class.java)
        } else {
            requireArguments().getParcelable(FILM) as TMBDResult?
        } ?: return

        Picasso.get().load(selectedMovie.backdropUrl).into(binding.selectedBackdrop)
        Picasso.get().load(selectedMovie.posterUrl).into(binding.selectedPoster)
        binding.selectedTitle.text = selectedMovie.title
        binding.selectedOverview.text = selectedMovie.overview
    }
}