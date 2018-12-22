/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Iterator;

/**
 *
 * @author Javiera
 */
public class Sala {
    String numero;
    Horario horario;
    
    
    public Sala(String numero) {
        this.numero = numero;
        this.horario=new Horario();
    }
    public Horario getPlanificacionSemanal() {
        return horario;
    }

    public void setPlanificacionSemanal(Horario planificacionSemanal) {
        this.horario = planificacionSemanal;
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
//    public Sala crearSala(Sala sala){      
//        return sala;
//    }
//    public void modificarSala(){
//        
//    }
}
