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
public class Bloque {
    Curso curso=null;
    LocalTime horaInicio;
    LocalTime horaTermino;
    
    //CONSTRUCTOR
    public Bloque(Curso cursoQueSeDicta, LocalTime horaInicio, LocalTime horaTermino) {
        this.curso= cursoQueSeDicta;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
    }

    public Bloque() {
    }
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
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
