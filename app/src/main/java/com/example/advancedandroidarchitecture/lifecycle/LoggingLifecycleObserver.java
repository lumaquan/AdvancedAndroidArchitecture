package com.example.advancedandroidarchitecture.lifecycle;


import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class LoggingLifecycleObserver implements LifecycleObserver {

    private static final String ON_CREATE_EVENT = "ON_CREATE_EVENT";
    private static final String ON_START_EVENT = "ON_START_EVENT";
    private static final String ON_RESUME_EVENT = "ON_RESUME_EVENT";
    private static final String ON_PAUSE_EVENT = "ON_PAUSE_EVENT";
    private static final String ON_STOP_EVENT = "ON_STOP_EVENT";
    private static final String ON_DESTROY_EVENT = "ON_DESTROY_EVENT";

    private String name;
    private static final String TAG = "XtremeLifecycle";

    LoggingLifecycleObserver(String name) {
        this.name = name;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void myOnCreate() {
        Log.d(TAG, ON_CREATE_EVENT + " " + name);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void myOnStart() {
        Log.d(TAG, ON_START_EVENT + " " + name);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void myOnResume() {
        Log.d(TAG, ON_RESUME_EVENT + " " + name);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void myOnStop() {
        Log.d(TAG, ON_STOP_EVENT + " " + name);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void myOnDestroy() {
        Log.d(TAG, ON_DESTROY_EVENT + " " + name);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void myOnPause() {
        Log.d(TAG, ON_PAUSE_EVENT + " " + name);
    }

}
