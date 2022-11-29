/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenaccesomysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alex Santos
 */
public class CityModel extends DBUtil {
    
    public boolean agregarCiudad (City c){
        try {
            PreparedStatement stmt = this.getConexion().prepareStatement("INSERT INTO city(Name,CountryCode,District,Population) VALUES(?, ?, ?, ?)");
            String nombre = c.getCiudad();
            String codigo = c.getCodigo();
            String distrito = c.getDistrito();
            int poblacion = c.getPoblacion();
            stmt.setString(1, nombre);
            stmt.setString(2, codigo);
            stmt.setString(3, distrito);
            stmt.setInt(4, poblacion);
            stmt.executeUpdate();
            return true;
        } finally {
            this.cerrarConexion();
            return false;
        }
    }
    
    public boolean borrarCiudad (City c) {
        boolean comprobar = false;
        ArrayList<City> arrayCiudades = mostrarInformacion();
        for (City ci : arrayCiudades) {
            if (ci.getId() == c.getId()) {
                comprobar = true;
            }
        }
        try {
            PreparedStatement stmt = this.getConexion().prepareStatement("DELETE FROM city where ID=?");
            stmt.setInt(1, c.getId());
            stmt.executeUpdate();
            return comprobar;
        } catch (Exception e) {
            return false;
        }
    }
    
        public ArrayList<City> mostrarInformacion() {
        ArrayList<City> arrayCiudades = new ArrayList();
        try {
            PreparedStatement stmt = this.getConexion().prepareStatement("SELECT ID,Name,CountryCode,District,Population from city");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("Name");
                String codigo = rs.getString("CountryCode");
                String distrito = rs.getString("District");
                int poblacion = rs.getInt("Population");
                City c = new City(id, nombre, codigo, distrito, poblacion);
                arrayCiudades.add(c);
            }
        } catch (Exception e) {
        }
        return arrayCiudades;
    }
        
         public boolean actualizarCiudad(City c) {
        try {
            PreparedStatement stmt = this.getConexion().prepareStatement("UPDATE city set Name=?,CountryCode=?,District=?,Population=? WHERE ID=?");
            stmt.setString(1, c.getCiudad());
            stmt.setString(2, c.getCodigo());
            stmt.setString(3, c.getDistrito());
            stmt.setInt(4, c.getPoblacion());
            stmt.setInt(5, c.getId());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            this.cerrarConexion();
        }
    }
    
}
