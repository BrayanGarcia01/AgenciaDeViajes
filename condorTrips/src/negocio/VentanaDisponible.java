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
public class VentanaDisponible {
    boolean nuevaVentana;
    /**
     * con esta clase se simula un singleton, ya que el singleton estándar no se puede utilizar
     * porque cuando se vuelve a añadir una misma ventana al desktop se bloquea, por eso se creó esta
     * clase
     */
    public VentanaDisponible() {
        nuevaVentana=true;
    }

    public boolean isNuevaVentana() {
        return nuevaVentana;
    }

    public void setNuevaVentana(boolean nuevaVentana) {
        this.nuevaVentana = nuevaVentana;
    }
    
    
}
