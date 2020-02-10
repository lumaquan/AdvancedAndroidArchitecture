package com.example.advancedandroidarchitecture.lifecycle;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

import com.example.ac_view_model_2.network.util.Clock;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class LoggingLifecycleActivity extends AppCompatActivity {

    public static final String ON_CREATE = "onCreate";
    public static final String ON_POST_CREATE = "onPostCreate";
    public static final String ON_CONFIGURATION_CHANGED = "onConfigurationChanged";
    public static final String ON_POST_RESUME = "onPostResume";
    public static final String ON_START = "onStart";
    public static final String ON_STOP = "onStop";
    public static final String ON_DESTROY = "onDestroy";
    public static final String ON_LOW_MEMORY = "onLowMemory";
    public static final String ON_PAUSE = "onPause";
    public static final String ON_NEW_INTENT = "onNewIntent";
    public static final String ON_RESTART = "onRestart";
    public static final String ON_RESUME = "onResume";
    public static final String ON_ATTACHED_TO_WINDOW = "onAttachedToWindow";
    public static final String ON_DETACHED_FROM_WINDOW = "onDetachedFromWindow";
    public static final String ON_SAVE_INSTANCE_STATE = "onSaveInstanceState";
    public static final String ON_RESTORE_INSTANCE_STATE = "onRestoreInstanceState";
    public static final String ON_OPTIONS_ITEM_SELECTED = "onOptionsItemSelected";
    public static final String ON_CREATE_OPTIONS_MENU = "onCreateOptionsMenu";
    public static final String ON_PREPARE_OPTIONS_MENU = "onPrepareOptionsMenu";
    public static final String ON_CONTENT_CHANGED = "onContentChanged";
    public static final String ON_ATTACH_FRAGMENT = "onAttachFragment";
    public static final String ON_USER_LEAVE_HINT = "onUserLeaveHint";

    protected static Map<String, Boolean> callbacks = new HashMap<>();

    static {

        // CONSTRUCTION

        // INITIALIZED
        callbacks.put(ON_CREATE, true);
        callbacks.put(ON_CONTENT_CHANGED, true);
        // CREATED
        callbacks.put(ON_RESTART, true);   // Coming back from another app
        callbacks.put(ON_RESTORE_INSTANCE_STATE, true); // Only after rotation
        callbacks.put(ON_START, true);
        callbacks.put(ON_ATTACH_FRAGMENT, true);   // If reattached this occurs after before onContentChange
        // STARTED
        callbacks.put(ON_POST_CREATE, true);
        callbacks.put(ON_RESUME, true);
        // RESUMED
        callbacks.put(ON_POST_RESUME, true);
        callbacks.put(ON_ATTACHED_TO_WINDOW, true);
        callbacks.put(ON_CREATE_OPTIONS_MENU, true);
        callbacks.put(ON_PREPARE_OPTIONS_MENU, true);

        // DESTRUCTION

        // STARTED
        callbacks.put(ON_PAUSE, true);
        // CREATED
        callbacks.put(ON_STOP, true);
        callbacks.put(ON_SAVE_INSTANCE_STATE, true);    // Rotation and leaving app (not dismissing it)
        //DESTROYED
        callbacks.put(ON_DESTROY, true);
        callbacks.put(ON_DETACHED_FROM_WINDOW, true);

        callbacks.put(ON_CONFIGURATION_CHANGED, true);
        callbacks.put(ON_LOW_MEMORY, true);
        callbacks.put(ON_NEW_INTENT, true);
        callbacks.put(ON_OPTIONS_ITEM_SELECTED, true);
        callbacks.put(ON_USER_LEAVE_HINT, true);   // When leaving app

    }

    private static int numInstances = 0;
    private String name = getClass().getSimpleName();
    protected static final String TAG = "XtremeLifecycle";
    protected Clock clock = new Clock(TAG);

    Lifecycle mLifecycle;

    private void beforeFather(String methodName) {
        boolean showBefore = true;
        if (showBefore && callbacks.get(methodName)) {
            clock.logMessageElapsedTimeMillis(methodName + "(" + mLifecycle.getCurrentState().name() + ")" + " -> " + name + " [BEFORE]");
        }
    }

    private void afterFather(String methodName) {
        boolean showAfter = true;
        if (showAfter && callbacks.get(methodName)) {
            clock.logMessageElapsedTimeMillis(methodName + "(" + mLifecycle.getCurrentState().name() + ")" + " -> " + name + " [AFTER]");
        }
    }

    // CONSTRUCTION
    public LoggingLifecycleActivity() {
        name = name.concat(" " + ++numInstances);
        mLifecycle = getLifecycle();
        mLifecycle.addObserver(new LoggingLifecycleObserver(name));
        clock.init();
        clock.logMessageElapsedTimeMillis("Creating Activity:" + name);
    }

    // CREATE, START , RESUME, ATTACH

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        beforeFather(ON_CREATE);
        super.onCreate(savedInstanceState);
        afterFather(ON_CREATE);
    }

    @Override
    public void onAttachFragment(@NotNull Fragment fragment) {
        beforeFather(ON_ATTACH_FRAGMENT);
        super.onAttachFragment(fragment);
        afterFather(ON_ATTACH_FRAGMENT);
    }

    @Override
    public void onContentChanged() {
        beforeFather(ON_CONTENT_CHANGED);
        super.onContentChanged();
        afterFather(ON_CONTENT_CHANGED);
    }

    @Override
    protected void onRestart() {
        beforeFather(ON_RESTART);
        super.onRestart();
        afterFather(ON_RESTART);
    }

    @Override
    protected void onStart() {
        beforeFather(ON_START);
        super.onStart();
        afterFather(ON_START);
    }

    @Override
    protected void onRestoreInstanceState(@NotNull Bundle savedInstanceState) {
        beforeFather(ON_RESTORE_INSTANCE_STATE);
        super.onRestoreInstanceState(savedInstanceState);
        afterFather(ON_RESTORE_INSTANCE_STATE);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        beforeFather(ON_POST_CREATE);
        super.onPostCreate(savedInstanceState);
        afterFather(ON_POST_CREATE);
    }

    @Override
    protected void onResume() {
        beforeFather(ON_RESUME);
        super.onResume();
        afterFather(ON_RESUME);
    }

    @Override
    protected void onPostResume() {
        beforeFather(ON_POST_RESUME);
        super.onPostResume();
        afterFather(ON_POST_RESUME);
    }

    @Override
    public void onAttachedToWindow() {
        beforeFather(ON_ATTACHED_TO_WINDOW);
        super.onAttachedToWindow();
        afterFather(ON_ATTACHED_TO_WINDOW);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        beforeFather(ON_CREATE_OPTIONS_MENU);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        beforeFather(ON_PREPARE_OPTIONS_MENU);
        return super.onPrepareOptionsMenu(menu);
    }

    // PAUSE, STOP , DESTROY, DETTACH

    @Override
    protected void onPause() {
        beforeFather(ON_PAUSE);
        super.onPause();
        afterFather(ON_PAUSE);
    }

    @Override
    protected void onSaveInstanceState(@NotNull Bundle outState) {
        beforeFather(ON_SAVE_INSTANCE_STATE);
        super.onSaveInstanceState(outState);
        afterFather(ON_SAVE_INSTANCE_STATE);
    }

    @Override
    protected void onStop() {
        beforeFather(ON_STOP);
        super.onStop();
        afterFather(ON_STOP);
    }

    @Override
    protected void onDestroy() {
        beforeFather(ON_DESTROY);
        super.onDestroy();
        afterFather(ON_DESTROY);
    }

    @Override
    public void onDetachedFromWindow() {
        beforeFather(ON_DETACHED_FROM_WINDOW);
        super.onDetachedFromWindow();
        afterFather(ON_DETACHED_FROM_WINDOW);
    }

    @Override
    protected void onUserLeaveHint() {
        beforeFather(ON_USER_LEAVE_HINT);
        super.onUserLeaveHint();
        afterFather(ON_USER_LEAVE_HINT);
    }

    @Override
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        beforeFather(ON_CONFIGURATION_CHANGED);
        super.onConfigurationChanged(newConfig);
        afterFather(ON_CONFIGURATION_CHANGED);
    }

    @Override
    public void onLowMemory() {
        beforeFather(ON_LOW_MEMORY);
        super.onLowMemory();
        afterFather(ON_LOW_MEMORY);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        beforeFather(ON_NEW_INTENT);
        super.onNewIntent(intent);
        afterFather(ON_LOW_MEMORY);
    }

    @Override
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        beforeFather(ON_OPTIONS_ITEM_SELECTED);
        boolean father = super.onOptionsItemSelected(item);
        afterFather(ON_OPTIONS_ITEM_SELECTED);
        return father;
    }

}
