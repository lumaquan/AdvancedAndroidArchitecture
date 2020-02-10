package com.example.advancedandroidarchitecture.base;

import android.app.Application;

import dagger.android.AndroidInjector;
import dagger.android.HasAndroidInjector;

public class MyApplication extends Application implements HasAndroidInjector {

    private ApplicationComponent component;


    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    public ApplicationComponent getComponent() {
        return component;
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return null;
    }
}
