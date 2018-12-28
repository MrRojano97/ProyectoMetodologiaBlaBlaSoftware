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
public class Carrera implements cambios{
    String nombre;//nombre de la carrera
    ArrayList<Curso> cursos=new ArrayList<>();;//cursos de la carrera
    public Carrera(String nombre){
        this.nombre=nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void addCurso(Curso curso){
        cursos.add(curso);
    }

    @Override
    public Curso modificarCurso(Curso c, String n, Horario h, Profesor p) {
        c.setHorario(h);
        c.setNombre(n);
        c.setProfesor(p);
        return c;
    }

    @Override
    public void eliminarCurso(Curso c) {
       cursos.remove(c);
    }
    
}
