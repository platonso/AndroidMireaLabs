package com.example.androidmirealabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    String jsonStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Вызываем метод для парсинга JSON
        createJsonUsingGson();

        readJsonFromFile();
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

    public void readJsonFromFile() {
        try {
            File file = new File(getFilesDir(), "student.json");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();

            Gson gson = new Gson();
            Student studentRead = gson.fromJson(sb.toString(), Student.class);

            Log.d("RRR", "Name from JSON: " + studentRead.name);
            Log.d("RRR", "Surname from JSON: " + studentRead.surname);
            Log.d("RRR", "Group from JSON: " + studentRead.group);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
