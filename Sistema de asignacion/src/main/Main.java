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
        
        // CREACION DE SALA A MODO DE PRUEBA CON SU RESPECTIVO HORARIO (VACIO)
        Sala sala1=new Sala("1");
        Horario horario1=new Horario();
        horario1.crearSemana();
        sala1.planificacionSemanal=horario1;
        System.out.println("Numero sala1: "+sala1.numero);
        
        //MODIFICACION DE SALA A MODO DE PRUEBA (Se modifica el numero y su planificacion)
        sala1.setNumero("5");
        Horario horario2=new Horario();
        horario2.crearSemana();
        sala1.planificacionSemanal=horario2;
        
        salasDisponibles.add(sala1);
        
        //ELIMINACION DE SALA (al ser la unica tiene indice 0)
        salasDisponibles.remove(0);
        
        
    }
     public static void addCurso(String nombre){
        curso=new Curso();
        curso.setNombre(nombre);
        cursos.add(curso);
    }
    // Sala  //
     
    public static void addSala(String numero){
        sala=new Sala(numero);
        salasDisponibles.add(sala);
    }
    public static void delSala(String numero){
        for(int i=0;i< salasDisponibles.size();i++){
            if(salasDisponibles.get(i).getNumero().equals(numero)){
                salasDisponibles.remove(i);
                i= salasDisponibles.size();
            }
        }
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
