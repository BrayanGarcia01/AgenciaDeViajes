package negocio;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
/**
 *
 * @author danielmej
 */
public class GestorPaquetesWeb {
    private ConectorJdbc conector;
    
    public GestorPaquetesWeb() {
        conector=new ConectorJdbc();    
    }
    

    public  ArrayList<String> consultarIDPaquetesTI() throws SQLException, ClassNotFoundException{
        ArrayList<String> paquetes=new ArrayList<String>();
        conector.conectarse();
        conector.crearConsulta("select idpaquete from paquete where tipopaquete='T'");
        while(conector.getResultado().next()){
            String idPaquete=conector.getResultado().getString("idpaquete");           
            paquetes.add(idPaquete);
        }
        conector.desconectarse();
        return paquetes;
    }
    
    public ArrayList<String> consultarFotosPaq(int id) throws SQLException, ClassNotFoundException{
        ArrayList<String> fotos=new ArrayList<String>();
        conector.conectarse();
        conector.crearConsulta("select foto from fotoCiudad inner join (select ciudad.idciudad as cid from ciudad inner join paqueteCiudades on ciudad.idciudad=paqueteCiudades.idciudad where paqueteCiudades.idPaquete="+id+")on fotoCiudad.idciudad=cid;");
        while(conector.getResultado().next()){
            String foto=conector.getResultado().getString("foto");           
            fotos.add(foto);
        }
        conector.desconectarse();
        return fotos;
    }
    
    public PaqueteWeb consultarPaquete(int id) throws SQLException, ClassNotFoundException{
        PaqueteWeb paquete=null;
        conector.conectarse();
        conector.crearConsulta("select idPaquete,nombrepaquete,precio,fechaInicio,fechaFin,tipoPaquete from paquete where idPaquete="+id+";");
        if(conector.getResultado().next()){
            paquete=new PaqueteWeb();
            String arregloFecha;
            paquete.setIdPaquete(conector.getResultado().getInt("idPaquete"));
            paquete.setNombrepaquete(conector.getResultado().getString("nombrepaquete"));
            paquete.setPrecio(conector.getResultado().getInt("precio"));
            arregloFecha=conector.getResultado().getString("fechaInicio");
            paquete.setFechaInicio(arregloFecha);
            arregloFecha=conector.getResultado().getString("fechaFin");
            paquete.setFechaFin(arregloFecha);            
            if((conector.getResultado().getString("tipoPaquete")).equals("T")){
                paquete.setTipoPaquete("Todo Incluido");
            }else{
                paquete.setTipoPaquete("Personalizado");
            }
            
            conector.crearConsulta("select ciudad.nomCiudad as ciudades from ciudad inner join paqueteCiudades on ciudad.idCiudad=paqueteCiudades.idCiudad where idPaquete="+id+";");        
            String ciudades="";
            while(conector.getResultado().next()){
                ciudades=ciudades+conector.getResultado().getString("ciudades")+", ";
            }
            paquete.setCiudades(ciudades);
            
            
        }
        conector.desconectarse();
        return paquete;
        
    }
}
