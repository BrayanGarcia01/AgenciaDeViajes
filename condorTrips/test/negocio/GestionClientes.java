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
public class GestionClientes {
    
    public GestionClientes() throws IOException {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    public void testCRUDCLientes() throws IOException{
        Funcionario f1=new Funcionario("Juan", "12345", "Juan Alejandro Muñoz","2019-07-02 12:32:43");
        System.out.println("CRUD cliente");
        
        // Lo elimina

        boolean eliminado=f1.eliminarCliente(123456);
        
        
        // Lo agrega
        long identificacion = 123456;
        String nombres = "Pepito";
        String apellidos = "Perez";
        String fechaNac= "1999-01-01";
        char genero = 'M';
        String direccion= "Av Panama";
        String ciudadResidencia = "Popayan";
        long celular = 555312456;
        String email = "pepito@yahoo.com";
        
        Cliente nuevoCliente=new Cliente(identificacion, nombres, apellidos, fechaNac, genero, direccion,ciudadResidencia,  celular, email);
        boolean agregado = f1.agregarCliente(nuevoCliente);
        assertEquals(true,agregado);
        

        // Lo consulta
        Cliente clienteConsulta = f1.consultarCliente(identificacion);
        assertEquals(123456, clienteConsulta.getIdentificacion());
        assertEquals("Pepito", clienteConsulta.getNombres());
        assertEquals("Perez", clienteConsulta.getApellidos());
        assertEquals("1999-01-01", clienteConsulta.getFechaNac());
        assertEquals('M', clienteConsulta.getGenero());
        assertEquals("Av Panama", clienteConsulta.getDireccion());
        assertEquals("Popayan", clienteConsulta.getCiudadResidencia());
        assertEquals(555312456, clienteConsulta.getCelular());
        assertEquals("pepito@yahoo.com", clienteConsulta.getEmail());
        
        // Lo edita
        identificacion = 123456;
        nombres = "Pepito Fulano";
        apellidos = "Perez Hurtado";
        fechaNac= "1998-02-02";
        genero = 'M';
        direccion= "Av Panaericana";
        ciudadResidencia = "Timbio";
        celular = 300741233;
        email = "pepitofulano@yahoo.com";
        
        Cliente clienteEditar=new Cliente(identificacion, nombres, apellidos, fechaNac, genero, direccion,ciudadResidencia,  celular, email);
        boolean editado=f1.editarCliente(clienteEditar);
        assertEquals(true,editado);
        
        // Lo vuelve a consuttar
        
        Cliente clienteConsultaEditado = f1.consultarCliente(identificacion);
        assertEquals(123456, clienteConsultaEditado.getIdentificacion());
        assertEquals("Pepito Fulano", clienteConsultaEditado.getNombres());
        assertEquals("Perez Hurtado", clienteConsultaEditado.getApellidos());
        assertEquals("1998-02-02", clienteConsultaEditado.getFechaNac());
        assertEquals('M', clienteConsultaEditado.getGenero());
        assertEquals("Av Panaericana", clienteConsultaEditado.getDireccion());
        assertEquals("Timbio", clienteConsultaEditado.getCiudadResidencia());
        assertEquals(300741233, clienteConsultaEditado.getCelular());
        assertEquals("pepitofulano@yahoo.com", clienteConsultaEditado.getEmail());
        //Lo deja eliminando
        eliminado=f1.eliminarCliente(123456);
        assertEquals(true, eliminado);


    }
}
