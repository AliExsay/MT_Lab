package com.example.lab4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class FragmentDel extends Fragment {
    private NoteDataSource dataSource;
    private EditText noteIdEditText;
    private Button deleteButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_del, container, false);

        noteIdEditText = view.findViewById(R.id.noteIdEditText);
        deleteButton = view.findViewById(R.id.deleteButton);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noteIdStr = noteIdEditText.getText().toString();
                if (!noteIdStr.isEmpty()) {
                    long noteId = Long.parseLong(noteIdStr);
                    dataSource = new NoteDataSource(getContext());
                    dataSource.open();
                    dataSource.deleteNote(noteId);
                    dataSource.close();
                    // Обновление списка заметок, если необходимо
                }
            }
        });

        return view;
    }
}
