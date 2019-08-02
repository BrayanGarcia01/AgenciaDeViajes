/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brayangarcia
 */
public class GestorVuelos {
    private ConectorJdbc conector;

    public GestorVuelos() {
        conector = new ConectorJdbc();
    }
    /**
     * 
     * @param fechaSalida fehca de salida del vuelo
     * @param fechaLlegada fecha de llegada del vuelo
     * @param origen    orgien en ofrmato continente-pais-ciudad
     * @param destino   destino en formato continnete-pais- ciudad
     * @return 
     */
    public ArrayList<Vuelo> consultarVuelos(String fechaSalida, String fechaLlegada,String origen,String destino){
        try {
            System.out.println("Entro a consultar vuelos de la base");
            conector.conectarse();
            ArrayList<Vuelo> vuelos = new ArrayList<>();
            String[] ciudad=destino.split("-");
            String continenteDestino=ciudad[0];
            String paisDestino=ciudad[1];
            String ciudadDestino= ciudad[2];
            
            String[] ciudad2=origen.split("-");
            String continenteOrigen=ciudad2[0];
            String paisOrigen=ciudad2[1];
            String ciudadOrigen= ciudad2[2];
            System.out.println("Entra a la consulta");
            String consulta=
"               select idVuelo,aerolinea,nomCiudadOrigen,nomCiudadDestino,fechaHoraSalida,fechaHoraLlegada,precio\n"+
"               from (\n"+
"                select idVuelo,aerolinea,idCiudadOrigen,(select nomCiudad from ciudad where idCiudadOrigen=idCiudad) nomCiudadOrigen,\n" +
"		idCiudadDestino,(select nomCiudad from ciudad where idCiudadDestino=idCiudad)nomCiudadDestino,\n" +
"		fechaHoraSalida,fechaHoraLlegada,precio\n" +
"		\n" +
"                from vuelo\n" +
"                where idCiudadOrigen=\n" +
"                (\n" +
"                	select idCiudad\n" +
"                	from ciudad\n" +
"                	where idPais=\n" +
"                	(\n" +
"               		select idPais\n" +
"                		from pais\n" +
"                		where idContinente =\n" +
"                		(\n" +
"                			select idContinente\n" +
"               			from continente\n" +
"                		where nomContinente = '"+continenteOrigen+"'\n" +
"                		)\n" +
"                		and nomPais ='"+paisOrigen+"'\n" +
"                	) and nomCiudad = '"+ciudadOrigen+"'\n" +
"                ) and idCiudadDestino=\n" +
"                (\n" +
"                      select idCiudad\n" +
"                	from ciudad\n" +
"                	where idPais=\n" +
"                	(\n" +
"                		select idPais\n" +
"                		from pais\n" +
"                		where idContinente =\n" +
"                		(\n" +
"                			select idContinente\n" +
"                			from continente\n" +
"                			where nomContinente ='"+continenteDestino+"'\n" +
"                		)\n" +
"                		and nomPais = '"+paisDestino+"'\n" +
"               	) and nomCiudad = '"+ciudadDestino+"'\n" +
"             \n" +
"                )\n" +
"                and fechaHoraSalida ='"+fechaSalida+"'\n" +
"                and fechaHoraLlegada='"+fechaLlegada+"'\n"+
"   )";
                    
            conector.crearConsulta(consulta);
            while(conector.getResultado().next()){
                       long id= conector.getResultado().getLong("idVuelo");
                       String aerolinea=conector.getResultado().getString("aerolinea");
                       String nomOrigen= conector.getResultado().getString("nomCiudadOrigen");
                       String nomDestino =conector.getResultado().getString("nomCiudadDestino");
                       int precio =conector.getResultado().getInt("precio");
                   Vuelo myVuelo= new Vuelo(id, aerolinea,nomOrigen,nomDestino,fechaLlegada, fechaSalida ,precio);
                   vuelos.add(myVuelo);
                   
            }
            conector.desconectarse();
            return vuelos;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorVuelos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
