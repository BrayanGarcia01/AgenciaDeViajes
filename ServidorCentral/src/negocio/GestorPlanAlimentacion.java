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
public class GestorPlanAlimentacion {
    private ConectorJdbc conector;

    public GestorPlanAlimentacion() {
        conector = new ConectorJdbc();
    }
    /**
     * 
     * @param idHotel id del hotel
     * @return devuelve los planes de alimentacion del hotel especificado
     */
    public ArrayList<PlanAlimentacionHotel> consultarPlanesAlimentacion(String idHotel) {
                try {

            conector.conectarse();
            System.out.println("Entra a la consulta");
            String consulta=
                   "select *  \n" +
                    "from planalimentacion\n" +
                    "where idHotel = "+idHotel+" and cantidad > 0 ";
                    
            conector.crearConsulta(consulta);
            ArrayList<PlanAlimentacionHotel> planes= new ArrayList<>();
            while(conector.getResultado().next()){
                        long idPlan = conector.getResultado().getLong("idPlanAlimentacion");
                        String descripcion = conector.getResultado().getString("descripcion");
                        int precio = conector.getResultado().getInt("precio");
                       PlanAlimentacionHotel myPlan = new PlanAlimentacionHotel(idPlan, descripcion,precio);
                       planes.add(myPlan);
            }
            conector.desconectarse();
            return planes;
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorVuelos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorPlanAlimentacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
