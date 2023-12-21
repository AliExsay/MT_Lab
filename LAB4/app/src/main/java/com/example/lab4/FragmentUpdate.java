package com.example.lab4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class FragmentUpdate extends Fragment {
    private NoteDataSource dataSource;
    private EditText noteIdEditText;
    private EditText newDescriptionEditText;
    private Button updateButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        noteIdEditText = view.findViewById(R.id.noteIdEditText);
        newDescriptionEditText = view.findViewById(R.id.newDescriptionEditText);
        updateButton = view.findViewById(R.id.updateButton);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noteIdStr = noteIdEditText.getText().toString();
                String newDescription = newDescriptionEditText.getText().toString();
                if (!noteIdStr.isEmpty() && !newDescription.isEmpty()) {
                    long noteId = Long.parseLong(noteIdStr);
                    dataSource = new NoteDataSource(getContext());
                    dataSource.open();
                    dataSource.updateNote(noteId, newDescription);
                    dataSource.close();
                    // Обновление списка заметок, если необходимо
                }
            }
        });

        return view;
    }
}
