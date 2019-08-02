/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brayangarcia
 */
public class GestorCityTour {
    private ConectorJdbc conector;

    public GestorCityTour() {
        conector = new ConectorJdbc();
    }
    /**
     * 
     * @param fechaInicio fecha inicio del citytour
     * @param fechaFin fecha fin del city tour
     * @param destino destino en formato continente-pais-ciudad
     * @return 
     */
    public ArrayList<CityTour> consultarCityTours(String fechaInicio, String fechaFin,String destino){
        try {
            System.out.println("Entro a consultar vuelos de la base");
            conector.conectarse();
            String[] ciudad=destino.split("-");
            String continenteDestino=ciudad[0];
            String paisDestino=ciudad[1];
            String ciudadDestino= ciudad[2];
            
            System.out.println("Entra a la consulta");
            String consulta=
                    "select *\n" +
                    "from cityTour\n" +
                    "where idCiudad=\n" +
                    "(\n" +
                    "	select idCiudad\n" +
                    "	from ciudad	\n" +
                    "	where idPais=\n" +
                    "	(\n" +
                    "	select idPais\n" +
                    "	from continente c inner join pais p on c.idContinente = p.idContinente\n" +
                    "	where c.nomContinente ='"+continenteDestino+"' and p.nomPais='"+paisDestino+"'\n" +
                    "	) and nomCiudad='"+ciudadDestino+"'\n" +
                    ") and fechaInicio='"+fechaInicio+"' and fechaFin='"+fechaFin+"' and cantidad > 0";
                    
            conector.crearConsulta(consulta);
            ArrayList<CityTour> cityTours= new ArrayList<>();
            while(conector.getResultado().next()){
                       long id= conector.getResultado().getLong("idCityTour");
                       
                       String descripcion=conector.getResultado().getString("descripcion");
                       String fechaInicioc= conector.getResultado().getString("fechaInicio");
                       String fechaFinc =conector.getResultado().getString("fechaFin");
                       int precio =conector.getResultado().getInt("precio");
                        CityTour myCityTour= new CityTour(id, fechaInicioc, fechaFinc, descripcion, precio);
                        cityTours.add(myCityTour);
                   
            }
            conector.desconectarse();
            return cityTours;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorVuelos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
