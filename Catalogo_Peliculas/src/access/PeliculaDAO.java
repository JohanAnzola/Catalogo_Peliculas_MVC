/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.PeliculaModel;
import model.ProductoModel;
import utils.ConnectionDB;

/**
 *
 * @author steve
 */
public class PeliculaDAO {
    private Connection conn = null;
    private CreadorDAO CreadorDAO = new CreadorDAO();
    /**
     * 
     * @return 
     */
    public ArrayList<PeliculaModel> getAllPeliculas() {
        ArrayList<PeliculaModel> peliculas = new ArrayList();
        
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT producto.id, producto.nombre, producto.anio, producto.rating, pelicula.duracion, creador.id, pelicula.resumen\n" +
                         "FROM producto\n" +
                         "JOIN pelicula ON (producto.id = pelicula.producto_id)\n" +
                         "JOIN creador ON(producto.creador_id = creador.id);";
            Statement statement = conn.createStatement();
            
            ResultSet result    = statement.executeQuery(sql);
            
            
            while (result.next()) {
                PeliculaModel pelicula = new PeliculaModel(result.getInt(1), result.getString(2), result.getInt(3), result.getDouble(4), result.getInt(5), CreadorDAO.getCreador(result.getInt(6)), result.getString(7), "Pelicula");
                peliculas.add( pelicula );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        //System.out.println(peliculas.size()+"tamaño");
        return peliculas;
    }

    
    public ArrayList<PeliculaModel> getFilteredPeliculas(String peliculaNombre) {
        ArrayList<PeliculaModel> peliculas = new ArrayList();
        
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql ="SELECT producto.id, producto.nombre, producto.anio, producto.rating, pelicula.duracion, creador.id, pelicula.resumen \n" +
                        "FROM producto \n" +
                        "JOIN pelicula ON (producto.id = pelicula.producto_id)\n" +
                        "JOIN creador ON (producto.creador_id = creador.id)\n" +
                        "WHERE (producto.nombre LIKE ?) OR (producto.anio LIKE ?) OR (creador.nombre LIKE ?);";
            
                        
            PreparedStatement statement = conn.prepareStatement(sql);
            //System.out.println(sql);            
            statement.setString(1, "%"+peliculaNombre+"%");
            statement.setString(2, "%"+peliculaNombre+"%");
            statement.setString(3, "%"+peliculaNombre+"%");
            //System.out.println(statement.toString());
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                PeliculaModel pelicula = new PeliculaModel(result.getInt(1), result.getString(2), result.getInt(3), result.getDouble(4), result.getInt(5), CreadorDAO.getCreador(result.getInt(6)), result.getString(7), "Pelicula");
                peliculas.add( pelicula );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return peliculas;
    }
    
    
    public void insertPelicula(PeliculaModel pelicula){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO producto(creador_id, nombre, anio, rating) VALUES (?, ?, ?, ?);\n" +
                         "INSERT INTO pelicula(producto_id, duracion, resumen) VALUES (@@identity, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pelicula.getCreador().getId());
            statement.setString(2, pelicula.getNombre());
            statement.setInt(3, pelicula.getAnio());
            statement.setDouble(4, pelicula.getRating());
            
            statement.setInt(5, pelicula.getDuracion());
            statement.setString(6, pelicula.getResumen());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void updatePelicula(PeliculaModel pelicula){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE  producto SET creador_id = ?, nombre = ?, anio = ?, rating = ? WHERE producto.id = ?;\n" +
                         "UPDATE  pelicula SET duracion = ?, resumen= ? WHERE pelicula.producto_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pelicula.getCreador().getId());
            statement.setString(2, pelicula.getNombre());
            statement.setInt(3, pelicula.getAnio());
            statement.setDouble(4, pelicula.getRating());
            statement.setInt(5, pelicula.getId());
            
            statement.setInt(6, pelicula.getDuracion());
            statement.setString(7, pelicula.getResumen());
            statement.setInt(8, pelicula.getId());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void deletePelicula(ProductoModel pelicula){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM producto WHERE id= ?;\n" +
                         "DELETE FROM pelicula WHERE producto_id= ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pelicula.getId());
            statement.setInt(2, pelicula.getId());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue eliminado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
}
