package com.moesystems.notas.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.moesystems.notas.DB.DBHelper;
import com.moesystems.notas.Data.Student;
import com.moesystems.notas.R;


public class AddFragment extends Fragment {
    EditText nombre,carne;
    Button btnSave;


    public AddFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DBHelper.getInstance(getContext());
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        nombre = view.findViewById(R.id.txt_name);
        carne =  view.findViewById(R.id.txt_carne);
        btnSave = view.findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String carnet = carne.getText().toString();
                String nombres = nombre.getText().toString();
                String nota = "";
                boolean flag = DBHelper.myDB.addStudent(new Student(
                        carnet,
                        nombres,nota
                ));
                if (flag){
                    Log.d("mensaje",nombre.getText().toString());
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }




}
