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
public class PlanAlimentacionHotel extends PaqueteComponent{

    private long idPlanAlimentacion;
    private String descripcion;
    private int precio;

    public PlanAlimentacionHotel() {
        super();
    }
    /**
     * 
     * @param idPlanAlimentacion id del plan de alimentacion del hotel
     * @param descripcion descripcion del plan de alimentacion por ejemplo desayuno, almuerzo, langosta, etc..
     * @param precio precio del plan de alimentacion
     */

    public PlanAlimentacionHotel(long idPlanAlimentacion, String descripcion, int precio) {
        super();
        this.precio = precio;
        this.idPlanAlimentacion = idPlanAlimentacion;
        this.descripcion = descripcion;
    }

    public void setIdPlanAlimentacion(long idPlanAlimentacion) {
        this.idPlanAlimentacion = idPlanAlimentacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(int  precio) {
        this.precio = precio;
    }

    public long getIdPlanAlimentacion() {
        return idPlanAlimentacion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public int getPrecio() {
        return precio;
    }

    
}
