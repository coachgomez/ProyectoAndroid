package com.example.proyectotrabajo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Obtener referencias a los elementos de la vista
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        // Agregar listener al botón de inicio de sesión
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Realizar la validación de las credenciales
                if (isValidCredentials(username, password)) {
                    // Inicio de sesión exitoso, realizar las acciones necesarias
                    Toast.makeText(login.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                    // Aquí puedes redirigir a la siguiente actividad o realizar otras acciones
                } else {
                    // Credenciales inválidas, mostrar mensaje de error
                    Toast.makeText(login.this, "Credenciales inválidas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean isValidCredentials(String username, String password) {
        // Aquí puedes realizar la validación con las credenciales almacenadas
        // Por ejemplo, comparar con los valores predefinidos o consultar una base de datos

        // Devolver true si las credenciales son válidas, false en caso contrario
        return username.equals("usuario") && password.equals("contraseña");
    }
}