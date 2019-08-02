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
public class Ciudad extends PaqueteComponent{
 ArrayList<PaqueteComponent> componentes;
    long idCiudad;
    String nombreCiudad;
    int precio;
    public Ciudad(){
        super();
        componentes = new ArrayList<>();
    }
    public Ciudad(long idCiudad, String nombreCiudad,int precio){
        super();
        componentes = new ArrayList<>();
        this.idCiudad=idCiudad;
        this.nombreCiudad=nombreCiudad;
        this.precio = precio;
    }
    /**
     * se añade un nuevo objeto de tipo PaqueteComponent a la ciudad
     * @param myComponent 
     */
    @Override
    public void addComponent(PaqueteComponent myComponent){
        componentes.add(myComponent);
    }
    /**
     * se elimina el paquete myComponent del vector de componentes
     * 
     * @param myComponent 
     */
    public void removeComponent(PaqueteComponent myComponent){
        componentes.remove(myComponent);
    }
    /** 
     * sesobre-escribe el método de PaqueteComponent
     * @return precio calculado por cadena de responsabilidad sobre los demá componentes de ciudad
     */
    @Override
    public int getPrecio() {
        int subPrecio=0;
        for (int i = 0; i < componentes.size(); i++) {
            subPrecio+=componentes.get(i).getPrecio();
        }
        return precio+subPrecio;
    }
    /**
     * 
     * @return precio singular de viajar a la ciudad, precio estimado por la empresa
     */
    public int getPrecioCiudadSolo(){
        return precio;
    }

    public ArrayList<PaqueteComponent> getComponentes() {
        return componentes;
    }
    /**
     * es necesario diferenciar lo sobjetos dentro del composite para hacer una busquedas obre cada item
     * @param idHotel id fel hotel a buscar
     * @param numHab numero de habitacion dentro del hotel a buscar
     * @return 
     */
     public Hotel buscarHabitacion(long idHotel, int numHab){
        for (int i = 0; i < componentes.size(); i++) {
            if(componentes.get(i) instanceof Hotel){
                    Hotel myHotel = (Hotel)componentes.get(i);
                if(idHotel == myHotel.getIdHotel()){
                    
                    Habitacion myHabitacion=myHotel.buscarHabitacion(numHab);
                    if(myHabitacion!=null){
                        return myHotel;
                    }else{
                        return null;
                    }
                }
            }
        }
        return null;
    }
     /**
      * 
      * @param idHotel id del hotel a buscar 
      * @return devuelve ell hotel buscado o null si no se encuentra
      */
     public Hotel buscarHotel(long idHotel){
        for (int i = 0; i < componentes.size(); i++) {
            if(componentes.get(i) instanceof Hotel){
                    Hotel myHotel = (Hotel)componentes.get(i);
                if(idHotel == myHotel.getIdHotel()){
                    return myHotel;
                }
            }
        }
        return null;
    }   
     /**
      * 
      * @param nombreHotel nombre del hotel a buscar
      * @return devuelve el hotel buscado o  null sino se encuentra
      */
     public Hotel buscarHotel(String nombreHotel){
         for (int i = 0; i < componentes.size(); i++) {
            if(componentes.get(i) instanceof Hotel){
                    Hotel myHotel = (Hotel)componentes.get(i);
                if(myHotel.getNombreHotel().equals(nombreHotel)){
                    return myHotel;
                }
            }
        }
        return null;
     }
     
    /**
     * 
     * @return devuelve los hoteles del paquete en cuestion 
     */
    
     public ArrayList<Hotel>devolverHotelesDelPaquete(){
        ArrayList<Hotel> misHoteles = new ArrayList<>();

         for (int i = 0; i < componentes.size(); i++) {
             if(componentes.get(i) instanceof Hotel){
                    Hotel myHotel = (Hotel)componentes.get(i);
                    misHoteles.add(myHotel);
           
            }
        }
        return misHoteles;     
     }
     /**
      * 
      * @param idCityTour id del citytour a buscar
      * @return devuelve el citytour buscado, sino lo encuentra devuelve null
      */
      public CityTour buscarCityTour(long idCityTour){
        for (int i = 0; i < componentes.size(); i++) {
            if(componentes.get(i) instanceof CityTour){
                CityTour myCityTour = (CityTour)componentes.get(i);
                if(idCiudad == myCityTour.getIdCityTour()){
                    return myCityTour;
                }
            } else {
            }
        }
        return null;
    }
      /**
       * 
       * @param idVuelo iddel vuelo a buscar 
       * @return devuelve el vuelo con el id especificado, sino lo encuentra devuelve null
       */
    public Vuelo buscarVuelo(long idVuelo){
        for (int i = 0; i < componentes.size(); i++) {
            if(componentes.get(i) instanceof  Vuelo){
                Vuelo myVuelo = (Vuelo)componentes.get(i);
                if(idVuelo == myVuelo.getIdVuelo()){
                    return myVuelo;
                }
            } else {
            }
        }
        return null;
    }


    
    public long getIdCiudad() {
        return idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }    
}
