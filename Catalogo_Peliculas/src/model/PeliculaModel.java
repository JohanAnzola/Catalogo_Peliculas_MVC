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
public class PeliculaModel extends ProductoModel {
    private int duracion;
    private String resumen;

    public PeliculaModel(int id, String nombre, int anio, double rating, int duracion, CreadorModel creador, String resumen, String tipo) {
        super(id, nombre, anio, rating, creador, tipo);
        this.duracion = duracion;
        this.resumen = resumen;
    }
    public PeliculaModel(int id, String nombre, int anio, double rating, int duracion, CreadorModel creador, String resumen, String tipo,ArrayList<String> comentarios) {
        super(id, nombre, anio, rating, creador, tipo, comentarios );
        this.duracion = duracion;
        this.resumen = resumen;
    }
    
    @Override
    public Object[] toArray(){
        Object[] data = {getNombre(),getAnio(), getRating(), getCreador().getNombre(), getTipo(), this.duracion, this.resumen};
        return data;
    }
    

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    
}
