/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import mvcf.AModel;
import recursos.MyException;

/**
 *
 * @author brayangarcia
 */
public class Paquete extends PaqueteComponent {
    long idPaquete;
    String nombrePaquete;
    String fechaCreacion;
    String fechaInicio;
    String fechaFin;
    char tipo;
    int existencias;
    String descripcion;
    ArrayList<PaqueteComponent> componentes;
    public Paquete() {
        super();
        componentes = new ArrayList<>();
    }
/**
 * 
 * @param idPaquete id del paquete
 * @param fechaCreacion fecha de cracion del paquete en formatio  yyyy-MM-dd
 * @param tipo tipo, puede tomar valor 'P' de personalizado o 'T' de todo incluido
 * @param existencias existencias del plan, cuantos paquetes del mismo existen para la venta    
 */
    public Paquete(long idPaquete, String fechaCreacion,char tipo,int existencias) {
        super();
        this.idPaquete = idPaquete;
        this.fechaCreacion = fechaCreacion;
        this.tipo=tipo;
        this.existencias=existencias;
        componentes = new ArrayList<>();
        
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getNombrePaquete() {
        return nombrePaquete;
    }

    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }
    
    
    @Override
    public int getPrecio() {
        int precio=0;
        for (int i = 0; i < componentes.size(); i++) {
            precio+=componentes.get(i).getPrecio();
        }
        return precio;
        
    }
    @Override
    public void addComponent(PaqueteComponent myComponent) {
        componentes.add(myComponent);

    }
    public void removeComponent(PaqueteComponent myComponent){
        removeComponent(myComponent);

    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    public Ciudad buscarCiudad(long idCiudad){
        for (int i = 0; i < componentes.size(); i++) {
            if(componentes.get(i) instanceof Ciudad){
                Ciudad myCiudad = (Ciudad)componentes.get(i);
                if(idCiudad == myCiudad.getIdCiudad()){
                    return myCiudad;
                }
            } else {
            }
        }
        return null;
    }

    public ArrayList<PaqueteComponent> getComponentes() {
        return componentes;
    }

    public long getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(long idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    
    
    
}
