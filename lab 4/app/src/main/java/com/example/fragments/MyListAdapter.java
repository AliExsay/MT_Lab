package com.example.fragments;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<String> notes;
    ArrayList<Integer> id;

    public MyListAdapter(Context context, ArrayList<Integer> id, ArrayList<String> notes)
    {
        ctx = context;
        this.notes = notes;
        this.id = id;
    }
    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(ctx).inflate(R.layout.row, parent, false);
        }
        String Note = notes.get(position);
        int Id = id.get(position);
        TextView tv1 = view.findViewById(R.id.idNoteTextView);
        tv1.setText(String.valueOf(Id));
        TextView tv2 = view.findViewById(R.id.NotetextView);
        tv2.setText(Note);
        return view;
    }
}
