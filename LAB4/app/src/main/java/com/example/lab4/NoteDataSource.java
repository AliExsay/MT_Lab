package com.example.lab4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class NoteDataSource {
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public NoteDataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long addNote(String description) {
        ContentValues values = new ContentValues();
        values.put("description", description);
        return database.insert("notes", null, values);
    }

    public void deleteNote(long noteId) {
        database.delete("notes", "id = " + noteId, null);
    }

    public void updateNote(long noteId, String newDescription) {
        ContentValues values = new ContentValues();
        values.put("description", newDescription);
        database.update("notes", values, "id = " + noteId, null);
    }

    public Cursor getAllNotes() {
        // Используем алиас для переименования столбца id в _id
        String[] columns = { "id as _id", "description" };
        return database.query("notes", columns, null, null, null, null, null);
    }

}
