/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;

/**
 *
 * @author brayangarcia
 */
public class Pais {
    private long idPais;
    private String nombre;
    private ArrayList<Ciudad> ciudades;
    public Pais() {
        ciudades = new ArrayList<>();
    }
    /**
     * 
     * @param idPais identificador unico del pais
     * @param nombre nombe del pais
     */
    public Pais(long idPais, String nombre) {
        this.idPais = idPais;
        this.nombre = nombre;
        ciudades = new ArrayList<>();

    }

    public long getIdPais() {
        return idPais;
    }

    public void setIdPais(long idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCiudad(long idCiudad, String nombre){
        Ciudad myCiudad = new Ciudad(idCiudad, nombre,0);
        ciudades.add(myCiudad);
    }

    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }
   
    
}
