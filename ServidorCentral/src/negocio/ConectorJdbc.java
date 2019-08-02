package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConectorJdbc {
    private Connection cn;
    private ResultSet rs;
    private Statement st;
    
    private String URL= "jdbc:hsqldb:file:/Users/brayangarcia/Desktop/CodigoFuente/ServidorCentral/BDFinal/BDFinal;hsqldb.lock_file=false";
    String USER="sa";
    String PASSWORD= "1234";


    
    public void conectarse() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbcDriver");
        cn = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Base de datos conectada");
    }

    /**
     * Ejecuta una consulta de tipo select
     * @param sql
     * @throws SQLException
     */
    public void crearConsulta(String sql) throws SQLException {
        cn.clearWarnings();
        st = cn.createStatement();
        rs = st.executeQuery(sql);
    }

    /**
     * Ejecuta una consulta de tipo insert, update o delete
     *
     * @param sql
     * @throws SQLException
     */
    public void actualizar(String sql,ArrayList<Integer> errores) throws SQLException {
        cn.clearWarnings();
        st = cn.createStatement();
        st.executeUpdate(sql);
        
        try{
            errores.add(cn.getWarnings().getErrorCode());
        }catch(NullPointerException ex){
            errores.clear();
        }
    }
    /**
     * Cierra las variables de rs, st y cn que estén abiertas
     * @throws SQLException
     */
    public void desconectarse() throws SQLException {
        if ( rs != null){
            rs.close();
            
        }
        st.close();
        cn.close();
        
    }

    public ResultSet getResultado() {
        return rs;
    }
}
