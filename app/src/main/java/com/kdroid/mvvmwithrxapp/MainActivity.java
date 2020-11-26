package com.kdroid.mvvmwithrxapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.makeQuery().observe(this, responseBody -> {
            Log.d(TAG, "onChanged called with live data observer");
            try {
                Log.d(TAG, "Value:" + responseBody.string());
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}