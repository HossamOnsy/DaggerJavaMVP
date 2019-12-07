package com.sam.daggerjavamvp.di.components;

import com.sam.daggerjavamvp.scope.ActivityScope;
import com.sam.daggerjavamvp.di.modules.AdapterModule;
import com.sam.daggerjavamvp.di.modules.MainActivityMvpModule;
import com.sam.daggerjavamvp.ui.MainActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {MainActivityMvpModule.class, AdapterModule.class}, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    void injectMainActivity(MainActivity mainActivity);
}
