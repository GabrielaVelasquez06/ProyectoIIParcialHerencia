package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Maestro> maestros = new ArrayList<>();
    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static ArrayList<Clase> clases = new ArrayList<>();

    static Scanner ent = new Scanner(System.in);

    public static void main(String[] args) {

        int op = 0;
        while (op != 5){
            System.out.println("|-------------------------------------------|");
            System.out.println("|\t \t \t \t BIENVENIDO                 |");
            System.out.println("|\t  UNIVERSIDAD JOSE CECILIO DEL VALLE    |");
            System.out.println("|\t\tDepartamento de Administracion      |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|\t\t\t QUE DESEA HACER?               |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|       \t1.... Clases                    |");
            System.out.println("|       \t2...  Maestros                  |");
            System.out.println("|       \t3.... Estudiantes               |");
            System.out.println("|       \t4.... Informe                   |");
            System.out.println("|       \t5.... Salir                     |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|           INGRESE UNA OPCION:             |");
            System.out.println("|-------------------------------------------|");

            op = ent.nextInt();

            switch (op){

                case 1:
                    menuClase();
                    break;

                case 2:

                    menuMaestro();
                    break;

                case 3:
                    menuEstudiantes();
                    break;


                case 4:

                    informe();

                    break;

            }

        }

    }

    private static void informe() {
        System.out.println("*-------------------------------------------------------------------*");
        System.out.println("|\t \t \t \t \t \t\t \t INFORME                            |");
        System.out.println("*-------------------------------------------------------------------*");
        for(Clase c: clases){
            System.out.println("|CLASE  : " + c.getNombre());
            System.out.println("|HORARIO: " + c.getHorario());
            if(c.getMaestro() != null){
                System.out.println("|MAESTRO: " + c.getMaestro().getNombre() + " " + c.getMaestro().getApellido());
            }else{
                System.out.println("Maestro: No Asignado");
            }
            for(Maestro asistente : c.getAsistente()){
                System.out.println("|ASISTENTE: " + asistente.getNombre() + " " + asistente.getApellido());
            }
            System.out.println("*-------------------------------------------------------------------*");
            System.out.println("|   ESTUDIANTE        |\t      No.CUENTA     |\t\t  OYENTE        |");
            System.out.println("*-------------------------------------------------------------------*");
            int contEst = 0;
            int contAsi = 0;
            for(Estudiante est: c.getEstudiantes()){
                System.out.print("|"+est.getNombre() + " " + est.getApellido() + "\t\t\t|" + est.getNumCuenta() + "|\t\t|");
                if(est.EsOyente()){
                    System.out.println("SI");
                    contAsi++;
                }else
                {
                    System.out.println("NO");
                    contEst++;
                }

            }
            System.out.println("*-------------------------------------------------------------------*");
            System.out.println("|\tESTUDIANTES: " + contEst + "\t |      OYENTES: " + contAsi + "\t\t|       ASISTENTES: " + c.getAsistente().size());
            System.out.println("*-------------------------------------------------------------------*");
            System.out.println("");

        }
    }

    private static void menuEstudiantes() {

        int op = 0;

        while (op != 4){
            System.out.println("|-------------------------------------------|");
            System.out.println("|\t\t\t QUE DESEA HACER?               |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|          1... Agregar Estudiante          |");
            System.out.println("|          2... Ver Estudiantes             |");
            System.out.println("|          3... Matricular Clases           |");
            System.out.println("|          4... Regresar                    |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|           INGRESE UNA OPCION:             |");
            System.out.println("|-------------------------------------------|");
            op = ent.nextInt();

            switch (op){

                case 1:

                    agregarEstudiante();
                    break;

                case 2:
                    verEstudiantes();
                    break;

                case 3:
                    matricularClase();
                    break;

            }

        }


    }

    private static void matricularClase() {
        System.out.println("|-------------------------------------------|");
        System.out.println("|             \t\tESTUDIANTES          |");
        System.out.println("|-------------------------------------------|");
        for(Estudiante est:estudiantes){
            System.out.println("" +
                    "|Nombre:" + est.getNombre()+""+ est.getApellido()+"\t |Numero Cuenta:"+ est.getNumCuenta());
        }

        System.out.println("Ingrese el numero de cuenta del estudiante:");
        int numC= ent.nextInt();
        Estudiante estu = null;
        for(Estudiante est:estudiantes){
            if(est.getNumCuenta()== numC){
                estu = est;
            }
        }

        if(estu == null){
            System.out.println("Estudiante no existe");
            return;
        }

        System.out.println("|-------------------------------------------|");
        System.out.println("|                  \t\tCLASES             |");
        System.out.println("|-------------------------------------------|");

        for (Clase c:clases){
            System.out.println(" NOMBRE DE LA CLASE:" + c.getNombre()+" HORARIO "+ c.getHorario()+" \t UNIDADES VALORATIVAS:"+ c.getUv());
        }

        System.out.println("INGRESE EL NOMBRE DE LA CLASE A LA CUAL LE QUIERE AGREGAR ESTUDIANTE:");
        String nomC;
        nomC = ent.next();

        Clase cm = null;
        for (Clase c:clases){
            if(c.getNombre().equalsIgnoreCase(nomC)){
                cm = c;
            }
        }
        if( cm == null){

            System.out.println("Clase NO EXISTENTE!");
            return;
        }

        cm.getEstudiantes().add(estu);
    }

    private static void verEstudiantes() {

        for(Estudiante est:estudiantes){
            System.out.println("NOMBRE:" + est.getNombre()+" "+ est.getApellido()+"\t NUMERO DE CUENTA:"+ est.getNumCuenta());
        }
    }

    private static void agregarEstudiante() {

        Estudiante nuevoEst = new Estudiante();

        System.out.println("INGRESE EL NOMBRE DEL ESTUDIANTE: ");
        nuevoEst.setNombre(ent.next());
        System.out.println("INGRESE EL APELLIDO DEL ESTUDIANTE:");
        nuevoEst.setApellido(ent.next());
        System.out.println("INGRESE EL ID DEL ESTUDIANTE:");
        nuevoEst.setIdentidad(ent.next());
        System.out.println("INGRESE EL NUMERO DE CUENTA DEL ESTUDIANTE:");
        nuevoEst.setNumCuenta(ent.nextInt());
        System.out.println(" INGRESE S ES OYENTE (S/N):");
        nuevoEst.setEsOyente(ent.next().equalsIgnoreCase("S"));

        estudiantes.add(nuevoEst);


    }

    private static void menuClase() {
        int op = 0;

        while (op != 5){
            System.out.println("\t");
            System.out.println("|-------------------------------------------|");
            System.out.println("|\t\t\t QUE DESEA AGREGAR?             |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|         1... Agregar Clases               |");
            System.out.println("|         2... Ver Clases                   |");
            System.out.println("|         3... Agregar Maestro              |");
            System.out.println("|         4... Agregar Asistente            |");
            System.out.println("|         5... Regresar                     |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|           INGRESE UNA OPCION:             |");
            System.out.println("|-------------------------------------------|");
            op = ent.nextInt();

            switch (op){

                case 1:

                    agregarClases();
                    break;

                case 2:
                    verClases();
                    break;

                case 3:
                  AgregarMaestroClase();
                    break;

                case 4:
                    AgregarAsistente();
            }

        }

    }

    private static void AgregarAsistente() {
        for (Clase c:clases){
            System.out.println(" NOMBRE CLASE:" + c.getNombre()+" HORARIO "+ c.getHorario()+" \t UNIDADES VALORATIVAS:"+ c.getUv());
        }
        System.out.println("INGRESE EL NOMBRE DE LA CLASE A LA CUAL LE QUIERE AGREGAR MAESTRO:");
        String nomC;
        nomC = ent.next();

        Clase cm = null;
        for (Clase c:clases){
            if(c.getNombre().equalsIgnoreCase(nomC)){
                cm = c;
            }
        }
        if( cm == null){

            System.out.println("Clase NO ENCONTRADA!");
            return;
        }

        if(cm.getAsistente().size()>= 3){
            System.out.println("******ESTA CLASE YA TIENE EL LIMITE DE ASISTENTES MAXIMOS******");
            return;
        }

        for (Maestro mast:maestros){
            if(mast.EsAsistente()){
                System.out.println("Nombre:" + mast.getNombre()+" "+ mast.getApellido()+"\t Numero Empleado:"+ mast.getNumEmpleado());
            }
        }


        System.out.println("INGRESE EL NUMERO DE EMPLEADO DE ASISTENTE A ASIGNAR :");
        int num = ent.nextInt();

        Maestro selec = null;
        for (Maestro mast:maestros) {

            if(mast.getNumEmpleado()== num && mast.EsAsistente()){
                selec = mast;
            }
        }
        if(selec== null){

            System.out.println("NO SE ENCONTRO EL ASISTENTE");
            return;
        }

        cm.getAsistente().add(selec);

    }

    private static void AgregarMaestroClase() {
        for (Clase c:clases){
            System.out.println(" NOMBRE DE CLASE:" + c.getNombre()+" HORARIO "+ c.getHorario()+" \t UNIDADES VALORATIVAS:"+ c.getUv());
        }
        System.out.println("INGRESE EL NOMBRE DE LA CLASE A LA CUAL LE AGREGARA MAESTRO:");
        String nomC;
        nomC = ent.next();

        Clase cm = null;
        for (Clase c:clases){
            if(c.getNombre().equalsIgnoreCase(nomC)){
                cm = c;
            }
        }
        if( cm == null){

            System.out.println("CLASE NO ENCONTRADA!");
            return;
        }

        if(cm.getMaestro() != null){
            System.out.println("******ESTA CLASE YA TIENE MESTRO ASIGNADO******");
            return;
        }

        System.out.println("------------ MAESTROS DISPONIBLE--------------");
        for (Maestro mast:maestros) {
            if (mast.EsAsistente() == false) {
                System.out.println("Nombre:" + mast.getNombre() + " " + mast.getApellido() + "\t Numero Empleado:" + mast.getNumEmpleado());
            }
        }

        System.out.println("INGRESE EL REGISTRO DE EMPLEDO A ASIGNAR MAESTRO :");
        int num = ent.nextInt();

        Maestro selec = null;
        for (Maestro mast:maestros) {

            if(mast.getNumEmpleado()== num){
                selec = mast;
            }
        }
        if(selec== null){

            System.out.println("NO SE ENCONTRADO EL MAESTRO");
            return;
        }
        cm.setMaestro(selec);
    }
    private static void verClases() {
        for (Clase c:clases){
            System.out.println(" NOMBRE CLASE:" + c.getNombre()+" HORARIO "+ c.getHorario()+" \t UNIDADES CALORATIVAS:"+ c.getUv());
        }
    }
    private static void agregarClases() {

        Clase nuevaC = new Clase();
        System.out.println(" INGRESE EL NOMBRE DE LA CLASE:");
        nuevaC.setNombre(ent.next());
        System.out.println(" INGRESE EL HORARIO DE LA CLASE:");
        nuevaC.setHorario(ent.next());
        System.out.println(" INGRESE EL NUMERO DE UNIDADES VALORATIVAS:");
        nuevaC.setUv(ent.nextInt());

        clases.add(nuevaC);
    }
    private static void menuMaestro() {

        int op = 0;

        while (op != 3){
            System.out.println("\t");
            System.out.println("|-------------------------------------------|");
            System.out.println("|\t\t\t QUE DESEA AGREGAR?             |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|         1... Agregar Maestro              |");
            System.out.println("|         2... Ver Maestros                 |");
            System.out.println("|         3... Regresar                     |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|           INGRESE UNA OPCION:             |");
            System.out.println("|-------------------------------------------|");

            op = ent.nextInt();

            switch (op){

                case 1:

                   agregarMaestro();
                    break;

                case 2:
                     verMaestros();
                    break;

            }

        }
    }
    private static void verMaestros() {

        for (Maestro mast:maestros){
            System.out.println("NOMBRE:" + mast.getNombre()+" "+ mast.getApellido()+"\t NUMERO DE EMPLEADO:"+ mast.getNumEmpleado());
        }
    }
    private static void agregarMaestro() {

        Maestro nuevoM = new Maestro();

        System.out.println(" INGRESE EL NOMBRE DEL MAESTRO:");
        nuevoM.setNombre(ent.next());
        System.out.println("INGRESE EL APELLIDO DEL MAESTRO:");
        nuevoM.setApellido(ent.next());
        System.out.println(" INGRESE EL ID DEL MAESTRO:");
        nuevoM.setIdentidad(ent.next());
        System.out.println(" INGRESE EL NUMERO DE REGISTRO DEL MAESTRO::");
        nuevoM.setNumEmpleado(ent.nextInt());
        System.out.println(" INGRESE SI ES ASISTENTE (S/N):");
        nuevoM.setEsAsistente(ent.next().equalsIgnoreCase("S"));

        maestros.add(nuevoM);

    }


}
