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
public class Carrera{
    private String nombre;//nombre de la carrera
    private ArrayList<String> cursos=new ArrayList<>();;//cursos de la carrera
    public Carrera(String nombre){
        this.nombre=nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void addCurso(String curso){
        cursos.add(curso);
    }
    public void eliminarCurso(String curso) {
        if(cursos.contains(curso)){
             cursos.remove(curso);
        }
    }
    public ArrayList getCursos(){
        ArrayList<String> c=new ArrayList<>();
        for (int x=0; x<this.cursos.size();x++) {
            c.add(this.cursos.get(x));
        }
        return c;
    }
    public void mostrarInfo(){
        
    }

}
