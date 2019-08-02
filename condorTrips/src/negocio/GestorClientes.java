package negocio;

import acceso.IServidorCentral;
import acceso.ServidorCentralSockets;

import java.io.IOException;

/**
 *
 * @author danielmej
 */
public class GestorClientes {
    private final IServidorCentral sc;

    public GestorClientes() {
        this.sc =new ServidorCentralSockets(); 
        
    }
    /**
     * 
     * @param cliente cliente a agregar a la base de datos
     * @return
     * @throws IOException 
     */
    public boolean agregarCliente(Cliente cliente) throws IOException{
        return sc.agregarCliente(cliente);
    }
    /**
     * 
     * @param cliente cliene a editar 
     * @return
     * @throws IOException 
     */
    public boolean editarCliente(Cliente cliente) throws IOException{
        return sc.editarCliente(cliente);
    }
    /**
     * 
     * @param id id del cliente a consultar
     * @return
     * @throws IOException 
     */
    public Cliente consultarCliente(long id) throws IOException{
        return sc.consultarCliente(id);        
     }
    /**
     * 
     * @param id id del cliente a eliminar
     * @return
     * @throws IOException 
     */
    public boolean eliminarCliente(long id) throws IOException{
        return sc.eliminarCliente(id);
    }
    
    
}
