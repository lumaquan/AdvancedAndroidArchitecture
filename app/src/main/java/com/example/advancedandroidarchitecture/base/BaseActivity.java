package com.example.advancedandroidarchitecture.base;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.advancedandroidarchitecture.di.Injector;

import java.util.UUID;

public abstract class BaseActivity extends AppCompatActivity {

    private static final String INSTANCE_ID_KEY = "instance_id";
    private String instanceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            instanceId = savedInstanceState.getString(INSTANCE_ID_KEY);
        } else {
            instanceId = UUID.randomUUID().toString();
        }
        Injector.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(INSTANCE_ID_KEY, instanceId);
        super.onSaveInstanceState(outState);
    }
}
