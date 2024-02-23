package com.example.androidmirealabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.androidmirealabs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private int counter = 0;
    private int startValue = 0;
    private int step = 1;

    private ActivityMainBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String startWithString = binding.startWith.getText().toString();
                String stepString = binding.step.getText().toString();

                if (startWithString.isEmpty()) {
                    startValue = 0; // значение по умолчанию, если поле ввода пустое
                } else {
                    startValue = Integer.parseInt(startWithString);
                }

                if (stepString.isEmpty()) {
                    step = 1; // значение по умолчанию, если поле ввода пустое
                } else {
                    step = Integer.parseInt(stepString);
                }

                // устанавливаем начальное значение счетчика
                counter = startValue;
                binding.count.setText(String.valueOf(counter));
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter += step;
                binding.count.setText(String.valueOf(counter));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        outState.putInt("startValue", startValue);
        outState.putInt("step", step);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counter");
        binding.count.setText(String.valueOf(counter));
        startValue = savedInstanceState.getInt("startValue");
        step = savedInstanceState.getInt("step");
    }

}



