package com.example.proyectotrabajo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyectotrabajo.eventoAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class configurar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar);
        setSupportActionBar(findViewById(R.id.mytoolbar));

        List<Evento> eventosList = new ArrayList<>();
        eventosList.add(new Evento("tarea 1", "algoritmos"));
        eventosList.add(new Evento("tarea 2", "algoritmos"));
        eventosList.add(new Evento("tarea 3", "algoritmos"));
        eventosList.add(new Evento("tarea 4", "algoritmos"));


        RecyclerView myRecycler = findViewById(R.id.recyclerViewEventos);
        eventoAdapter myAdapter = new eventoAdapter(eventosList);
        myRecycler.setLayoutManager(new LinearLayoutManager(this));
        myRecycler.setAdapter(myAdapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        setTitle("Configurar");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_itemhome) {
            Intent i1 = new Intent(configurar.this, MainActivity.class);
            startActivity(i1);
            return true;
        } else if (item.getItemId() == R.id.menu_item1) {
            Intent i1 = new Intent(configurar.this, newEvento.class);
            startActivity(i1);
            return true;
        } else if (item.getItemId() == R.id.menu_item2) {
            Toast.makeText(configurar.this, "Estas en Configuración", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.menu_item3) {
            Intent i1 = new Intent(configurar.this, login.class);
            startActivity(i1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
