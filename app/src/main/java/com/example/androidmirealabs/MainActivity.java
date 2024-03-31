package com.example.androidmirealabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<State> states = new ArrayList<State>();
    ListView countriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        countriesList = findViewById(R.id.countriesList);
        // создаем адаптер
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_item,
                states);
        // устанавливаем адаптер
        countriesList.setAdapter(stateAdapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new
                AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View v, int position,
                                            long id) {
                        // получаем выбранный пункт
                        State selectedState = (State) parent.getItemAtPosition(position);
                        Toast.makeText(getApplicationContext(), "Был выбран пункт " +
                                        selectedState.getName(),
                                Toast.LENGTH_SHORT).show();
                    }
                };
        countriesList.setOnItemClickListener(itemListener);
    }

    private void setInitialData() {
        states.add(new State("Антарктида", "Мак-Мердо", R.drawable.aq));
        states.add(new State("Непал", "Катманду", R.drawable.np));
        states.add(new State("Уганда", "Кампала", R.drawable.ug));
        states.add(new State("Сейшельские Острова", "Виктория", R.drawable.sc));
        states.add(new State("Гренландия", "Нуук", R.drawable.gl));
    }
}
