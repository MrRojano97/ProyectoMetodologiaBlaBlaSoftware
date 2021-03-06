/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Francisco Gamboa
 * @author Javiera
 */
public class Profesor {
    private String nombre;//nombre completo del profesor
    private String correoInstitucional;//correo asignado por la universidad
    private String correoPersonal;//correo personal del profesor
    private Date fechaContratacion;//fecha en la cual se contrato al profesor
    private String numeroContacto;//numero celular personal del profesor
    //horario que contiene los bloques semanales y sus cursos asignados
    Horario horario;
    ArrayList<Curso> cursosAsignados;//cursos que esta dictando el profesor
    
    public Profesor(String nombre, String correoP, String numC,String correoI){
        this.nombre=nombre;
        this.correoPersonal=correoP;
        this.correoInstitucional=correoI;
        this.fechaContratacion= new Date();
        this.horario= new Horario();
        this.numeroContacto=numC;
    }
 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }
    public void visualizarDatos() {
        System.out.println("\n Nombre: "+this.getNombre()+"\n Correo: "+this.getCorreoPersonal()+"\n Correo institucional: "+this.getCorreoInstitucional());
        System.out.println(" Numero de contato: "+this.getNumeroContacto()+"\n Fecha/Hora de contratacion: "+this.getFechaContratacion());
    }
    
    
    // valida si existe un curso
    public boolean CurosExist(String nombreCurso) 
    {
        for(Curso curso: this.cursosAsignados)
        {
            if(curso.getNombre().equalsIgnoreCase(nombreCurso))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean agregarCurso(Curso curso)
    {
        if(!this.CurosExist(curso.getNombre()))
        {
            curso.setProfesor(this.nombre);
            return this.cursosAsignados.add(curso);
            
        }
        
        return false;
    }
    
    
    
    //Los profesores solo deberian poder modificar el horario de un curso
}
