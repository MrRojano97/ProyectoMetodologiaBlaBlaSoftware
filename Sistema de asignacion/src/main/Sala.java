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
    ArrayList <Curso> cursosEnLaSala=new ArrayList<>();
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void addCurso(Curso curso){
        this.cursosEnLaSala.add(curso);
    }
}
