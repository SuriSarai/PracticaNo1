/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.granjas;

import java.util.Date;

/**
 *
 * @author Suri
 */
public class Animal {
    private int edad;
    private String raza;
    private Date fecha_ingreso;
    private String ID;
    private float[] leche_Semana = new float[52];
    private int Semana_Actual = 0;

    public String getID() {
        return ID;
    }

    public String getRaza() {
        return raza;
    }

    public int getSemana_Actual() {
        return Semana_Actual;
    }
    

    public Animal(int edad, String raza, Date fecha_ingreso) {
        this.edad = edad;
        this.raza = raza;
        this.fecha_ingreso = fecha_ingreso;
        GeneraID();
    }
    
    public void RegistroLeche(float litros){
        leche_Semana[Semana_Actual]=litros; //Se guardan en semana actual para no perder los registros anteriores
        Semana_Actual +=1;  
       
    }
    
    public float ObtenerPromedio(){
        float promedio=0;
        for(int i=0;i<Semana_Actual;i++){
            promedio+=leche_Semana[i];
        }
        if(Semana_Actual!=0){
            promedio /=Semana_Actual;
        }
        return promedio;
    }
    
    private void GeneraID(){
        ID=String.valueOf(edad)+raza; //Cambiar a 8 digitos (pendiente)
       
    }
      
}
