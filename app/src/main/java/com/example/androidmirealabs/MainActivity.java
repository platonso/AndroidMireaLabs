package com.example.androidmirealabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androidmirealabs.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    String[] food = {"Бургер", "Паста", "Пицца", "Салат",
            "Суши"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_multiple_choice, food);
        // устанавливаем для списка адаптер
        binding.foodList.setAdapter(adapter);
        // добавляем для списка слушатель
        binding.foodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                SparseBooleanArray selected = binding.foodList.getCheckedItemPositions();
                String selectedItems = "";
                for (int i = 0; i < food.length; i++) {
                    if (selected.get(i))
                        selectedItems += food[i] + ",";
                }
                // установка текста элемента TextView
                binding.selection.setText("Выбрано: " + selectedItems);
            }
        });
    }
}
