/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author FranciscoGP
 * @author Javiera
 */
public class Gestion {
    ArrayList<Semestre> semestres=new ArrayList<>();
    ArrayList<Carrera> carrerasQueSeImparten=new ArrayList<>();
    ArrayList<Sala> salasDisponibles=new ArrayList<>();;
    ArrayList<Profesor> profesoresContratados=new ArrayList<>();;
    ArrayList<Horario> horariosDisponibles=new ArrayList<>();;
    ArrayList<Curso> cursos=new ArrayList<>();;//cursos de la carrera
    Carrera carrera;
    Curso curso;
    Horario horario;
    Profesor profesor;
    Sala sala;
    
    public Gestion(){
        this.inicio();
    }
    /**
     * Metodo creado con la finalidad de gestionare 
     * metodos y/o instancias de variables contenidos la calse
     */
    public void inicio(){
        // INSTANCIAMIENTO DE UN NUEVO PROFESOR //
        //creacion de un profesor con sus datos basicos
        this.crearProfesor("Obi-Wan Kenobi","quelafuerzateacompañe@gmail.com","+5697263847");
        profesor.setCorreoInstitucional("OWKenobi@alianza.com");
        this.addProfesor(profesor);
        
        this.crearProfesor(" Chewbacca", "aararrggwwwww@gmail.com","+56926361781");
        profesor.setCorreoInstitucional("Chew@alianza.com");
        this.addProfesor(profesor);
        
        //muestra en consola los profesores contenidos en la lista
        this.mostrarListaDeProfesores();
        
        
    
    }
    /**
     * Metodo encargado de mostrar por consola
     * los profesores contenidos en la lista profesoresContratados
     */
    public void mostrarListaDeProfesores(){
        Iterator<Profesor> it;
        Profesor p;
        it = this.profesoresContratados.iterator();
        System.out.println("Listado de profesores contratados ");
        while (it.hasNext() ) {
                p = it.next();
                System.out.println("\n Nombre: "+p.getNombre()+"\n Correo: "+p.getCorreoPersonal()+"\n Correo institucional: "+p.getCorreoInstitucional());
                System.out.println(" Numero de contato: "+p.getNumeroContacto()+"\n Fecha/Hora de contratacion: "+p.getFechaContratacion());
            }
    }
    // CURSO //
     public void addCurso(String nombre){
        curso=new Curso();
        curso.setNombre(nombre);
        cursos.add(curso);
    }
    // SALA  //
    public void addSala(String numero){
        sala=new Sala();
        sala.setNumero(numero);
        salasDisponibles.add(sala);
    }
    // PROFESOR //
    /**
     * Metodo encargado de crear un nuevo profesor con sus datos basicos
     * @param nombre nombre del profesor a crear
     * @param correoP correo personal del profesor a crear
     */
    public void crearProfesor(String nombre, String correoP, String numC){
        this.profesor=new Profesor(nombre,correoP,numC);
        
    }
     public void addProfesor(Profesor p){
        this.profesoresContratados.add(p);
    }

     // CARRERA //
     public void addCarrera(String nombre){
        carrera=new Carrera();
        carrera.setNombre(nombre);
        carrerasQueSeImparten.add(carrera);
    }
}
