package com.mycompany.condortripsweb.negocio;
import com.mycompany.condortripsweb.acceso.*;
import java.io.IOException;
/**
 *
 * @author danielmej
 */
public class GestorPaquetesWeb {
    private final IServidorCentral sc;
    
    public GestorPaquetesWeb() {
        this.sc = new ServidorCentralSockets();
    }

    public VString[] consultarIDPaquetesTI() throws IOException{
        return sc.consultarIDPaquetesTI();
    }
    
    public VString[] consultarFotosPaquete(int id) throws IOException{
        return sc.consultarFotosPaquete(id);
    }
    
    public PaqueteWeb consultarPaquete(int id) throws IOException{
        PaqueteWeb paquete=sc.consultarPaquete(id);
        if(paquete!=null){
            VString[] fotos=consultarFotosPaquete(id);
            paquete.setFotos(fotos);
        }
        return paquete;
    }
}
