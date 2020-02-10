package com.example.advancedandroidarchitecture.exp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.advancedandroidarchitecture.R;
import com.example.advancedandroidarchitecture.base.BaseActivity;
import com.example.advancedandroidarchitecture.base.MyApplication;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class TestActivity extends BaseActivity {

    private static final String TAG = TestActivity.class.getSimpleName();

    @Inject
    Context context;
    @Inject
    OkHttpClient client;
    @Inject
    Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ((MyApplication) getApplication()).getComponent().inject(this);
        Log.d(TAG, "onCreate: " + context);
        Log.d(TAG, "onCreate: " + client);
        Log.d(TAG, "onCreate: " + retrofit);


    }
}
