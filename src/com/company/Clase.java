package com.company;

import java.util.ArrayList;

public class Clase  {

    protected Maestro maestro;
    protected ArrayList<Estudiante> estudiantes;
    protected int uv;
    protected String horario;
    protected String nombre;
    protected ArrayList<Maestro> asistente;

    public ArrayList<Maestro>  getAsistente() {
        return asistente;
    }

    public void setAsistente(ArrayList<Maestro> asistente) {
        this.asistente = asistente;
    }

    public Clase() {
        this.maestro = null;
        this.estudiantes = new ArrayList<>();
        this.uv = 0;
        this.horario = "";
        this.nombre = "";
        this.asistente= new ArrayList<>();
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public int getUv() {
        return uv;
    }

    public void setUv(int uv) {
        this.uv = uv;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
