/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Matias.Erenchun
 */

import com.google.gson.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Persistor 
{
    private Gson miGson = new Gson();
    
   
    public void escribirSalas(Sala []salas) throws IOException
    {
        String gSonSalas =this.pasarListaAStringConGSon(salas);
        try{
            this.escribirGson(gSonSalas);
        }catch (IOException e)
        {
            System.out.println(e);
        }
        
    }
    
    // retorna un ArrayList de salas con todas las salas que tenia el archivo.
    public ArrayList leerSalasJson() throws IOException
    {
        ArrayList<Sala> salasSalida = new ArrayList<Sala>();
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader("D:/repo git local 2/ProyectoMetodologiaBlaBlaSoftware/Json/salas.json"));
            String json= br.readLine();// leemos la linea donde estan los datos
            Sala[] jArr = miGson.fromJson(json,Sala[].class);// guardamos los objetos principales en una lista de objetos de ese tipo
            System.out.println(jArr.length);
            for (Sala p: jArr)
            {
                salasSalida.add(p);// agregamos todos los objetos a la lista correspondiente.
                
            }

        }

        catch (FileNotFoundException e)// si el archivo no esta 
        {
                e.printStackTrace();
        }
        finally
        {
            if(br!=null)// mientras el archivo exista 
            {
                try
                {
                    br.close();// lo cerramos 
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        return salasSalida;
    }
    

    private void escribirGson( String string)throws IOException
    {
       FileWriter archivo = new FileWriter("D:/repo git local 2/ProyectoMetodologiaBlaBlaSoftware/Json/salas.json");
       archivo.write(string);// se escriben los dato en el archivo.json
       archivo.close();

    }
    
    public  String pasarListaAStringConGSon(Object[] listaObject)
    {
        String jSon = miGson.toJson(listaObject);
        return jSon;
    }
}
