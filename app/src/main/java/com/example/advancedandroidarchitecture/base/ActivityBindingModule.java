package com.example.advancedandroidarchitecture.base;

import android.app.Activity;

import com.example.advancedandroidarchitecture.exp.TestActivityComponent;
import com.example.advancedandroidarchitecture.home.MainActivity;
import com.example.advancedandroidarchitecture.home.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MainActivityComponent.class, TestActivityComponent.class})
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjectorFactory(MainActivityComponent.Factory factory);


    @Binds
    @IntoMap
    @ClassKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindTestActivityInjectorFactory(TestActivityComponent.Factory factory);

}
