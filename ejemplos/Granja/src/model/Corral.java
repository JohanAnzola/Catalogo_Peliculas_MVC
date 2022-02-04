package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import controlador.Conector;

public class Corral {
    // Parametros
    private int id=1;
    private double area;
    private boolean esta_limpio;
    private String tipo="corraaasdas";
    // Constructor
    public Corral(int id, double area, boolean esta_limpio){
        this.id = id;
        this.area = area;
        this.esta_limpio = esta_limpio;
        crear_corral(id, area, esta_limpio);
    }
    public Object[] toArray(){
        Object[] data = {id, area, tipo};
        return data;
    } 
    public void crear_corral(int id, double area, boolean esta_limpio){
        String query = "INSERT INTO corral(id,area, esta_limpio) VALUES (?,?,?)";
         try{
            PreparedStatement statement = Conector.getConn().prepareStatement(query);
            statement.setInt(1, id);
            statement.setDouble(2, area);
            statement.setBoolean(3, esta_limpio);
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0){
                System.out.println("Se creó el corral");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }      
    } 
}
