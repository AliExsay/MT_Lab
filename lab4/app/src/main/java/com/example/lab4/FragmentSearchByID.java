package com.example.lab4;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class FragmentSearchByID extends Fragment {
    private NoteDataSource dataSource;
    private NoteCursorAdapter cursorAdapter;
    private ListView listView;
    private EditText searchByIdEditText;
    private Button searchByIdButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_by_id, container, false);

        listView = view.findViewById(R.id.listView);
        searchByIdEditText = view.findViewById(R.id.searchByIdEditText);
        searchByIdButton = view.findViewById(R.id.searchByIdButton);

        dataSource = new NoteDataSource(getContext());
        dataSource.open();

        searchByIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noteIdStr = searchByIdEditText.getText().toString();
                if (!noteIdStr.isEmpty()) {
                    long noteId = Long.parseLong(noteIdStr);
                    Cursor searchCursor = dataSource.getNoteById(noteId);
                    cursorAdapter = new NoteCursorAdapter(getContext(), searchCursor);
                    listView.setAdapter(cursorAdapter);
                }
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dataSource.close();
    }
}
