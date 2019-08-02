/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import negocio.Funcionario;
import negocio.Usuario;

/**
 *
 * @author danielmej
 */
public abstract class GUIPrincipal extends javax.swing.JFrame {

    protected GUIPrincipal ventana;
    protected Usuario usuario;
    /**
     * Creates new form GUIPrincpal
     */
    public GUIPrincipal(){
        
    }
    
    protected abstract GUIPrincipal GUIPrincpal(Usuario usuario);

    public GUIPrincipal getVentana() {
        return ventana;
    }

    public void setVentana(GUIPrincipal ventana) {
        this.ventana = ventana;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
                     
}
