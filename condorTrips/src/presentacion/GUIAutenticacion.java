/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import acceso.IServidorCentral;
import acceso.ServidorCentralSockets;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Administrador;
import negocio.Funcionario;
import negocio.Usuario;
import recursos.Utilidades;

/**
 *
 * @author danielmej
 */
public class GUIAutenticacion extends javax.swing.JFrame {

    private final IServidorCentral sc;
    /**
     * Creates new form GUIAutenticacion
     */
    public GUIAutenticacion() {
        this.sc = new ServidorCentralSockets();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAutenticacion = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        pnlAutenticacion.setBackground(new java.awt.Color(255, 255, 255));

        btnSalir.setBackground(new java.awt.Color(204, 204, 255));
        btnSalir.setFont(new java.awt.Font("Quicksand", 0, 15)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N

        txtContrasenia.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        jLabel3.setText("Autenticación de usuarios");

        jLabel2.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña:");

        jLabel1.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        jLabel1.setText("Usuario: ");

        btnEntrar.setBackground(new java.awt.Color(204, 204, 255));
        btnEntrar.setFont(new java.awt.Font("Quicksand", 0, 15)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAutenticacionLayout = new javax.swing.GroupLayout(pnlAutenticacion);
        pnlAutenticacion.setLayout(pnlAutenticacionLayout);
        pnlAutenticacionLayout.setHorizontalGroup(
            pnlAutenticacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAutenticacionLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlAutenticacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAutenticacionLayout.createSequentialGroup()
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAutenticacionLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAutenticacionLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
            .addGroup(pnlAutenticacionLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel3)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        pnlAutenticacionLayout.setVerticalGroup(
            pnlAutenticacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAutenticacionLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addGroup(pnlAutenticacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(pnlAutenticacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(pnlAutenticacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnEntrar))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAutenticacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAutenticacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private Usuario consultarUsuario(String nombre, String contrasenia) throws IOException{
        Usuario usuario;
        usuario=sc.consultarUsuario(nombre, contrasenia);
        return usuario;
    }
    /**
     * autenticacion
     * @param evt evente de teclado
     */
    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        FabricaGUIPrincipal fabrica=new FabricaGUIPrincipal();
        try {
            Usuario usuarioConsultado;
            usuarioConsultado=consultarUsuario((txtUsuario.getText()), (txtContrasenia.getText()));
            
            if (usuarioConsultado!=null) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        GUIPrincipal principal;
                        
                        if(usuarioConsultado instanceof Administrador){                            
                            try {
                                principal = fabrica.getGUIPrincipal("GUIPrincipalAdministrador");
                                principal.setUsuario(usuarioConsultado);
                                principal.setExtendedState(MAXIMIZED_BOTH);
                                principal.setVisible(true);
                            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                                Logger.getLogger(GUIAutenticacion.class.getName()).log(Level.SEVERE, null, ex);
                            }                                                
                        }else{
                            try {
                                principal = fabrica.getGUIPrincipal("GUIPrincipalFuncionario");
                                principal.setUsuario(usuarioConsultado);
                                principal.setExtendedState(MAXIMIZED_BOTH);
                                principal.setVisible(true);
                            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                                Logger.getLogger(GUIAutenticacion.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        
                        
                        //Abre la ventana correspondiente
                        System.out.println("Ingreso exitoso");
                    }
                });
                this.dispose();
            } else {
                Utilidades.mensajeAdvertencia("Los datos no corresponden a un usuario existente", "Atención");           
            }
        } catch (IOException ex) {
            Utilidades.mensajeAdvertencia("Ha ocurrido un error con el servidor", "Atención"); 
            Logger.getLogger(GUIAutenticacion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIAutenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIAutenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIAutenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIAutenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIAutenticacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel pnlAutenticacion;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
