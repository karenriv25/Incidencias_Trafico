package com.example.loginregistrer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SingUp extends AppCompatActivity {

    TextInputEditText textInputEditTextFullname, textInputEditTextApellido, textInputEditTextCelular, textInputEditTextUsername, textInputEditTextPassword, textInputEditTextEmail, textInputEditTextDistrito;
    Button buttonSignUp;
    TextView textViewLogin;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        textInputEditTextFullname = findViewById(R.id.fullname);
        textInputEditTextApellido = findViewById(R.id.apellido);
        textInputEditTextCelular = findViewById(R.id.celular);
        textInputEditTextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        textInputEditTextEmail = findViewById(R.id.email);
        textInputEditTextDistrito = findViewById(R.id.distrito);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        textViewLogin = findViewById(R.id.loginText);
        progressBar = findViewById(R.id.progress);

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullname, apellido, celular, username, password, email, distrito;
                fullname = String.valueOf(textInputEditTextFullname.getText());
                apellido = String.valueOf(textInputEditTextApellido.getText());
                celular = String.valueOf(textInputEditTextCelular.getText());
                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());
                email = String.valueOf(textInputEditTextEmail.getText());
                distrito = String.valueOf(textInputEditTextDistrito.getText());

                if (!fullname.equals("") && !username.equals("") && !password.equals("") && !email.equals("")) {

                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            String[] field = new String[7];
                            field[0] = "Nombre";
                            field[1] = "Apellido";
                            field[2] = "Celular";
                            field[3] = "Username";
                            field[4] = "Password";
                            field[5] = "CorreElectronico";
                            field[6] = "CodDistrito";
                            String[] data = new String[7];
                            data[0] = fullname;
                            data[1] = apellido;
                            data[2] = celular;
                            data[3] = username;
                            data[4] = password;
                            data[5] = email;
                            data[6] = distrito;
                            PutData putData = new PutData("http://192.168.22.134/LoginRegister/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success")){
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), Login.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(), "All fields required", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}