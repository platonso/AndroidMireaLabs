package com.example.androidmirealabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    String jsonStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Вызываем метод для парсинга JSON
        createJsonUsingGson();
    }

    public void createJsonUsingGson() {


        Student student = new Student();
        student.name = "Platon";
        student.surname = "Solozobov";
        student.group = "IKBO-11-22";

        Gson gson = new Gson();
        jsonStudent = gson.toJson(student); // Преобразование данных в JSON


        // Создаем файл и записываем в него данные
        try {
            File file = new File(getFilesDir(), "student.json");
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(jsonStudent);
            osw.close();
            fos.close();
            Log.d("AAA", "JSON data saved to file: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
