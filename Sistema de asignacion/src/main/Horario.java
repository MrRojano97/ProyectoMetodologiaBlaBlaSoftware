/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Javiera
 */
public class Horario {
    ArrayList< ArrayList<Bloque>> horarioSemanal = new ArrayList< ArrayList<Bloque>>();
    ArrayList<Bloque> diaDeLaSemana=    new ArrayList<>();
    
    //los dias de la semana se representan desde 0(lunes) hasta 6(sabado) 
    public void crearSemana(){
        for(int i=0;i<7;i++){
            diaDeLaSemana=new ArrayList<>();
            horarioSemanal.add(diaDeLaSemana);
        }           
    }
    //se da por supuesto que la introduccion de los bloques esta en un correcto orden temporal
    public void addBloque(int dia,Bloque bloque){
        horarioSemanal.get(dia).add(bloque);
        
    }
    
}
