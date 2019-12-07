package com.sam.daggerjavamvp.di.modules;



import com.sam.daggerjavamvp.scope.ApplicationScope;
import com.sam.daggerjavamvp.network.ApiServiceInterface;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

import static com.sam.daggerjavamvp.network.NetworkUtils.createHttpClient;
import static com.sam.daggerjavamvp.network.NetworkUtils.createWebService;


@Module
public class NetworkModule {

    @Provides
    @ApplicationScope
    ApiServiceInterface getApiInterface() {
        return createWebService();
    }

    @Provides
    @ApplicationScope
    OkHttpClient getRetrofit() {
        return createHttpClient();
    }

}

