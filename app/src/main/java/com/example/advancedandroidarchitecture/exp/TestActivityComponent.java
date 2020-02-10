package com.example.advancedandroidarchitecture.exp;


import com.example.advancedandroidarchitecture.TestActivity_MembersInjector;
import com.example.advancedandroidarchitecture.di.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent
public interface TestActivityComponent extends AndroidInjector<TestActivity> {

    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<TestActivity> {
    }
}
