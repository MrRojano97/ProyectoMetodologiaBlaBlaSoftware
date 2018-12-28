/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *Interface realizada para dejar metodos que se repiten en varias clases
 */
public interface cambios {

    /**
     *
     * @param c
     * @param n
     * @param h
     * @param p
     * @return
     */
    public Curso modificarCurso(Curso c, String n,Horario h,Profesor p);
    public void eliminarCurso(Curso c);
}
