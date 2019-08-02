/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author brayangarcia
 */
public class Habitacion  extends PaqueteComponent{
     private int precio;
    private int numeroHabitacion;
    private String descripcion;
    private char disponible;
    
    public Habitacion (int numeroHabitacion){
        this.numeroHabitacion= numeroHabitacion;
        descripcion ="";
        disponible ='D';
    }
    /**
     * 
     * @param numeroHabitacion numerode habitacion de hotrel
     * @param descripcion descripcion si es sencilla doble, etc
     * @param disponible    variable char que toma valor o 'D' o 'O', DIsponible y ocupada respectivamente
     * @param precio precio de la habitacion
     */
    public Habitacion (int numeroHabitacion,String descripcion, char disponible,int precio){
        this.numeroHabitacion= numeroHabitacion;
        this.descripcion = descripcion;
        this.disponible= disponible;
        this.precio = precio;
        
    }
    /**
     * metodo sobre-escrito de paqueteComponent
     * @return 
     */
    @Override
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getDisponible() {
        return disponible;
    }

    public void setDisponible(char disponible) {
        this.disponible = disponible;
    }
  
    
}
