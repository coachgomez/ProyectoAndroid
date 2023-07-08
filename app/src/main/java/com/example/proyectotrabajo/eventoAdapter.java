package com.example.proyectotrabajo;

import android.content.Intent;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class eventoAdapter extends RecyclerView.Adapter<ViewHolder> {

    List<Evento> listaEventos;
    public eventoAdapter(List<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Evento evento = listaEventos.get(position);
        holder.tvtitulo.setText(evento.getTitulo());
        holder.tvCurso.setText(evento.getCurso());

        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtén la posición del evento en la lista
                int position = holder.getAdapterPosition();

                // Remueve el evento de la lista
                listaEventos.remove(position);

                // Notifica al adaptador que se ha eliminado un elemento en la posición
                notifyItemRemoved(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listaEventos.size();
    }
}
