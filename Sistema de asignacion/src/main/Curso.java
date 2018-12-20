/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Javiera
 */
public class Curso {
    String nombre;
    Horario horario;
    Profesor profesor=null;

    public Curso(String nombre) {
        this.nombre = nombre;
        this.horario=new Horario();
    }
    
    public String getNombre() {
        
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    public void deleteProfesor() {
        this.profesor = null;
    }
    public void visualizarDatos(){
        System.out.println("\n Curso: "+this.nombre+"\n Profesor: "+profesor.getNombre());
    }
    
}
