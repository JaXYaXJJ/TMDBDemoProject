package hackeru.zakalinskyevgeny.mycinemaapp.ui.tv

import android.app.Application
import androidx.lifecycle.*
import hackeru.zakalinskyevgeny.mycinemaapp.MyCinemaApp
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.tv_cast.TvCast
import hackeru.zakalinskyevgeny.mycinemaapp.data.repository.MovieRepository
import kotlinx.coroutines.launch

class ShowInfoViewModel(application: Application)
    : AndroidViewModel(application) {

    private val _tvCast : MutableLiveData<TvCast> = MutableLiveData()
    val tvCast : LiveData<TvCast> = _tvCast

    fun getTvCast(id : Int) {
        viewModelScope.launch {
            val show = MovieRepository(MyCinemaApp.db.movieDao()).getTvCast(id)
            _tvCast.postValue(show)
        }
    }
}