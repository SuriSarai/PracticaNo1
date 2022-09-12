/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.granjas;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.Float.max;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/**
 *
 * @author Suri
 */
public class Granjas {

    private Animal[] animales = new Animal [100];
    private int animal_Actual=0;
   

    public Granjas(String ruta_Archivo) throws FileNotFoundException, ParseException {
       CargaAnimales(ruta_Archivo);
    }
    
    public float ObtenerPromedioVacas(){
        float promedio=0; //Siempre inicialzar las variables dentro de una funcion
        int cantidad_Vacas=0;
        for(int i=0;i<animal_Actual;i++){
            if(animales[i].getRaza().trim().equals("Vaca") || animales[i].getRaza().trim().equals("vaca") || animales[i].getRaza().trim().equals("VACA") ){
                promedio+=animales[i].ObtenerPromedio()*animales[i].getSemana_Actual();
                cantidad_Vacas+=1;
            }
        }
        promedio /= cantidad_Vacas;
    
        return promedio;
    }
    public float ObtenerPromedioCabras(){
        float promedio=0; 
        int cantidad_Cabras=0;
        for(int i=0;i<animal_Actual;i++){
            if(animales[i].getRaza().trim().equals("Cabra") || animales[i].getRaza().trim().equals("cabra") || animales[i].getRaza().trim().equals("CABRA") ){
                promedio+=animales[i].ObtenerPromedio()*animales[i].getSemana_Actual();
                cantidad_Cabras+=1;
            }
        }

        promedio /= cantidad_Cabras;    
        return promedio;
    }
    
    public String[] Vacas_Max(){
        String [] Respuesta = new String [3];
        float promedio_max =-1;
        int contador=0;
        for(int i=0;i<animal_Actual;i++){
            if(animales[i].getRaza().trim().equals("Vaca") || animales[i].getRaza().trim().equals("vaca") || animales[i].getRaza().trim().equals("VACA") ){
                promedio_max=max(promedio_max,animales[i].ObtenerPromedio());
            }
        }
        for(int i=0;i<animal_Actual;i++){
            if(animales[i].getRaza().trim().equals("Vaca") || animales[i].getRaza().trim().equals("vaca") || animales[i].getRaza().trim().equals("VACA") ){
               if(animales[i].ObtenerPromedio()==promedio_max){
                  Respuesta[contador]=animales[i].getID();
                  contador +=1;
                  if(contador>=3){
                      break;
                  }
               }
            }
        }
        return Respuesta;
    }
    public String[] Cabras_Max(){
        String [] Respuesta = new String [3];
        float promedio_max =-1;
        int contador=0;
        for(int i=0;i<animal_Actual;i++){
            if(animales[i].getRaza().trim().equals("Cabra") || animales[i].getRaza().trim().equals("cabra") || animales[i].getRaza().trim().equals("CABRA") ){
                promedio_max=max(promedio_max,animales[i].ObtenerPromedio());
            }
        }
        for(int i=0;i<animal_Actual;i++){
            if(animales[i].getRaza().trim().equals("Cabra") || animales[i].getRaza().trim().equals("cabra") || animales[i].getRaza().trim().equals("CABRA") ){
               if(animales[i].ObtenerPromedio()==promedio_max){
                  Respuesta[contador]=animales[i].getID();
                  contador +=1;
                  if(contador>=3){
                      break;
                  }
               }
            }
        }
        return Respuesta; //Como hacer arreglo dinamico
    }
    
    private void CargaAnimales(String ruta_Archivo) throws FileNotFoundException, ParseException{
        Scanner read = new Scanner (new FileInputStream(ruta_Archivo));
        read.useDelimiter(",");
        String raza,fecha,edad,l1,l2,l3,l4,l5;

        while(read.hasNext())
        {         
            raza = read.next();
            fecha = read.next();
            edad = read.next();
            l1 = read.next();
            l2 = read.next();
            l3 = read.next();
            l4 = read.next();
            l5 = read.next();                
            animales [animal_Actual]=new Animal(Integer.valueOf(edad),raza,new SimpleDateFormat("dd/MM/yyyy").parse(fecha));
            animales [animal_Actual].RegistroLeche(Float.valueOf(l1));  
            animales [animal_Actual].RegistroLeche(Float.valueOf(l2));
            animales [animal_Actual].RegistroLeche(Float.valueOf(l3));
            animales [animal_Actual].RegistroLeche(Float.valueOf(l4));
            animales [animal_Actual].RegistroLeche(Float.valueOf(l5));
            animal_Actual+=1;
        }
        read.close();
    }
    
}
