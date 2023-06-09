package hackeru.zakalinskyevgeny.mycinemaapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hackeru.zakalinskyevgeny.mycinemaapp.data.dao.MovieDao
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.cast.Cast
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.genre.Genre
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.info.Backdrop
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.info.Info
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.movie.Movie
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.search.TMBDResult
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.tv.TV

private const val DB_NAME = "MovieDatabase"
private const val DB_VERSION = 16

@Database(version = DB_VERSION, entities = [
    Movie::class,
    Genre::class,
    TV::class,
    Cast::class,
    hackeru.zakalinskyevgeny.mycinemaapp.data.models.tv_cast.Cast::class,
    TMBDResult::class,
])
abstract class MainDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {

        var instance : MainDatabase? = null
        fun createDatabase(context: Context): MainDatabase {
            if(instance == null) {
                instance = Room.databaseBuilder(

                    context,
                    MainDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
    }
}