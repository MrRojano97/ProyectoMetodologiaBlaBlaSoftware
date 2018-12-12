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
    static ArrayList<Carrera> carreras=new ArrayList<>();
    static ArrayList<Sala> salas=new ArrayList<>();;
    static ArrayList<Profesor> profesores=new ArrayList<>();;
    static ArrayList<Horario> horarios=new ArrayList<>();;
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
        salas.add(sala);
    }
    // PROFESOR //
     public static void addProfesor(String nombre){
        profesor=new Profesor();
        profesor.setNombre(nombre);
        profesores.add(profesor);
    }

     // Carrera //
     public static void addCarrera(String nombre){
        carrera=new Carrera();
        carrera.setNombre(nombre);
        carreras.add(carrera);
    }
    // Horario //
    public static void addHorario(int h_inicio,int m_inicio, int h_termino, int m_termino){
        horario=new Horario();
        horario.setHoraInicio(h_inicio, m_inicio);
        horario.setHoraTermino(h_termino, m_termino);
        horarios.add(horario);
    }
    
}
