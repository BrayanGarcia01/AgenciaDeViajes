/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brayangarcia
 */
public class GestorPlanesPersonalizados {
    private ConectorJdbc conector;
    
    public GestorPlanesPersonalizados() {
        conector=new ConectorJdbc();    
    }
    /**
     * 
     * @return devuelve un id dispobible para un paquete
     */
     public long asignarIdToPaquetePersonalizado() {
         long idLibre=0;
        try {
            conector.conectarse();
            ArrayList<Integer> errores=new ArrayList<Integer>();
            String consulta=
                    "select count(*) idLibre\n" +
                    "from paquete";
            conector.crearConsulta(consulta);
            if(conector.getResultado().next()){
                idLibre =100+ conector.getResultado().getLong("idLibre");
            }
            conector.desconectarse();
            return idLibre;
        } catch (SQLException ex) {
            Logger.getLogger(GestorPlanesPersonalizados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorPlanesPersonalizados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    /**
     * 
     * @param myPaquete  paquuete a agreggar a la base de datos
     */
    public boolean agregarPlanPersonalizado(Paquete myPaquete){
        try {
            conector.conectarse();
            ArrayList<Integer> errores=new ArrayList<Integer>();
 
            String insert="";
            if(myPaquete.getTipo()=='T'){
                    insert =
                    "insert into paquete(idPaquete,nombrePaquete,tipoPaquete,cantidad,precio,fechaCreacion,fechaInicio,fechaFin,descripcion)"
                    + " values ("+myPaquete.getIdPaquete()+",'"+myPaquete.getNombrePaquete()+"','"+myPaquete.getTipo()+"',"+myPaquete.getExistencias()+","+myPaquete.getPrecio()+","
                    +"TO_DATE('"+myPaquete.getFechaCreacion()+"','yyyy-MM-dd')"+",TO_DATE('"+myPaquete.getFechaInicio()+"','yyyy-MM-dd'),TO_DATE('"+myPaquete.getFechaFin()+"','yyyy-MM-dd'),'"+myPaquete.getDescripcion()+"')";
            }else{
                insert="insert into paquete(idPaquete,nombrePaquete,tipoPaquete,cantidad,precio,fechaCreacion,fechaInicio,fechaFin,descripcion)"
                    + " values ("+myPaquete.getIdPaquete()+",null,'"+myPaquete.getTipo()+"',"+myPaquete.getExistencias()+","+myPaquete.getPrecio()+","
                    +"TO_DATE('"+myPaquete.getFechaCreacion()+"','yyyy-MM-dd'),"+"null,null,null)";
            }
            conector.actualizar(insert, errores);
            
            for (int i = 0; i < myPaquete.getComponentes().size(); i++) {
                insert="insert into paqueteCiudades values("+myPaquete.getIdPaquete();
                Ciudad myCiudad = (Ciudad) myPaquete.getComponentes().get(i);
                insert+=","+myCiudad.getIdCiudad()+");";
                conector.actualizar(insert,errores);
                for (int j = 0; j < myCiudad.getComponentes().size(); j++) {
                    if(myCiudad.getComponentes().get(j) instanceof CityTour){
                        CityTour myCityTour = (CityTour) myCiudad.getComponentes().get(j);
                        insert= "insert into paqueteCityTours values("+myPaquete.getIdPaquete()+","+myCityTour.getIdCityTour()+");";
                        conector.actualizar(insert, errores);
                    }
                    if(myCiudad.getComponentes().get(j) instanceof Vuelo){
                        Vuelo myVuelo = (Vuelo) myCiudad.getComponentes().get(j);
                        insert= "insert into paqueteVuelos values("+myPaquete.getIdPaquete()+","+myVuelo.getIdVuelo()+");";
                        conector.actualizar(insert, errores);
                    }
                    if(myCiudad.getComponentes().get(j) instanceof Hotel){
                        Hotel myHotel = (Hotel) myCiudad.getComponentes().get(j);
                        insert= "insert into paqueteHoteles values("+myPaquete.getIdPaquete()+","+myHotel.getIdHotel()+");";
                        conector.actualizar(insert, errores);
                        for (int k = 0; k < myHotel.getArrayComponentes().size(); k++) {
                            insert ="";
                            if(myHotel.getComponentes().get(k) instanceof PlanAlimentacionHotel){
                            PlanAlimentacionHotel myPlanAli = (PlanAlimentacionHotel) myHotel.getComponentes().get(k);
                            insert= "insert into paqueteAlimentacion values("+myPaquete.getIdPaquete()
                                    +","+myPlanAli.getIdPlanAlimentacion()+","+myHotel.getIdHotel()+");";
                            conector.actualizar(insert, errores);
                            }
                            if(myHotel.getComponentes().get(k) instanceof Habitacion){
                            Habitacion myHabitacion = (Habitacion) myHotel.getComponentes().get(k);
                            insert= "insert into paqueteHabitacion values("+myPaquete.getIdPaquete()+
                                    ","+myHotel.getIdHotel()+","+myHabitacion.getNumeroHabitacion()+");";
                            conector.actualizar(insert, errores);
                            }
                            
                        }
                    }
                    
                    
                }

            }
            conector.desconectarse();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(GestorPlanesPersonalizados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorPlanesPersonalizados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    public void consultarPlanPersonalizado(){
    
    }
    public void editarPlanPersonalizado(){
    
    }
    public void eliminarPlanPersonalizado(){
    
    }

   
    
}
