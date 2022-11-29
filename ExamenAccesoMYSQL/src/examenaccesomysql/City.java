/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenaccesomysql;

/**
 *
 * @author Alex Santos
 */
public class City {
    
    private int id;
    private String ciudad;
    private String codigo;
    private String distrito;
    private int poblacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public City(int id, String ciudad, String codigo, String distrito, int poblacion) {
        this.id = id;
        this.ciudad = ciudad;
        this.codigo = codigo;
        this.distrito = distrito;
        this.poblacion = poblacion;
    }

    public City() {
    }
    
    
    
}
