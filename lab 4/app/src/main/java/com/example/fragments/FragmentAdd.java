package com.example.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class FragmentAdd extends Fragment {
    MainActivity ctx;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fadd, null);
        ctx.editText = view.findViewById(R.id.editViewAdd);
        return view;
    }

    public FragmentAdd(MainActivity context)
    {
        ctx = context;
    }
}
