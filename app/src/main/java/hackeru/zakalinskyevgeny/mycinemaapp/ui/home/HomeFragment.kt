package hackeru.zakalinskyevgeny.mycinemaapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import hackeru.zakalinskyevgeny.mycinemaapp.R
import hackeru.zakalinskyevgeny.mycinemaapp.adapters.CastAdapter
import hackeru.zakalinskyevgeny.mycinemaapp.adapters.MovieAdapter
import hackeru.zakalinskyevgeny.mycinemaapp.adapters.TVAdapter
import hackeru.zakalinskyevgeny.mycinemaapp.data.dao.MovieDao
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Movie
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.cast.MovieCast
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.primary_info.PrimaryMovieInfo
import hackeru.zakalinskyevgeny.mycinemaapp.databinding.FragmentHomeBinding
import hackeru.zakalinskyevgeny.mycinemaapp.services.TMBDService
import hackeru.zakalinskyevgeny.mycinemaapp.ui.film.FILM

class HomeFragment : Fragment(), MovieAdapter.Listener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )
        val root: View = binding.root

        homeViewModel.movies.observe(viewLifecycleOwner) {
            val movieAdapter = MovieAdapter(it,this) {
                movie ->
                val bundle = Bundle()
                bundle.putParcelable(FILM, movie)
                findNavController().navigate(
                    R.id.action_from_home_to_filmInfoFragment,
                    bundle
                )
            }
            binding.popMovieRV.adapter = movieAdapter
            binding.popMovieRV.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

        homeViewModel.shows.observe(viewLifecycleOwner) {
            val tvAdapter = TVAdapter(it)
            binding.popShowRV.adapter = tvAdapter
            binding.popShowRV.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(movie: Movie) {
        Toast.makeText(context, "Click on: ${movie.title}",
            Toast.LENGTH_LONG).show()
    }
}