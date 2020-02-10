package com.example.advancedandroidarchitecture.lifecycle;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

import com.example.ac_view_model_2.network.util.Clock;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;


public class LoggingLifecycleFragment extends Fragment {

    private static final String ON_INFLATE = "onInflate";
    private static final String ON_ATTACH = "onAttach";
    private static final String ON_CREATE = "onCreate";
    private static final String ON_CREATE_VIEW = "onCreateView";
    private static final String ON_VIEW_CREATED = "onViewCreated";
    private static final String ON_ACTIVITY_CREATED = "onActivityCreated";
    private static final String ON_CONFIGURATION_CHANGED = "onConfigurationChanged";
    private static final String ON_START = "onStart";
    private static final String ON_STOP = "onStop";
    private static final String ON_DESTROY = "onDestroy";
    private static final String ON_LOW_MEMORY = "onLowMemory";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_RESUME = "onResume";
    private static final String ON_SAVE_INSTANCE_STATE = "onSaveInstanceState";
    private static final String ON_VIEW_STATE_RESTORED = "onViewStateRestored";
    private static final String ON_DESTROY_VIEW = "onDestroyView";
    private static final String ON_DETACH = "onDetach";
    private static final String ON_OPTIONS_ITEM_SELECTED = "onOptionsItemSelected";
    private static final String ON_CREATE_OPTIONS_MENU = "onCreateOptionsMenu";
    private static final String ON_PREPARE_OPTIONS_MENU = "onPrepareOptionsMenu";
    private static final String ON_ATTACH_FRAGMENT = "onAttachFragment";

    private static int numInstances = 0;
    private String name = getClass().getSimpleName();
    private static final String TAG = "XtremeLifecycle";
    protected Clock clock = new Clock(TAG);
    private static Map<String, Boolean> callbacks = new HashMap<>();

    static {

        // CONSTRUCTION

        // INITIALIZED
        callbacks.put(ON_INFLATE, true);
        callbacks.put(ON_ATTACH, true);
        callbacks.put(ON_CREATE, true);
        // CREATED
        callbacks.put(ON_ATTACH_FRAGMENT, true);
        callbacks.put(ON_CREATE_VIEW, true);
        callbacks.put(ON_VIEW_CREATED, true);
        callbacks.put(ON_ACTIVITY_CREATED, true);
        callbacks.put(ON_VIEW_STATE_RESTORED, true);
        callbacks.put(ON_START, true);
        //STARTED
        callbacks.put(ON_RESUME, true);
        //RESUMED
        callbacks.put(ON_CREATE_OPTIONS_MENU, true);
        callbacks.put(ON_PREPARE_OPTIONS_MENU, true);


        // DESTRUCTION
        // STARTED
        callbacks.put(ON_PAUSE, true);
        //STOPPED
        callbacks.put(ON_STOP, true);
        callbacks.put(ON_SAVE_INSTANCE_STATE, true);
        callbacks.put(ON_DESTROY_VIEW, true);
        //DESTROYED
        callbacks.put(ON_DESTROY, true);
        callbacks.put(ON_DETACH, true);

        //  OTHER CALLBACKS
        callbacks.put(ON_CONFIGURATION_CHANGED, true);
        callbacks.put(ON_OPTIONS_ITEM_SELECTED, true);
        callbacks.put(ON_LOW_MEMORY, true);
    }

    private Lifecycle mLifecycle;

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

    public LoggingLifecycleFragment() {
        name = name.concat(" " + ++numInstances);
        mLifecycle = getLifecycle();
        mLifecycle.addObserver(new LoggingLifecycleObserver(name));
        clock.init();
        clock.logMessageElapsedTimeMillis("Creating Fragment:" + name);
    }


    @Override
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attrs, @Nullable Bundle savedInstanceState) {
        beforeFather(ON_INFLATE);
        super.onInflate(context, attrs, savedInstanceState);
        afterFather(ON_INFLATE);
    }

    @Override
    public void onAttach(@NotNull Context context) {
        setHasOptionsMenu(true);
        beforeFather(ON_ATTACH);
        super.onAttach(context);
        afterFather(ON_ATTACH);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        beforeFather(ON_CREATE);
        super.onCreate(savedInstanceState);
        afterFather(ON_CREATE);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        beforeFather(ON_CREATE_VIEW);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        beforeFather(ON_VIEW_CREATED);
        super.onViewCreated(view, savedInstanceState);
        afterFather(ON_VIEW_CREATED);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        beforeFather(ON_ACTIVITY_CREATED);
        super.onActivityCreated(savedInstanceState);
        afterFather(ON_ACTIVITY_CREATED);
    }

    @Override
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        beforeFather(ON_CONFIGURATION_CHANGED);
        super.onConfigurationChanged(newConfig);
        afterFather(ON_CONFIGURATION_CHANGED);
    }


    @Override
    public void onStart() {
        beforeFather(ON_START);
        super.onStart();
        afterFather(ON_START);
    }

    @Override
    public void onStop() {
        beforeFather(ON_STOP);
        super.onStop();
        afterFather(ON_STOP);
    }

    @Override
    public void onDestroy() {
        beforeFather(ON_DESTROY);
        super.onDestroy();
        afterFather(ON_DESTROY);
    }

    @Override
    public void onLowMemory() {
        beforeFather(ON_LOW_MEMORY);
        super.onLowMemory();
        afterFather(ON_LOW_MEMORY);
    }

    @Override
    public void onPause() {
        beforeFather(ON_PAUSE);
        super.onPause();
        afterFather(ON_PAUSE);
    }


    @Override
    public void onResume() {
        beforeFather(ON_RESUME);
        super.onResume();
        afterFather(ON_RESUME);
    }

    @Override
    public void onSaveInstanceState(@NotNull Bundle outState) {
        beforeFather(ON_SAVE_INSTANCE_STATE);
        super.onSaveInstanceState(outState);
        afterFather(ON_SAVE_INSTANCE_STATE);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        beforeFather(ON_VIEW_STATE_RESTORED);
        super.onViewStateRestored(savedInstanceState);
        afterFather(ON_VIEW_STATE_RESTORED);
    }

    @Override
    public void onDestroyView() {
        beforeFather(ON_DESTROY_VIEW);
        super.onDestroyView();
        afterFather(ON_DESTROY_VIEW);
    }

    @Override
    public void onDetach() {
        beforeFather(ON_DETACH);
        super.onDetach();
        afterFather(ON_DETACH);
    }

    @Override
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        beforeFather(ON_OPTIONS_ITEM_SELECTED);
        boolean father = super.onOptionsItemSelected(item);
        afterFather(ON_OPTIONS_ITEM_SELECTED);
        return father;
    }

    @Override
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater menuInflater) {
        beforeFather(ON_CREATE_OPTIONS_MENU);
        super.onCreateOptionsMenu(menu, menuInflater);
        afterFather(ON_CREATE_OPTIONS_MENU);
    }

    @Override
    public void onPrepareOptionsMenu(@NotNull Menu menu) {
        beforeFather(ON_PREPARE_OPTIONS_MENU);
        super.onPrepareOptionsMenu(menu);
        afterFather(ON_PREPARE_OPTIONS_MENU);
    }

    @Override
    public void onAttachFragment(@NotNull Fragment fragment) {
        beforeFather(ON_ATTACH_FRAGMENT);
        super.onAttachFragment(fragment);
        afterFather(ON_ATTACH_FRAGMENT);
    }
}
