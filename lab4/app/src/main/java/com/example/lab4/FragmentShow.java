package com.example.lab4;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class FragmentShow extends Fragment {
    private NoteDataSource dataSource;
    private NoteCursorAdapter cursorAdapter;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show, container, false);

        listView = view.findViewById(R.id.listView);

        dataSource = new NoteDataSource(getContext());
        dataSource.open();

        Cursor cursor = dataSource.getAllNotes();
        cursorAdapter = new NoteCursorAdapter(getContext(), cursor);

        listView.setAdapter(cursorAdapter);

        return view;
    }
    public void updateNotesList() {
        Cursor newCursor = dataSource.getAllNotes();
        cursorAdapter.changeCursor(newCursor);
        cursorAdapter.notifyDataSetChanged();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        dataSource.close();
    }
}
