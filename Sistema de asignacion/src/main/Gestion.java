/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author FranciscoGP
 * @author Javiera
 */
public class Gestion {
    ArrayList<Semestre> semestres=new ArrayList<>();
    ArrayList<Carrera> carrerasQueSeImparten=new ArrayList<>();
    ArrayList<Sala> salasDisponibles=new ArrayList<>();
    ArrayList<Profesor> profesoresContratados=new ArrayList<>();
    ArrayList<Horario> horariosDisponibles=new ArrayList<>();
    ArrayList<Curso> cursos=new ArrayList<>();//cursos de la carrera
    Carrera carrera;
    Curso curso;
    Horario horario;
    Profesor profesor;
    Sala sala;
    Bloque bloque;
    
    public Gestion(){
        this.inicio();
    }
    /**
     * Metodo creado con la finalidad de gestionar
     * metodos y/o instancias de variables contenidos en la clase
     */
    public void inicio(){
        // INSTANCIAMIENTO DE UN NUEVO PROFESOR //
        //creacion de un profesor con sus datos
        profesor = new Profesor("Obi-Wan Kenobi","quelafuerzateacompañe@gmail.com","+5697263847","OWKenobi@alianza.com");
        this.addProfesor(profesor);//agregamos el profesor a la lista
        
        //muestra en consola los profesores contenidos en la lista
        this.mostrarListaDeProfesores();
        
         //INSTANCIAMIENTO DE UN NUEVO CURSO Y PROFESOR //
        curso=new Curso("Metodologia");//creamos el curso
        //asignamos el horario del curso
        curso.horario.asignarCursoABloque(curso, 1, 3);//asignamos el curso a un bloque de un día (martes bloque 4)
        curso.horario.asignarCursoABloque(curso, 1, 4);//asignamos el curso a un bloque de un día (martes bloque 5)
        
        //creacion de un profesor con sus datos
        profesor = new Profesor("pepe","sdfd@gmail.com","+6456454657","sdafd@adsf.com");
        profesor.horario.asignarCursoABloque(curso, 1, 3);//asignamos el curso a un bloque de un día (martes bloque 4)
        profesor.horario.asignarCursoABloque(curso, 1, 4);//asignamos el curso a un bloque de un día (martes bloque 4)
        this.addProfesor(profesor);//agregamos el profesor a la lista
        
        curso.setProfesor(profesor);//podemos asignar un profesor al curso
        //curso.deleteProfesor();//podemos quitar un profesor del curso
        this.cursos.add(curso);//agregamos el curso a la lista
        //System.out.println(curso.horario.verificarDisponibilidadDeBloque(1, 0));//podemos verificar la disponibilidad de un bloque, indicando su dia y posicion del bloque
        this.mostrarListaDeCursos();//muestra los cursos añadidos al semesntre
        
        
        //INSTANCIAMIENTO DE UNA NUEVA SALA //
        sala=new Sala("11");
        //le asignamos un curso a un bloque, especificando:  (el curso, dia de la semana,  numero del bloque)
        sala.horario.asignarCursoABloque(curso, 1, 3);
        sala.horario.asignarCursoABloque(curso, 1, 4);
        System.out.println("\n Disponibilidad Sala: "+sala.getNumero()+" martes, bloque 4: "+sala.horario.verificarDisponibilidadDeBloque(1,3));//podemos verificar la disponibilidad de un bloque, indicando su dia y posicion del bloque
        System.out.println("\n Disponibilidad Sala: "+sala.getNumero()+" martes, bloque 5: "+sala.horario.verificarDisponibilidadDeBloque(1,4));
        System.out.println("\n Disponibilidad Sala: "+sala.getNumero()+" martes, bloque 6: "+sala.horario.verificarDisponibilidadDeBloque(1,5));
        sala.horario.visualizarPlanificacionSemanal();//visualizaion de la planificacion semanal(bloques) de la sala
        
        
        
    
    }
    /**
     * Metodo encargado de mostrar por consola
     * los profesores contenidos en la lista profesoresContratados
     */
    public void mostrarListaDeProfesores(){
        Iterator<Profesor> it;
        it = this.profesoresContratados.iterator();
        System.out.println("\nListado de profesores");
        while (it.hasNext() ) {
                profesor = it.next();
                profesor.visualizarDatos();
            }
    }
    // CURSO //
     public void addCurso(Curso curso){
        cursos.add(curso);
    }
    public void mostrarListaDeCursos(){
        Iterator<Curso> it;
        it = this.cursos.iterator();
        System.out.println("\nListado de cursos");
        while (it.hasNext() ) {
                curso = it.next();
                curso.visualizarDatos();
            }
    }
    //        //
    // SALA  //
    public void addSala(Sala sala){
        
        salasDisponibles.add(sala);
    }
    //           //
    // PROFESOR //
    //          //
     public void addProfesor(Profesor p){
        this.profesoresContratados.add(p);
    }

     // CARRERA //
     public void addCarrera(String nombre){
        carrera=new Carrera();
        carrera.setNombre(nombre);
        carrerasQueSeImparten.add(carrera);
    }
     //         //
}
