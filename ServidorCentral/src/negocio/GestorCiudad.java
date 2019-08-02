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
public class GestorCiudad {
    private ConectorJdbc conector;

    public GestorCiudad() {
        conector = new ConectorJdbc();
    }
    /**
     * 
     * @param nombreContinente nombre del continente de los paises a buscar
     * @return devuelve todos los paises del continente especificado
     */
    public ArrayList<Ciudad> consultarContinentes(){
        try {
            conector.conectarse();            
            System.out.println("Entra a la consulta");
            String consulta = "select * from continente";
            conector.crearConsulta(consulta);
            ArrayList<Ciudad> ciudades = new ArrayList<>();
            
            while(conector.getResultado().next()){
                Ciudad myCiudad;
                long idCiudad= conector.getResultado().getLong("idContinente");
                String nombreCiudad=conector.getResultado().getString("nomContinente");
                myCiudad = new Ciudad(idCiudad,nombreCiudad,0);
                ciudades.add(myCiudad);
            }
            conector.desconectarse();
            return ciudades;
        } catch (SQLException ex) {
            Logger.getLogger(GestorCiudad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorCiudad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     /**
      * 
      * @param nombreContinente nombre del continente de la ciudad
      * @param nombrePais nombre del pais de la ciudad
      * @return devuelve todas la ciudades de ese pais
      */
    public ArrayList<Ciudad> consultarPaises(String continente){
        try {            
            conector.conectarse();
            System.out.println("Entra a la consulta");
            String consulta=
                    "select  *\n" +
                    "from pais\n" +
                    "where idContinente =\n" +
                    "(\n" +
                        "select idContinente\n" +
                        "from continente \n" +
                        "where continente.nomContinente = '"+continente+"'\n" +
                    ") ";
            conector.crearConsulta(consulta);
            ArrayList<Ciudad> ciudades= new ArrayList<>();
            while(conector.getResultado().next()){
                Ciudad myCiudad;
                long idCiudad= conector.getResultado().getLong("idPais");
                String nombreCiudad=conector.getResultado().getString("nomPais");
                myCiudad = new Ciudad(idCiudad,nombreCiudad,0);
                ciudades.add(myCiudad);
            }
            conector.desconectarse();
            return ciudades;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorCiudad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorCiudad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Ciudad> consultarCiudades(String nombreContinente, String nombrePais){
        
      try {            
            conector.conectarse();
            System.out.println("Entra a la consulta");
            String consulta=
                    "select * \n" +
                    "from ciudad\n" +
                    "where idPais=\n" +
                    "(\n" +
                    "select idPais\n" +
                    "from continente c inner join pais p on c.idContinente = p.idContinente\n" +
                    " where c.nomContinente ='"+nombreContinente+"' and p.nomPais='"+nombrePais+"'\n" +
                    ")";
                    
            conector.crearConsulta(consulta);
            ArrayList<Ciudad> ciudades= new ArrayList<>();
            while(conector.getResultado().next()){
                Ciudad myCiudad;
                long idCiudad= conector.getResultado().getLong("idCiudad");
                String nombreCiudad=conector.getResultado().getString("nomCiudad");
                int precio = conector.getResultado().getInt("precio");
                myCiudad = new Ciudad(idCiudad,nombreCiudad,precio);
                ciudades.add(myCiudad);
            }
            conector.desconectarse();
            return ciudades;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorCiudad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorCiudad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Ciudad consultarPrecioCiudad(String nomContinente, String nomPais,String nomCiudad){
        try {
            conector.conectarse();

            System.out.println("Entra a la consulta");
            String consulta=
                "	select *\n" +
                "	from ciudad\n" +
                "	where idPais=\n" +
                "	(\n" +
                "		select idPais\n" +
                "		from pais\n" +
                "		where idContinente =\n" +
                "		(\n" +
                "			select idContinente\n" +
                "			from continente\n" +
                "			where nomContinente ='"+nomContinente+"'\n" +
                "		)\n" +
                "		and nomPais = '"+nomPais+"'\n" +
                "	) and nomCiudad = '"+nomCiudad+"';" ;
            conector.crearConsulta(consulta);
            Ciudad myCiudad=null;
            if(conector.getResultado().next()){
                long idCiudad= conector.getResultado().getLong("idCiudad");
                String nombreCiudad=conector.getResultado().getString("nomCiudad");
                int precio = conector.getResultado().getInt("precio");
                myCiudad = new Ciudad(idCiudad,nombreCiudad,precio);
            }
            conector.desconectarse();
            return myCiudad;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorVuelos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
