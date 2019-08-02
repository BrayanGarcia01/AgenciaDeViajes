/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author danielmej
 */
public class PaqueteWeb {
    /**
     * Atributos
     */
    int idPaquete;
    String nombrepaquete;      
    int precio;
    String fechaInicio;
    String fechaFin;
    String tipoPaquete;  
    String ciudades;
    String vuelos;
    String hoteles;
    String habitaciones;
    String cityTuours;    
    String alimentaciones; 
    //String[] fotos;

    /**
     * Constructor por defecto
     */
    public PaqueteWeb() {
    }

    /**
     * Constructor Parametrizado
     * @param idPaquete
     * @param tipoPaquete
     * @param nombrepaquete
     * @param precio
     * @param fechaInicio
     * @param fechaFin
     * @param ciudades
     * @param vuelos
     * @param hoteles
     * @param habitaciones
     * @param cityTuours
     * @param alimentaciones
     * @param fotos 
     */
    public PaqueteWeb(int idPaquete, String tipoPaquete, String nombrepaquete, int precio, String fechaInicio, String fechaFin, String ciudades, String vuelos, String hoteles, String habitaciones, String cityTuours, String alimentaciones/*,String[] fotos*/) {
        this.idPaquete = idPaquete;
        this.tipoPaquete = tipoPaquete;
        this.nombrepaquete = nombrepaquete;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ciudades = ciudades;
        this.vuelos = vuelos;
        this.hoteles = hoteles;
        this.habitaciones = habitaciones;
        this.cityTuours = cityTuours;
        this.alimentaciones = alimentaciones;
        //this.fotos = fotos;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getTipoPaquete() {
        return tipoPaquete;
    }

    public void setTipoPaquete(String tipoPaquete) {
        this.tipoPaquete = tipoPaquete;
    }

    public String getNombrepaquete() {
        return nombrepaquete;
    }

    public void setNombrepaquete(String nombrepaquete) {
        this.nombrepaquete = nombrepaquete;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCiudades() {
        return ciudades;
    }

    public void setCiudades(String ciudades) {
        this.ciudades = ciudades;
    }

    public String getVuelos() {
        return vuelos;
    }

    public void setVuelos(String vuelos) {
        this.vuelos = vuelos;
    }

    public String getHoteles() {
        return hoteles;
    }

    public void setHoteles(String hoteles) {
        this.hoteles = hoteles;
    }

    public String getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(String habitaciones) {
        this.habitaciones = habitaciones;
    }

    public String getCityTuours() {
        return cityTuours;
    }

    public void setCityTuours(String cityTuours) {
        this.cityTuours = cityTuours;
    }

    public String getAlimentaciones() {
        return alimentaciones;
    }

    public void setAlimentaciones(String alimentaciones) {
        this.alimentaciones = alimentaciones;
    }

    /*
    public String[] getFotos() {
        return fotos;
    }

    public void setFotos(String[] fotos) {
        this.fotos = fotos;
    }*/
     
}
