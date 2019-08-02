/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author brayangarcia
 */
public class GestorPaquetePersonalizado {
    
     @Test
    public void testCRUDPaquetePersonalizado() throws IOException{
               System.out.println("Agregar plan personalizado");
        Funcionario myFuncionario = new Funcionario();
        Paquete myPaquete = new Paquete();
        Ciudad myCiudad=myFuncionario.consultarCiudad("America", "Mexico", "Cancun");
        myPaquete.addComponent(myCiudad);
        Calendar fecha = new GregorianCalendar();
        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int myAnio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        
        String myDia=convertirDiaoMesAHsqldb(dia);
        String myMes=convertirDiaoMesAHsqldb(mes);
        String fechaCreacion = myAnio+"-"+myMes+"-"+myDia;

        myPaquete.setFechaCreacion(fechaCreacion);
        long idPaquete=myFuncionario.asignarIdToPaquetePersonalizado();
        myPaquete.setIdPaquete(idPaquete);
        myPaquete.setTipo('P');
        myPaquete.setExistencias(0);
        boolean planAgregado=myFuncionario.agregarPlanPersonalizado(myPaquete);
        assertEquals(true, planAgregado);
        
    }

    private String convertirDiaoMesAHsqldb(int diaoMes) {
         String conversion=String.valueOf(diaoMes);
        if(diaoMes<10){
            conversion="0"+diaoMes;
        }
        return conversion;
    }
    
}
