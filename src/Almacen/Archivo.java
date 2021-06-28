/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Almacen;


import informacion.Datos;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
/**
 *
 * @author JORGE VALERIANO
 */
public class Archivo {
    
    public void agregarUsuario (Datos datos){
        String cadena = convertirJson(datos);
        try{
            FileWriter archivo = new FileWriter("datos.txt", true);
            BufferedWriter bw = new BufferedWriter(archivo);
            bw.write(cadena + "\n");
            bw.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public List<Datos> leerusuarios(){
        List<Datos> listadatos = new ArrayList<>();
        String cadena;
        try{
            FileReader archivo = new FileReader("datos.txt");
            BufferedReader br = new BufferedReader(archivo);
            while((cadena = br.readLine()) !=null){
               listadatos.add(convEstructura(cadena));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }return listadatos;
    }
    
    private String convertirJson(Datos datos){
        Gson gson= new Gson();
        String cadena;
        cadena = gson.toJson(datos);
        return cadena;
    }
    
    private Datos convEstructura(String cadena){
        Gson gson = new Gson();
        Datos datos = new Datos();
        datos = gson.fromJson(cadena, Datos.class);
        return datos;
    }
}
