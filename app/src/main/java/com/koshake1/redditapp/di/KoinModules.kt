package com.koshake1.redditapp.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.koshake1.redditapp.api.ApiService
import com.koshake1.redditapp.constants.BASE_API_URL
import com.koshake1.redditapp.model.data_source.RemoteDataSource
import com.koshake1.redditapp.model.data_source.RemoteDataSourceImpl
import com.koshake1.redditapp.model.repository.RedditRepository
import com.koshake1.redditapp.model.repository.RedditRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import viewmodel.MainViewModel

val retrofitModule = module {
    single {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build().create(ApiService::class.java)
    }
}

val dataSourceModule = module {
    single<RemoteDataSource> {
        RemoteDataSourceImpl(get())
    }
}
val repositoryModule = module {
    single<RedditRepository> {
        RedditRepositoryImpl(get())
    }
}
val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}