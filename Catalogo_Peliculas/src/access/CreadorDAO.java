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
import model.CreadorModel;
import utils.ConnectionDB;

/**
 *
 * @author steve
 */
public class CreadorDAO {
    private Connection conn = null;
    
    /**
     * 
     * @return 
     */
    
    public ArrayList<CreadorModel> getFinteredCreadores(String creadorNombre) {
        ArrayList<CreadorModel> creadores = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT id, nombre, nacionalidad, edad from creador WHERE (nombre LIKE ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+creadorNombre+"%");
            ResultSet result    = statement.executeQuery();
            
            while (result.next()) {
                CreadorModel creador = new CreadorModel(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
                creadores.add( creador );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return creadores;
    }

    public CreadorModel getCreador(int id) {
        CreadorModel creador = null;
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT nombre, nacionalidad, edad FROM creador WHERE id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery( );
            while (result.next()) {
                creador = new CreadorModel(id, result.getString(1), result.getString(2), result.getInt(3));
                break;
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return creador;
    }

    
    /**
     * 
     * @param museum 
     */
    public void insertCreador(CreadorModel creador){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO creador(nombre, nacionalidad, edad)  VALUES (?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, creador.getNombre());
            statement.setString(2, creador.getNacionalidad());
            statement.setInt(3, creador.getEdad());

            System.out.println("inserta creador---");
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    
    /**
     * 
     * @param museum 
     */
    public void updateCreador(CreadorModel creador) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE creador SET nombre = ?, nacionalidad = ?, edad = ? WHERE id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, creador.getNombre());
            statement.setString(2, creador.getNacionalidad());
            statement.setInt(3, creador.getEdad());
            statement.setInt(4, creador.getId());
            System.out.println("actualiza creador---");
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }

    
    /**
     * 
     * @param id 
     */
    public void deleteCreador(int id) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM creador WHERE id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
    
}
