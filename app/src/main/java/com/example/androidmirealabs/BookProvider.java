package com.example.androidmirealabs;

import static com.example.androidmirealabs.MainActivity.CONTENT_URI;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;


public class BookProvider extends ContentProvider {
    private SQLiteDatabase db;

    @Override
    public boolean onCreate() {
        DBHelper dbHelper = new DBHelper(getContext());
        db = dbHelper.getWritableDatabase();
        if (db != null) {
            // Добавим начальные данные в базу данных
            ContentValues values = new ContentValues();
            values.put("title", "Book Title 1");
            values.put("author", "Author 1");
            db.insert("books", null, values);

            values.clear();
            values.put("title", "Book Title 2");
            values.put("author", "Author 2");
            db.insert("books", null, values);
        }
        return (db != null);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String
            selection, String[] selectionArgs, String sortOrder) {
        return db.query("books", projection, selection,
                selectionArgs, null, null, sortOrder);
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID = db.insert("books", "", values);
        Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
        getContext().getContentResolver().notifyChange(_uri,
                null);
        return _uri;
    }

    @Override
    public int delete(Uri uri, String selection, String[]
            selectionArgs) {
        int count = db.delete("books", selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String
            selection, String[] selectionArgs) {
        int count = db.update("books", values, selection,
                selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/vnd.example.books";
    }
}

