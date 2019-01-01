package main;

import java.time.LocalTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FrancsicoGP
 */
public class Bloque{
    String curso="";
    private LocalTime horaInicio;
    private LocalTime horaTermino;
    
    //CONSTRUCTOR
    public Bloque(String cursoQueSeDicta, LocalTime horaInicio, LocalTime horaTermino) {
        this.curso= cursoQueSeDicta;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
    }

    public Bloque() {
    }
    
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public String getHoraInicio() {
        return horaInicio.toString();
    }

    public void setHoraInicio(int hora, int minuto) {
        this.horaInicio = LocalTime.of(hora, minuto);
    }

    public String getHoraTermino() {
        return horaTermino.toString();
    }

    public void setHoraTermino(int hora, int minuto) {
         this.horaTermino = LocalTime.of(hora, minuto);
    }
}
