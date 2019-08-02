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
public class Hotel extends PaqueteComponent{
    ArrayList<PaqueteComponent> componentes;  
    private long idHotel;
    private String nombreHotel;
    public Hotel(){
        super();
    }
    /**
     * 
     * @param idHotel identificador unico para el hotel
     * @param nombreHotel nombre del hotel
     */
    public Hotel(long idHotel,String nombreHotel){
        super();
        this.idHotel=idHotel;
        this.nombreHotel=nombreHotel;
        componentes = new ArrayList<>();
    }
    
    /**
     * este metodo premite añadir objetos ya sea hojas o composite's a hotel
     * @param myComponent 
     */
    @Override
    public void addComponent(PaqueteComponent myComponent) {
        componentes.add(myComponent);
    }
    /**
     * 
     * @param myComponent componente a eliminar del objeto compuesto hotel
     */
    public void removeComponent(PaqueteComponent myComponent){
        componentes.remove(myComponent);
    }
    /**
     * sobre-escritura del método de Pawuete component
     * @return 
     */
    @Override
    public int getPrecio() {
        int precio=0;
        for (int i = 0; i < componentes.size(); i++) {
            precio= precio +componentes.get(i).getPrecio();
        }
        return precio;
    }
/**
 * devuelve el array de hojas y/o composites dentro de hotel
 * @return 
 */
    public ArrayList<PaqueteComponent> getComponentes() {
        return componentes;
    }
    /**
     * 
     * @param numHabitacion numero de habitacion de este hotel a buscar
     * @return devuelve la habitacion, sino la encuentra devuelve null
     */
    public Habitacion buscarHabitacion(int numHabitacion){      
        for (int i = 0; i < componentes.size(); i++) {
            if(componentes.get(i) instanceof Habitacion){
                    Habitacion myHabitacion = (Habitacion)componentes.get(i);
                if(numHabitacion == myHabitacion.getNumeroHabitacion()){
                    return myHabitacion;
                }
            } else {
            }
        }
        return null;
    
    }
    /**
     * 
     * @param idPlan id del plan de alimentacion en este hotel
     * @return devuelve el plan de alimentacio, si no lo encuentra devuelve null
     */
    public PlanAlimentacionHotel buscarPlanAlimentacion(long idPlan){
        for (int i = 0; i < componentes.size(); i++) {
            if(componentes.get(i) instanceof PlanAlimentacionHotel){
                    PlanAlimentacionHotel myPlanAlimentacionHotel = (PlanAlimentacionHotel)componentes.get(i);
                if(idPlan == myPlanAlimentacionHotel.getIdPlanAlimentacion()){
                    return myPlanAlimentacionHotel;
                }
            } else {
            }
        }
        return null;
    }

    public void setArray(ArrayList<PaqueteComponent> componentes) {
        this.componentes = componentes;
    }
    
    public ArrayList<PaqueteComponent> getArrayComponentes() {
        return componentes;
    }
    
    public long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(long idHotel) {
        this.idHotel = idHotel;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

}
