package com.example.androidmirealabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.androidmirealabs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private int counter = 0;

    private ActivityMainBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*
        String startWithString = binding.startWith.getText().toString();
        int startWith = 0; // Значение по умолчанию, если поле ввода пустое

        if (!startWithString.isEmpty()) {
            startWith = Integer.parseInt(startWithString);
        }

        String stepString = binding.step.getText().toString();
        int step = 0;

        if (!startWithString.isEmpty()) {
            step = Integer.parseInt(startWithString);
        }
         */


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                binding.count.setText(String.valueOf(counter));
            }
        });


    }
}


