package hackeru.zakalinskyevgeny.mycinemaapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Genre
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Movie
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.TV

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

    @Query("SELECT * FROM movies")
    fun getMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM shows")
    fun getShows(): LiveData<List<TV>>

    @Query("SELECT * FROM genres")
    fun getGenres(): LiveData<List<Genre>>
}