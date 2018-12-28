package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * @author FranciscoGP
 * @author Javiera
 */
public class Gestion implements cambios{
    ArrayList<Semestre> semestres=new ArrayList<>();
    ArrayList<Carrera> carrerasQueSeImparten=new ArrayList<>();
    ArrayList<Sala> salasDisponibles=new ArrayList<>();;
    ArrayList<Profesor> profesoresContratados=new ArrayList<>();;
    ArrayList<Horario> horariosDisponibles=new ArrayList<>();;
    ArrayList<Curso> cursos=new ArrayList<>();;//cursos de la carrera
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
        
        
        this.crearProfesor(" Chewbacca", "aararrggwwwww@gmail.com","+56926361781", "Chew@alianza.com");

        //muestra en consola los profesores contenidos en la lista
        this.mostrarListaDeProfesores();
        this.addSala("asd");
        this.visualizarSalas();
        
        
        
    
    }
    /**
     * Metodo encargado de mostrar por consola
     * los profesores contenidos en la lista profesoresContratados
     */
    public void mostrarListaDeProfesores(){
        Iterator<Profesor> it;
        Profesor p;
        it = this.profesoresContratados.iterator();
        System.out.println("Listado de profesores contratados ");
        while (it.hasNext() ) {
                p = it.next();
                System.out.println("\n Nombre: "+p.getNombre()+"\n Correo: "+p.getCorreoPersonal()+"\n Correo institucional: "+p.getCorreoInstitucional());
                System.out.println(" Numero de contato: "+p.getNumeroContacto()+"\n Fecha/Hora de contratacion: "+p.getFechaContratacion());
            }
    }
    // CURSO //
     public void addCurso(String nombre){
        curso=new Curso(nombre);
        cursos.add(curso);
    }
     public void modificarSala(Sala sala,String numero, Horario planificacion){
         sala.numero=numero;
         sala.horario=planificacion;
     }
     public void eliminarSala(String numero){
         int eliminar=-1;
         for (int i=0;i<salasDisponibles.size();i++){
             if (salasDisponibles.get(i).numero.equals(numero)){
                 eliminar=i;
             }
         }
         if(eliminar!=-1){
             salasDisponibles.remove(eliminar);
         }
         else{
             System.out.println("No se encuentra esa Sala en nuestros datos.");
         }
     }
    // SALA  //
    public void addSala(String numero){
        salasDisponibles.add(new Sala(numero));
    }
    // RETORNA STRING CON NOMBRES DE SALAS
    public ArrayList<String> visualizarSalas(){
        ArrayList<String> salas= new ArrayList<>();
        for(int i=0;i<salasDisponibles.size();i++){
            System.out.println(salasDisponibles.get(i).toString());
            salas.add(salasDisponibles.get(i).getNumero());
        
        }
        return salas;
    }
    //RETORNA STRING CON NOMBRES DE CARRERAS
    public ArrayList<String> visualizarCarreras(){
        ArrayList<String> carreras=new ArrayList<>();
        for(int i=0;i<carrerasQueSeImparten.size();i++){
            System.out.println(carrerasQueSeImparten.get(i).toString());
            carreras.add(carrerasQueSeImparten.get(i).nombre);
        }
        return carreras;
    }
    public void visualizarCarrera(String nombre){
        boolean encontrado=false;
        for(int i=0;i<carrerasQueSeImparten.size() && encontrado==false;i++){
            if (carrerasQueSeImparten.get(i).nombre.equals(nombre)){
                System.out.println(carrerasQueSeImparten.get(i).toString());
                encontrado=true;
            }
        }
    }
    // PROFESOR //
    /**
     * Metodo encargado de crear un nuevo profesor con sus datos basicos
     * @param nombre nombre del profesor a crear
     * @param correoP correo personal del profesor a crear
     */
    // creacion de profesor, sus valores de entrada deben ser su nombre, seguido de su correo, y finalizando 
    //  con su numero de celular

     // CARRERA //
     public void addCarrera(String nombre){
        carrera=new Carrera(nombre);
        carrerasQueSeImparten.add(carrera);
    }
     public int buscarCarrera(String carrera){
         int j=-1;
         for (int i=0;i<carrerasQueSeImparten.size();i++){
             if (carrerasQueSeImparten.get(i).nombre.equals(carrera)){
                 j=i;
             }
         }
         return j;
     }
     public void agregarCurso_Carrera(String carrera, Curso curso){
         int j= buscarCarrera(carrera);
         if(j!=-1)
            carrerasQueSeImparten.get(j).addCurso(curso);
         else
             System.out.println("No se encuentra esa Carrera en nuestros datos.");
     }
     public void eliminarCurso_Carrera(String carrera, String curso){
         int j= buscarCarrera(carrera);
         if(j!=-1)
            carrerasQueSeImparten.get(j).delCurso(curso);
         else
             System.out.println("No se encuentra esa Carrera en nuestros datos.");
     }
     public void modificarNombreCarrera(String nombre,String nombre_nuevo){
         int j=buscarCarrera(nombre);
         if(j!=-1){
             carrerasQueSeImparten.get(j).setNombre(nombre_nuevo);
         }
         else{
             System.out.println("No se encuentra esa Carrera en nuestros datos.");
         }
     }
     public void eliminarCarrera(String nombre){
         int eliminar=buscarCarrera(nombre);
         if(eliminar!=-1){
             carrerasQueSeImparten.remove(eliminar);
         }
         else{
             System.out.println("No se encuentra esa Carrera en nuestros datos.");
         }
     }
     
    public void crearProfesor(String nombre, String correoP, String numC, String correoI){
        
        this.profesor=new Profesor(nombre,correoP,numC, correoI);
        this.profesoresContratados.add(profesor);
    }
     
    public String[][] visualizarProfesores(){
        String[][] profesores=new String[this.profesoresContratados.size()][4];
        for(int i=0;i<this.profesoresContratados.size();i++){
             profesores[i][0]=this.profesoresContratados.get(i).getNombre();
             profesores[i][1]=this.profesoresContratados.get(i).getNumeroContacto();
             profesores[i][2]=this.profesoresContratados.get(i).getCorreoPersonal();
             profesores[i][3]=this.profesoresContratados.get(i).getCorreoInstitucional();
             
            }
        return profesores;
    }

    public void modificarProfesor(String nombre, String correoP, String numC, String correoI,Date fecha) {
        this.profesor.setCorreoInstitucional(correoP);
        this.profesor.setNombre(nombre);
        this.profesor.setNumeroContacto(numC);
        this.profesor.setCorreoInstitucional(correoI);
        this.profesor.setFechaContratacion(fecha);
    }
    public void eliminarProfesor(String nombre){
        int indice=-1;
        for(int i=0;i<profesoresContratados.size();i++){
            if(profesoresContratados.get(i).nombre.equals(nombre)){
                indice=i;               
            }
        }
        if(indice!= -1){
            profesoresContratados.remove(indice);
        }
        else{
            System.out.println("no se encuentra el profesor buscado");
        }
            
    }

    @Override
    public Curso modificarCurso(Curso c, String n, Horario h, Profesor p) {
        c.setNombre(n);
        c.setHorario(h);
        c.setProfesor(p);
        return c;
    }
    @Override
    public void eliminarCurso(Curso c) {
        cursos.remove(c);
    }
    
    // recordar validar las fechas
    public int crearSemestre(String nombreSemestre,String fechainicio,String fechaFin)
    {
        int i=this.semestreExiste(nombreSemestre);
        if(i>-1)
        {
            Semestre semestre = new Semestre(nombreSemestre,fechainicio,fechaFin);
            boolean b =this.semestres.add(semestre);
            if(b)
            {
                return 1;// se agrego correctamente
            }
            else
            {
                return 0;//  ocurrio un error al agregar semestre
            }
        }
        else
        {
            return -2;// semestre ya existe
        }
    }
    
    /*@
    retorna 1 si se agrego correctamente el curso al semestre
    retorna 0 si ocurrio un erro inesperado al agregar
    retorna -1  si el semestre indicado no existe
    retorna -2 si el curso indicado ya existe en el semestre
    */
    public int agregarCursoSemeste(String nombreSemestre, Curso curso)
    {
        int i =this.semestreExiste(nombreSemestre);
        if(-1<i)
        {
           return  this.semestres.get(i).agregarCurso(curso);// puede retornar los siguentes valores : 1,0 y -2.
           
        }
        else
        {
            
            return -1;// retorna -1 si el smestre no existe
        }
        
        
    }
    
    public  void mostrarSemestres ()
    {
        for(Semestre semestre: this.semestres)
        {
            semestre.mostrarDatos();
        }
    }
    
    public int semestreExiste(String nombreSemestre)
    {
        int i=0;
        for(Semestre semestre: this.semestres)
        {
            if(semestre.getNombre().equalsIgnoreCase(nombreSemestre))
            {
                return i;// retorna la posicion del semestre indicado.
            }
            i++;
        }
        return -1;// retorna -1 si el semestre no existe
    }
     
}
