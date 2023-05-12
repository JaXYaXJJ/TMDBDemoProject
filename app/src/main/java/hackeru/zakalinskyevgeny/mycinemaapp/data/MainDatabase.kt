package hackeru.zakalinskyevgeny.mycinemaapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hackeru.zakalinskyevgeny.mycinemaapp.data.dao.MovieDao
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Genre
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Movie
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.TV
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.cast.Cast
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.primary_info.PrimaryMovieInfo

private const val DB_NAME = "MovieDatabase"
private const val DB_VERSION = 8

@Database(version = DB_VERSION, entities = [
    Movie::class,
    Genre::class,
    TV::class,
    Cast::class,
    PrimaryMovieInfo::class
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