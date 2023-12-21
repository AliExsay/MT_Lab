package com.example.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class FragmentShow extends Fragment {
    MyListAdapter listAdapter;

    MainActivity ctx;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fshow, null);
        listAdapter = new MyListAdapter(ctx, ctx.getAllId(), ctx.getData());
        ctx.listView = view.findViewById(R.id.lvMain);
        ctx.listView.setAdapter(listAdapter);
        return view;
    }

    public FragmentShow(MainActivity context)
    {
        ctx = context;
    }
}
