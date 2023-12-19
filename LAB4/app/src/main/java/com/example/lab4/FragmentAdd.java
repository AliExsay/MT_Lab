package com.example.lab4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class FragmentAdd extends Fragment {
    private NoteDataSource dataSource;
    private EditText descriptionEditText;
    private Button addButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        descriptionEditText = view.findViewById(R.id.descriptionEditText);
        addButton = view.findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = descriptionEditText.getText().toString();
                if (!description.isEmpty()) {
                    dataSource = new NoteDataSource(getContext());
                    dataSource.open();
                    dataSource.addNote(description);
                    dataSource.close();
                    // Обновление списка заметок, если необходимо
                    FragmentShow fragmentShow = (FragmentShow) getParentFragmentManager().findFragmentByTag("android:switcher:" + R.id.pager + ":" + 0);
                    if (fragmentShow != null) {
                        fragmentShow.updateNotesList();
                }
                }
            }
        });

        return view;
    }
}
