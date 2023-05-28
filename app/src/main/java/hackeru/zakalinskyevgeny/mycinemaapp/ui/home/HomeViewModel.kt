package hackeru.zakalinskyevgeny.mycinemaapp.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import hackeru.zakalinskyevgeny.mycinemaapp.MyCinemaApp
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.movie.Movie
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.tv.TV
import kotlinx.coroutines.launch

class HomeViewModel(application: Application)
    : AndroidViewModel(application) {

    val movies: LiveData<List<Movie>> = MyCinemaApp.db.movieDao().getMovies()
    val shows: LiveData<List<TV>> = MyCinemaApp.db.movieDao().getShows()

    init {
        viewModelScope.launch {
            MyCinemaApp.movieRepository.refreshMovies()
        }
    }
}