package com.tsengvn.redmartdemo.di.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hino.cardemo.BuildConfig
import com.hino.cardemo.data.service.CarApiService
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author hienngo
 * @since 8/29/18
 */
@Module
class NetworkModule {
    @Provides
    fun provideCarApiService(retrofit: Retrofit): CarApiService {
        return retrofit.create(CarApiService::class.java)
    }

    @Provides
    fun provideRetrofit(converterFactory: GsonConverterFactory, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

    @Provides
    fun provideGsonConverter(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { Timber.i(it) })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    fun provideOkhttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }

}