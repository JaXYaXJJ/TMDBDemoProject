package hackeru.zakalinskyevgeny.mycinemaapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hackeru.zakalinskyevgeny.mycinemaapp.data.dao.MovieDao
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Genre
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.Movie

@Database(version = 1, entities = [
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
                "MovieDatabase"
            ).build()
        }
    }
}