package com.example.androidmirealabs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final Uri CONTENT_URI =
            Uri.parse("content://com.example.app.provider/books");

    private TextView booksTextView;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        booksTextView = findViewById(R.id.booksTextView);
        deleteButton = findViewById(R.id.deleteButton);

        // Установка обработчика нажатия на кнопку
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Удаление всех записей из базы данных
                int rowsDeleted = deleteAllBooks();
                if (rowsDeleted > 0) {
                    Toast.makeText(MainActivity.this, "All books deleted successfully", Toast.LENGTH_SHORT).show();
                    // Обновление отображения списка книг в TextView после удаления
                    displayBooks();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to delete books", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Отображение списка книг в TextView
        displayBooks();
    }

    // Метод для отображения списка книг в TextView
    private void displayBooks() {
        Cursor cursor = getContentResolver().query(CONTENT_URI, null, null, null, null);
        if (cursor != null) {
            StringBuilder booksInfo = new StringBuilder();
            while (cursor.moveToNext()) {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("_id"));
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex("title"));
                @SuppressLint("Range") String author = cursor.getString(cursor.getColumnIndex("author"));

                booksInfo.append("Book ID: ").append(id).append(", Title: ").append(title).append(", Author: ").append(author).append("\n");
            }
            cursor.close();

            // Установка текста в TextView
            booksTextView.setText(booksInfo.toString());
        } else {
            Log.e("MainActivity", "Cursor is null");
        }
    }

    // Метод для удаления всех записей из базы данных
    private int deleteAllBooks() {
        ContentResolver contentResolver = getContentResolver();
        return contentResolver.delete(CONTENT_URI, null, null);
    }
}