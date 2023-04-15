package hackeru.zakalinskyevgeny.mycinemaapp.services

import hackeru.zakalinskyevgeny.mycinemaapp.data.models.GenreResponse
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.MoveResponse
import hackeru.zakalinskyevgeny.mycinemaapp.utils.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface TMBDService {
    @GET("3/discover/movie?sort_by=popularity.desc")
    suspend fun popularMovies(): MoveResponse

    @GET("3/discover/movie?sort_by=release_date.desc")
    suspend fun newMovies(): MoveResponse

    @GET("3/genre/movie/list")
    suspend fun genres(): GenreResponse

    companion object {
        fun create(): TMBDService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
                .addInterceptor(TokenInterceptor())
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TMBDService::class.java)
        }
    }
}