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
   
public class Semestre {
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private ArrayList<String> carrerasImpartidas;
    private ArrayList<String> salasUtilizadas;
    private ArrayList<String> profesoresContratados;
    private ArrayList<String> cursosImpartidos;//cursos de la carrera

    public Semestre(String nombre, String fechaInicio, String fechaFin) 
    {
        this.nombre=nombre;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.carrerasImpartidas=new ArrayList<>();
        this.salasUtilizadas=new ArrayList<>();
        this.profesoresContratados=new ArrayList<>();
        this.cursosImpartidos=new ArrayList<>();
        
    }
    public String getNombre() 
    {
        return this.nombre;
    }

    public String getFechaInicio() 
    {
        return this.fechaInicio;
    }

    public String getFechaFin() 
    {
        return this.fechaFin;
    }
    //retorna array list con nombre de salas
    public ArrayList visualizarSalas()
    {
       ArrayList<String> s=new ArrayList<>();
       for(int x=0; x<this.salasUtilizadas.size();x++){
           s.add(this.salasUtilizadas.get(x));
       }
       return s;
    }
    
    public void agregarSala(String sala){
        //si la sala no eiste en el ArayList la agregamos
        if(!this.salasUtilizadas.contains(sala)) {
            this.salasUtilizadas.add(sala);
        } 
    }
    
    public void eliminarSala(String numeroSala)
    {
       if(this.salasUtilizadas.contains(numeroSala)) {
            this.salasUtilizadas.remove(numeroSala);
        } 
    }
     //retorna array list con nombres de profesores
     public ArrayList visulizarProfesores()
    {
       ArrayList<String> p=new ArrayList<>();
       for(int x=0; x<this.profesoresContratados.size();x++){
           p.add(this.profesoresContratados.get(x));
       }
       return p;
    }
    
    public void agregarProfesor(String profesor)
    {
       //si el profesor no eiste en el ArayList lo agregamos
        if(!this.profesoresContratados.contains(profesor)) {
            this.salasUtilizadas.add(profesor);
        } 
    }
    
    public void eliminarProfesor(String profesor)
    {
       //si el profesor  eiste en el ArayList lo eliminamos
        if(this.profesoresContratados.contains(profesor)) {
            this.salasUtilizadas.remove(profesor);
        } 
    }
    
    public ArrayList<String> visualizarCarreras()
    {
       ArrayList<String> c=new ArrayList<>();
       for(int x=0; x<this.carrerasImpartidas.size();x++){
           c.add(this.carrerasImpartidas.get(x));
       }
       return c;
    }
    
    public void agregarCarrera(String carrera)
    {
         //si el profesor no eiste en el ArayList lo agregamos
        if(this.carrerasImpartidas.contains(carrera)) {
            this.carrerasImpartidas.add(carrera);
        } 
    }
    
    public void eliminarCarrera(String carrera)
    {
         //si la carrera existe la eliminamos
        if(this.carrerasImpartidas.contains(carrera)) {
            this.carrerasImpartidas.remove(carrera);
        }
    }
   
    public void agregarCurso(String curso)
    {
       //siel curso no existe lo agregamos
        if(!this.cursosImpartidos.contains(curso)) {
            this.cursosImpartidos.add(curso);
        }
    }
 
    //Retorna ArrayList con nombres de cursos contenidos en el semestre
    public ArrayList<String> visualizarCursos(){
       ArrayList<String> c=new ArrayList<>();
       for(int x=0; x<this.cursosImpartidos.size();x++){
           c.add(this.cursosImpartidos.get(x));
       }
       return c;
    }
    
     //@Override
    public Curso modificarCurso(Curso c,String n, Horario h,String p) {
        c.setNombre(n);
        c.setHorario(h);
        c.setProfesor(p);
        return c;
    }

    //@Override
    public void eliminarCurso(Curso c) {
        cursosImpartidos.remove(c);
    }
}
