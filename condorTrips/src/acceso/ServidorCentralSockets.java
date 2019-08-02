package acceso;

import negocio.Administrador;
import negocio.Cliente;
import negocio.Funcionario;
import negocio.Usuario;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import negocio.CityTour;
import negocio.Ciudad;
import negocio.Habitacion;
import negocio.Hotel;
import negocio.Paquete;
import negocio.PaqueteComponent;
import negocio.PlanAlimentacionHotel;
import negocio.Vuelo;
import org.json.JSONArray;

/**
 *
 * @author danielmej
 */
import org.json.JSONException;
import org.json.JSONObject;
public class ServidorCentralSockets implements IServidorCentral{

    private Socket socket = null;
    private Scanner entradaDecorada;
    private PrintStream salidaDecorada;
    private final String IP_SERVIDOR = "localhost";
    private final int PUERTO = 5000;
   
    /* 
     *Funcion que envia la peticion de agregarCliente al servidor central   
     * @param cliente  cliente a agregar ala base de datos
     * @throws IOException
     */
    @Override
    public boolean agregarCliente(Cliente cliente) throws IOException{
        boolean agregado=false;
        String salida="";           
        conectar(IP_SERVIDOR, PUERTO);
        salida=leerFlujoEntradaSalida("agregarCliente,,"+cliente.getIdentificacion()+",,"
                +cliente.getNombres()+",,"
                +cliente.getApellidos()+",,"
                +cliente.getFechaNac()+",,"
                +cliente.getGenero()+",,"
                +cliente.getDireccion()+",,"
                +cliente.getCiudadResidencia()+",,"
                +cliente.getCelular()+",,"
                +cliente.getEmail());
        cerrarFlujos();
        desconectar();     
        
        if(salida.equals("AGREGADO")){
            agregado = true;
        }else{              
            agregado =false;   
        }
        return agregado;
    }

    
    /* 
     *Funcion que envia la peticion de editarCliente al servidor central
     * @param cliente cliente a editar 
     * @throws IOException
     */
    @Override
    public boolean editarCliente(Cliente cliente) throws IOException{
        boolean editado=false;
        String salida="";           
        conectar(IP_SERVIDOR, PUERTO);
        salida=leerFlujoEntradaSalida("editarCliente,,"+cliente.getIdentificacion()+",,"
                +cliente.getNombres()+",,"
                +cliente.getApellidos()+",,"
                +cliente.getFechaNac()+",,"
                +cliente.getGenero()+",,"
                +cliente.getDireccion()+",,"
                +cliente.getCiudadResidencia()+",,"
                +cliente.getCelular()+",,"
                +cliente.getEmail());
        cerrarFlujos();
        desconectar();     
        
        if(salida.equals("EDITADO")){
            editado = true;
        }else{              
            editado =false;   
        }
        return editado;
    }
    /* 
     *Funcion que envia la peticion de consultarCliente al servidor central
     * @param id  id del cliente a ser consultado
     * @throws IOException
     */
    @Override
    public Cliente consultarCliente(long id) throws IOException{
        String salida="NO_ENCONTRADO";
        conectar(IP_SERVIDOR, PUERTO);
        salida=leerFlujoEntradaSalida("consultarCliente,,"+id);
        cerrarFlujos();
        desconectar();     
        if(salida.equals("NO_ENCONTRADO")){
            return null;
        }else{
            Cliente clienteConsulta=new Gson().fromJson(salida, Cliente.class);               
            return clienteConsulta;   
        }            
    }
    /* 
     *Funcion que envia la peticion de eliminarCliente al servidor central
     * @param id  id del cliente a ser borrado de la base de datos
     * @throws IOException
     */
    @Override
    public boolean eliminarCliente(long id) throws IOException{
        boolean eliminado=false;
        String salida="";           
        conectar(IP_SERVIDOR, PUERTO);
        salida=leerFlujoEntradaSalida("eliminarCliente,,"+id);
        cerrarFlujos();
        desconectar();     
        
        if(salida.equals("ELIMINADO")){
            eliminado = true;
        }else{              
            eliminado =false;   
        }
        return eliminado;
    }
    
    
    /* 
     *Funcion que lee un flujo de entrada y retorna una salida, se comunica con el servidor 
     * @param vsalidaDecorada cadena a enviar por el protoloco TCP/IPdel cliente al servidor
     * @throws IOException
     */   
    private String leerFlujoEntradaSalida(String vsalidaDecorada) throws IOException {
        String respuesta = "";
        entradaDecorada = new Scanner(socket.getInputStream());
        salidaDecorada = new PrintStream(socket.getOutputStream());
        salidaDecorada.flush();
        // Usando el protocolo de comunicación
        salidaDecorada.println(vsalidaDecorada);
        if (entradaDecorada.hasNextLine()) {
            respuesta = entradaDecorada.nextLine();
        }
        return respuesta;
    }
    
    /* 
     *procedimineto que cierra los Flujos
     */
     private void cerrarFlujos() {
        salidaDecorada.close();
        entradaDecorada.close();
    }
    /* 
     *procedimineto que se desconecta del servidor central
     */
    private void desconectar() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralSockets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /* 
     *procedimineto que se desconecta del servidor central ingresando la direccion y el puerto
     *@param address port
     */
    public void conectar(String address, int port) throws IOException {
        socket = new Socket(address, port);
        
    }
    /* 
     *Funcion que envia la peticion de agregarUsuario al servidor central
     * @param usuario usuario a ser agregado a la base de datos
     * @throws IOException
     */
    @Override
    public boolean agregarUsuario(Usuario usuario) throws IOException {
        //Verifico el cargo del usuario a agregar
        int v_cargo = averiguarCargoUsuario(usuario);
        boolean agregado=false;
        String salida="";           
        conectar(IP_SERVIDOR, PUERTO);
  
        if(v_cargo==10){
            Administrador administrador =  (Administrador) usuario;
            String peticion="agregarUsuario,,"+flujoEntradaAdministrador(administrador);
            salida=leerFlujoEntradaSalida(peticion);
        }

        if(v_cargo==20){
            Funcionario funcionario = (Funcionario) usuario;
            String peticion="agregarUsuario,,"+flujoEntradaFuncionario(funcionario);
            salida=leerFlujoEntradaSalida(peticion);
        }
        cerrarFlujos();
        desconectar();     
 
        if(salida.equals("AGREGADO")){
            agregado = true;
        }else{              
            agregado =false;   
        }
        return agregado;
    }
    /* 
     *Funcion que envia la peticion de editarUsuario al servidor central
     * @param usuario usuario a ser 
     * @throws IOException
     */
    @Override
    public boolean editarUsuario(Usuario usuario) throws IOException {
        //Verifico el cargo del usuario a agregar
        int v_cargo = averiguarCargoUsuario(usuario);
        boolean editado=false;
        String salida="";           
        conectar(IP_SERVIDOR, PUERTO);
        
        if(v_cargo==10){
            Administrador administrador =  (Administrador) usuario;
            String peticion="editarUsuario,,"+flujoEntradaAdministrador(administrador);
            salida=leerFlujoEntradaSalida(peticion);
        }

        if(v_cargo==20){
            Funcionario funcionario = (Funcionario) usuario;
            String peticion="editarUsuario,,"+flujoEntradaFuncionario(funcionario);
            salida=leerFlujoEntradaSalida(peticion);
        }

        cerrarFlujos();
        desconectar();     
        
        if(salida.equals("EDITADO")){
            editado = true;
        }else{              
            editado =false;   
        }
        return editado;    }

    /* 
     *Funcion que envia la peticion de consultarUsuario al servidor central
     * @param nombre
     * @throws IOException
     */
    @Override
    public Usuario consultarUsuario(String nombre) throws IOException {
        String salida="NO_ENCONTRADO";
        conectar(IP_SERVIDOR, PUERTO);
        salida=leerFlujoEntradaSalida("consultarUsuario,,"+nombre);
        cerrarFlujos();
        desconectar();     
        if(salida.equals("NO_ENCONTRADO")){
            return null;
        }
        
        try{
            JsonObject clienteSerializado = new JsonParser().parse(salida).getAsJsonObject();
        
            //10 = Administrador, 20=Funcionario
            if(clienteSerializado.get("cargo").getAsInt()==10){
                Administrador administradorConsultado=new Administrador(clienteSerializado.get("nombre").getAsString(), 
                        clienteSerializado.get("contrasenia").getAsString(), 
                        clienteSerializado.get("nombreCompleto").getAsString(), 
                        clienteSerializado.get("fechaCreacion").getAsString());
                return administradorConsultado;
            }else if (clienteSerializado.get("cargo").getAsInt()==20){
                Funcionario funcionarioConsultado=new Funcionario(clienteSerializado.get("nombre").getAsString(), 
                        clienteSerializado.get("contrasenia").getAsString(), 
                        clienteSerializado.get("nombreCompleto").getAsString(), 
                        clienteSerializado.get("fechaCreacion").getAsString());
                return funcionarioConsultado;
            }
        }catch(Exception ex){
            System.out.println("Ha ocurrido un error con la serializacion");
            ex.printStackTrace();
        }
        return null;   
        
    }
    /**
     * 
     * @param nombre nombre del usuario a consultar
     * @param contrasenia constraseña del usuario a consultar
     * @return
     * @throws IOException 
     */
     @Override
    public Usuario consultarUsuario(String nombre, String contrasenia) throws IOException {
        String salida="NO_ENCONTRADO";
        conectar(IP_SERVIDOR, PUERTO);
        salida=leerFlujoEntradaSalida("consultarUsuario2,,"+nombre+",,"+contrasenia);
        cerrarFlujos();
        desconectar();     
        if(salida.equals("NO_ENCONTRADO")){
            return null;
        }
        
        try{
            JsonObject clienteSerializado = new JsonParser().parse(salida).getAsJsonObject();
        
            //10 = Administrador, 20=Funcionario
            if(clienteSerializado.get("cargo").getAsInt()==10){
                Administrador administradorConsultado=new Administrador(clienteSerializado.get("nombre").getAsString(), 
                        clienteSerializado.get("contrasenia").getAsString(), 
                        clienteSerializado.get("nombreCompleto").getAsString(), 
                        clienteSerializado.get("fechaCreacion").getAsString());
                return administradorConsultado;
            }else if (clienteSerializado.get("cargo").getAsInt()==20){
                Funcionario funcionarioConsultado=new Funcionario(clienteSerializado.get("nombre").getAsString(), 
                        clienteSerializado.get("contrasenia").getAsString(), 
                        clienteSerializado.get("nombreCompleto").getAsString(), 
                        clienteSerializado.get("fechaCreacion").getAsString());
                return funcionarioConsultado;
            }
        }catch(Exception ex){
            System.out.println("Ha ocurrido un error con la serializacion");
            ex.printStackTrace();
        }
        return null; 
    }

    /* 
     *Funcion que envia la peticion de eliminarUsuario al servidor central
     * @param nombre nombre del usuario a borrar de la base de datos
     * @throws IOException
     */
    @Override
    public boolean eliminarUsuario(String nombre) throws IOException {
        boolean eliminado=false;
        String salida="";           
        conectar(IP_SERVIDOR, PUERTO);
        salida=leerFlujoEntradaSalida("eliminarUsuario,,"+nombre);
        cerrarFlujos();
        desconectar();     
        
        if(salida.equals("ELIMINADO")){
            eliminado = true;
        }else{              
            eliminado =false;   
        }
        return eliminado;
    }
    
    /* 
     *Funcion que retorna el cargo del usuario dependiendo de que tipo de instancia es (10=administrador y 20 =funcionario)
     * @param usuario usuario a averiguar cargo
     */
    private int averiguarCargoUsuario(Usuario usuario){
        int v_cargo=0;
        if(usuario instanceof Administrador){
            v_cargo=10;
        }
        if(usuario instanceof Funcionario){
            v_cargo=20;
        }
        return v_cargo;
    }
    
    /* 
     *Funcion que retorna el usuario en un formato (nombre,constrasenia,nombreCompleto,cargo) para facilitar la editarUsuario y agregarUsuario
     * @param administradr el flujo de entrada especifico para administrador
     */
    private String flujoEntradaAdministrador(Administrador administrador){
        String salida=administrador.getNombre()+",,"
                +administrador.getContrasenia()+",,"
                +administrador.getNombreCompleto()+",,10";   
        return salida;
    }
    
    /**
     * 
     * @param funcionario crear flujo de entrada para el tipo de usuario funcionario
     * @return 
     */
    private String flujoEntradaFuncionario(Funcionario funcionario){
        String salida=funcionario.getNombre()+",,"
                +funcionario.getContrasenia()+",,"
                +funcionario.getNombreCompleto()+",,20";   
        return salida;
    }

    
   /**
    * 
    * @param fechaSalida fecha de salida del vuelo o vuelos
    * @param fechaLlegada fecha llegada del vuelo o vuelos
    * @param origen origen del vuelo, es decir, desde donde parte
    * @param destino destino del vuelo
    * @return 
    */
    @Override
    public Vuelo[] consultarVuelos(String fechaSalida, String fechaLlegada, String origen, String destino) {
        try {
            
            String salida="NO_ENCONTRADO";
            conectar(IP_SERVIDOR, PUERTO);
            salida=leerFlujoEntradaSalida("ConsultarVuelos,,"+fechaSalida
                    +",,"+fechaLlegada
                    +",,"+origen
                    +",,"+destino);
            
            cerrarFlujos();
            desconectar();
            
            if(salida.equals("NO_ENCONTRADO")){
                return null;
            }else{
                
                System.out.println(salida);
                Vuelo[] vuelos=new Gson().fromJson(salida, Vuelo[].class);
                
                return vuelos;        
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralSockets.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
/**
 * 
 * @param fechaEntrada fecha de entrada al hotel
 * @param fechaSalida fecha de salida del hotel
 * @param ciudad  ciudad en la cual se buscar hoteles en las fechas especificadas
 * @return 
 */
    @Override
    public Hotel[] consultarHoteles(String fechaEntrada, String fechaSalida,String ciudad) {
        
        try {
            
            String salida="NO_ENCONTRADO";
            conectar(IP_SERVIDOR, PUERTO);
            salida=leerFlujoEntradaSalida("ConsultarHoteles,,"+fechaEntrada
                    +",,"+fechaSalida
                    +",,"+ciudad);            
            cerrarFlujos();
            desconectar();
            
            if(salida.equals("NO_ENCONTRADO")){
                return null;
            }else{
                
   
                System.out.println(salida);
                if(salida.equals(""))return null; 
                Hotel[] hoteles=deserializarHotel(salida);
                return hoteles;
            
       
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralSockets.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return null;
        
        
    }
    /**
     * se deserializa el hotel, en este caso no hay necesidad de hacer distincion entre los
     * objetos que componen al hotel, pues solo nos interesa las habitaciones
     * @param json fuente json de un hotel
     * @return 
     */
    public Hotel[] deserializarHotel(String json){
        try {
            
            JSONArray arregloJson= new JSONArray(json);
             JSONArray arregloHab;
             Hotel [] hoteles = new Hotel[arregloJson.length()];

            for (int i = 0; i < arregloJson.length(); i++) {
                JSONObject hotel = arregloJson.getJSONObject(i);
                int idHotel = hotel.getInt("idHotel");
                String nombreHotel = hotel.getString("nombreHotel");
                Hotel myHotel = new Hotel(idHotel, nombreHotel);
               
                JSONArray arregloHabitaciones=hotel.getJSONArray("componentes");
               
                for (int j = 0; j <arregloHabitaciones.length(); j++) {
                    JSONObject habitacion=arregloHabitaciones.getJSONObject(j);
                    int numeroHabitacion = habitacion.getInt("numeroHabitacion");
                    String descripcion =habitacion.getString("descripcion");
                    String disponible = habitacion.getString("disponible");
                    char d=disponible.charAt(0);
                     int precio = habitacion.getInt("precio");

                     Habitacion myHabitacion = new Habitacion(numeroHabitacion,descripcion,d,precio);
                     myHotel.addComponent(myHabitacion);
                }
                hoteles[i]=myHotel;            
            }
            return  hoteles;
        } catch (JSONException ex) {
            Logger.getLogger(ServidorCentralSockets.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }
    /**
     * 
     * @param nomContinente Nombre del continente de la ciudad
     * @param nomPais nombre del pais de la ciudad
     * @param nomCiudad nombre de la ciudad a consultar
     * @return 
     */
    @Override
    public Ciudad consultarCiudad(String nomContinente, String nomPais, String nomCiudad) {
            try {
            String salida="NO_ENCONTRADO";
            conectar(IP_SERVIDOR, PUERTO);
         
            salida=leerFlujoEntradaSalida("ConsultarCiudad,,"+nomContinente+",,"+nomPais+",,"+nomCiudad);
            cerrarFlujos();
            desconectar();
            if(salida.equals("NO_ENCONTRADO")){
                return null;
            }else{
                 System.out.println(salida);
                 
                
                Ciudad ciudad=new Gson().fromJson(salida, Ciudad.class);
                return ciudad;
                    
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralSockets.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * este método se utiliza para llenar la tabla de regiones en GUIPlanesPersonalizados
     * @return 
     */
    public Ciudad[] consultarContinentes(){
         try {
            String salida="NO_ENCONTRADO";
            conectar(IP_SERVIDOR, PUERTO);
         
            salida=leerFlujoEntradaSalida("ConsultarContinentes,, ");
            cerrarFlujos();
            desconectar();
            if(salida.equals("NO_ENCONTRADO")){
                return null;
            }else{
                 System.out.println(salida);
                 
                
                Ciudad[] continentes=new Gson().fromJson(salida, Ciudad[].class);
                return continentes;
                    
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralSockets.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * 
     * @param nombreContinente nombre del continente, con este parametro se consultan todos
     * los paises que pertenecen a ese continente
     * @return 
     */
    public Ciudad[] consultarPaises(String nombreContinente){
         try {
            String salida="NO_ENCONTRADO";
            conectar(IP_SERVIDOR, PUERTO);
         
            salida=leerFlujoEntradaSalida("ConsultarPaises,,"+nombreContinente);
            cerrarFlujos();
            desconectar();
            if(salida.equals("NO_ENCONTRADO")){
                return null;
            }else{
                 System.out.println(salida);
                 
                
                Ciudad[] paises=new Gson().fromJson(salida, Ciudad[].class);
                return paises;
                    
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralSockets.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * 
     * @param nombreContinente el nombre del continente de las ciudades a consultar
     * @param nombrePais nombre del pais de las ciuadades a consultar
     * @return 
     */
    public Ciudad[] consultarCiudades(String nombreContinente, String nombrePais){
         try {
            String salida="NO_ENCONTRADO";
            conectar(IP_SERVIDOR, PUERTO);
         
            salida=leerFlujoEntradaSalida("ConsultarCiudades,,"+nombreContinente+",,"+nombrePais);
            cerrarFlujos();
            desconectar();
            if(salida.equals("NO_ENCONTRADO")){
                return null;
            }else{
                 System.out.println(salida);
                 
                
                Ciudad[] ciudades=new Gson().fromJson(salida, Ciudad[].class);
                return ciudades;
                    
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralSockets.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * 
     * @param fechaInicio fecha inicio del citytour
     * @param fechaFin  fecha fin del city tour, es de cir, cuando acaba el citytour
     * @param destino  la ciudad en la cual se oferta el citytour
     * @return 
     */

    @Override
    public CityTour[] consultarCityTours(String fechaInicio, String fechaFin, String destino) {
        try {
            
            String salida="NO_ENCONTRADO";
            conectar(IP_SERVIDOR, PUERTO);
            salida=leerFlujoEntradaSalida("ConsultarCityTours,,"+fechaInicio
                    +",,"+fechaFin
                    +",,"+destino);
            
            cerrarFlujos();
            desconectar();
            
            if(salida.equals("NO_ENCONTRADO")){
                return null;
            }else{
                
                System.out.println(salida);
                CityTour[] cityTours=new Gson().fromJson(salida, CityTour[].class);
                
                return cityTours;        
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralSockets.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * 
     * @param idHotel con este parametro se consultar los planes de alimentacion de ese hotel
     * @return 
     */
    @Override
    public PlanAlimentacionHotel[] consultarPlanesAlimentacion(long idHotel) {
        try {
            
            String salida="NO_ENCONTRADO";
            conectar(IP_SERVIDOR, PUERTO);
            salida=leerFlujoEntradaSalida("ConsultarPlanAlimentacion,,"+idHotel);
            
            cerrarFlujos();
            desconectar();
            
            if(salida.equals("NO_ENCONTRADO")){
                return null;
            }else{
                
                System.out.println(salida);
                PlanAlimentacionHotel[] planesALimen=new Gson().fromJson(salida, PlanAlimentacionHotel[].class);
                
                return planesALimen;       
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralSockets.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * 
     * @return devuelve un id disponible para el paquete que se este creando 
     */
    @Override
    public long asignarIdToPaquetePersonalizado() {
        try {
            String salida="";
            conectar(IP_SERVIDOR, PUERTO);
            
            
            String peticion="AsignarIdToPaquetePersonalizado,, ";
            String[] split = peticion.split(",,");
            
            salida=leerFlujoEntradaSalida(peticion);
            
            
            cerrarFlujos();
            desconectar();
            
            
            return Long.parseLong(salida);
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralSockets.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    /**
     * 
     * @param myPaquete paquete personalizado a ser agregado a la base de datos
     * @return
     * @throws IOException 
     */
    @Override
    public boolean agregarPlanPersonalizado(Paquete myPaquete) throws IOException {
         
        String salida="";           
        conectar(IP_SERVIDOR, PUERTO);
  
        
            String peticion="AgregarPlanPersonalizado,,"+parsePaqueteToJson(myPaquete);
            String[] split = peticion.split(",,");
            
            salida=leerFlujoEntradaSalida(peticion);
        
        cerrarFlujos();
        desconectar();   
        if(salida.equals("AGREGADO")){
            return true;
        
        }else if (salida.equals("NO_AGREGADO")){
            return false;
        }
 

        return false;
    }
    /**
     * 
     * @param myCiudad se consultan los vuelos de esa ciudad
     * @return 
     */
    public int cuantosVuelos(Ciudad myCiudad){
        int vuelos=0;
        for (int i = 0; i < myCiudad.getComponentes().size(); i++) {

                if(myCiudad.getComponentes().get(i) instanceof Vuelo){
                    vuelos+=1;
                }
        
            }
        return vuelos;
    }
    /**
     * 
     * @param myCiudad con este parametro se consultan los hoteles en un paquete
     * @return  el numero de hoteles en el paquete
     */
    public int cuantosHoteles(Ciudad myCiudad){
        int hoteles=0;
        for (int i = 0; i < myCiudad.getComponentes().size(); i++) {

                if(myCiudad.getComponentes().get(i) instanceof Hotel){
                    hoteles+=1;
                }
        
            }
        return hoteles;
    }
    /**
     * este metod devuelve el numero de citytours asignados a un paquete en especifico
     * @param myCiudad ciudad donde se ofertan los citytours
     * @return 
     */
    public int cuantosCityTours(Ciudad myCiudad){
        int cityTours=0;
        for (int i = 0; i < myCiudad.getComponentes().size(); i++) {

                if(myCiudad.getComponentes().get(i) instanceof CityTour){
                    cityTours+=1;
                }
        
            }
        return cityTours;
         
    }
    /**
     * este metodo devuelve el numero de habitaciones que se han registrado a un paquete
     * @param myHotel hotel de un paquete
     * @return 
     */
    public int cuantasHabitaciones(Hotel myHotel){
        int hoteles=0;
        for (int i = 0; i < myHotel.getComponentes().size(); i++) {

                if(myHotel.getComponentes().get(i) instanceof Habitacion){
                    hoteles+=1;
                }
        
            }
        return hoteles;
    }
    /**
     * esta funcion devuelve el numero de planes de alimentacion en un paquete
     * @param myHotel hotel donde se ofertan los planes de alimentacion 
     * @return 
     */
    public int cuantosPlanesdeAlimentacion(Hotel myHotel){
        int planes=0;
        for (int i = 0; i < myHotel.getComponentes().size(); i++) {

                if(myHotel.getComponentes().get(i) instanceof PlanAlimentacionHotel){
                    planes+=1;
                }
        
            }
        return planes;
    }
    /**
     * debido a que se usó el composite quiere decir que los componentes se tratan de la misma manera
     * esto tiene sus implicaciones,como por ejemplo añadir objetos más fácilmente, pero para el caso
     * de serializar y deserializar, es una desventaja ya que es necesario tratar a los componentes
     * de un composite diferentemente para poder deserializar de manera correcta. por lo tanto
     * aquí se hizo la distincion para poderlo serializar
     * @param myPaquete
     * @return devuelve el paquete en formato json
     */
    public String parsePaqueteToJson(Paquete myPaquete){
      JsonArray array = new JsonArray();

        
        JsonObject gsonObj;
        String json ="{\"fechaCreacion\":\""+myPaquete.getFechaCreacion()+"\",";

        
        json +="\"idPaquete\":\""+myPaquete.getIdPaquete()+"\",";
        json +="\"tipo\":\""+myPaquete.getTipo()+"\",";
        json +="\"nombrePaquete\":\""+myPaquete.getNombrePaquete()+"\",";
        json +="\"fechaInicio\":\""+myPaquete.getFechaInicio()+"\",";
        json +="\"fechaFin\":\""+myPaquete.getFechaFin()+"\",";
        json +="\"descripcion\":\""+myPaquete.getDescripcion()+"\",";

        json +="\"existencias\":\""+myPaquete.getExistencias()+"\",";
       
        json+="\"ciudades\":[";
        for (int i = 0; i < myPaquete.getComponentes().size(); i++) {
            Ciudad myCiudad = (Ciudad) myPaquete.getComponentes().get(i);
                    int hotelesEnCurso=0;
                    int vuelosEnCurso=0;
                    int cityToursEnCurso=0;
            json +="{\"idCiudad\":\""+myCiudad.getIdCiudad()+"\",";
            json +="\"nombreCiudad\":\""+myCiudad.getNombreCiudad()+"\",";
            json +="\"precio\":\""+myCiudad.getPrecioCiudadSolo()+"\"";
            int hotelesEnPaquete=cuantosHoteles(myCiudad); 
            if(hotelesEnPaquete!=0){
                json +=",\"hoteles\":[";
                for (int j = 0; j < myCiudad.getComponentes().size(); j++) {
                    if(myCiudad.getComponentes().get(j) instanceof Hotel){
                        hotelesEnCurso+=1;
                    Hotel myHotel =(Hotel)myCiudad.getComponentes().get(j);
                    json +="{\"idHotel\":\""+myHotel.getIdHotel()+"\",";
                    json +="\"nombreHotel\":\""+myHotel.getNombreHotel()+"\"";
                    int habitaciones=0;
                     int habitacionesDelPaquete= cuantasHabitaciones(myHotel);
                     if(habitacionesDelPaquete!=0){
                         json+=",\"habitaciones\":[";
                         for (int k = 0; k < myHotel.getArrayComponentes().size(); k++) {
                             if(myHotel.getArrayComponentes().get(k)instanceof Habitacion){
                                 habitaciones+=1;
                                 Habitacion myHabitacion= (Habitacion) myHotel.getArrayComponentes().get(k);
                                 json+="{\"numeroHabitacion\":\""+myHabitacion.getNumeroHabitacion()+"\",";
                                 json+="\"disponible\":\""+myHabitacion.getDisponible()+"\",";
                                 json+="\"descripcion\":\""+myHabitacion.getDescripcion()+"\",";

                                 json+="\"precio\":\""+myHabitacion.getPrecio()+"\"}";   
                                  if(habitaciones < habitacionesDelPaquete){
                                      json+=",";
                                 }else{
                                      json+="]";
                                      break;
                                  }
                             }
                         }
                     
                     }
                    int planesAlimentacion=0;
                    int planesAlimentacionEnPaquete = cuantosPlanesdeAlimentacion(myHotel);
                    if(planesAlimentacionEnPaquete!=0){
                        json+=",\"planesAlimentacion\":[";
                        
                        for (int k = 0; k < myHotel.getArrayComponentes().size(); k++) {
                            if(myHotel.getArrayComponentes().get(k) instanceof PlanAlimentacionHotel){
                                planesAlimentacion+=1;
                                PlanAlimentacionHotel myPlanAli = (PlanAlimentacionHotel) myHotel.getArrayComponentes().get(k);
                                json+="{\"idPlanAlimentacion\":\""+myPlanAli.getIdPlanAlimentacion()+"\",";
                                json+="\"descripcion\":\""+myPlanAli.getDescripcion()+"\",";
                                json+="\"precio\":\""+myPlanAli.getPrecio()+"\"}";
                                if(planesAlimentacion < planesAlimentacionEnPaquete){
                                    json+=",";
                                }else{
                                    json+="]";
                                    break;
                                }
                            }
                        }
                    }
                                         
                     if(hotelesEnCurso < hotelesEnPaquete){
                            json+="},";
                        }else{
                            
                             json+="}]";
                             break;
                        }
                    }
                   
                    }
                }
            int vuelosEnPaquete=cuantosVuelos(myCiudad);
            if(vuelosEnPaquete!=0){
                    json +=",\"vuelos\":[";
                    
                    for (int j = 0; j < myCiudad.getComponentes().size(); j++) {
                        if(myCiudad.getComponentes().get(j) instanceof Vuelo){
                        vuelosEnCurso+=1;
                        Vuelo myVuelo =(Vuelo)myCiudad.getComponentes().get(j);
                        json +="{\"idVuelo\":\""+myVuelo.getIdVuelo()+"\",";
                        json +="\"aerolinea\":\""+myVuelo.getAerolinea()+"\",";
                        json +="\"precio\":\""+myVuelo.getPrecio()+"\",";
                        json +="\"nombreCiudadOrigen\":\""+myVuelo.getNombreCiudadOrigen()+"\",";
                        json +="\"nombreCiudadDestino\":\""+myVuelo.getNombreCiudadDestino()+"\",";
                        json +="\"fechaHoraLlegada\":\""+myVuelo.getFechaHoraLlegada()+"\",";
                        json +="\"fechaHoraSalida\":\""+myVuelo.getFechaHoraSalida()+"\"}";
                        if(vuelosEnCurso < vuelosEnPaquete){
                            json+=",";
                        }else{
                            json+="]";
                            break;
                        }
                    }
                        
                    }
            
            }
            int cityToursEnPaquete =cuantosCityTours(myCiudad);
            if(cityToursEnPaquete!=0){
                    json +=",\"cityTours\":[";
                    for (int j = 0; j < myCiudad.getComponentes().size(); j++) {
                        if(myCiudad.getComponentes().get(j) instanceof CityTour){
                         cityToursEnCurso+=1;
                        CityTour myCityTour =(CityTour)myCiudad.getComponentes().get(j);
                        json +="{\"idCityTour\":\""+myCityTour.getIdCityTour()+"\",";
                        json +="\"fechaInicio\":\""+myCityTour.getFechaInicio()+"\",";
                        json +="\"fechaFin\":\""+myCityTour.getFechaFin()+"\",";
                        json +="\"descripcion\":\""+myCityTour.getDescripcion()+"\",";
                        json +="\"precio\":\""+myCityTour.getPrecio()+"\"}";
                        if(cityToursEnCurso < cityToursEnPaquete){
                            json+=",";
                        }else{
                            json+="]";
                            break;
                        }
                        }
                        
                    }
            }
            
            if((myPaquete.getComponentes().size()-1) !=i){
                json+="},";
            }else{
                json+="}]";
            }
            }
            json+="}";
            
            
       return json;
       
    
    }
    @Override
    public boolean editarPlanPersonalizado(Paquete Paquete) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario consultarPlanPersonalizado(long idPaquete) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarPlanPersonalizado(long idPaquete) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   


   
    


}
