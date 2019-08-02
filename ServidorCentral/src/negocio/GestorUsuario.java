package negocio;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import java.util.ArrayList;
/**
 *
 * @author danielmej
 */
public class GestorUsuario {
    private ConectorJdbc conector;
        
   /**
     * Constructor por defecto
     */

    public GestorUsuario() {
        conector=new ConectorJdbc();    
    }

    /**
     * Agrega un usuario a la BD, retorna falso si no se pudo ejecutar la operacion 
     * o verdadero si el procedimiento fue exitoso
     * @param usuario
     * @return
     * @throws ClassNotFoundException
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public boolean agregarUsuario(Usuario usuario) throws ClassNotFoundException,ClassNotFoundException, SQLException{
        try{
            conector.conectarse();
            ArrayList<Integer> errores=new ArrayList<Integer>();
            String insertarQuery=usuarioToQuery(usuario);
            conector.actualizar(insertarQuery, errores);
            conector.desconectarse();           
            if(errores.size()!=0){
                return false;
            }
            return true;  
        }catch(SQLIntegrityConstraintViolationException ex){
            conector.desconectarse();
            return false;
        }
    }
    /**
     * Edita un usuario de la BD,retorna falso si no se pudo ejecutar la operacion 
     * o verdadero si el procedimiento fue exitoso
     * @param usuario
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public boolean editarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException{
        conector.conectarse();
        ArrayList<Integer> errores=new ArrayList<Integer>();
        String editarQuery=queryForUpdateUsuario(usuario);
        conector.actualizar(editarQuery, errores);
        conector.desconectarse();
        if(errores.size()!=0){
                return false;
        }
        return true; 
    }
    /**
     * Consulta un usuario especifico de la DB
     * @param nombre
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Usuario consultarUsuario(String nombre)throws SQLException, ClassNotFoundException{
        Usuario usuario=null;
        conector.conectarse();
        conector.crearConsulta("SELECT * FROM usuario where nombre='"+nombre+"';");
        if(conector.getResultado().next()){
            usuario = new Usuario(conector.getResultado().getString("nombre"),
                    conector.getResultado().getString("contrasenia"),
                    conector.getResultado().getString("nombrecompleto"),
                    conector.getResultado().getInt("cargo"),
                    conector.getResultado().getString("fechacreacion"));
            String arregloFechaCreacion=usuario.getFechaCreacion().substring(0, 19);
            usuario.setFechaCreacion(arregloFechaCreacion);
        }
        conector.desconectarse();
        return usuario;
    }
    /**
     * Consulta un usuario especifico de la DB
     * @param nombre
     * @param contrasenia
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Usuario consultarUsuario(String nombre, String contrasenia)throws SQLException, ClassNotFoundException{
        Usuario usuario=null;
        conector.conectarse();
        conector.crearConsulta("SELECT * FROM usuario where nombre='"+nombre+"' and contrasenia='"+contrasenia+"'");
        if(conector.getResultado().next()){
            usuario = new Usuario(conector.getResultado().getString("nombre"),
                    conector.getResultado().getString("contrasenia"),
                    conector.getResultado().getString("nombrecompleto"),
                    conector.getResultado().getInt("cargo"),
                    conector.getResultado().getString("fechacreacion"));
            String arregloFechaCreacion=usuario.getFechaCreacion().substring(0, 19);
            usuario.setFechaCreacion(arregloFechaCreacion);
        }
        conector.desconectarse();
        return usuario;
    }
    /**
     * Elimina  a un usuario de la base de datos,retorna falso si no se pudo ejecutar la operacion 
     * o verdadero si el procedimiento fue exitoso
     * @param nombre
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public boolean eliminarUsuario(String nombre) throws SQLException, ClassNotFoundException{
        conector.conectarse();
        ArrayList<Integer> errores=new ArrayList<Integer>();
        conector.actualizar("delete from usuario where nombre='"+nombre+"';",errores);
        conector.desconectarse();
        if(errores.size()!=0){
            return false;
        } 
        return true;
    }
    /**
     * Convierte un objeto de tipo Usuario a una sentencia insert QuerySQL
     * @param usuario
     * @return 
     */
    private String usuarioToQuery(Usuario usuario){
        String insertarQuery="insert into USUARIO values('"
            + usuario.getNombre()+"',"
            + "'"+usuario.getContrasenia()+"',"
            + "'"+usuario.getNombreCompleto()+"',"
            +usuario.getCargo()+",current_timestamp)";  
        return insertarQuery;
    }
    /**
     * Convierte un objeto de tipo usuario a una sentencia update QuerySQL
     * @param usuario
     * @return 
     */
    private String queryForUpdateUsuario(Usuario usuario){
        String updateQuery="update usuario set "
            +"contrasenia='"+usuario.getContrasenia()+"',"
            +"nombrecompleto='"+usuario.getNombreCompleto()+"',"
            +"cargo="+usuario.getCargo();
        updateQuery=updateQuery+" where nombre='"+usuario.getNombre()+"'";
        return updateQuery;
    }  
    
}
