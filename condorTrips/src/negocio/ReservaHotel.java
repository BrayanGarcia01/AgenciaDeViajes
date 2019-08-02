/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Date;

/**
 *
 * @author brayangarcia
 */
public class ReservaHotel {
    private Habitacion myHabitacion;
    private Cliente myCliente;
    private Date fechaEntrada;
    private Date fechaSalida;
    /**
     * 
     * @param myHabitacion habitacion de la reserva
     * @param myCliente cliente que hizo la reserva
     * @param fechaEntrada  fecha entrada a la habitacion
     * @param fechaSalida  fecha salida de la habitacion
     */
    public ReservaHotel(Habitacion myHabitacion, Cliente myCliente, Date fechaEntrada, Date fechaSalida) {
        this.myHabitacion = myHabitacion;
        this.myCliente = myCliente;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }
    

    public Habitacion getMyHabitacion() {
        return myHabitacion;
    }

    public void setMyHabitacion(Habitacion myHabitacion) {
        this.myHabitacion = myHabitacion;
    }

    public Cliente getMyCliente() {
        return myCliente;
    }

    public void setMyCliente(Cliente myCliente) {
        this.myCliente = myCliente;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    
    
}
