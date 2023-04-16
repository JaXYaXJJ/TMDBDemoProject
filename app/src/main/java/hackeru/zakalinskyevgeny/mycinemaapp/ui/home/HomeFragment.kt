package hackeru.zakalinskyevgeny.mycinemaapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hackeru.zakalinskyevgeny.mycinemaapp.MyCinemaApp
import hackeru.zakalinskyevgeny.mycinemaapp.adapters.MovieAdapter
import hackeru.zakalinskyevgeny.mycinemaapp.adapters.TVAdapter
import hackeru.zakalinskyevgeny.mycinemaapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.movies.observe(viewLifecycleOwner) {
            val movieAdapter = MovieAdapter(it)
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
}