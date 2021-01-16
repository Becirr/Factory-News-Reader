package com.factorynewsreader.di.module


import com.factorynewsreader.App
import com.factorynewsreader.R
import com.factorynewsreader.data.api.ApiService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule constructor(private val app: App) {

    @Singleton
    @Provides
    fun providesApiUrl() = app.getString(R.string.api_url)

    @Singleton
    @Provides
    fun providesHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(logging)
        return httpClient.build()
    }

    @Singleton
    @Provides
    fun providesApiService(
        httpClient: OkHttpClient,
        apiUrl: String
    ): ApiService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .baseUrl(apiUrl)
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(ApiService::class.java)
}