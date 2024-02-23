package com.example.androidmirealabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.androidmirealabs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private int counter = 0;
    private int startValue;
    private int step;

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

                if (startWithString.isEmpty()){
                    startValue =0; // значение по умолчанию, если поле ввода пустое
                }else {
                    startValue = Integer.parseInt(startWithString);
                }

                if (stepString.isEmpty()){
                    step=1; // значение по умолчанию, если поле ввода пустое
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
}



