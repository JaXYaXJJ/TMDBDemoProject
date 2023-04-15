package hackeru.zakalinskyevgeny.mycinemaapp.data.repository

import hackeru.zakalinskyevgeny.mycinemaapp.data.dao.MovieDao
import hackeru.zakalinskyevgeny.mycinemaapp.services.TMBDService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val movieDao: MovieDao) {
    suspend fun refreshMovies() {
        withContext(Dispatchers.IO) {
            //fetch movie from API
            val movieRes = TMBDService
                .create()
                .popularMovies()
            val genreRes = TMBDService
                .create()
                .genres()
            //save to local DB
            movieDao.addMovies(movieRes.movies)
            movieDao.addGenres(genreRes.genres)
        }
    }
}