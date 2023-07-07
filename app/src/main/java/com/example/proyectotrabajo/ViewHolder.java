package com.example.proyectotrabajo;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView tvtitulo;
    public TextView tvCurso;
    public ImageButton buttonConfig;
    public ImageButton buttonDelete;

    public ViewHolder(View itemView) {
        super(itemView);
        tvtitulo = itemView.findViewById(R.id.tvtitulo);
        tvCurso = itemView.findViewById(R.id.tvCurso);
        buttonConfig = itemView.findViewById(R.id.ButtonConfig);
        buttonDelete = itemView.findViewById(R.id.ButtonDelete);
    }
}
