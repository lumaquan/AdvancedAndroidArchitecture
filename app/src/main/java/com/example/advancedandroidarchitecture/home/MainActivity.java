package com.example.advancedandroidarchitecture.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.advancedandroidarchitecture.R;
import com.example.advancedandroidarchitecture.exp.TestActivity;
import com.example.advancedandroidarchitecture.base.BaseActivity;
import com.example.advancedandroidarchitecture.base.MyApplication;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Inject
    Context context;
    @Inject
    OkHttpClient client;
    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) getApplication()).getComponent().inject(this);

        Button button = findViewById(R.id.goTestActivity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        });


        accessVariablesInAnotherThread();

        Log.d(TAG, "onCreate: " + context);
        Log.d(TAG, "onCreate: " + client);
        Log.d(TAG, "onCreate: " + retrofit);

    }

    private void accessVariablesInAnotherThread() {
        new Thread(() -> {

        }).start();
    }


}
