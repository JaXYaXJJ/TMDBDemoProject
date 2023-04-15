package hackeru.zakalinskyevgeny.mycinemaapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hackeru.zakalinskyevgeny.mycinemaapp.data.dao.MovieDao
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Genre
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Movie

private const val DB_NAME = "MovieDatabase"
private const val DB_VERSION = 1

@Database(version = DB_VERSION, entities = [
    Movie::class,
    Genre::class
])
abstract class MainDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        fun createDatabase(context: Context): MainDatabase {
            return Room.databaseBuilder(

                context,
                MainDatabase::class.java,
                DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}