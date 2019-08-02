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
public class GestorHoteles {
     private ConectorJdbc conector;
    
    public GestorHoteles() {
        conector=new ConectorJdbc();    
    }
    /**
     * 
     * @param fechaEntrada fecha entrada al hotel
     * @param fechaSalida    fecha salida del hotel
     * @param ciudad    ciudad donde se encuentra el hotel
     * @return  devuelve  el array de hoteles
     */
    public ArrayList<Hotel> consultarHoteles(String fechaEntrada, String fechaSalida,String ciudad){
         try {
            System.out.println("Entro a consultar vuelos del servidor");
            conector.conectarse();
            ArrayList<Hotel> hoteles = new ArrayList<>();
            String[] vecCiudad=ciudad.split("-");
            String nomContinente=vecCiudad[0];
            String nomPais=vecCiudad[1];
            String nomCiudad= vecCiudad[2];
 

          
            String consulta =
                "select t3.idHotel,t3.nomHotel,t3.numHabitacion,ciudad.nomCiudad,t3.descripcion,t3.precio\n" +
                "from ciudad inner join\n" +
                "(\n" +
                "	select hotel.idHotel,hotel.nomHotel,hotel.idCiudad,t2.descripcion,t2.precio,t2.numHabitacion\n" +
                "	from hotel inner join \n" +
                "	(\n" +
                "	select habitacion.*\n" +
                "	from habitacion left join\n" +
                "	 	( 	\n" +
                "		select *\n" +
                "		from reservaHotel\n" +
                "		where SYSDATE between fechaEntrada and fechaSalida\n" +
                "\n" +
                "		) t1 on habitacion.idHotel = t1.idHotel and habitacion.numHabitacion = t1.numHabitacion\n" +
                "	where t1.idHotel is null and t1.numHabitacion is null\n" +
                "	) t2 on hotel.idHotel = t2.idHotel \n" +
                ")t3 on ciudad.idCiudad = t3.idCiudad\n" +
                "where idCiudad = (\n" +
                "	select  idCiudad\n" +
                "	from ciudad\n" +
                "	where idPais=(\n" +
                "		select  idPais\n" +
                "		from pais\n" +
                "		where idContinente = (\n" +
                "			select idContinente\n" +
                "			from continente\n" +
                "			where nomContinente='"+nomContinente+"'\n" +
                "		) and nomPais = '"+nomPais+"'\n" +
                "	) and nomCiudad ='"+nomCiudad+"'\n" +
                ")";
            conector.crearConsulta(consulta);
            
            int cont=0;
            boolean primero=true;
            String salida="";
            while(conector.getResultado().next()){
                long id= conector.getResultado().getLong("idHotel");
                String nom = conector.getResultado().getString("nomHotel");
                Hotel myHotel = new Hotel(id,nom);
               
                Habitacion myHabitacion= new Habitacion(conector.getResultado().getInt("numHabitacion"),conector.getResultado().getString("descripcion"),'D',conector.getResultado().getInt("precio"));
                myHotel.addComponent(myHabitacion);
                hoteles.add(myHotel);
            }
            
            conector.desconectarse();
            return hoteles;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorVuelos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
