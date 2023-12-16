package com.example.lab4;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class NoteCursorAdapter extends CursorAdapter {
    public NoteCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item_note, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView noteIdTextView = view.findViewById(R.id.noteIdTextView);
        TextView descriptionTextView = view.findViewById(R.id.descriptionTextView);

        int noteId = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));

        noteIdTextView.setText(String.valueOf(noteId));
        descriptionTextView.setText(description);
    }
}

