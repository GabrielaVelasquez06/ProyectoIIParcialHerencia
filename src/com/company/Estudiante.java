package com.company;

public class Estudiante extends Persona{

    protected int numCuenta;
    protected boolean esOyente;

    public Estudiante() {
        this.numCuenta = 0;
        this.esOyente = false;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public boolean EsOyente() {
        return esOyente;
    }

    public void setEsOyente(boolean esOyente) {
        this.esOyente = esOyente;
    }
}
