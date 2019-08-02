package presentacion;

import negocio.Administrador;
import negocio.Funcionario;
import negocio.Usuario;

public class FabricaGUIPrincipal {
    public GUIPrincipal getGUIPrincipal(String tipo) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        GUIPrincipal principal=null;
        if(tipo.equals("GUIPrincipalAdministrador")){
            principal=new GUIPrincipalAdministrador();
        }
        
        if(tipo.equals("GUIPrincipalFuncionario")){
            principal=new GUIPrincipalFuncionario();
        }
        
        return principal;
        //return (GUIPrincipal) Class.forName(tipo).newInstance();
    }
}
