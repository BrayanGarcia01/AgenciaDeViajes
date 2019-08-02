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
/*
*
*
*/
public class CityTour extends PaqueteComponent{
   
    private long idCityTour;
    private String fechaInicio;
    private String fechaFin;
    private String descripcion;
    private int precio;
    /**
     * 
     * @param idCityTour id del city tour
     * @param fechaInicio fecha inicio del city tour
     * @param fechaFin  fecha fin del city tour
     * @param descripcion   descripcion del city tour
     * @param precio precio singular del city tour
     */
    public CityTour(long idCityTour,String fechaInicio,String fechaFin,String descripcion,int precio) {
        super();
        this.idCityTour = idCityTour;
        this.fechaInicio = fechaInicio;
        this.fechaFin= fechaFin;
        this.descripcion=descripcion;
        this.precio = precio;
    }
    
    public CityTour(){
        super();
    }
/**
 * método sobre-escrito del paqueteComponent
 * @return 
 */
    @Override
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public long getIdCityTour() {
        return idCityTour;
    }

    public void setIdCityTour(long idCityTour) {
        this.idCityTour = idCityTour;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
