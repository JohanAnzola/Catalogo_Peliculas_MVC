/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author steve
 */
public class CreadorModel {
    private int    id;
    private int    edad;
    private String nombre;
    private String nacionalidad;


    public CreadorModel(int id, String nombre, String nacionalidad, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;

    }
    public CreadorModel(String nombre, String nacionalidad, int edad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;

    }
    public Object[] toArray(){
        Object[] data = {this.nombre};
        return data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    

    
    
            
}
