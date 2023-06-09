package hackeru.zakalinskyevgeny.mycinemaapp.ui.selected_movie

import android.app.Application
import androidx.lifecycle.*
import hackeru.zakalinskyevgeny.mycinemaapp.MyCinemaApp
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.info.Backdrop
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.info.Images
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.info.Info
import hackeru.zakalinskyevgeny.mycinemaapp.data.repository.MovieRepository
import kotlinx.coroutines.launch

class SelectedMovieViewModel(application: Application)
    : AndroidViewModel(application)