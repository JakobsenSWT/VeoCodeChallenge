package com.veo.codechallenge.request.service

import com.veo.codechallenge.model.Movie
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import retrofit2.Retrofit
import retrofit2.http.GET

interface VeoService {

    @GET(value = "https://api.themoviedb.org/3/trending/all/day?api_key={api_key}")
    suspend fun movies(): List<Movie>

    @GET(value = "https://api.themoviedb.org/3/movie/{movie_id}?api_key={api_key}&language=en-US")
    suspend fun details(): Any

}

@Module
@InstallIn(ActivityRetainedComponent::class)
class VeoServiceModule {

    @Provides
    fun provideVeoService(retrofit: Retrofit): VeoService =
        retrofit.create(VeoService::class.java)
}
