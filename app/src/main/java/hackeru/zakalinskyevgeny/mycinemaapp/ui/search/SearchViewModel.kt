package hackeru.zakalinskyevgeny.mycinemaapp.ui.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import hackeru.zakalinskyevgeny.mycinemaapp.MyCinemaApp
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.cast.MovieCast
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.info.Images
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.search.SearchMovie
import hackeru.zakalinskyevgeny.mycinemaapp.data.repository.MovieRepository
import kotlinx.coroutines.launch

class SearchViewModel (application: Application)
    : AndroidViewModel(application) {

    private val repository = MovieRepository(MyCinemaApp.db.movieDao())

    private val _searchMovie : MutableLiveData<SearchMovie> = MutableLiveData()
    val searchMovie : LiveData<SearchMovie> = _searchMovie

    fun search(query:String) {
        viewModelScope.launch {
            _searchMovie.postValue(repository.getSearchMovie(query))
        }
    }
}