package hackeru.zakalinskyevgeny.mycinemaapp.services

import hackeru.zakalinskyevgeny.mycinemaapp.data.models.GenreResponse
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.MovieResponse
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.TVResponse
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.cast.MovieCast
import hackeru.zakalinskyevgeny.mycinemaapp.data.models.primary_info.PrimaryMovieInfo
import hackeru.zakalinskyevgeny.mycinemaapp.utils.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMBDService {
    @GET("3/discover/movie?sort_by=popularity.desc")
    suspend fun popularMovies(): MovieResponse

    @GET("3/discover/movie?sort_by=release_date.desc")
    suspend fun newMovies(): MovieResponse

    @GET("3/genre/movie/list")
    suspend fun genres(): GenreResponse

    @GET("3/discover/tv?sort_by=popularity.desc")
    suspend fun popularShows(): TVResponse

    @GET("3/search/movie")
    suspend fun search(
        @Query("q") name: String
    ): MovieResponse

    @GET("3/movie/{movie_id}/credits")
    suspend fun cast(
        @Path("movie_id") movieId: Int
    ): MovieCast

    @GET ("3/movie/{movie_id}")
    suspend fun info(
        @Path("id") movieId: Int
    ): PrimaryMovieInfo

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