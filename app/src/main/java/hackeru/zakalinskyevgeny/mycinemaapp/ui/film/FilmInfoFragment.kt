package hackeru.zakalinskyevgeny.mycinemaapp.ui.film

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Movie
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.film.FilmInfo
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}