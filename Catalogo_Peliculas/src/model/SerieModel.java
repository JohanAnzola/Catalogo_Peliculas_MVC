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
public class SerieModel extends ProductoModel {
    private int temporadas;
    private int episodios;
    
    public SerieModel(int id, String nombre, int anio, double rating, int temporadas, CreadorModel creador, int episodios, String tipo) {
        super(id, nombre, anio, rating, creador, tipo);
        this.temporadas = temporadas;
        this.episodios =  episodios;
    }
    public SerieModel(int id, String nombre, int anio, double rating, int temporadas, CreadorModel creador, int episodios, String tipo,ArrayList<String> comentarios) {
        super(id, nombre, anio, rating, creador, tipo,  comentarios);
        this.temporadas = temporadas;
        this.episodios =  episodios;
    }
    
    @Override
    public Object[] toArray(){
        Object[] data = {getNombre(),getAnio(), getRating(), getCreador().getNombre(), getTipo(), this.temporadas, this.episodios};
        return data;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }
    
    
}
