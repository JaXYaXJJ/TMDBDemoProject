package hackeru.zakalinskyevgeny.mycinemaapp.data.repository

import hackeru.zakalinskyevgeny.mycinemaapp.data.dao.MovieDao
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.cast.MovieCast
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.info.Backdrop
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.info.Images
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.info.Info
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.search.SearchMovie
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.tv_cast.TvCast
import hackeru.zakalinskyevgeny.mycinemaapp.services.TMBDService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val movieDao: MovieDao) {
    suspend fun refreshMovies() {
        withContext(Dispatchers.IO) {

            val service = TMBDService.create()

            //fetch movie from API
            val movieRes = service
                .popularMovies()
            val showRes = service
                .popularShows()
            val genreRes = service
                .genres()

            //save to local DB
            movieDao.addMovies(movieRes.movies)
            movieDao.addShows(showRes.tv)
            movieDao.addGenres(genreRes.genres)
        }
    }

    suspend fun getCast(id: Int): MovieCast {
        val service = TMBDService.create()
        return service.cast(id)
    }

    suspend fun getTvCast(id: Int): TvCast {
        val service = TMBDService.create()
        return service.tvCast(id)
    }

    suspend fun getSearchMovie(string: String): SearchMovie {
        val service = TMBDService.create()
        return service.search(string)
    }
}