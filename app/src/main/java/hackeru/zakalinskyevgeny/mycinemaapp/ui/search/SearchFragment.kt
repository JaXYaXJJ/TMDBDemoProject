package hackeru.zakalinskyevgeny.mycinemaapp.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import hackeru.zakalinskyevgeny.mycinemaapp.MyCinemaApp
import hackeru.zakalinskyevgeny.mycinemaapp.R
import hackeru.zakalinskyevgeny.mycinemaapp.adapters.SearchAdapter
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.search.TMBDResult
import hackeru.zakalinskyevgeny.mycinemaapp.data.repository.MovieRepository
import hackeru.zakalinskyevgeny.mycinemaapp.databinding.FragmentSearchBinding
import hackeru.zakalinskyevgeny.mycinemaapp.services.TMBDService
import hackeru.zakalinskyevgeny.mycinemaapp.ui.film.FILM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    lateinit var searchViewModel : SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        searchViewModel =
            ViewModelProvider(this)[SearchViewModel::class.java]

        _binding = FragmentSearchBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.searchRV.layoutManager = LinearLayoutManager( requireContext())
        val searchAdapter = SearchAdapter {
                clickedMovie ->
            val bundle = Bundle()
            bundle.putParcelable(FILM, clickedMovie)
            findNavController().navigate(
                R.id.action_from_searchFragment_to_selectedMovieFragment,
                bundle
            )
        }
        binding.searchRV.adapter = searchAdapter
        searchViewModel.searchMovie.observe(viewLifecycleOwner) {
            searchAdapter.submitList(it?.results)
        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    searchViewModel.search(it)
                }
                return true
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}