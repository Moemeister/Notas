package com.moesystems.notas.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moesystems.notas.Adapter.Adapter;
import com.moesystems.notas.DB.DBHelper;
import com.moesystems.notas.Data.Student;
import com.moesystems.notas.R;

import java.util.ArrayList;


public class ShowFragment extends Fragment {

    RecyclerView rv;
    LinearLayoutManager llm;
    ArrayList<Student> alumno;
    Adapter adapter;
    public ShowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show, container, false);

        rv = view.findViewById(R.id.rv);
        alumno = DBHelper.myDB.getStudent();

        adapter = new Adapter(alumno,getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);


        return view;
    }


}
