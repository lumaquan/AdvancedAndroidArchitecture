package com.example.advancedandroidarchitecture.base;

import com.example.advancedandroidarchitecture.home.MainActivity;
import com.example.advancedandroidarchitecture.exp.NetworkModule;
import com.example.advancedandroidarchitecture.exp.TestActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class, ActivityBindingModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(TestActivity mainActivity);

}
