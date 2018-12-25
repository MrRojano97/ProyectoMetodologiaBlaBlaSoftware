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
public class Semestre 
{
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private ArrayList<Carrera> carrerasImpartidasEnSemestre;
    private ArrayList<Sala> salasUtilizadasEnSemestre;
    private ArrayList<Profesor> profesoresContratadosEnSemestre;
    private ArrayList<Curso> cursosImpartidos;//cursos de la carrera

    public Semestre(String nombre, String fechaInicio, String fechaFin) 
    {
        this.nombre=nombre;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.carrerasImpartidasEnSemestre=new ArrayList<>();
        this.salasUtilizadasEnSemestre=new ArrayList<>();
        this.profesoresContratadosEnSemestre=new ArrayList<>();
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
    
    
    
    // retorna false si el curso no se agrego
    public boolean agregarCurso(Curso curso)
    {
        if(!this.cursoExiste(curso))// si el curso no existe
        {
            return this.cursosImpartidos.add(curso);
        }
         return false;
    }
    
    public boolean cursoExiste(Curso curso)
    {
        for(Curso auxCurso: this.cursosImpartidos)
        {
            if(auxCurso.equals(curso))
            {
                return true;// el curso existe
            }
        }
        
        return false;//el curso no existe
    }
    
    public void mostrarDatos()
    {
        System.out.println("semestre: "+this.nombre+", fecha de inicio: "+this.fechaInicio+", fecha de fin: "+this.fechaFin);
    }
    
    public void mostrarCurso()
    {
        for(Curso auxCurso: this.cursosImpartidos)
        {
            auxCurso.visualizarDatos();
        }
    }
}
