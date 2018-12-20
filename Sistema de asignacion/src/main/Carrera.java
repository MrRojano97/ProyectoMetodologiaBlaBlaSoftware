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
public class Carrera {
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
    
}
