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
public class Semestre implements cambios {
    static ArrayList<Carrera> carrerasImpartidasEnSemestre=new ArrayList<>();
    static ArrayList<Sala> salasUtilizadasEnSemestre=new ArrayList<>();;
    static ArrayList<Profesor> profesoresContratadosEnSemestre=new ArrayList<>();;
    static ArrayList<Curso> cursosImpartidos=new ArrayList<>();;//cursos de la carrera

    @Override
    public Curso modificarCurso(Curso c,String n, Horario h,Profesor p) {
        c.setNombre(n);
        c.setHorario(h);
        c.setProfesor(p);
        return c;
    }

    @Override
    public void eliminarCurso(Curso c) {
        cursosImpartidos.remove(c);
    }
}
