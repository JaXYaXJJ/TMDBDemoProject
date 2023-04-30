package hackeru.zakalinskyevgeny.mycinemaapp.utils

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TokenInterceptor (
    private val queryParam: String = "api_key",
    private val queryValue: String = "54fc82d6a085bac3d8b338040bd47684",
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()

        val url = original
            .url.newBuilder()
            .addQueryParameter(queryParam, queryValue)
            .build()

        val request = original
            .newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }
}