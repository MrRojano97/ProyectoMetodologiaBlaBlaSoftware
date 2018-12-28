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
    
    public void mostrarSalas()
    {
        for(Sala sala: this.salasUtilizadasEnSemestre)
        {
            sala.toString();
        }
    }
    
    public int agregarSala(Sala sala)
    {
        if(0>this.salaExiste(sala.getNumero()))//si la sala no existe  se obtendra un -1
        {
            boolean respuesta=this.salasUtilizadasEnSemestre.add(sala);
            if(respuesta)
            {
                return 1;//se  agrego correctamente  la sala.
            }
            else
            {
                return 0;//error al agregar la sala, error del metoo add.
            }
            
        }
        
        else
        {
            return -2;// la sala  ya existe.
        }
    }
    
    public int salaExiste(String numeroSala)
    {
        int i=0;
        for(Sala sala:this.salasUtilizadasEnSemestre)
        {
            if(sala.getNumero().equalsIgnoreCase(numeroSala))
            {
                return i;// retirna el indice de la sala si este existe
            }
        }
        return -1;// retorna -1 si la sala no existe
    }
    
    public Sala eliminarSala(String numeroSala)
    {
        Sala sala = new Sala("-1");
        int i = this.salaExiste(numeroSala);
        if(i>-1)// si la sala existe
        {
            return this.salasUtilizadasEnSemestre.remove(i);
        }
        else
        {
            return sala;// la sala  a eliminar no existe
        }
    }
    
     public void mostrarProfesores()
    {
        for(Profesor profesor: this.profesoresContratadosEnSemestre)
        {
            profesor.visualizarDatos();
        }
    }
    
    public int agregarProfesor(Profesor profesor)
    {
        if(0>this.profesorExiste(profesor.getNombre()))//si el profesor no existe  se obtendra un -1
        {
            boolean respuesta=this.profesoresContratadosEnSemestre.add(profesor);
            if(respuesta)
            {
                return 1;//se  agrego correctamente  el profesor.
            }
            else
            {
                return 0;//error al agregar el Profesor, erro del metoo add.
            }
            
        }
        
        else
        {
            return -2;// el rpofesor  ya existe.
        }
    }
    
    public int profesorExiste(String nombreProfesor)
    {
        int i=0;
        for(Profesor profesor:this.profesoresContratadosEnSemestre)
        {
            if(profesor.getNombre().equalsIgnoreCase(nombreProfesor))
            {
                return i;// retirna el indice del profesor si este existe
            }
        }
        return -1;// retorna -1 si el profesor no existe
    }
    
    public Profesor eliminarProfesor(String nombreProfesor)
    {
        Profesor profesor = new Profesor("-1","-1","-1","-1");
        int i =this.profesorExiste(nombreProfesor);
        if(i>-1)// si el profesor existe
        {
            return this.profesoresContratadosEnSemestre.remove(i);
        }
        else
        {
            return profesor;// el profesor  a eliminar no existe
        }
    }
    
    public void mostrarCarreras()
    {
        for(Carrera carrera: this.carrerasImpartidasEnSemestre)
        {
            carrera.mostrarInfo();
        }
    }
    
    public int agregarCarrera(Carrera carrera)
    {
        if(0>this.CarreraExiste(carrera.getNombre()))//si la carrera ya no existe  se obtendra un -1
        {
            boolean respuesta=this.carrerasImpartidasEnSemestre.add(carrera);
            if(respuesta)
            {
                return 1;//se  agrego correctamente  la carrera.
            }
            else
            {
                return 0;//error al agregar el curso, erro del metoo add.
            }
            
        }
        
        else
        {
            return -2;// la carrera ya existe.
        }
    }
    
    public int CarreraExiste(String nombreCarrera)
    {
        int i=0;
        for(Carrera carrera:this.carrerasImpartidasEnSemestre)
        {
            if(carrera.getNombre().equalsIgnoreCase(nombreCarrera))
            {
                return i;// si la carrera existe
            }
        }
        return -1;// si la carrera no existe
    }
    
    public Carrera eliminarCarrera(String nombreCarrera)
    {
        Carrera carrera = new Carrera("-1");
        int i =this.CarreraExiste(nombreCarrera);
        if(i>-1)// la carrera existe
        {
            return this.carrerasImpartidasEnSemestre.remove(i);
        }
        else
        {
            return carrera;// la carrera a eliminar no existe
        }
    }
    
    public Curso eliminarCurso(Curso curso)
    {
        Curso auxCurso=new Curso("-1");
        int i=this.cursoExiste(curso);
        if(i>-1)
        {
            return this.cursosImpartidos.remove(i);
        }
        else
        {
            return auxCurso;
        }
        
    }
    
    public int agregarCurso(Curso curso)
    {
        if(0>this.cursoExiste(curso))// si el curso no existe
        {
            boolean respuesta= this.cursosImpartidos.add(curso);
            if(respuesta)
            {
                return 1;//curso agregado correctamente
            }
            else
            {
                return 0;// erro al agregar curso
            }
        }
        else
        {
            return -2;//el curso ya existe
        }
        
    }
    
    public int cursoExiste(Curso curso)
    {
        int i=0;
        for(Curso auxCurso: this.cursosImpartidos)
        {
            if(auxCurso.equals(curso))
            {
                return i;// el curso existe
            }
        }
        
        return -1;//el curso no existe
    }
    
    // falta mejorar el metodo
    public void mostrarDatos()
    {
        System.out.println("semestre: "+this.nombre+", fecha de inicio: "+this.fechaInicio+", fecha de fin: "+this.fechaFin);
        this.mostrarCursos();
    }
    
    public void mostrarCursos()
    {
        for(Curso auxCurso: this.cursosImpartidos)
        {
            auxCurso.visualizarDatos();
        }
    }
}
