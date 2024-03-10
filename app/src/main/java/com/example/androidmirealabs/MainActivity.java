package com.example.androidmirealabs;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.androidmirealabs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btn.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        String name = binding.name.getText().toString();
        String surname = binding.surname.getText().toString();
        String group = binding.group.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);

        intent.putExtra("name", name);
        intent.putExtra("surname", surname);
        intent.putExtra("group", group);

        startActivity(intent);
    }
}

