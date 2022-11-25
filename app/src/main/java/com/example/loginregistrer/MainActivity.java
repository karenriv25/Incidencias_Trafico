package com.example.loginregistrer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Adapter adapter;

    public static ArrayList<Incidente>incidentesArraylist = new ArrayList<>();
    String url="http://192.168.0.3/LoginRegister/mostrar.php";
    Incidente incidente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listMostrar);
        adapter = new Adapter(this, incidentesArraylist);
        listView.setAdapter((ListAdapter) adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view ,final int position,long id){
                AlertDialog.Builder builder= new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog =  new ProgressDialog(view.getContext());

                CharSequence[] dialogoItem = {"Ver datos", "Editar datos", "Eliminar datos"};
                builder.setTitle(incidentesArraylist.get(position).getDireccion());
                builder.setItems(dialogoItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                startActivity(new Intent(getApplicationContext(), Detalles.class).putExtra("position", position));
                                break;
                            case 1:
                                startActivity(new Intent(getApplicationContext(), Editar.class).putExtra("position", position));
                                break;
                            case 2:
                                EliminarDatos(incidentesArraylist.get(position).getId());
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ListarDatos();
    }

    private void ListarDatos() {
        StringRequest request =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                incidentesArraylist.clear();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String exito = jsonObject.getString("exito");
                    JSONArray jsonArray = jsonObject.getJSONArray("datos");
                    if (exito.equals("1")) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String direccion = object.getString("Direccion");
                            String distrito = object.getString("Distrito");
                            String descripcion = object.getString("Descripcion");

                            incidente = new Incidente(id, direccion, distrito, descripcion);
                            incidentesArraylist.add(incidente);
                            adapter.notifyDataSetChanged();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void Agregar (View view){
        startActivity(new Intent(getApplicationContext(),Agregar.class));
    }

    private void EliminarDatos(String id) {
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.0.3/LoginRegister/eliminar.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equalsIgnoreCase("Datos eliminados")){
                    Toast.makeText( MainActivity.this,"Eliminado", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }else{
                    Toast.makeText( MainActivity.this,"No se pudo eliminar", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText( MainActivity.this,"Error", Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params = new HashMap<>();
                params.put("id", id);
                return super.getParams();
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}