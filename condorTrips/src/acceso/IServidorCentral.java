package acceso;
import negocio.Cliente;
import negocio.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import negocio.CityTour;
import negocio.Ciudad;
import negocio.Hotel;
import negocio.Paquete;
import negocio.PaqueteComponent;
import negocio.PlanAlimentacionHotel;
import negocio.Vuelo;
import negocio.Vuelo;
/**
 *
 * @author danielmej
 */
public interface IServidorCentral {
   /* 
    *Funciones para la gestion de Clientes
    */
    public abstract boolean agregarCliente(Cliente cliente) throws IOException;
    public abstract boolean editarCliente(Cliente cliente)throws IOException;
    public abstract Cliente consultarCliente(long id) throws IOException;
    public abstract boolean eliminarCliente(long id) throws IOException;
   /* 
    *Funciones para la gestion de usuarios
    */
    public abstract boolean agregarUsuario(Usuario usuario) throws IOException;
    public abstract boolean editarUsuario(Usuario usuario)throws IOException;
    public abstract Usuario consultarUsuario(String nombre) throws IOException;
    public Usuario consultarUsuario(String nombre,String contrasenia) throws IOException;
    public abstract boolean eliminarUsuario(String nombre) throws IOException;
    /**
     * Metodos para llenar los datos de continentes, paises y ciudades del servidor a la aplicacion
     * 
     * @return 
     */
    public abstract Ciudad[] consultarContinentes();
    public abstract Ciudad[] consultarPaises(String continente);
    public abstract Ciudad[] consultarCiudades(String continente, String pais);

    public abstract long asignarIdToPaquetePersonalizado();
       /* 
    * Metodos para agregar, editar, consultar y eliminar paquetes personalizados
    */
    public abstract boolean agregarPlanPersonalizado(Paquete myPaquete) throws IOException;
    public abstract boolean editarPlanPersonalizado(Paquete Paquete)throws IOException;
    public abstract Usuario consultarPlanPersonalizado(long idPaquete) throws IOException;
    public abstract boolean eliminarPlanPersonalizado(long idPaquete) throws IOException;
    
    /*
    *Consultar vuelos
    */

    /**
     *
     * @param fechaSalida
     * @param fechaLlegada
     * @param origen
     * @param destino
     * @return
     */

    public abstract Vuelo[] consultarVuelos(String fechaSalida, String fechaLlegada,String origen,String destino);
    
    /*
    *Consultar Hoteles
    */
   public abstract Hotel[] consultarHoteles(String fechaEntrada, String fechaSalida,String ciudad);
    
    public abstract Ciudad consultarCiudad(String nomContinente, String nomPais, String nomCiudad);
    public abstract CityTour[] consultarCityTours(String fechaInicio,String fechaFin, String destino);
    public abstract PlanAlimentacionHotel[] consultarPlanesAlimentacion(long idCiudad);

}
