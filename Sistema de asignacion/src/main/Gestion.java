package main;

import java.util.ArrayList;
import java.util.Date;
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
    
    public Gestion()
    {
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
        //creacion de un profesor con sus datos basicos
        profesor = new Profesor("Obi-Wan Kenobi","quelafuerzateacompañe@gmail.com","+5697263847","OWKenobi@alianza.com");
        this.addProfesor(profesor);//agregamos el profesor a la lista
    
        profesor = new Profesor(" Chewbacca", "aararrggwwwww@gmail.com","+56926361781","Chew@alianza.com");
        this.addProfesor(profesor);//agregamos el profesor a la lista
        
        //muestra en consola los profesores contenidos en la lista
        this.mostrarListaDeProfesores();
        this.visualizarSalas();
        
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
        
         //TESTEO DE CALIDAD DEL MODELO
        sala = new Sala("105");
        System.out.println("\nSala instanciada correctamente "+sala.getNumero());
        
        sala = new Sala("T2");
        System.out.println("\nSala instanciada correctamente "+sala.getNumero());
        
        bloque= new Bloque();
        Curso c2=new Curso("Metodologias y blabla");
        bloque.setCurso(c2);
        bloque.setHoraInicio(8,30);
        bloque.setHoraTermino(9,30);
        System.out.println("\nBloque instanciado correctamente- Inicio:  "+bloque.getHoraInicio()+"  Fin:  "+bloque.getHoraTermino()+"  Curso:  "+bloque.getCurso().getNombre());
        
        bloque= new Bloque();
        bloque.setCurso(new Curso("Proyecto de programacion"));
        bloque.setHoraInicio(18,00);
        bloque.setHoraTermino(19,00);
        System.out.println("\nBloque instanciado correctamente- Inicio:  "+bloque.getHoraInicio()+"  Fin:  "+bloque.getHoraTermino()+"  Curso:  "+bloque.getCurso().getNombre());
        
        profesor= new Profesor("Rodrigo ","rodrigo@gmail.com","99929292929","profesorRodrigo@utalca.cl");
        System.out.println("\nProfesor instanciado correctamente Nombre: ");
        profesor.visualizarDatos();
        
        profesor= new Profesor("Jose","jose@gmail.com","99945254359","profesorJose@utalca.cl");
        System.out.println("\nProfesor instanciado correctamente Nombre: ");
        profesor.visualizarDatos();
        
        carrera= new Carrera("Compu");
        System.out.println("\nCarrera instanciada correctamente : "+carrera.getNombre());
        
        carrera= new Carrera("Electrica");
        System.out.println("\nCarrera instanciada correctamente : "+carrera.getNombre());
        
        
    
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
    public void addSala(Sala sala){      
        salasDisponibles.add(sala);
    }
    public void visualizarSalas(){
        for(int i=0;i<salasDisponibles.size();i++){
            System.out.println(salasDisponibles.get(i).toString());
        
        }
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
    //          //
     public void addProfesor(Profesor p){
        this.profesoresContratados.add(p);
    }


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
