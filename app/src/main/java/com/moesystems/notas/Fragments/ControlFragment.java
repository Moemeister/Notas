package com.moesystems.notas.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.moesystems.notas.DB.DBHelper;
import com.moesystems.notas.Data.Student;
import com.moesystems.notas.R;



public class ControlFragment extends Fragment {
    Button buscar,mod,clean,delete;
    TextView carnet,nombre,nota;

    public ControlFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_control, container, false);
        DBHelper.getInstance(getContext());


        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        carnet =  view.findViewById(R.id.txt_carneR);
        nombre = view.findViewById(R.id.txt_nameR);
        nota =  view.findViewById(R.id.txt_nota);
        buscar =  view.findViewById(R.id.btn_search);
        mod =  view.findViewById(R.id.btn_mod);
        delete =  view.findViewById(R.id.btn_del);
        clean = view.findViewById(R.id.btn_clean);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student a = DBHelper.myDB.findStudent(carnet.getText().toString());

                if (a == null){
                    Toast.makeText(getContext(), "El usuario no fue encontrado", Toast.LENGTH_SHORT).show();

                }
                else{
                    nota.setText(a.getNota());
                    nombre.setText(a.getName());
                }
            }
        });
    }
}
