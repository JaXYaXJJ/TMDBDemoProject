package hackeru.zakalinskyevgeny.mycinemaapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.cast.Cast
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.genre.Genre
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.movie.Movie
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.search.TMBDResult
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.tv.TV

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovies(movies: List<Movie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(show: TV)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addShows(shows: List<TV>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(genre: Genre)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addGenres(genres: List<Genre>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(person: Cast)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCast(persons: List<Cast>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(person: hackeru.zakalinskyevgeny.mycinemaapp.data.models.tv_cast.Cast)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTvCast(persons: List<hackeru.zakalinskyevgeny.mycinemaapp.data.models.tv_cast.Cast>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(searchMovie: TMBDResult)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSearchMovie(searchMovies: List<TMBDResult>)

    @Query("SELECT * FROM movies")
    fun getMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM shows")
    fun getShows(): LiveData<List<TV>>

    @Query("SELECT * FROM genres")
    fun getGenres(): LiveData<List<Genre>>

    @Query("SELECT * FROM movieCast")
    fun getCast(): LiveData<List<Cast>>

    @Query("SELECT * FROM tvCast")
    fun getTvCast(): LiveData<List<hackeru.zakalinskyevgeny.mycinemaapp.data.models.tv_cast.Cast>>

    @Query("SELECT * FROM tmbd_result")
    fun getSearchMovie(): LiveData<TMBDResult>
}