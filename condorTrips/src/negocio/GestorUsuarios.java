package negocio;

import acceso.IServidorCentral;
import acceso.ServidorCentralSockets;

import java.io.IOException;
/**
 *
 * @author danielmej
 */
public class GestorUsuarios {
    private final IServidorCentral sc;

    public GestorUsuarios() {
        this.sc = new ServidorCentralSockets();
    }
    /**
     * 
     * @param usuario usuario a agregar
     * @return
     * @throws IOException 
     */
    public boolean agregarUsuario(Usuario usuario) throws IOException{
        return sc.agregarUsuario(usuario);
    }
    /**
     * 
     * @param usuario usuario a editar
     * @return
     * @throws IOException 
     */
    public boolean editarUsuario(Usuario usuario) throws IOException{
        return sc.editarUsuario(usuario);
    }
    /**
     * 
     * @param nombre nombre de usuario a consultar
     * @return
     * @throws IOException 
     */
    public Usuario consultarUsuario(String nombre) throws IOException{
        return sc.consultarUsuario(nombre);
     }
    /**
     * 
     * @param nombre nombre del usuario a eliminar
     * @return
     * @throws IOException 
     */
    public boolean eliminarUsuario(String nombre) throws IOException{
        return sc.eliminarUsuario(nombre);
    }
    
    
    
}
