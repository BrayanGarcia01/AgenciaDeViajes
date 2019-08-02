package com.mycompany.condortripsweb.acceso;

import com.mycompany.condortripsweb.negocio.PaqueteWeb;
import java.io.IOException;

 
public interface IServidorCentral {
   
    
    public abstract VString[] consultarIDPaquetesTI() throws IOException;
    public abstract VString[] consultarFotosPaquete(int id) throws IOException;
    public abstract PaqueteWeb consultarPaquete(int id) throws IOException;

}
