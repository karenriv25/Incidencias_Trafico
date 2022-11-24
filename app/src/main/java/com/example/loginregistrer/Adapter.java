package com.example.loginregistrer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<Incidente> {
    Context context;
    List<Incidente> arrayIncidente;

    public Adapter(@NonNull Context context, List<Incidente>arrayIncidente) {
        super(context, R.layout.list_incidentes,arrayIncidente);
        this.context=context;
        this.arrayIncidente=arrayIncidente;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_incidentes,null,true);

        TextView txt_Id = view.findViewById(R.id.txtId);
        TextView txt_Direccion = view.findViewById(R.id.txtDireccion);

        return view;
    }
}
