package com.example.androidmirealabs;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_second);

        TextView textView = new TextView(this);
        textView.setTextSize(26);
        textView.setPadding(16, 16, 16, 16);
        Bundle arguments = getIntent().getExtras();

        if (arguments != null) {
            String name = arguments.getString("name");
            String surname = arguments.getString("surname");
            String group = arguments.getString("group");
            textView.setText("Name: " + name + "\nSurname: " + surname + "\nGroup: " + group);
        }
        setContentView(textView);

    }
}

