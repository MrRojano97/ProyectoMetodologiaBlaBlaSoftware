package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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
    private Persistor persistor = new Persistor();
    
    Semestre semestre;
    Carrera carrera;
    Curso curso;
    Horario horario;
    Profesor profesor;
    Sala sala;
    Cuenta cuenta_en_sesion; //cuenta logeada actualmente
    ArrayList<Cuenta> cuentas=new ArrayList<>(); //cuentas registradas en el sistema
    
    public Gestion() throws IOException
    {
        this.inicio();
    }
    /**
     * Metodo creado con la finalidad de gestionare 
     * metodos y/o instancias de variables contenidos la calse
     */
    public void inicio(){
        //CREACION DE CUENTA ADMIN
        Cuenta nueva_cuenta=new Cuenta();
        nueva_cuenta.setId("admin");
        nueva_cuenta.setPassword("metodologias");
        nueva_cuenta.setPermisos_de_admin(true);
        cuentas.add(nueva_cuenta);
        
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
        //muestra en consola los profesores contenidos en la lista
        this.mostrarListaDeProfesores();
        this.addSala("asd");
        this.visualizarSalas();
    }
    
    ////-----------CUENTA-----------///
    
    //METODO PARA CAMBIAR LA CONTRASEÑA DE UNA CUENTA
    public void cambiar_password(String password_actual, String nuevo_password){
        if (cuenta_en_sesion.password.equals(password_actual)){
            cuenta_en_sesion.setPassword(nuevo_password);
        }
    }
    
    //METODO PARA CAMBIAR ID DE CUENTA
    public void cambiar_id_cuenta(String password, String nuevo_id){
        if (cuenta_en_sesion.password.equals(password)){
            cuenta_en_sesion.setId(nuevo_id);
        }
    }
    
    //SE AGREGA UNA NUEVA CUENTA AL SISTEMA
    public void crear_cuenta(String id,String password){
        Cuenta nueva_cuenta=new Cuenta();
        nueva_cuenta.setId(id);
        nueva_cuenta.setPassword(password);
        nueva_cuenta.setPermisos_de_admin(false);
        cuentas.add(nueva_cuenta);    
    }    
    //Este buscara si la cuenta existe y comprobara si la clave corresponde//
    public void verificarCuenta(String id, String pass){
        for(int i=0; i<cuentas.size();i++){
            if(id.equals(cuentas.get(i).id)){
                if(cuentas.get(i).verificarClave(pass)){
                    this.cuenta_en_sesion= cuentas.get(i);
                    return;
                }
                else{
                    System.out.println("Contraseña incorrecta.");
                    return;
                }
            }
        }
        System.out.println("No existe ese usuario.");
     }
    
    public String quienAdmin(String pass){
        for(int i=0; i<cuentas.size();i++){
            if(cuentas.get(i).isPermisos_de_admin()){
               return cuentas.get(i).getId();
               }
            }
           return "";
        }
    //Revisara quien es el admin en caso de algun cambio, (Se puede eliminar si el Admin no cambia)//
    /**
     * Metodo encargado de mostrar por consola
     * los profesores contenidos en la lista profesoresContratados
     */
//    public void mostrarListaDeProfesores(){
//        Iterator<Profesor> it;
//        Profesor p;
//        it = this.profesoresContratados.iterator();
//        System.out.println("Listado de profesores contratados ");
//        while (it.hasNext() ) {
//                p = it.next();
//                System.out.println("\n Nombre: "+p.getNombre()+"\n Correo: "+p.getCorreoPersonal()+"\n Correo institucional: "+p.getCorreoInstitucional());
//                System.out.println(" Numero de contato: "+p.getNumeroContacto()+"\n Fecha/Hora de contratacion: "+p.getFechaContratacion());
//            }
//    }
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
        //return salas;
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
    
    public String[] arregloCursos() {
        String[]curs=new String[this.cursos.size()];
        int i=0;
        for (Map.Entry<String, Curso> entry : cursos.entrySet()) {
            curs[i]=entry.getValue().getNombre();
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
     public void eliminarSala(String numero_sala){
         //si la sala existe la eliminamos
         if(salas.containsKey(numero_sala)){
             salas.remove(numero_sala);
         }else{
             System.out.println("No se encuentra esa Sala en nuestros datos.");
         }
     }
    // RETORNA ArrayLis CON NOMBRES DE SALAS
    public String[] visualizarSalas(){
        String[] s= new String[this.salas.size()];
        int i=0;
        for (Map.Entry<String, Sala> entry : salas.entrySet()) {
            s[i] = entry.getValue().getNumero();
            i++;
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
    public ArrayList visualizarCursosCarrera(String nombre_carrera){
        if(carreras.containsKey(nombre_carrera)){
             return carreras.get(nombre_carrera).getCursos();
         }
        return null;
    }
    public void agregarCursoACarrera(String nombre_carrera, String curso){
         if(carreras.containsKey(nombre_carrera)){
             carreras.get(nombre_carrera).addCurso(curso);
         }
         else{
             System.out.println("No se encuentra esa Carrera en nuestros datos.");
     }
    }
    public void eliminarCarrera(String nombre_carrera){
         if(carreras.containsKey(nombre_carrera)){
             carreras.remove(nombre_carrera);
         }
         else{
             System.out.println("No se encuentra esa Carrera en nuestros datos.");
     }
     }
    //RETORNA ArrayLis CON NOMBRES DE CARRERAS
    public String[] visualizarCarreras(){
        String[] c=new String[this.carreras.size()];
        int i=0;
        for (Map.Entry<String, Carrera> entry : carreras.entrySet()) {
            c[i] = entry.getValue().getNombre();
            i++;
        }
        return c;
    }
    //-----------------------------------------------------------------------------//
    
    //------------------------------ PROFESOR ------------------------------ //
    public void crearProfesor(String nombre, String correoP, String numC, String correoI){
        this.profesor=new Profesor(nombre,correoP,numC, correoI);
        this.profesores.put(profesor.getNombre(),profesor);
    }
   
    //
    public void modificarProfesor(String nombre, String nuevo_nombre, String correoP, String numC, String correoI, Date fecha) {
        profesor=profesores.get(nombre);
        profesores.remove(nombre);
        this.profesor.setCorreoInstitucional(correoP);
        this.profesor.setNombre(nuevo_nombre);
        this.profesor.setNumeroContacto(numC);
        this.profesor.setCorreoInstitucional(correoI);
        this.profesor.setFechaContratacion(fecha);
        profesores.put(profesor.getNombre(), profesor);
       
    }
    public void eliminarProfesor(String nombre_profesor){
        if(profesores.containsKey(nombre_profesor)){
             profesores.remove(nombre_profesor);
         }
        else{
            System.out.println("no se encuentra el profesor buscado");
        }
    }
    //retorna String con datos de profesores
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
    
    public boolean agregarCursoAProfesor(String nombreProfesor, String nombreCurso)
    {
        
        if(this.profesores.containsKey(nombreProfesor))
        {
            Profesor profe = this.profesores.get(nombreProfesor);
            if(this.cursos.containsKey(nombreCurso))
            {
                Curso curso =this.cursos.get(nombreCurso);
                return profe.agregarCurso(curso);
            }
        }
        
        return false;
    }
    
    public void escribirSalas() throws IOException
    {
        Collection<Sala> co =this.salas.values();
        Sala[] salidaSalas = new Sala[co.size()];
        int i=0;
        for(Sala salal:co)
        {
            salidaSalas[i]=salal;
            i++; 
        }
        
        this.persistor.escribirSalas(salidaSalas );
    }
   
    public void cargarSalas() throws IOException
    {
        ArrayList<Sala> salidaFile =this.persistor.leerSalasJson();
        for(Sala contenedor: salidaFile)
        {
            this.salas.put(contenedor.getNumero(), contenedor);
        }
    }
    
    
}
