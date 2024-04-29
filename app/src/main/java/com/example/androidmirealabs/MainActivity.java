package com.example.androidmirealabs;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final Uri CONTENT_URI =
            Uri.parse("content://com.example.app.provider/books");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}