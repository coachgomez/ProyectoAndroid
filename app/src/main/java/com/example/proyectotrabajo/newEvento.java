package com.example.proyectotrabajo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class newEvento extends AppCompatActivity {

    // -----------------------------------------------------------------
    private EditText eventoEditText;
    private EditText cursoEditText;
    private String nombreEvento;
    private String nombreCurso;
    private Date fechaSelect;
    private Time horaSelect;
    private ImageButton Buttonfecha;
    private ImageButton ButtonHora;
    private TextView TVfecha;
    private TextView TVhora;
    private Button guardarButton;
    private int dia, mes, ano, hora, minutos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_evento);
        setSupportActionBar(findViewById(R.id.mytoolbar));

        String nombreEvento = getIntent().getStringExtra("nombreEvento");
        String nombreCurso = getIntent().getStringExtra("nombreCurso");
        EditText eventoEditText = findViewById(R.id.eventoEditText);
        EditText cursoEditText = findViewById(R.id.cursoEditText);


        Buttonfecha = findViewById(R.id.ib_dia);
        ButtonHora = findViewById(R.id.ib_hora);
        TVfecha = findViewById(R.id.tv_dia);
        TVhora = findViewById(R.id.tv_hora);
        guardarButton = findViewById(R.id.guardarButton);

        Buttonfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int dia = c.get(Calendar.DAY_OF_MONTH);
                int mes = c.get(Calendar.MONTH);
                int ano = c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(newEvento.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                TVfecha.setText(dayOfMonth + " / " + (month + 1) + " / " + year);
                            }
                        }, ano, mes, dia);

                datePickerDialog.show();
                Toast.makeText(newEvento.this, "Seleccionar día", Toast.LENGTH_SHORT).show();
            }
        });

        ButtonHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int hora = c.get(Calendar.HOUR_OF_DAY);
                int minutos = c.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(newEvento.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                TVhora.setText(hourOfDay + ":" + minute);
                            }
                        }, hora, minutos, false);
                timePickerDialog.show();
                Toast.makeText(newEvento.this, "Seleccione la hora", Toast.LENGTH_SHORT).show();
            }
        });


        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreEvento = eventoEditText.getText().toString();
                String nombreCurso = cursoEditText.getText().toString();
                String fecha = TVfecha.getText().toString();
                String hora = TVhora.getText().toString();


                if (nombreEvento.isEmpty() || nombreCurso.isEmpty()) {
                    Toast.makeText(newEvento.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Crear el Intent para ir al otro Activity
                    Intent intent = new Intent(newEvento.this, configurar.class);
                    intent.putExtra("nombreEvento", nombreEvento);
                    intent.putExtra("nombreCurso", nombreCurso);
                    intent.putExtra("fecha", fecha);
                    intent.putExtra("hora", hora);
                    // Iniciar el otro Activity
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        setTitle("Nuevo Evento");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_itemhome) {
            Intent i1 = new Intent(newEvento.this, MainActivity.class);
            startActivity(i1);
            return true;}
        else if (item.getItemId() == R.id.menu_item1) {
            Toast.makeText(newEvento.this, "Estas en el nuevo evento", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.menu_item2) {
            Intent i1 = new Intent(newEvento.this, configurar.class);
            startActivity(i1);
            return true;
        } else if (item.getItemId() == R.id.menu_item3) {
            Intent i1 = new Intent(newEvento.this, login.class);
            startActivity(i1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}



