package com.example.advancedandroidarchitecture.base;

import com.example.advancedandroidarchitecture.home.MainActivity;
import com.example.advancedandroidarchitecture.home.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MainActivityComponent.class})
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity.class)
    abstract AndroidInjector.Factory<?> bindMainActivityInjectorFactory(MainActivityComponent.Factory factory);

}
