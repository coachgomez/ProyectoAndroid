package com.example.proyectotrabajo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.mytoolbar));
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
