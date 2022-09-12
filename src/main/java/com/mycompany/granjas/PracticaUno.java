/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.granjas;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Arrays;

/**
 *
 * @author Suri
 */
public class PracticaUno {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Granjas g = new Granjas ("C:\\Users\\POWERMARS\\Documents\\Prueba.txt");
        System.out.println(g.ObtenerPromedioVacas());
        System.out.println(g.ObtenerPromedioCabras());
        System.out.println(Arrays.toString(g.Vacas_Max()));
        System.out.println(Arrays.toString(g.Cabras_Max()));
    }
}
