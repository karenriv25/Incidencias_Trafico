package com.example.loginregistrer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Agregar extends AppCompatActivity {

    EditText txt_Direccion, txt_Distrito, txt_Descripcion;
    Button btn_Insertar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        txt_Direccion=findViewById(R.id.txtdireccion);
        txt_Distrito=findViewById(R.id.txtdistrito);
        txt_Descripcion=findViewById(R.id.txtdescripcion);
        btn_Insertar=findViewById(R.id.btnagregar);

        btn_Insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertarDatos();
            }
        });
    }

    private void insertarDatos() {
        final String direccion =txt_Direccion.getText().toString().trim();
        final String distrito =txt_Distrito.getText().toString().trim();
        final String descripcion =txt_Descripcion.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando");

        if (direccion.isEmpty()){
            Toast.makeText(this, "Ingrese direccion", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (distrito.isEmpty()){
            Toast.makeText(this, "Ingrese distrito", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (descripcion.isEmpty()){
            Toast.makeText(this, "Ingrese descripcion", Toast.LENGTH_SHORT).show();
            return;
        }else{
            StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.0.3/LoginRegister/insertar.php", new Response.Listener<String>(){
                @Override
                public void onResponse(String response){
                    if(response.equalsIgnoreCase("datos insertados")){
                        Toast.makeText(Agregar.this,"datos insertados",Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }else{
                        Toast.makeText(Agregar.this, response, Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }
            }, new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){
                    Toast.makeText(Agregar.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws  AuthFailureError{
                    Map<String,String> params = new HashMap<>();
                    params.put("Direccion", direccion);
                    params.put("Distrito", distrito);
                    params.put("Descripcion", descripcion);
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(Agregar.this);
            requestQueue.add(request);
        }
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}