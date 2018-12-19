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
    String nombre;//nombre completo del profesor
    String correoInstitucional;//correo asignado por la universidad
    String correoPersonal;//correo personal del profesor
    Date fechaContratacion;//fecha en la cual se contrato al profesor
    String numeroContacto;//numero celular personal del profesor
    //horario que contiene los bloques semanales y sus cursos asignados
    Horario horarioSemanal;
    ArrayList<Curso> cursosAsignados;//cursos que esta dictando el profesor
    
    public Profesor(String nombre, String correoP, String numC){
        this.nombre=nombre;
        this.correoPersonal=correoP;
        this.fechaContratacion= new Date();
        this.horarioSemanal= new Horario();
        this.setNumeroContacto(numC);
    }

    Profesor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    
}
