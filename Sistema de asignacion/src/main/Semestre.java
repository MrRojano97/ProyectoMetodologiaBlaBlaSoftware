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
    static ArrayList<Carrera> carrerasImpartidasEnSemestre=new ArrayList<>();
    static ArrayList<Sala> salasUtilizadasEnSemestre=new ArrayList<>();
    static ArrayList<Profesor> profesoresContratadosEnSemestre=new ArrayList<>();
    static ArrayList<Curso> cursosImpartidos=new ArrayList<>();//cursos de la carrera

    public Semestre(String nombre, String fechaInicio, String fechaFin) 
    {
        this.nombre=nombre;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public String getFechaInicio() 
    {
        return fechaInicio;
    }

    public String getFechaFin() 
    {
        return fechaFin;
    }
    
    
    
    // retorna false si el curso no se agrego
    public boolean agregarCurso(Curso curso)
    {
        if(!this.cursoExiste(curso))// si el curso no existe
        {
            return cursosImpartidos.add(curso);
        }
         return false;
    }
    
    public boolean cursoExiste(Curso curso)
    {
        for(Curso auxCurso: cursosImpartidos)
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
        for(Curso auxCurso: cursosImpartidos)
        {
            auxCurso.visualizarDatos();
        }
    }
}
