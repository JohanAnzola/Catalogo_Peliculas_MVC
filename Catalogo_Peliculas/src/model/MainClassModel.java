/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.ProductoVista;
import view.VistaProductos;

/**
 *
 * @author steve
 */
public class MainClassModel {
    public static VistaProductos vistaProductos = new VistaProductos();
    public static ProductoVista productoVista = new ProductoVista();
   
    //pelis crea y agrega
    
    
    public static void main(String[] args) {
        
        
        vistaProductos.setVisible(true);
        
         //Producto nuevo_producto = new Serie("nombre","gene","2013","12.5","5");
        //String a = nuevo_producto.toString();
        
    }
    public static void setVista (){
       
        if(vistaProductos.isVisible()){
            productoVista.setSize(vistaProductos.getSize());
            productoVista.setLocation(vistaProductos.getLocation());
            
            productoVista.setVisible(true);
            vistaProductos.setVisible(false);
        }else{
            vistaProductos.setLocation(productoVista.getLocation());
            vistaProductos.setSize(productoVista.getSize());
            
            vistaProductos.setVisible(true);
            productoVista.setVisible(false);
            
        }  
    }
   
    
}
