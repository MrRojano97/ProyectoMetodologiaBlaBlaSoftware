/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;

/**
 *
 * @author Javiera
 */
public class Main {
    static ArrayList<Semestre> semestres=new ArrayList<>();
    static ArrayList<Carrera> carrerasQueSeImparten=new ArrayList<>();
    static ArrayList<Sala> salasDisponibles=new ArrayList<>();;
    static ArrayList<Profesor> profesoresContratados=new ArrayList<>();;
    static ArrayList<Horario> horariosDisponibles=new ArrayList<>();;
    static ArrayList<Curso> cursos=new ArrayList<>();;//cursos de la carrera
    static Carrera carrera;
    static Curso curso;
    static Horario horario;
    static Profesor profesor;
    static Sala sala;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
     public static void addCurso(String nombre){
        curso=new Curso();
        curso.setNombre(nombre);
        cursos.add(curso);
    }
    // Sala  //
    public static void addSala(String numero){
        sala=new Sala();
        sala.setNumero(numero);
        salasDisponibles.add(sala);
    }
    // PROFESOR //
     public static void addProfesor(String nombre){
        profesor=new Profesor();
        profesor.setNombre(nombre);
        profesoresContratados.add(profesor);
    }

     // Carrera //
     public static void addCarrera(String nombre){
        carrera=new Carrera();
        carrera.setNombre(nombre);
        carrerasQueSeImparten.add(carrera);
    }
    
    
}
