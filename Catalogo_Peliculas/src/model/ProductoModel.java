/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author steve
 */
public abstract class ProductoModel{
    private int           id;
    private String        nombre; 
    private int           anio;
    private double        rating;
    private CreadorModel  creador;
    private String        tipo;
    private ArrayList<String> comentarios;
    
    
    public ProductoModel(int id, String nombre, int anio, double rating, CreadorModel creador, String tipo) {
        this.id      = id;
        this.nombre  = nombre;
        this.anio    = anio;
        this.rating  = rating;
        this.creador = creador;
        this.tipo    = tipo;
    }
    public ProductoModel(int id, String nombre, int anio, double rating, CreadorModel creador, String tipo, ArrayList<String> comentarios) {
        this.id             = id;
        this.nombre         = nombre;
        this.anio           = anio;
        this.rating         = rating;
        this.creador        = creador;
        this.comentarios    = comentarios;
        this.tipo           = tipo;
    }
    
    public Object[] toArray(){
        Object[] data = {nombre, anio, rating, creador.getNombre(), tipo};
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public CreadorModel getCreador() {
        return creador;
    }

    public void setCreador(CreadorModel creador) {
        this.creador = creador;
    }

    public ArrayList<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<String> comentarios) {
        this.comentarios = comentarios;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
