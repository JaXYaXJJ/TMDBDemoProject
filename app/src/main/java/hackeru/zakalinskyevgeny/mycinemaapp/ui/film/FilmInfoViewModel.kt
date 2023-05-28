package hackeru.zakalinskyevgeny.mycinemaapp.ui.film

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import hackeru.zakalinskyevgeny.mycinemaapp.MyCinemaApp
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.cast.MovieCast
import hackeru.zakalinskyevgeny.mycinemaapp.data.repository.MovieRepository
import kotlinx.coroutines.launch

class FilmInfoViewModel(application: Application)
    : AndroidViewModel(application) {

    private val _cast : MutableLiveData<MovieCast> = MutableLiveData()
    val cast : LiveData<MovieCast> = _cast

    fun getCast(id : Int) {
        viewModelScope.launch {
           val cast = MovieRepository(MyCinemaApp.db.movieDao()).getCast(id)
            _cast.postValue(cast)
        }
    }
}