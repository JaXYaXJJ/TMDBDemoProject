package hackeru.zakalinskyevgeny.mycinemaapp

import android.app.Application
import hackeru.zakalinskyevgeny.mycinemaapp.data.MainDatabase
import hackeru.zakalinskyevgeny.mycinemaapp.data.repository.MovieRepository

class MyCinemaApp: Application() {
    override fun onCreate() {
        super.onCreate()
        app = this
        db = MainDatabase.createDatabase(this)
        movieRepository = MovieRepository(db.movieDao())
    }

    companion object {
        lateinit var app: MyCinemaApp
        lateinit var db: MainDatabase
        lateinit var movieRepository: MovieRepository
    }
}