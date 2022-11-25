package com.example.loginregistrer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Detalles extends AppCompatActivity {

    TextView tv1,tv2,tv3;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        tv1 = findViewById(R.id.tvdireccion);
        tv2 = findViewById(R.id.tvdistrito);
        tv3 = findViewById(R.id.tvdescripcion);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        tv1.setText( "Direccion"+ MainActivity.incidentesArraylist.get(position).getDireccion());
        tv2.setText( "Distrito"+ MainActivity.incidentesArraylist.get(position).getDistrito());
        tv3.setText( "Descripcion"+ MainActivity.incidentesArraylist.get(position).getDescripcion());
    }
}