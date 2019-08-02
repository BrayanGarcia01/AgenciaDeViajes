package negocio;

import java.util.Observable;

/**
 *
 * @author danielmej
 */
public  abstract class Usuario  {
    
    /**
     * Atributos de la clase
     */
    private String nombre;
    private String contrasenia;
    private String nombreCompleto;
    private String fechaCreacion;    

    /**
     * Constructor por defecto
     */
    public Usuario() {
    }
    
    /**
     * Constructor parametrizado
     * @param nombre
     * @param contrasenia
     * @param nombreCompleto
     * @param fechaCreacion 
     */
    public Usuario(String nombre, String contrasenia, String nombreCompleto, String fechaCreacion) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.nombreCompleto = nombreCompleto;
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * retorna el nombre del usuario
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el valor del nombre del usuario
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna la contrasenia del usuario
     * @return 
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Cambia el valor de la contrasenia
     * @param contrasenia 
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Retorna el nombre del usuario
     * @return 
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Cambia el nombre del empleado
     * @param nombreCompleto 
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Retorna la fecha de creacion del usuario
     * @return 
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Cambia la fecha de creacion del usuario
     * @param fechaCreacion 
     */
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
}
