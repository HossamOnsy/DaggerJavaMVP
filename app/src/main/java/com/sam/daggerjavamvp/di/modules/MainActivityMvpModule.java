package com.sam.daggerjavamvp.di.modules;

import com.sam.daggerjavamvp.mvp.MainActivityContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityMvpModule {
    private final MainActivityContract.View mView;

    public MainActivityMvpModule(MainActivityContract.View mView) {
        this.mView = mView;
    }

    @Provides
    MainActivityContract.View provideView() {
        return mView;
    }

}