/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danielmej
 */
public class GestionUsuarios {
    
    public GestionUsuarios() {
    }
    
    @Test
    public void testCRUDUsuarios() throws IOException{
        Administrador a1=new Administrador("Oscar", "12345", "Oscar Restrepo","2019-07-02 12:32:43");
        System.out.println("CRUD usuario");
        
        // Lo elimina

        boolean eliminado=a1.eliminarUsuario("newuser");
        
        
        // Lo agrega
        String nombre = "newuser";
        String contrasenia = "abracadabra";
        String nombreCompleto = "Pepito Alejandro Perez Garcia";
        String fechaCreacion = "null";
        
        Funcionario nuevoFuncionario=new Funcionario(nombre,contrasenia,nombreCompleto,fechaCreacion);
        boolean agregado = a1.agregarUsuario(nuevoFuncionario);
        assertEquals(true,agregado);
        

        // Lo consulta
        Funcionario funcionarioConsulta = (Funcionario) a1.consultarUsuario("newuser");
        assertEquals("newuser", funcionarioConsulta.getNombre());
        assertEquals("abracadabra", funcionarioConsulta.getContrasenia());
        assertEquals("Pepito Alejandro Perez Garcia", funcionarioConsulta.getNombreCompleto());

        
        // Lo edita
        contrasenia = "abretesesamo";
        nombreCompleto = "Pepito Garcia";
        
        Funcionario funcionarioEditado=new Funcionario(nombre,contrasenia,nombreCompleto,fechaCreacion);
        boolean editado=a1.editarUsuario(funcionarioEditado);
        assertEquals(true,editado);
        
        // Lo vuelve a consuttar
        
        Funcionario funcionarioConsultaEditador = (Funcionario) a1.consultarUsuario(nombre);
        assertEquals("newuser", funcionarioConsultaEditador.getNombre());
        assertEquals("abretesesamo", funcionarioConsultaEditador.getContrasenia());
        assertEquals("Pepito Garcia", funcionarioConsultaEditador.getNombreCompleto());
        //Lo deja eliminando
        eliminado=a1.eliminarUsuario(nombre);
        assertEquals(true, eliminado);
    }
}
