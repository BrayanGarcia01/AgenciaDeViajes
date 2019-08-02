package negocio;

import acceso.IServidorCentral;
import acceso.ServidorCentralSockets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Funcionario extends Usuario{
    
    GestorClientes gestorClientes;
    private final IServidorCentral sc;


    
    
    public Funcionario() {
        gestorClientes=new GestorClientes();
        sc =new ServidorCentralSockets(); 
    }
        /**
         * 
         * @param nombre nombre de usuario del funcionario
         * @param contrasenia   contraseña del funcionario para entrar al siste,a
         * @param nombreCompleto nombre completo del funcionario
         * @param fechaCreacion fecha de creacion del usuario en formato yyyy-MM-dd
         */
    public Funcionario(String nombre, String contrasenia, String nombreCompleto, String fechaCreacion) {        
        super(nombre, contrasenia, nombreCompleto, fechaCreacion);
        gestorClientes=new GestorClientes();
        sc =new ServidorCentralSockets(); 
    }
    /**
     * 
     * @param cliente cliente a ser agregado
     * @return
     * @throws IOException 
     */
    public boolean agregarCliente(Cliente cliente) throws IOException{
        return gestorClientes.agregarCliente(cliente);
    }
    /**
     * 
     * @param cliente cliente a ser editado
     * @return
     * @throws IOException 
     */
    
    public boolean editarCliente(Cliente cliente) throws IOException{
        return gestorClientes.editarCliente(cliente);
    }
    /**
     * 
     * @param id id del cliente a ser consultado
     * @return
     * @throws IOException 
     */
    public Cliente consultarCliente(long id) throws IOException{        
        return gestorClientes.consultarCliente(id);   
    }
    /**
     * 
     * @param id id del cliente a ser borrado 
     * @return
     * @throws IOException 
     */
    public boolean eliminarCliente(long id) throws IOException{
        return gestorClientes.eliminarCliente(id);
    }
    /**
     * 
     * @return devuleve todos los continente de la base de datos
     */
    public Ciudad[] consultarContinentes(){
        return sc.consultarContinentes();
    }
    /**
     * 
     * @param nombreContinente nombre del continente de los paises a buscar
     * @return devuelve todos los paises del continente especificado
     */
     public Ciudad[] consultarPaises(String nombreContinente){
        return sc.consultarPaises(nombreContinente);
    }
     /**
      * 
      * @param nombreContinente nombre del continente de la ciudad
      * @param nombrePais nombre del pais de la ciudad
      * @return devuelve todas la ciudades de ese pais
      */
     public Ciudad[] consultarCiudades(String nombreContinente, String nombrePais){
         return sc.consultarCiudades(nombreContinente, nombrePais);
     }
     /**
      * devuelve el id del paquete personalizado
      * @return 
      */
    public long asignarIdToPaquetePersonalizado(){
        return sc.asignarIdToPaquetePersonalizado();
    }
    /**
     * 
     * @param myPaquete paquete a ser agregado a la base de datos
     */
    public boolean agregarPlanPersonalizado(Paquete myPaquete){
        
        try {
            return sc.agregarPlanPersonalizado(myPaquete);
            
        } catch (IOException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void consultarPlanPersonalizado(){
    
    }
    public void editarPlanPersonalizado(){
    
    }
    public void eliminarPlanPersonalizado(){
    
    }
    /**
     * 
     * @param fechaSalida fehca de salida de vuelo
     * @param fechaLlegada fehca de llegada del vuelo
     * @param origen  coordenadas de origen en formato continente-pais-ciudad
     * @param destino coordenadas destino en formato continente-pais-ciudad
     * @return 
     */
    public Vuelo[] consultarVuelos(String fechaSalida, String fechaLlegada,String origen,String destino){
        return sc.consultarVuelos(fechaSalida, fechaLlegada, origen, destino);
        
    
    }
    /**
     * 
     * @param nomContinente nombre del continente de la ciudad buscar
     * @param nomPais   nombre del pais de la ciuadad a buscar
     * @param nomCiudad nombre de la ciudad a buscar
     * @return 
     */
    public Ciudad consultarCiudad(String nomContinente,String nomPais, String nomCiudad){
        return sc.consultarCiudad(nomContinente, nomPais, nomCiudad);
    }
    /**
     * 
     * @param fechaEntrada fecha de entrada al hotel
     * @param fechaSalida fecha de salida del hotel
     * @param destino coordenada destino en formato continente-pais-ciudad
     * @return 
     */
    public Hotel[] consultarHoteles(String fechaEntrada, String fechaSalida, String destino) {
            return sc.consultarHoteles(fechaEntrada, fechaSalida, destino);
    }
    /**
     * 
     * @param fechaInicio fecha inicio del city tour
     * @param fechaFin  fecha fin del tour
     * @param destino   coordenada destino en formato continente-pais-ciudad
     * @return 
     */
    
    public CityTour[] consultarCityTours(String fechaInicio, String fechaFin,String destino){
        return sc.consultarCityTours(fechaInicio, fechaFin, destino);
    }
    /**
     * 
     * @param idHotel id hotel donde se ofertan los pplanes de alimentacion
     * @return 
     */
    public PlanAlimentacionHotel[] consultarPlanesAlimentacion(long idHotel) {
        return sc.consultarPlanesAlimentacion(idHotel);
    }
    
        
    
}
