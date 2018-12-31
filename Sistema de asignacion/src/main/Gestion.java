package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author FranciscoGP
 * @author Javiera
 */
public class Gestion{
    HashMap<String, Semestre> semestres = new HashMap<>();
    HashMap<String, Carrera> carreras = new HashMap<>();
    HashMap<String, Profesor> profesores = new HashMap<>();
    HashMap<String, Curso> cursos = new HashMap<>();
    HashMap<String, Sala> salas = new HashMap<>();
    
    Semestre semestre;
    Carrera carrera;
    Curso curso;
    Horario horario;
    Profesor profesor;
    Sala sala;
    
    public Gestion(){
        this.inicio();
    }
    /**
     * Metodo creado con la finalidad de gestionare 
     * metodos y/o instancias de variables contenidos la calse
     */
    public void inicio(){
        // INSTANCIAMIENTO DE UN NUEVO PROFESOR //
        //creacion de un profesor con sus datos basicos
        this.crearProfesor("Obi-Wan Kenobi","quelafuerzateacompañe@gmail.com","+5697263847", "OWKenobi@alianza.com");
        
        
        this.crearProfesor("Chewbacca", "aararrggwwwww@gmail.com","+56926361781", "Chew@alianza.com");
        
        
        
        this.crearSala("4C");
        
        /**
         * IMPORTNTE
         * LAS VARIABLES INDEPENDIENTES DE CADA CLASE ALMACENAN EL VALOR 
         * DEL OBJETO CON EL QUE SE DESEA TRABAJAR
         * POR TANTO PARA MODIFICAR ALGUN DATO DEBEMOS PRIMERO EXTRAERLO A SU RESPECTIVA
         * VARIABLE
         * 
         * CADA PROFESOR, SALA Y CURSO POSEE UN atributo de tipo HORARIO, PARA MODIFICAR SU HORARIO 
         * SE DEBE ACCEDER DIRECTAMENTE AL ATRIBUTO planificacionSemanal el cual provee
         * los metodos asignarCursoABloque, quitarCursoDeBloque y verificarDisponibilidadDeBloque
         */
        
        
        //EJEMPLO PARA crear y MODIFICAR curso
        this.crearCurso("met");
        //extraemos el curso a modificar
        curso=cursos.get("met");
        //cambiamos el nombre del curso y si lo deseamos su prfesor
        this.modificarCurso(curso.getNombre(), "Metodología","");
        //asignamos un profesor existente al curso
        curso.setProfesor(profesores.get("Chewbacca").getNombre());
        //para modificar un HORARIO (esto aplica a todo lo que posea un horario)
       //verificamos que el bloque al cual deseamos asignar un curso este disponible 
        if(curso.getHorario().verificarDisponibilidadDeBloque(1, 3)==false){
            curso.getHorario().asignarCursoABloque(curso.getNombre(), 1, 3);//asigamos el curso al dia martes, bloque 4
        }
        if(curso.getHorario().verificarDisponibilidadDeBloque(1, 4)==false){
            curso.getHorario().asignarCursoABloque(curso.getNombre(), 1, 4);//asigamos el curso al dia martes, bloque 5
        }
        
        //verifica si el bloque esta disponible, esto se debe hacer al tratar de asiganr un bloque
        System.out.println("\n 111111 ");
        curso.getHorario().visualizarPlanificacionSemanal();
        System.out.println("\n 22222222222 ");
        
        this.crearSala("11");
        sala=salas.get("11");
        //MODIFICAR SALA SOLO CAMBIA EL NOMBRE DE ESTA, 
        //YA QUE PARA CAMBIAR SU HORARIO ESTA DISPONIBLE EN SU ATRIBUTO HORARIO EL METODO
        //asignarCursoABloque Y quitarCursoDeBloque
        //CAMBIAMOS EL NUMERO DE LA SALA Y MANTENEMOS SU PLANIFICACION SEMANAL
        this.modificarSala(sala.getNumero(), "12");
    
    }
    // CURSO //
    public void crearCurso(String nombre){
        //si el curso no existe lo creamos
        if(!cursos.containsKey(nombre)){
            curso=new Curso(nombre);
            cursos.put(curso.getNombre(),curso);
        }
    }
    public void modificarCurso(String nombreCurso, String nuevo_nombre, String profesor) {
        //Si el curso existe  lo modificamos
        if(cursos.containsKey(nombreCurso)){
            //extraemos el curso
            curso=cursos.get(nombreCurso);
            //eliminamos el curso con datos antiguos
            cursos.remove(nombreCurso);
            //modificamos el curso extraido
            curso.setNombre(nuevo_nombre);
            curso.setProfesor(profesor);
            //insertamos el curso modificado
            cursos.put(curso.getNombre(), curso);
            
        } 
    }
    
    public void asignarProfesorACurso(String nombreProfesor, String nombreCurso){
        if(profesores.containsKey(nombreProfesor) && cursos.containsKey(nombreCurso) ){
             cursos.get(nombreCurso).setProfesor(nombreProfesor);
         }
    }
    public void eliminarCurso(String nombreCurso) {
        //si el curso existe lo eliminamos
        if(cursos.containsKey(nombreCurso)){
            cursos.remove(nombreCurso);
        }
    }
    //Retorna String[][] "curs" con nombre del curso
    //en curs[0] y su profesor asignado en curs[1]
    public String[][] visualizarCursos(){
        String[][] curs=new String[this.cursos.size()][2];
        int i=0;
        for (Map.Entry<String, Curso> entry : cursos.entrySet()) {
            curs[i][0]=entry.getValue().getNombre();
            curs[i][1]=entry.getValue().getProfesor();
            i++;
        }
        return curs;
    }
     
    // SALA  //
    public void crearSala(String numero){
     //si la sala no existe en el hash map la creamos y agregamos
     if(!salas.containsKey(numero)){
        this.sala=new Sala(numero);
        salas.put(sala.getNumero(),sala);
     }   
    }
    public void modificarSala(String numero,String numero_nuevo){
        //si la sala existe la modificamos
         if(salas.containsKey(numero)){
            sala=salas.get(numero);
            salas.remove(numero);
            sala.setNumero(numero_nuevo);
            salas.put(sala.getNumero(), sala);
         }
     }
     public void eliminarSala(String id){
         //si la sala existe la eliminamos
         if(salas.containsKey(id)){
             salas.remove(id);
         }else{
             System.out.println("No se encuentra esa Sala en nuestros datos.");
         }
     }
    // RETORNA ArrayLis CON NOMBRES DE SALAS
    public ArrayList<String> visualizarSalas(){
        ArrayList<String> s= new ArrayList<>();
        for (Map.Entry<String, Sala> entry : salas.entrySet()) {
            s.add(entry.getValue().getNumero());
        }
        return s;
    }
    
    
    //----------------- CARRERA --------------------- //
    
    public void crearCarrera(String nombre){
        carrera=new Carrera(nombre);
        carreras.put(carrera.getNombre(),carrera);
    }
  
     public void modificarNombreCarrera(String nombreCarrera, String nombre_nuevo){
         //si la carrera existe la modificamos
         if(carreras.containsKey(nombreCarrera)){
             //copiamos la carrera y le cambiamos el nombre
             carrera=carreras.get(nombreCarrera);
             carrera.setNombre(nombre_nuevo);
             //agregamos al carrera con nuevo nombre
             carreras.put(nombre_nuevo, carrera);
             //eliminamos la carrera con el nombre antiguo
             carreras.remove(nombreCarrera);
             
         }
         else{
             System.out.println("No se encuentra esa Carrera en nuestros datos.");
         }
     }
    public ArrayList visualizarCursosCarrera(String idCarrera){
        if(carreras.containsKey(idCarrera)){
             return carreras.get(idCarrera).getCursos();
         }
        return null;
    }
    public void agregarCursoACarrera(String idCarrera, String curso){
         if(carreras.containsKey(idCarrera)){
             carreras.get(idCarrera).addCurso(curso);
         }
         else{
             System.out.println("No se encuentra esa Carrera en nuestros datos.");
     }
    }
    public void eliminarCarrera(String idCarrera){
         if(carreras.containsKey(idCarrera)){
             carreras.remove(idCarrera);
         }
         else{
             System.out.println("No se encuentra esa Carrera en nuestros datos.");
     }
     }
    //RETORNA ArrayLis CON NOMBRES DE CARRERAS
    public ArrayList<String> visualizarCarreras(){
        ArrayList<String> c=new ArrayList<>();
        for (Map.Entry<String, Carrera> entry : carreras.entrySet()) {
            c.add(entry.getValue().getNombre());
        }
        return c;
    }
    //-----------------------------------------------------------------------------//
    
    //------------------------------ PROFESOR ------------------------------ //
    public void crearProfesor(String nombre, String correoP, String numC, String correoI){
        this.profesor=new Profesor(nombre,correoP,numC, correoI);
        this.profesores.put(profesor.getNombre(),profesor);
    }
   

    public void modificarProfesor(String nombre, String correoP, String numC, String correoI, Date fecha) {
        this.profesor.setCorreoInstitucional(correoP);
        this.profesor.setNombre(nombre);
        this.profesor.setNumeroContacto(numC);
        this.profesor.setCorreoInstitucional(correoI);
        this.profesor.setFechaContratacion(fecha);
    }
    public void eliminarProfesor(String idProfesor){
        if(profesores.containsKey(idProfesor)){
             profesores.remove(idProfesor);
         }
        else{
            System.out.println("no se encuentra el profesor buscado");
        }
    }
     public String[][] visualizarProfesores(){
        String[][] prof=new String[this.profesores.size()][4];
        int i=0;
        for (Map.Entry<String, Profesor> entry : profesores.entrySet()) {
            prof[i][0]=entry.getValue().getNombre();
            prof[i][1]=entry.getValue().getNumeroContacto();
            prof[i][2]=entry.getValue().getCorreoPersonal();
            prof[i][3]=entry.getValue().getCorreoInstitucional();
            i++;
        }
        return prof;
    }
    //------------------------------ Semestre ------------------------------ //
    // recordar validar las fechas
    public void crearSemestre(String nombreSemestre,String fechainicio,String fechaFin){
        semestre=new Semestre(nombreSemestre, fechainicio, fechaFin);
        semestres.put(semestre.getNombre(),semestre);
        
    }
    public void agregarCursoASemeste(String nombreSemestre, String nombreCurso){
        //si el curso y semestre existen, agregamos el curso al semstre
        if(semestres.containsKey(nombreSemestre) && this.cursos.containsKey(nombreCurso)){
            semestres.get(nombreSemestre).agregarCurso(nombreCurso);
         }
    }
    public  ArrayList<String> visualizarSemestres (){
        ArrayList<String> s=new ArrayList<>();
        for (Map.Entry<String, Semestre> entry : semestres.entrySet()) {
            s.add(entry.getValue().getNombre());
        }
        return s;
    }
    public void eliminarSemestre(String nombreSemestre){
        if(semestres.containsKey(nombreSemestre)){
            semestres.remove(nombreSemestre);
         }
        
    }
}
