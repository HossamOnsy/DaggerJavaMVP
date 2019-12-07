package com.sam.daggerjavamvp.di.components;

import com.sam.daggerjavamvp.MyApplication;
import com.sam.daggerjavamvp.scope.ApplicationScope;
import com.sam.daggerjavamvp.di.modules.NetworkModule;
import com.sam.daggerjavamvp.network.ApiServiceInterface;

import dagger.Component;

@ApplicationScope
@Component(modules = {NetworkModule.class})
public interface ApplicationComponent {

    ApiServiceInterface getApiInterface();

    void injectApplication(MyApplication myApplication);
}
