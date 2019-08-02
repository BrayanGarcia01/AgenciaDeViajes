package servicio;

import com.google.gson.JsonArray;
import negocio.GestorCliente;
import negocio.Usuario;
import negocio.Cliente;
import negocio.GestorUsuario;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.PrintStream;

import java.net.ServerSocket;
import java.net.Socket;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.CityTour;
import negocio.Ciudad;
import negocio.GestorCityTour;
import negocio.GestorCiudad;
import negocio.GestorHoteles;
import negocio.GestorPaquetesWeb;
import negocio.GestorPlanAlimentacion;
import negocio.GestorPlanesPersonalizados;
import negocio.GestorVuelos;
import negocio.Habitacion;
import negocio.Hotel;
import negocio.Paquete;
import negocio.PaqueteComponent;
import negocio.PaqueteWeb;
import negocio.PlanAlimentacionHotel;
import negocio.Vuelo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServidorCentralServer implements Runnable{ 
    private  final GestorCliente gestorC;
    private  final GestorUsuario gestorU;
    private final GestorVuelos myGestorVuelos;
    private final GestorHoteles myGestorHoteles;
    private final GestorCiudad myGestorCiudad;
    private final GestorCityTour myGestorCityTour;
    private final GestorPlanAlimentacion myGestorPlanAlimentacion;
    private final GestorPlanesPersonalizados myGestorPlanesPersonalizados;
    private final GestorPaquetesWeb myGestorPaquetesWeb;
    


    


    
    private static ServerSocket ssock;
    private static Socket socket;
    private Scanner entradaDecorada;
    private PrintStream salidaDecorada;
    private static final int PUERTO = 5000;

    /**
     * Constructor
     */
    public ServidorCentralServer() {
        gestorC = new GestorCliente();
        gestorU = new GestorUsuario();
        myGestorHoteles= new GestorHoteles();
        myGestorVuelos = new GestorVuelos();
        myGestorCiudad = new GestorCiudad();
        myGestorCityTour = new GestorCityTour();
        myGestorPlanAlimentacion = new GestorPlanAlimentacion();
        myGestorPlanesPersonalizados = new GestorPlanesPersonalizados();
        myGestorPaquetesWeb=new GestorPaquetesWeb();
    }
    /**
     * Logica completa del servidor
     */
    public void iniciar() {
        abrirPuerto();

        while (true) {
            esperarAlCliente();
            lanzarHilo();
        }
    }

    /**
     * Lanza el hilo
     */
    private static void lanzarHilo() {
        new Thread(new ServidorCentralServer()).start();
    }

    private static void abrirPuerto() {
        try {
            ssock = new ServerSocket(PUERTO);
            System.out.println("Escuchando por el puerto " + PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Espera que el cliente se conecta y le devuelve un socket
     */
    private static void esperarAlCliente() {
        try {
            socket = ssock.accept();
            System.out.println("Cliente conectado");
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cuerpo del hilo
     */
    @Override
    public void run() {
        try {
            crearFlujos();
            leerFlujos();
            cerrarFlujos();
        } catch (IOException e) {
            System.out.println(e);
        } catch (SQLException ex) {
            Logger.getLogger(ServidorCentralServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServidorCentralServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Crea los flujos con el socket
     *
     * @throws IOException
     */
    private void crearFlujos() throws IOException {
        salidaDecorada = new PrintStream(socket.getOutputStream());
        entradaDecorada = new Scanner(socket.getInputStream());
    }

    /**
     * Lee los flujos del socket
     */
    private void leerFlujos() throws SQLException, ClassNotFoundException {
        if (entradaDecorada.hasNextLine()) {
            // Extrae el flujo que envía el cliente
            String peticion = entradaDecorada.nextLine();
            decodificarPeticion(peticion);

        } else {
            salidaDecorada.flush();
            salidaDecorada.println("NO_ENCONTRADO");
        }
    }
    
    /**
     * Cierra los flujos de entrada y salida
     *
     * @throws IOException
     */
    private void cerrarFlujos() throws IOException {
        salidaDecorada.close();
        entradaDecorada.close();
        socket.close();
    }

    /**
     * Decodifica la petición, extrayeno la acción y los parámetros
     *
     * @param peticion petición completa al estilo
     * "consultarCiudadano,983932814"
     */
    private void decodificarPeticion(String peticion) throws SQLException, ClassNotFoundException {
            StringTokenizer tokens = new StringTokenizer(peticion, ",,");
            String parametros1[] = peticion.split(",,");
        /*String parametros[] = new String[10];

        int i = 0;
        while (tokens.hasMoreTokens()) {
            parametros[i++] = tokens.nextToken();
        }
        String accion = parametros[0];
*/
        procesarAccion(parametros1[0], parametros1);

    }

    private void procesarAccion(String accion, String parametros[]) throws SQLException, ClassNotFoundException {
        switch (accion) {
            case "agregarCliente":
                Cliente nuevoClienteAgregar=new Cliente(Long.parseLong(parametros[1]), parametros[2], parametros[3], parametros[4], parametros[5].charAt(0), parametros[6], parametros[7], Long.parseLong(parametros[8]), parametros[9]);
                boolean clienteAgregado=gestorC.agregarCliente(nuevoClienteAgregar);
                if(clienteAgregado){
                    salidaDecorada.println("AGREGADO");    
                }else{
                    salidaDecorada.println("NO_AGREGADO");
                }
                break;          
            case "editarCliente":
                Cliente nuevoClienteEditar=new Cliente(Long.parseLong(parametros[1]), parametros[2], parametros[3], parametros[4], parametros[5].charAt(0), parametros[6], parametros[7], Long.parseLong(parametros[8]), parametros[9]);
                boolean clienteEditado=gestorC.editarCliente(nuevoClienteEditar);
                if(clienteEditado){
                    salidaDecorada.println("EDITADO");    
                }else{
                    salidaDecorada.println("NO_EDITADO");
                }
                break;
            case "consultarCliente":
                Cliente cliente;
                cliente=gestorC.consultarCliente(Long.parseLong(parametros[1]));
                if(cliente==null){
                    salidaDecorada.println("NO_ENCONTRADO");
                    return;
                }else{
                    salidaDecorada.println(parseToJSON(cliente));                   
                }
                break;
            case "eliminarCliente":
                boolean clienteEliminado=gestorC.eliminarCliente(Long.parseLong(parametros[1]));
                if(clienteEliminado){
                    salidaDecorada.println("ELIMINADO");    
                }else{
                    salidaDecorada.println("NO_ELIMINADO");
                }                
                break;
            
            case "agregarUsuario":
                Usuario nuevoUsuarioAgregar=new Usuario(parametros[1],parametros[2],parametros[3],Integer.parseInt(parametros[4]),"null");
                boolean usuarioAgregado=gestorU.agregarUsuario(nuevoUsuarioAgregar);
                if(usuarioAgregado){
                    salidaDecorada.println("AGREGADO");    
                }else{
                    salidaDecorada.println("NO_AGREGADO");
                }
                break;          
            case "editarUsuario": 
                Usuario nuevoUsuarioEditar=new Usuario(parametros[1],parametros[2],parametros[3],Integer.parseInt(parametros[4]),"null");
                boolean usuarioEditado=gestorU.editarUsuario(nuevoUsuarioEditar);
                if(usuarioEditado){
                    salidaDecorada.println("EDITADO");    
                }else{
                    salidaDecorada.println("NO_EDITADO");
                }
                break;
            case "consultarUsuario":
                Usuario usuario;
                
                usuario=gestorU.consultarUsuario(parametros[1]);
                              
                if(usuario==null){
                    salidaDecorada.println("NO_ENCONTRADO");
                    return;
                }else{
                    salidaDecorada.println(parseToJSON(usuario));                   
                }                
                break;
            case "consultarUsuario2":
                Usuario usuario2;
                usuario2=gestorU.consultarUsuario(parametros[1],parametros[2]);
                              
                if(usuario2==null){
                    salidaDecorada.println("NO_ENCONTRADO");
                    return;
                }else{
                    salidaDecorada.println(parseToJSON(usuario2));                   
                } 

                
                break;
            case "eliminarUsuario":
                boolean usuarioEliminado=gestorU.eliminarUsuario(parametros[1]);
                if(usuarioEliminado){
                    salidaDecorada.println("ELIMINADO");    
                }else{
                    salidaDecorada.println("NO_ELIMINADO");
                }                
                break;
            case "ConsultarContinentes":
               ArrayList<Ciudad> continentes= myGestorCiudad.consultarContinentes();
              salidaDecorada.println(parseArrCiudades(continentes));
               break;
            case "ConsultarPaises":
                ArrayList<Ciudad> paises= myGestorCiudad.consultarPaises(parametros[1]);
                salidaDecorada.println(parseArrCiudades(paises));
                break;
            case "ConsultarCiudades":
                 ArrayList<Ciudad> ciudades= myGestorCiudad.consultarCiudades(parametros[1],parametros[2]);
              salidaDecorada.println(parseArrCiudades(ciudades));
                break;
            case "AsignarIdToPaquetePersonalizado":
                long idPaquete =myGestorPlanesPersonalizados.asignarIdToPaquetePersonalizado();
                salidaDecorada.println(""+idPaquete);
                break;
            case "AgregarPlanPersonalizado":
                
                Paquete myPaquete=deserializarPaquete(parametros[1]);
                boolean planAgregado=myGestorPlanesPersonalizados.agregarPlanPersonalizado(myPaquete);
                if(planAgregado){
                    salidaDecorada.print("AGREGADO");
                }else{
                    salidaDecorada.print("NO_AGREGADO");

                }
                break;
            case "ConsultarPlanPersonalizado":
                break;
            case "EditarPlanPersonalizado":
                break;
            case "EliminarPlanPersonalizado":
                break;
            case "ConsultarVuelos":
                ArrayList<Vuelo> vuelos=myGestorVuelos.consultarVuelos(parametros[1], parametros[2], parametros[3], parametros[4]);
                String mensaje =parseArrayVuelosToJson(vuelos);
                salidaDecorada.println(mensaje);
                break;
            case "ConsultarHoteles":
                ArrayList<Hotel> hoteles=myGestorHoteles.consultarHoteles(parametros[1], parametros[2], parametros[3]);               
                String m2 = parseArrayHotelesToJson(hoteles);
                salidaDecorada.println(m2);
                break;
            case "ConsultarCiudad":
                Ciudad myCiudad=myGestorCiudad.consultarPrecioCiudad(parametros[1], parametros[2], parametros[3]);              
                salidaDecorada.println(parseCiudadToJSON(myCiudad));
                break;
            case "ConsultarCityTours":
                ArrayList<CityTour>cityTours =myGestorCityTour.consultarCityTours(parametros[1], parametros[2], parametros[3]);
                
                salidaDecorada.println(parseArrCityToJson(cityTours));
                break;
            case "ConsultarPlanAlimentacion":
                ArrayList<PlanAlimentacionHotel> planes=myGestorPlanAlimentacion.consultarPlanesAlimentacion(parametros[1]);
                salidaDecorada.println(parseArrAlimentacionToJson(planes));
                break;
            case "consultarPaqueteWeb":
                PaqueteWeb paqueteWebConsultado=null;                
                paqueteWebConsultado=myGestorPaquetesWeb.consultarPaquete(Integer.parseInt(parametros[1]));
                if(paqueteWebConsultado==null){
                    salidaDecorada.println("NO_ENCONTRADO");
                }else{
                    salidaDecorada.println(parseToJSONPaqueteWeb(paqueteWebConsultado));   
                    return;
                }
                break;
            case "consultarIDPaquetesTI":
                ArrayList<String> paquetesConsultados;
                paquetesConsultados=myGestorPaquetesWeb.consultarIDPaquetesTI();
                if(paquetesConsultados==null){
                    salidaDecorada.println("NO_ENCONTRADO");
                }else{
                    salidaDecorada.println(parseToJSONArrayString(paquetesConsultados));                   
                }
                break; 
            case "consultarFotosPaqueteWeb":
                ArrayList<String> fotos;
                fotos=myGestorPaquetesWeb.consultarFotosPaq(Integer.parseInt(parametros[1]));
                if(fotos==null){
                    salidaDecorada.println("NO_ENCONTRADO");
                }else{
                    salidaDecorada.println(parseToJSONArrayString(fotos));                   
                }
                break; 
            default:
                salidaDecorada.println("PETICION_INVALIDA");
                break;
                
        }
    }
    private Paquete deserializarPaquete(String json){
        try {
            Paquete myPaquete = new Paquete();
            JSONObject paqueteJson = new JSONObject(json);
            String fechaCreacion = paqueteJson.getString("fechaCreacion");
            int existencias = paqueteJson.getInt("existencias");
            long idPaquete = paqueteJson.getLong("idPaquete");
            char tipo = paqueteJson.getString("tipo").charAt(0);
            
            String fechaInicio = paqueteJson.getString("fechaInicio");
            String fechaFin = paqueteJson.getString("fechaFin");
            String nombrePaquete  = paqueteJson.getString("nombrePaquete");
            String descripcionPaquete  = paqueteJson.getString("descripcion");

            
            myPaquete.setFechaInicio(fechaInicio);
            myPaquete.setFechaFin(fechaFin);           
            myPaquete.setNombrePaquete(nombrePaquete);           
            myPaquete.setFechaCreacion(fechaCreacion);
            myPaquete.setTipo(tipo);
            myPaquete.setIdPaquete(idPaquete);
            myPaquete.setExistencias(existencias);
            myPaquete.setDescripcion(descripcionPaquete);
            
            JSONArray ciudadesJson= paqueteJson.getJSONArray("ciudades");
            
            for (int i = 0; i <ciudadesJson.length(); i++) {
                JSONObject ciudadJson = ciudadesJson.getJSONObject(i);
                for (int j = 0; j < ciudadesJson.length(); j++) {
                    long idCiudad = ciudadJson.getLong("idCiudad");
                    String nombreCiudad = ciudadJson.getString("nombreCiudad");
                    int precioCiudad = ciudadJson.getInt("precio");
                    Ciudad myCiudad = new Ciudad(idCiudad,nombreCiudad,precioCiudad);
                    myPaquete.addComponent(myCiudad);
                    
                    JSONArray hotelesJson = ciudadJson.optJSONArray("hoteles");
                    if(hotelesJson!=null){
                        
                       for (int k = 0; k < hotelesJson.length(); k++) {
                           
                           JSONObject hotelJson = hotelesJson.getJSONObject(k);
                           long idHotel =hotelJson.getLong("idHotel");
                           String nombreHotel = hotelJson.getString("nombreHotel");
                           Hotel myHotel = new Hotel(idHotel, nombreHotel);
                           myCiudad.addComponent(myHotel);
                           
                             JSONArray habitacionesJson = hotelJson.optJSONArray("habitaciones");
                             if(habitacionesJson!=null){
                                 for (int l = 0; l < habitacionesJson.length(); l++) {
                                     JSONObject habitacionJson = habitacionesJson.getJSONObject(l);
                                     int numeroHabitacion = habitacionJson.getInt("numeroHabitacion");
                                     String descripcion = habitacionJson.getString("descripcion");
                                     int precio = habitacionJson.getInt("precio");
                                     char disponible = habitacionJson.getString("disponible").charAt(0);
                                     Habitacion myHabitacion = new Habitacion(numeroHabitacion, descripcion,disponible, precio);
                                     myHotel.addComponent(myHabitacion);
                                     
                                 }
                             }
                             JSONArray planesAliJson = hotelJson.optJSONArray("planesAlimentacion");
                             if(planesAliJson !=null){
                                 for (int l = 0; l < planesAliJson.length(); l++) {
                                    JSONObject planAliJson = planesAliJson.getJSONObject(l);
                                    long idPlan = planAliJson.getLong("idPlanAlimentacion");
                                    String descripcion = planAliJson.getString("descripcion");
                                    int precio = planAliJson.getInt("precio");
                                    PlanAlimentacionHotel myPlanAli = new PlanAlimentacionHotel(idPlan, descripcion, precio);
                                    myHotel.addComponent(myPlanAli);
                                    

                                 }
                             }      
                        }
                       
                    }
                    
                    JSONArray vuelosJson = ciudadJson.optJSONArray("vuelos");
                    if(vuelosJson !=null){
                        for (int k = 0; k < vuelosJson.length(); k++) {
                           
                           JSONObject vueloJson = vuelosJson.getJSONObject(k);
                           long idVuelo = vueloJson.getLong("idVuelo");
                           String aerolinea = vueloJson.getString("aerolinea");
                           String nombreCiudadOrigen = vueloJson.getString("nombreCiudadOrigen");
                           String nombreCiudadDestino = vueloJson.getString("nombreCiudadDestino");
                           String fechaHoraLLegada = vueloJson.getString("fechaHoraLlegada");
                           String fechaHoraSalida = vueloJson.getString("fechaHoraSalida");
                           int precioVuelo = vueloJson.getInt("precio");
                           Vuelo myVuelo = new Vuelo(idVuelo, aerolinea, nombreCiudadOrigen, nombreCiudadDestino, fechaHoraLLegada, fechaHoraSalida, precioVuelo);
                           myCiudad.addComponent(myVuelo);
                           
                        }
                        
                    }
                   JSONArray cityToursJson = ciudadJson.optJSONArray("cityTours");
                   if(cityToursJson!=null){
                       for (int k = 0; k < cityToursJson.length(); k++) {
                           
                           JSONObject cityTourJson = cityToursJson.getJSONObject(k);
                           long idCityTour = cityTourJson.getLong("idCityTour");
                           String fechaInicioCT = cityTourJson.getString("fechaInicio");
                           String fechaFinCT = cityTourJson.getString("fechaFin");
                           String descripcion = cityTourJson.getString("descripcion");
                           int precioCityTour = cityTourJson.getInt("precio");
                           CityTour myCityTour = new CityTour(idCityTour, fechaInicioCT, fechaFinCT, descripcion, precioCityTour);                          
                           myCiudad.addComponent(myCityTour);
                           
                        }
                   }


                    
                }
               
                
            }
            return myPaquete;
        } catch (JSONException ex) {
            Logger.getLogger(ServidorCentralServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private String parseArrAlimentacionToJson(ArrayList<PlanAlimentacionHotel> planes){
    JsonArray array = new JsonArray();
        JsonObject gsonObj;    
        for(int i=0;i<planes.size() ;i++){
            PlanAlimentacionHotel plan =planes.get(i);
            gsonObj = new JsonObject();
            gsonObj.addProperty("idPlanAlimentacion",plan.getIdPlanAlimentacion());
            gsonObj.addProperty("descripcion", plan.getDescripcion());
            gsonObj.addProperty("precio", plan.getPrecio());
            array.add(gsonObj);

        }    
        
        return array.toString();
    }
    private String parseArrCityToJson(ArrayList<CityTour> cityTours){
    JsonArray array = new JsonArray();
        JsonObject gsonObj;    
        for(int i=0;i<cityTours.size() ;i++){
            CityTour myCityTour =cityTours.get(i);
            gsonObj = new JsonObject();
            gsonObj.addProperty("idCityTour",myCityTour.getIdCityTour());
            gsonObj.addProperty("descripcion", myCityTour.getDescripcion());
            gsonObj.addProperty("fechaInicio", myCityTour.getFechaInicio());
            gsonObj.addProperty("fechaFin", myCityTour.getFechaFin());
            gsonObj.addProperty("precio", myCityTour.getPrecio());

            array.add(gsonObj);

        }    
        
        return array.toString();
    }
    private String parseArrCiudades(ArrayList<Ciudad> ciudades){
    JsonArray array = new JsonArray();
        JsonObject gsonObj;    
        for(int i=0;i<ciudades.size() ;i++){
            Ciudad myCiudad =ciudades.get(i);
            gsonObj = new JsonObject();
            gsonObj.addProperty("idCiudad",myCiudad.getIdCiudad());
            gsonObj.addProperty("nombreCiudad", myCiudad.getNombreCiudad());
            gsonObj.addProperty("precio", myCiudad.getPrecioCiudadSolo());
            array.add(gsonObj);

        }    
        
        return array.toString();
    }
    private String parseCiudadToJSON(PaqueteComponent ciu) {
        Ciudad myCiudad = (Ciudad) ciu;
        JsonObject salida = new JsonObject();
        salida.addProperty("idCiudad",myCiudad.getIdCiudad());
        salida.addProperty("nombreCiudad", myCiudad.getNombreCiudad());
        salida.addProperty("precio",myCiudad.getPrecio());


        return salida.toString();
    } 
    private String parseArrayHotelesToJson(ArrayList<Hotel> hoteles){
        JsonArray array = new JsonArray();

        JsonObject gsonObj;    
        String json="[";
        for(int i=0;i<hoteles.size();i++){
           JsonArray arrayHab = new JsonArray();
            Hotel myHotel =hoteles.get(i);
            json +="{\"idHotel\":\""+myHotel.getIdHotel()+"\",";
            json +="\"nombreHotel\":\""+myHotel.getNombreHotel()+"\",";
            json +="\"componentes\":[";
            
            for (int j = 0; j < myHotel.getArrayComponentes().size(); j++) {
                Habitacion myHabitacion = (Habitacion)myHotel.getArrayComponentes().get(j);
               json +="{\"numeroHabitacion\":\""+myHabitacion.getNumeroHabitacion()+"\",";
               json +="\"descripcion\":\""+myHabitacion.getDescripcion()+"\",";
               json +="\"disponible\":\""+myHabitacion.getDisponible()+"\",";
               json +="\"precio\":\""+myHabitacion.getPrecio()+"\"}";
               
               if((myHotel.getArrayComponentes().size()-1)!=j){
                   json+=",";
               }else{
                    json+="]";
               }
            }
            if((hoteles.size()-1) != i){
                json+="},";
            }else{
                json+="}";
            }
            
        }    
        json+="]";
        return json;
    }
    private String parseArrayVuelosToJson(ArrayList<Vuelo> vuelos){
        JsonArray array = new JsonArray();
        JsonObject gsonObj;    
        for(int i=0;i<vuelos.size() ;i++){
            Vuelo myVuelo =vuelos.get(i);
            gsonObj = new JsonObject();
            gsonObj.addProperty("idVuelo",myVuelo.getIdVuelo());
            gsonObj.addProperty("precio", myVuelo.getPrecio());
            gsonObj.addProperty("aerolinea", myVuelo.getAerolinea());
            gsonObj.addProperty("nombreCiudadOrigen", myVuelo.getNombreCiudadOrigen());
            gsonObj.addProperty("nombreCiudadDestino", myVuelo.getNombreCiudadDestino());
            gsonObj.addProperty("fechaHoraSalida", myVuelo.getFechaHoraSalida());
            gsonObj.addProperty("fechaHoraLlegada", myVuelo.getFechaHoraLlegada());

            array.add(gsonObj);

        }    
        
        return array.toString();
    }

    private String parseToJSON(Cliente ciu) {
        JsonObject salida = new JsonObject();
        salida.addProperty("idCliente", ciu.getIdentificacion());
        salida.addProperty("nombres", ciu.getNombres());
        salida.addProperty("apellidos", ciu.getApellidos());
        salida.addProperty("fechaNac", ciu.getFechaNac());
        salida.addProperty("genero", ciu.getGenero());
        salida.addProperty("direccion", ciu.getDireccion());
        salida.addProperty("ciudadResidencia", ciu.getCiudadResidencia());       
        salida.addProperty("celular", ciu.getCelular());
        salida.addProperty("email", ciu.getEmail());           
        return salida.toString();
    } 
    
    private String parseToJSON(Usuario user) {
        JsonObject salida = new JsonObject();
        salida.addProperty("nombre", user.getNombre());
        salida.addProperty("contrasenia", user.getContrasenia());
        salida.addProperty("nombreCompleto", user.getNombreCompleto());
        salida.addProperty("cargo", user.getCargo());
        salida.addProperty("fechaCreacion", user.getFechaCreacion());           
        return salida.toString();
    }
    
    private String parseToJSONArrayString(ArrayList<String> vector) {
        JsonArray array = new JsonArray();
        JsonObject gsonObj;
        for(int i=0;i<vector.size();i++){
            gsonObj = new JsonObject();
            gsonObj.addProperty("string", vector.get(i));
            array.add(gsonObj);
        }    
        return array.toString();
    }


    private String parseToJSONPaqueteWeb(PaqueteWeb paqueteWebConsultado) {
        JsonObject salida = new JsonObject();
        salida.addProperty("idPaquete", paqueteWebConsultado.getIdPaquete());
        salida.addProperty("nombrepaquete", paqueteWebConsultado.getNombrepaquete());
        salida.addProperty("precio", paqueteWebConsultado.getPrecio());
        salida.addProperty("fechaInicio", paqueteWebConsultado.getFechaInicio());
        salida.addProperty("fechaFin", paqueteWebConsultado.getFechaFin());           
        salida.addProperty("tipoPaquete", paqueteWebConsultado.getTipoPaquete());    
        salida.addProperty("ciudades", paqueteWebConsultado.getCiudades());  
        salida.addProperty("vuelos", "null");  
        salida.addProperty("hoteles", "null");
        salida.addProperty("habitaciones", "null");
        salida.addProperty("cityTuours", "null");
        salida.addProperty("alimentaciones", "null");       
        return salida.toString();
    }
}
