package com.example.advancedandroidarchitecture.di;

import android.app.Activity;

import com.example.advancedandroidarchitecture.base.BaseActivity;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;

public class ActivityInjector {

    private final Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors;
    private final Map<String, AndroidInjector<? extends Activity>> cache = new HashMap<>();

    @Inject
    ActivityInjector(Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors) {
        this.activityInjectors = activityInjectors;
    }

    public void inject(Activity activity) {
        if (!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException("Activity must extend BaseActivity");
        }
        String instanceId = ((BaseActivity) activity).getInstanceId();
        if (cache.containsKey(instanceId)) {
            ((AndroidInjector<Activity>) cache.get(instanceId)).inject(activity);
            return;
        } else {
            AndroidInjector.Factory<Activity> androidActivityInjectorFactory = (AndroidInjector.Factory<Activity>) activityInjectors.get(activity.getClass()).get();
            AndroidInjector<Activity> androidInjector = androidActivityInjectorFactory.create(activity);
            androidInjector.inject(activity);
            cache.put(instanceId, androidInjector);
        }
    }


}
