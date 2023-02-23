package com.veo.codechallenge.request.service

import com.veo.codechallenge.model.MovieDetails
import com.veo.codechallenge.model.MovieResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface VeoService {

    @GET(value = "https://api.themoviedb.org/3/trending/all/day?api_key=$key")
    suspend fun movies(): MovieResponse

    @GET(value = "https://api.themoviedb.org/3/movie/{movie_id}?api_key=$key")
    suspend fun details(@Path("movie_id") movie: Int): MovieDetails

    companion object {
        private const val key = "2b1141217ebbb8c700ded52eb2028d48"
    }

}

@Module
@InstallIn(ActivityRetainedComponent::class)
class VeoServiceModule {

    @Provides
    fun provideVeoService(retrofit: Retrofit): VeoService =
        retrofit.create(VeoService::class.java)
}
