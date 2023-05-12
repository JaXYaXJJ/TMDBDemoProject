package hackeru.zakalinskyevgeny.mycinemaapp.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import hackeru.zakalinskyevgeny.mycinemaapp.BuildConfig
import hackeru.zakalinskyevgeny.mycinemaapp.MyCinemaApp
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Movie
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.TV
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.cast.Cast
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.cast.MovieCast
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.primary_info.PrimaryMovieInfo
import hackeru.zakalinskyevgeny.mycinemaapp.data.repository.MovieRepository
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