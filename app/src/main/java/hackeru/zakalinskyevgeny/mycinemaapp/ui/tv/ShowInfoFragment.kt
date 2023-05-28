package hackeru.zakalinskyevgeny.mycinemaapp.ui.tv

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import hackeru.zakalinskyevgeny.mycinemaapp.adapters.TvCastAdapter
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.tv.TV
import hackeru.zakalinskyevgeny.mycinemaapp.databinding.FragmentShowInfoBinding
import hackeru.zakalinskyevgeny.mycinemaapp.ui.film.FILM

class ShowInfoFragment : Fragment() {

    private var _binding: FragmentShowInfoBinding? = null
    private val binding: FragmentShowInfoBinding get() = _binding!!
    lateinit var showViewModel : ShowInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        showViewModel =
            ViewModelProvider(this)[ShowInfoViewModel::class.java]

        _binding = FragmentShowInfoBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showViewModel.tvCast.observe(viewLifecycleOwner) {
            val tvCastAdapter = TvCastAdapter(it.cast)
            binding.tvCastRV.adapter = tvCastAdapter
            binding.tvCastRV.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

        val show = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelable(FILM, TV::class.java)
        } else {
            requireArguments().getParcelable(FILM) as TV?
        } ?: return

        binding.showTitle.text = show.name
        Picasso.get().load(show.backdropUrl).into(binding.showBackdrop)
        Picasso.get().load(show.posterUrl).into(binding.showPoster)
        binding.showOverview.text = show.overview
        binding.showRating.text = show.voteAverage.toString()

        showViewModel.getTvCast(show.tvId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}