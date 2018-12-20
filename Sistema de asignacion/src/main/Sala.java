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
public class Sala {
    String numero;
    Horario planificacionSemanal;

    public Horario getPlanificacionSemanal() {
        return planificacionSemanal;
    }

    public void setPlanificacionSemanal(Horario planificacionSemanal) {
        this.planificacionSemanal = planificacionSemanal;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    //Agrega un curso al horario
    public void addCurso(Curso curso ){
        
    }
    public Sala crearSala(String numero){
        Horario horarioo=new Horario();
        Sala sala=new Sala();
        sala.numero=numero;
        sala.planificacionSemanal=horarioo;
        return sala;
    }
    
    public void modificarSala(String numero,Horario planificacionSemanal){
        this.numero=numero;
        this.planificacionSemanal=planificacionSemanal;
    }
}
