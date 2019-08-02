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
public class Vuelo extends PaqueteComponent{
    
    private long idVuelo;
    private String aerolinea;
    private int precio;
    private String nombreCiudadOrigen;
    private String nombreCiudadDestino;
    private String fechaHoraLlegada;
    private String fechaHoraSalida;
    public Vuelo(){
    }
    /**
     * 
     * @param idVuelo id unico del vuelo
     * @param aerolinea aerolinea que ofrece ese vuelo
     * @param nombreCiudadOrigen    nombre ciudad de origen 
     * @param nombreCiudadDestino   nombre ciudad destino
     * @param fechaHoraLlegada  fecha llegada
     * @param fechaHoraSalida fecha salida
     * @param precio precio del  vuelo
     */
    public Vuelo(long idVuelo,String aerolinea,String nombreCiudadOrigen,String nombreCiudadDestino, String fechaHoraLlegada, String fechaHoraSalida, int precio) {
        this.idVuelo=idVuelo;
        this.aerolinea = aerolinea;
        this.nombreCiudadOrigen= nombreCiudadOrigen;
        this.nombreCiudadDestino= nombreCiudadDestino;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.fechaHoraSalida = fechaHoraSalida;
        this.precio = precio;
        
    }
        

    public long getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(long idVuelo) {
        this.idVuelo = idVuelo;
    }

     @Override
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
  

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public void setFechaHoraLlegada(String fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public String getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(String fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public String getNombreCiudadOrigen() {
        return nombreCiudadOrigen;
    }

    public void setNombreCiudadOrigen(String nombreCiudadOrigen) {
        this.nombreCiudadOrigen = nombreCiudadOrigen;
    }

    public String getNombreCiudadDestino() {
        return nombreCiudadDestino;
    }

    public void setNombreCiudadDestino(String nombreCiudadDestino) {
        this.nombreCiudadDestino = nombreCiudadDestino;
    }

}
