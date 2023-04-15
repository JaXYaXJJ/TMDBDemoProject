package hackeru.zakalinskyevgeny.mycinemaapp.ui.home

import android.app.Application
import androidx.lifecycle.*
import hackeru.zakalinskyevgeny.mycinemaapp.MyCinemaApp
import hackeru.zakalinskyevgeny.mycinemaapp.data.MainDatabase
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Movie
import hackeru.zakalinskyevgeny.mycinemaapp.data.repository.MovieRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application)
    : AndroidViewModel(application) {

    val movies: LiveData<List<Movie>> = MyCinemaApp.db.movieDao().getMovies()

    init {
        viewModelScope.launch {
            MyCinemaApp.movieRepository.refreshMovies()
        }
    }
}