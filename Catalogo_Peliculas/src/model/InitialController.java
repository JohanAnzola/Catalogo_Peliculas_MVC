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
import access.CreadorDAO;
import access.PeliculaDAO;
import access.SerieDAO;
import java.util.Scanner;
import java.util.ArrayList;
import view.ProductoVista;
import view.VistaProductos;
public class InitialController {
    
    private ProductoModel            productoSelected;
    private PeliculaDAO              peliculaDAO ;
    private SerieDAO                 serieDAO;
    private CreadorDAO               creadorDAO;
    private ArrayList<PeliculaModel> peliculas;
    private ArrayList<SerieModel>    series ;
    private ArrayList<CreadorModel>  creadores ;
    private ArrayList<ProductoModel> productos = new ArrayList();
    
    
    
    public InitialController(){
        this.peliculaDAO    = new PeliculaDAO();
        this.serieDAO       = new SerieDAO();
        this.creadorDAO     = new CreadorDAO();
        this.creadores      = this.creadorDAO.getFinteredCreadores("");
        this.peliculas      = this.peliculaDAO.getAllPeliculas();
        this.series         = this.serieDAO.getAllSeries();
        this.productos.addAll(peliculas);
        this.productos.addAll(series);
     
    }
    public ArrayList<ProductoModel> getAllDAO(){
        ArrayList<ProductoModel> productos = new ArrayList();
        this.peliculas = this.peliculaDAO.getAllPeliculas();
        this.series = this.serieDAO.getAllSeries();
        productos.addAll(peliculas);
        productos.addAll(series);
        this.productos = productos;
        return productos;
    }
    public ArrayList<ProductoModel> getFilteredDAO (String searchText ){
        ArrayList<ProductoModel> productos = new ArrayList();
        this.peliculas = this.peliculaDAO.getFilteredPeliculas(searchText);
        this.series = this.serieDAO.getFilteredSeries(searchText);
        productos.addAll(peliculas);
        productos.addAll(series);
        this.productos = productos;
        return productos;
    }
    private void searchOrAll (String searchText){
        if(searchText.isEmpty()){
            getAllDAO();
        }else{
            getFilteredDAO(searchText);
        }
    }

    public ArrayList<ProductoModel> getAllProductos(String searchText) {
        searchOrAll (searchText);
        return productos;
    }
    
    //obtener lista de cradors
     public ArrayList<CreadorModel> getFilteredCreadorDAO (String searchText ){
        ArrayList<CreadorModel> creadores = new ArrayList();
        creadores = this.creadorDAO.getFinteredCreadores(searchText);
        return creadores;
    }
    //public void getAllCreadores()
    
 //Ingresa y actualizar productos
    public void setPeliculaDAO(PeliculaModel newPelicula) {
        if(newPelicula!=null){
            int idMayorCreadores=0;
            System.out.println("id creador sera este " + newPelicula.getCreador().getId());
            if(newPelicula.getCreador().getId() == -1){ 
                this.creadorDAO.insertCreador(newPelicula.getCreador()); 
                for(int i=0; i<creadores.size(); i++){
                    idMayorCreadores = idMayorCreadores>creadores.get(i).getId() ? idMayorCreadores:creadores.get(i).getId();
                }
                newPelicula.getCreador().setId(idMayorCreadores+1);
            }else{
                this.creadorDAO.updateCreador(newPelicula.getCreador());
            }
            
            if(newPelicula.getId() == -1){ 
                this.peliculaDAO.insertPelicula(newPelicula); 
            }else{
                this.peliculaDAO.updatePelicula(newPelicula);
            
            }
            this.peliculaDAO = peliculaDAO;

        }
        
    }
   
   
    public void setSerieDAO(SerieModel newSerie) {
        if(newSerie!=null){
            int idMayorCreadores=0;
            System.out.println("id creador sera este " + newSerie.getCreador().getId());
            if(newSerie.getCreador().getId() == -1){ 
                this.creadorDAO.insertCreador(newSerie.getCreador()); 
                for(int i=0; i<creadores.size(); i++){
                    idMayorCreadores = idMayorCreadores>creadores.get(i).getId() ? idMayorCreadores:creadores.get(i).getId();
                }
                newSerie.getCreador().setId(idMayorCreadores+1);
            }else{
                this.creadorDAO.updateCreador(newSerie.getCreador());
            }
            
            if(newSerie.getId() == -1){ 
                this.serieDAO.insertSerie(newSerie); 
            }else{
                this.serieDAO.updateSerie(newSerie);
            
            }
            

        }
        
    }
       
    ///////////////////////////////////////////////////////////////
    
    public ArrayList<ProductoModel> getProductoPeliculas(String searchText) {
        searchOrAll (searchText);
        this.productos.removeAll(this.series);
        return this.productos;
    }

    public ArrayList<ProductoModel> getProductoSeries(String searchText) {
        searchOrAll (searchText);
        this.productos.removeAll(this.peliculas);
        return this.productos;
    }
    
    ////borrar/////////////////////////////////////////////////////////
    public void deleteProducto(int index){
        if(index != -1){
            ProductoModel producto = getProducto(index);
            if(producto.getTipo().equals("Serie")){
                serieDAO.deleteSerie(producto);
            }else{
                peliculaDAO.deletePelicula(producto);
            }
            getAllDAO();
        }
        
    }
     public void deleteProducto(ProductoModel producto){
        if(producto != null){
            if(producto.getTipo().equals("Serie")){
                serieDAO.deleteSerie(producto);
            }else{
                peliculaDAO.deletePelicula(producto);
            }
            getAllDAO();
        }
        
    }
    
    
    //enviar a otra vista
    public ProductoModel getProducto(int index){
        ProductoModel producto;
        if(index != -1){
            producto = this.productos.get(index);
        }else{
            producto = null;
        }
      
        return producto;
    }
    public PeliculaModel getPelicula(ProductoModel indexProduct){
        PeliculaModel pelicula = null ;
        getAllDAO();
        for (int i =0; i<this.peliculas.size(); i++){
            if (this.peliculas.get(i).getId() == indexProduct.getId()){
                pelicula = this.peliculas.get(i); 
            }
        }
        return pelicula;
    }
    public SerieModel getSerie(ProductoModel indexProduct){
      getAllDAO();
        SerieModel serie = null;      
        for (int i =0; i<this.series.size(); i++){
            if (this.series.get(i).getId() == indexProduct.getId()){
                serie = this.series.get(i); 
            }
        }
        return serie;
    }
    public ProductoModel setProducto(ProductoModel productoSelected){
        ProductoModel productoReturn = productoSelected;
        return productoReturn;
    }
    
    
    
    
    
}
