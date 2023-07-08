package com.example.proyectotrabajo;

public class Evento {
    private String Titulo;
    private String Curso;
    public Evento(String titulo, String curso) {
        this.Titulo = titulo;
        this.Curso = curso;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso = curso;
    }
}
