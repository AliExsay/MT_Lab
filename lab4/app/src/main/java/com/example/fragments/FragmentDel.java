package com.example.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentDel extends Fragment {

    MainActivity ctx;

    @SuppressLint("MissingInflatedId")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fdel, null);
        ArrayList<Integer> ids = ctx.getAllId();
        ctx.IncButton = view.findViewById(R.id.IncButton);
        ctx.DecButton = view.findViewById(R.id.DecButton);
        ctx.IDtextview = view.findViewById(R.id.IDtextView);
        if (ids.size() == 0) ctx.IDtextview.setText("...");
        else ctx.IDtextview.setText(String.valueOf(ids.get(0)));
        return view;
    }

    public FragmentDel(MainActivity context)
    {
        ctx = context;
    }

}
