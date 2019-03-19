package com.company;

import java.util.ArrayList;

public class Maestro extends Persona{

    protected ArrayList<Clase> clases;
    protected int numEmpleado;
    protected boolean esAsistente;

    public Maestro() {

        esAsistente = false;
        clases = new ArrayList<>();

    }

    public ArrayList<Clase> getClases() {
        return clases;
    }

    public void setClases(ArrayList<Clase> clases) {
        this.clases = clases;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public boolean EsAsistente() {
        return esAsistente;
    }

    public void setEsAsistente(boolean esAsistente) {
        this.esAsistente = esAsistente;
    }
}
