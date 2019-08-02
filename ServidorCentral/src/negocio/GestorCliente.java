package negocio;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import java.util.ArrayList;

public class GestorCliente {
    private ConectorJdbc conector;
    
    public GestorCliente() {
        conector=new ConectorJdbc();    
    }
    
    public boolean agregarCliente(Cliente cliente) throws ClassNotFoundException,ClassNotFoundException, SQLException{
        try{
            conector.conectarse();
            ArrayList<Integer> errores=new ArrayList<Integer>();
            String insertarQuery=clienteToQuery(cliente);
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
    public boolean editarCliente(Cliente cliente) throws ClassNotFoundException, SQLException{
        conector.conectarse();
        ArrayList<Integer> errores=new ArrayList<Integer>();
        String editarQuery=queryForUpdateCliente(cliente);
        conector.actualizar(editarQuery, errores);
        conector.desconectarse();
        if(errores.size()!=0){
                return false;
        }
        return true; 
    }
    public Cliente consultarCliente(long id) throws SQLException, ClassNotFoundException{
        Cliente cliente=null;
        conector.conectarse();
        conector.crearConsulta("SELECT * FROM cliente where idCliente="+id+";");
        if(conector.getResultado().next()){
            cliente = new Cliente(conector.getResultado().getLong("idCliente"),
                    conector.getResultado().getString("nombres"),
                    conector.getResultado().getString("apellidos"),
                    conector.getResultado().getString("fechanac"),
                    conector.getResultado().getString("genero").charAt(0),
                    conector.getResultado().getString("direccion"),
                    conector.getResultado().getString("ciudadresidencia"),
                    conector.getResultado().getLong("celular"),
                    conector.getResultado().getString("email"));            
        }
        conector.desconectarse();
        return cliente;
    }
    
    
    public boolean eliminarCliente(long id) throws SQLException, ClassNotFoundException{
        conector.conectarse();
        ArrayList<Integer> errores=new ArrayList<Integer>();
        conector.actualizar("delete from cliente where idCliente="+id+";",errores);
        conector.desconectarse();
        if(errores.size()!=0){
            return false;
        } 
        return true;
    }
    private String queryForUpdateCliente(Cliente cliente){
        String updateQuery="update cliente set "
            +"nombres='"+cliente.getNombres()+"',"
            +"apellidos='"+cliente.getApellidos()+"',"
            +"fechanac=";
        
        if(cliente.getFechaNac().equals("null")){
            updateQuery=updateQuery+"null"+",";
        }else{
            updateQuery=updateQuery+ "'"+cliente.getFechaNac()+"',";
        }
        
        updateQuery=updateQuery+"genero='"+cliente.getGenero()+"',"
            +"direccion=";
        
        if(cliente.getDireccion().equals("null")){
            updateQuery=updateQuery+"null"+",";
        }else{
            updateQuery=updateQuery+ "'"+cliente.getDireccion()+"',";
        }

        updateQuery=updateQuery+"ciudadresidencia=";
        
        if(cliente.getCiudadResidencia().equals("null")){
            updateQuery=updateQuery+"null"+",";
        }else{
            updateQuery=updateQuery+ "'"+cliente.getCiudadResidencia()+"',";
        }
        
        updateQuery=updateQuery+"celular=";
        
        if(cliente.getCelular()==0){
            updateQuery=updateQuery+"null"+",";
        }else{
            updateQuery=updateQuery+ cliente.getCelular()+",";
        }
        
        updateQuery=updateQuery+"email='"+cliente.getEmail()+"'";
        updateQuery=updateQuery+" where idCliente="+cliente.getIdentificacion()+";";
        return updateQuery;
    }
    private String clienteToQuery(Cliente cliente){
        String insertarQuery="insert into cliente values("
            + cliente.getIdentificacion()+","
            + "'"+cliente.getNombres()+"',"
            + "'"+cliente.getApellidos()+"',";
        
        if(cliente.getFechaNac().equals("null")){
            insertarQuery=insertarQuery+"null"+",";
        }else{
            insertarQuery=insertarQuery+ "'"+cliente.getFechaNac()+"',";
        }
        
        insertarQuery=insertarQuery+ "'"+cliente.getGenero()+"',";
        
        if(cliente.getDireccion().equals("null")){
            insertarQuery=insertarQuery+"null"+",";
        }else{
            insertarQuery=insertarQuery+ "'"+cliente.getDireccion()+"',";
        }
        
        
        if(cliente.getCiudadResidencia().equals("null")){
            insertarQuery=insertarQuery+"null"+",";
        }else{
            insertarQuery=insertarQuery+ "'"+cliente.getCiudadResidencia()+"',";
        }
        
        if(cliente.getCelular()==0){
            insertarQuery=insertarQuery+"null"+",";
        }else{
            insertarQuery=insertarQuery+ cliente.getCelular()+",";
        }
        
        insertarQuery=insertarQuery+ "'"+cliente.getEmail()+"');";
        return insertarQuery;
    }
    
}
