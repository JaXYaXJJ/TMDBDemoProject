package hackeru.zakalinskyevgeny.mycinemaapp.ui.film

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import hackeru.zakalinskyevgeny.mycinemaapp.adapters.CastAdapter
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.movie.Movie
import hackeru.zakalinskyevgeny.mycinemaapp.databinding.FragmentFilmInfoBinding

const val FILM = "hackeru.zakalinskyevgeny.data.models.film"

class FilmInfoFragment: Fragment() {

    private var _binding: FragmentFilmInfoBinding? = null
    private val binding: FragmentFilmInfoBinding get() = _binding!!
    lateinit var filmViewModel : FilmInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        filmViewModel =
            ViewModelProvider(this)[FilmInfoViewModel::class.java]

        _binding = FragmentFilmInfoBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filmViewModel.cast.observe(viewLifecycleOwner) {
            val castAdapter = CastAdapter(it.cast) {
//                    cast ->
//                moveToDetails(cast)
            }
            binding.castRV.adapter = castAdapter
            binding.castRV.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

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

        filmViewModel.getCast(movie.movieId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    private fun moveToDetails(cast : Cast) {
//        val bundle = Bundle()
//        val castAsString = Gson().toJson(cast)
//        bundle.putString("cast", castAsString)
//        findNavController().navigate(R.id.action_from_home_to_filmInfoFragment, bundle)
//    }
}