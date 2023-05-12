package hackeru.zakalinskyevgeny.mycinemaapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Genre
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Movie
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.TV
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.cast.Cast
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.primary_info.PrimaryMovieInfo

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
    suspend fun add(info: PrimaryMovieInfo)

    @Query("SELECT * FROM movies")
    fun getMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM shows")
    fun getShows(): LiveData<List<TV>>

    @Query("SELECT * FROM genres")
    fun getGenres(): LiveData<List<Genre>>

    @Query("SELECT * FROM movieCast")
    fun getCast(): LiveData<List<Cast>>

    @Query("SELECT * FROM primaryInfo")
    fun getPrimaryInfo(): LiveData<PrimaryMovieInfo>
}