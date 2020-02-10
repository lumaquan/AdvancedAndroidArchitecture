package com.example.advancedandroidarchitecture.exp;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public abstract class NetworkModule {

    @Singleton
    @Provides
    static OkHttpClient providesOkHttpClient() {
        return new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(chain.request());
            }
        }).build();
    }


    @Provides
    @Singleton
    static Retrofit providesRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().client(client)
                .baseUrl("http://google.com.mx/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

    }


}
