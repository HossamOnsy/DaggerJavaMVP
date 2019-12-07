package com.sam.daggerjavamvp;

import android.app.Activity;
import android.app.Application;

import com.sam.daggerjavamvp.di.components.ApplicationComponent;
import com.sam.daggerjavamvp.di.DaggerApplicationComponent;

public class MyApplication extends Application {
    public static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().build();
        applicationComponent.injectApplication(this);
    }

    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
