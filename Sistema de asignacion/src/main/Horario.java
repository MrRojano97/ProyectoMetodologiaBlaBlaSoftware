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
public class Horario {
    ArrayList< ArrayList<Bloque>> planificacionSemanal;
    public Horario() {
        this.planificacionSemanal = new ArrayList< >();
        for(int x=0; this.planificacionSemanal.size()<6; x++){
            ArrayList<Bloque> diaDeLaSemana= new ArrayList<>();
            ArrayList<Integer> hora=new ArrayList<>();
            hora.add(8);
            hora.add(30);
            for(int i=0;diaDeLaSemana.size()<11;i++){
                Bloque bloque=new Bloque();
                bloque.setHoraInicio(hora.get(0),hora.get(1));
                hora.set(0,hora.get(0)+1);//incrementamos 1 hora
                bloque.setHoraTermino(hora.get(0),hora.get(1));
                hora.set(1,hora.get(1)+10);//incrementamos 10 minutos
                diaDeLaSemana.add(bloque);// agregamos el bloque al día
                if(hora.get(1)==60){//reinicio de los minutos e incremento de hora
                    hora.set(1,0);
                    hora.set(0,hora.get(0)+1);
                }
            }
            planificacionSemanal.add(diaDeLaSemana);//agregamos a la semana el dia con sus bloques creados
        }
    }
    
    //los dias de la semana se representan desde 0(lunes) hasta 6(sabado) 
//    public void crearSemana(){
//        for(int i=0;i<7;i++){
//            diaDeLaSemana=new ArrayList<>();
//            horarioSemanal.add(diaDeLaSemana);
//        }           
//    }
//    //se da por supuesto que la introduccion de los bloques esta en un correcto orden temporal
//    public void addBloque(int dia,Bloque bloque){
//        horarioSemanal.get(dia).add(bloque);
//        
//    }
    /**
     * permite vizualizar la planificacion semanal ya sea de un profesor, un curso o una sala
     */
     public void visualizarPlanificacionSemanal(){
        System.out.println("\nPlanificacion semanal ");
        for(int x=0; x<planificacionSemanal.size(); x++){
            System.out.println("\n Día: "+x);
            for(int i=0;i<planificacionSemanal.get(x).size();i++){
                if(this.planificacionSemanal.get(x).get(i).curso != null){
                    System.out.println("  "+this.planificacionSemanal.get(x).get(i).getHoraInicio().toString()+"-"+this.planificacionSemanal.get(x).get(i).getHoraTermino().toString()+" "+this.planificacionSemanal.get(x).get(i).curso.nombre);
                }
                else{
                System.out.println("  "+this.planificacionSemanal.get(x).get(i).getHoraInicio().toString()+"-"+this.planificacionSemanal.get(x).get(i).getHoraTermino().toString());
                }
            }
        }
    }
     /**
      * verifica la disponibilidad de un bloque (que no tenga un curso asociado)
      * @param dia posicion del día; de lunes(0) a sabado(5)
      * @param bloque posicion del bloque especifico
      * @return true si el bloque esta disponible y false si el bloque no esta disponible
      */
     public boolean verificarDisponibilidadDeBloque(int dia, int bloque){
         if(this.planificacionSemanal.get(dia).get(bloque).curso != null){
             return false;
         }else{
             return true;
         }
     }
     /**
      * asigna un curso a un determinado bloque
      * @param curso curso que se desea asignar al bloque
      * @param dia posicion del día; de lunes(0) a sabado(5)
      * @param bloque posicion del bloque especifico
      */
    public void asignarCursoABloque(Curso curso, int dia, int bloque){
            this.planificacionSemanal.get(dia).get(bloque).setCursoQueSeDicta(curso);
    }
    /**
     * elimina un curso de un determinado bloque
     * @param dia posicion del día; de lunes(0) a sabado(5)
     * @param bloque posicion del bloque especifico 
     */
    public void quitarCursoDeBloque(int dia, int bloque){
        this.planificacionSemanal.get(dia).get(bloque).setCursoQueSeDicta(null);
    }
    
    
}
