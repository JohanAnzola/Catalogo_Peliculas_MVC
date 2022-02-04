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
import model.ProductoModel;
import model.SerieModel;
import utils.ConnectionDB;

/**
 *
 * @author steve
 */
public class SerieDAO {
    private Connection conn = null;
    private CreadorDAO CreadorDAO = new CreadorDAO();
    /**
     * 
     * @return 
     */
    public ArrayList<SerieModel> getAllSeries() {
        ArrayList<SerieModel> series = new ArrayList();
        
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT producto.id, producto.nombre, producto.anio, producto.rating, serie.temporadas, creador.id, serie.episodios  \n" +
                         "FROM producto \n" +
                         "JOIN serie ON (producto.id = serie.producto_id)\n" +
                         "JOIN creador ON (producto.creador_id = creador.id);";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                SerieModel serie = new SerieModel(result.getInt(1), result.getString(2), result.getInt(3), result.getDouble(4), result.getInt(5), CreadorDAO.getCreador(result.getInt(6)), result.getInt(7), "Serie");
                series.add( serie );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        System.out.println(series.size());
        return series;
    }

    
    public ArrayList<SerieModel> getFilteredSeries(String serieDato) {
        ArrayList<SerieModel> series = new ArrayList();
        
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT producto.id, producto.nombre, producto.anio, producto.rating, serie.temporadas, creador.id, serie.episodios \n" +
                        "FROM producto \n" +
                        "JOIN serie ON (producto.id = serie.producto_id)\n" +
                        "JOIN creador ON (producto.creador_id = creador.id)\n" +
                        "WHERE (producto.nombre LIKE ?) OR (producto.anio LIKE ?) OR (creador.nombre LIKE ?);";
            
                        
            PreparedStatement statement = conn.prepareStatement(sql);
            //System.out.println(sql);            
            statement.setString(1, "%"+serieDato+"%");
            statement.setString(2, "%"+serieDato+"%");
            statement.setString(3, "%"+serieDato+"%");
            //System.out.println(statement.toString());
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                SerieModel serie = new SerieModel(result.getInt(1), result.getString(2), result.getInt(3), result.getDouble(4), result.getInt(5), CreadorDAO.getCreador(result.getInt(6)), result.getInt(7), "Serie");
                series.add( serie );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return series;
    }
    
    
    public void insertSerie(SerieModel serie){
        System.out.println("siii entrooo");
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO producto(creador_id, nombre, anio, rating) VALUES (?, ?, ?, ?);\n" +
                         "INSERT INTO serie(producto_id, temporadas, episodios) VALUES (@@identity, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, serie.getCreador().getId());
            statement.setString(2, serie.getNombre());
            statement.setInt(3, serie.getAnio());
            statement.setDouble(4, serie.getRating());
            
            statement.setInt(5, serie.getTemporadas());
            statement.setInt(6, serie.getEpisodios());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    } 
    
    public void updateSerie(SerieModel serie){
        System.out.println("siii entrooo");
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE  producto SET creador_id = ?, nombre = ?, anio = ?, rating = ? WHERE producto.id = ?;\n" +
                         "UPDATE  serie SET temporadas = ?, episodios= ? WHERE serie.producto_id = ?;";
            System.out.println("actualiza in serta serie---");
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, serie.getCreador().getId());
            statement.setString(2, serie.getNombre());
            statement.setInt(3, serie.getAnio());
            statement.setDouble(4, serie.getRating());
            statement.setInt(5, serie.getId());
            statement.setInt(6, serie.getTemporadas());
            statement.setInt(7, serie.getEpisodios());
            statement.setInt(8, serie.getId());
            System.out.println("actualiza in serta serie---");
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue Actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void deleteSerie(ProductoModel serie){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM producto WHERE id=?;\n" +
                         "DELETE FROM serie WHERE producto_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, serie.getId());
            statement.setInt(2, serie.getId());
            
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue Borrado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    } 
}
