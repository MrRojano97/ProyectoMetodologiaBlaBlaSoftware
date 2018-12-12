/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.time.LocalTime;

/**
 *
 * @author Javiera
 */
public class Horario {
    LocalTime horaInicio;
    LocalTime horaTermino;


    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int hora, int minuto) {
        this.horaInicio = LocalTime.of(hora, minuto);
    }

    public LocalTime getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(int hora, int minuto) {
         this.horaTermino = LocalTime.of(hora, minuto);
    }
    
}
