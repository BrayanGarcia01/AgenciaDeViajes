package negocio;

import java.io.IOException;


/**
 *
 * @author danielmej
 */
public class Administrador extends Usuario{
        /**
     * Atributos
     */
    GestorUsuarios gestorUsuarios;
    /**
     * Constructor por defecto
     */
    public Administrador() {
        gestorUsuarios=new GestorUsuarios();
    }
    /**
     * Constructor parametrizado
     * @param nombre
     * @param contrasenia
     * @param nombreCompleto
     * @param fechaCreacion 
     */
    public Administrador(String nombre, String contrasenia, String nombreCompleto, String fechaCreacion) {        
        super(nombre, contrasenia, nombreCompleto, fechaCreacion);
        gestorUsuarios=new GestorUsuarios();
    }
    /**
     * agrega un nuevo usuario a la BD
     * @param usuario
     * @return
     * @throws IOException 
     */
    public boolean agregarUsuario(Usuario usuario) throws IOException{
        return gestorUsuarios.agregarUsuario(usuario);
    }
    /**
     * Edita la informacion de un usuario existente en la DB
     * @param usuario
     * @return
     * @throws IOException 
     */
    public boolean editarUsuario(Usuario usuario) throws IOException{
        return gestorUsuarios.editarUsuario(usuario);
    }
    /**
     * Consulta la informacion de un usuario existente en la DB
     * @param nombre
     * @return
     * @throws IOException 
     */
    public Usuario consultarUsuario(String nombre) throws IOException{        
        return gestorUsuarios.consultarUsuario(nombre);
    }
    /**
     * Eliminar a un usuario especifico de la DB
     * @param nombre
     * @return
     * @throws IOException 
     */
    public boolean eliminarUsuario(String nombre) throws IOException{
        return gestorUsuarios.eliminarUsuario(nombre);
    }
}
