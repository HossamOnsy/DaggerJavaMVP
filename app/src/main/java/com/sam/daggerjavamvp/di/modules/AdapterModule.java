package com.sam.daggerjavamvp.di.modules;



import com.sam.daggerjavamvp.ui.CatsAdapter;

import dagger.Module;
import dagger.Provides;


@Module
public class AdapterModule {

    @Provides
    CatsAdapter getAdapter() {
        return new CatsAdapter();
    }

}

