/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.PaqueteComponent;

/**
 *
 * @author brayangarcia
 */
public class Utilidades {
/*
    public  PaqueteComponent devolverContinente(RegionComponent paquete,String nombreContinente){
       
        for (int i = 0; i < paquete.devolverVecRegiones().size(); i++) {
            if(nombreContinente.equals(paquete.getNombre())){
                try {
                    return paquete.getComponent(i);
                } catch (Exception ex) {
                    Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return null;
    
    }

    public PaqueteComponent devolverPaisEnPaquete(RegionComponent paquete,String nombreContinente,String nombrePais) throws Exception{
        RegionComponent continente =(RegionComponent) devolverContinente(paquete,nombreContinente);
        if(continente ==null) return null;
        for (int i = 0; i < continente.devolverVecRegiones().size(); i++) {
            if(nombreContinente.equals(continente.getComponent(i).getNombre())){
                try {
                    return continente.getComponent(i);
                } catch (Exception ex) {
                    Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return null;
        
    }
    public PaqueteComponent devolverCiudadEnPaquete(RegionComponent paquete,String nombreContinente,String nombrePais,String nombreCiudad) throws Exception{
        RegionComponent continente =(RegionComponent) devolverContinente(paquete,nombreContinente);
        if(continente ==null) return null;
        RegionComponent pais =(RegionComponent) devolverPaisEnPaquete(paquete,nombreContinente,nombrePais);
        for (int i = 0; i < pais.devolverVecRegiones().size(); i++) {
            if(nombreContinente.equals(pais.getComponent(i).getNombre())){
                return pais.getComponent(i);
            }
            
        }
        return null;
        
    }
*/
}
