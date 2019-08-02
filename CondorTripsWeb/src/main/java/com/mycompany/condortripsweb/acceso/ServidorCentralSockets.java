package com.mycompany.condortripsweb.acceso;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mycompany.condortripsweb.negocio.PaqueteWeb;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 *
 * @author danielmej
 */

public class ServidorCentralSockets implements IServidorCentral{

    private Socket socket = null;
    private Scanner entradaDecorada;
    private PrintStream salidaDecorada;
    private final String IP_SERVIDOR = "localhost";
    private final int PUERTO = 5000;
   
    
    
    /* 
     *Funcion que lee un flujo de entrada y retorna una salida, se comunica con el servidor 
     * @param vsalidaDecorada
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
     * @param usuario
     * @throws IOException
     */

    @Override
    public VString[] consultarIDPaquetesTI() throws IOException{
        String salida="NO_ENCONTRADO";
        conectar(IP_SERVIDOR, PUERTO);
        salida=leerFlujoEntradaSalida("consultarIDPaquetesTI,,");
        cerrarFlujos();
        desconectar();     
        
        if(salida.equals("NO_ENCONTRADO")){
            return null;
        }else{
            VString[] paquetes=new Gson().fromJson(salida, VString[].class);               
            return paquetes;   
        }            
    }

    @Override
    public VString[] consultarFotosPaquete(int id) throws IOException {
        String salida="NO_ENCONTRADO";
        conectar(IP_SERVIDOR, PUERTO);
        salida=leerFlujoEntradaSalida("consultarFotosPaqueteWeb,,"+id);
        cerrarFlujos();
        desconectar();     
        if(salida.equals("NO_ENCONTRADO")){
            return null;
        }else{
            VString[] fotos=new Gson().fromJson(salida, VString[].class);               
            return fotos;   
        }    
    }

    @Override
    public PaqueteWeb consultarPaquete(int id) throws IOException {
        String salida="NO_ENCONTRADO";
        conectar(IP_SERVIDOR, PUERTO);
        salida=leerFlujoEntradaSalida("consultarPaqueteWeb,,"+id);
        cerrarFlujos();
        desconectar();     
        if(salida.equals("NO_ENCONTRADO")){
            return null;
        }else{
            PaqueteWeb paquete=new Gson().fromJson(salida, PaqueteWeb.class);               
            return paquete;   
        }
    }
   
}
