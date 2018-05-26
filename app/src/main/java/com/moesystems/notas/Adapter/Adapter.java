package com.moesystems.notas.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moesystems.notas.Data.Student;
import com.moesystems.notas.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private View view;
    private static Context context;
    ArrayList<Student> a;

    public Adapter(ArrayList<Student> a,Context context) {
        this.a = a;
        this.context = context;
    }
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        view = inflater.inflate(R.layout.cardview_activity,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.carnet.setText(a.get(position).getCarne());
        holder.nota.setText(a.get(position).getNota()+"");
        holder.nombre.setText(a.get(position).getName());
    }
    @Override
    public int getItemCount() {
        return a.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView carnet, nombre, nota;

        public ViewHolder(final View itemView) {
            super(itemView);
            carnet = itemView.findViewById(R.id.txtcarneS);
            nota = itemView.findViewById(R.id.txtnota);
            nombre = itemView.findViewById(R.id.txtnameS);
        }
    }
}
