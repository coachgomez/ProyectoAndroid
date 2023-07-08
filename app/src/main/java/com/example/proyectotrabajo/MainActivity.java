package com.example.proyectotrabajo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.mytoolbar));

        tableLayout = findViewById(R.id.tableLayout);

        // Generar el horario académico
        generarHorarioAcademico();
    }

    private void generarHorarioAcademico() {
        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        String[] horasClases = {"8:00 - 9:00", "9:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00"};

        // Crear la fila de encabezado de días de la semana
        TableRow encabezadoDias = new TableRow(this);
        encabezadoDias.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        for (String dia : diasSemana) {
            TextView textViewDia = new TextView(this);
            textViewDia.setText(dia);
            textViewDia.setTypeface(null, Typeface.BOLD);
            textViewDia.setGravity(Gravity.CENTER);
            textViewDia.setPadding(16, 16, 16, 16);

            encabezadoDias.addView(textViewDia);
        }

        tableLayout.addView(encabezadoDias);

        // Crear las filas de horas de clases y asignaturas
        for (String horaClase : horasClases) {
            TableRow filaHoraClase = new TableRow(this);
            filaHoraClase.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            for (String dia : diasSemana) {
                TextView textViewAsignatura = new TextView(this);
                textViewAsignatura.setText(""); // Agrega aquí el nombre de la asignatura correspondiente
                textViewAsignatura.setGravity(Gravity.CENTER);
                textViewAsignatura.setPadding(16, 16, 16, 16);

                filaHoraClase.addView(textViewAsignatura);
            }

            TextView textViewHoraClase = new TextView(this);
            textViewHoraClase.setText(horaClase);
            textViewHoraClase.setTypeface(null, Typeface.BOLD);
            textViewHoraClase.setGravity(Gravity.CENTER);
            textViewHoraClase.setPadding(16, 16, 16, 16);

            filaHoraClase.addView(textViewHoraClase);

            tableLayout.addView(filaHoraClase);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        setTitle("Inicio");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_itemhome) {
            Toast.makeText(MainActivity.this, "Estas en el Inicio", Toast.LENGTH_SHORT).show();
            return true;}
        else if (item.getItemId() == R.id.menu_item1) {
            Intent i1 = new Intent(MainActivity.this, newEvento.class);
            startActivity(i1);
            return true;
        } else if (item.getItemId() == R.id.menu_item2) {
            Intent i1 = new Intent(MainActivity.this, configurar.class);
            startActivity(i1);
            return true;
        } else if (item.getItemId() == R.id.menu_item3) {
            Intent i1 = new Intent(MainActivity.this, login.class);
            startActivity(i1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
