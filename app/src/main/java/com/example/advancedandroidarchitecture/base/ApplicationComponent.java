package com.example.advancedandroidarchitecture.base;

import com.example.advancedandroidarchitecture.home.MainActivity;
import com.example.advancedandroidarchitecture.NetworkModule;
import com.example.advancedandroidarchitecture.TestActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class, ActivityBindingModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(TestActivity mainActivity);

}
