package com.app.login360.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { provideLoggingInterceptor() }
    single { provideHttpClient(loggingInterceptor = get()) }
    single { providesGson() }
    single { provideRetrofit(okHttpClient = get(), gson = get()) }
}

private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return loggingInterceptor
}

private fun provideHttpClient(
    loggingInterceptor: HttpLoggingInterceptor
) = OkHttpClient.Builder()
    .addNetworkInterceptor(loggingInterceptor)
    .readTimeout(5, TimeUnit.MINUTES)
    .writeTimeout(5, TimeUnit.MINUTES)
    .build()

private fun providesGson(): Gson = GsonBuilder().create()

private fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl("https://login360.getsandbox.com//api/")
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()