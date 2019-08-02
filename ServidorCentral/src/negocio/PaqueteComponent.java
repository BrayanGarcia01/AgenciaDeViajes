/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Utilidades.MyException;


/**
 *
 * @author brayangarcia
 */
public abstract class PaqueteComponent {
        
    /**
     * método que busca ser sobre-escrito por las clases hijas 
     * @return deuelve el precio ya sea de una hoja o de un compuesto
     */
    public abstract int getPrecio();
    /**
     * este método no se declara abstract, pero busca ser sobre-escrito por las clases hijas composite
     *mientras que las clases hoja no la soportan, si quieren las clases hojas acceder a este método
     * se lanzará un error
     * @param myComponent
     * @throws MyException 
     */
    public void addComponent(PaqueteComponent myComponent) throws MyException{
        throw new MyException("Operacion no soportada");
    }
    /**
     * similarmente al método anterioir busca ser sobre-escrito por las clases composite hijas
     * @param myComponent 
     * @throws MyException 
     */
    public void removeComponent(PaqueteComponent myComponent) throws MyException{
        throw new MyException("Operacion no soportada");
    }


}
