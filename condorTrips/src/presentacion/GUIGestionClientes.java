package presentacion;

import negocio.Funcionario;
import negocio.Cliente;

import javax.swing.ImageIcon;

import recursos.Utilidades;

import java.io.IOException;



import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import negocio.Administrador;
import negocio.VentanaDisponible;

public class GUIGestionClientes extends javax.swing.JInternalFrame {
    
    Funcionario funcionario;
    private static GUIGestionClientes ventana =null;
    private static VentanaDisponible myUnicaVentana;

    
    public GUIGestionClientes(Funcionario funcionario,VentanaDisponible myUnicaVentana) {
        initComponents();
        Utilidades utilidades=new Utilidades();
        //setIconImage(new ImageIcon(getClass().getResource("/Recursos/customer-service.png")).getImage());
        this.funcionario=funcionario;
        btnGroupSexoAC.add(rbtnFAC);
        btnGroupSexoAC.add(rbtnMAC);
        
        
        btnGroupSexoUC.add(rbtnFUC);
        btnGroupSexoUC.add(rbtnMUC);
        this.myUnicaVentana = myUnicaVentana;
    }
    
    public static GUIGestionClientes GUIGestionClientes(Funcionario func,VentanaDisponible myUnicaVentana){
        if(ventana==null){
            ventana=new GUIGestionClientes(func, new VentanaDisponible());
            GUIGestionClientes.myUnicaVentana = myUnicaVentana;
        }
        return ventana;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupSexoAC = new javax.swing.ButtonGroup();
        btnGroupSexoUC = new javax.swing.ButtonGroup();
        pnlGestionClientes = new javax.swing.JPanel();
        lblGestionClientes = new javax.swing.JLabel();
        lblImagenDataBase = new javax.swing.JLabel();
        lblImgGestionClientes = new javax.swing.JLabel();
        pnlsGestionCliente = new javax.swing.JTabbedPane();
        pnlAgregarCliente = new javax.swing.JPanel();
        lblFechaNacAC = new javax.swing.JLabel();
        lblDireccionAC = new javax.swing.JLabel();
        lblCiudadResidenciaAC = new javax.swing.JLabel();
        lblCelularAC = new javax.swing.JLabel();
        btnComprobarAC = new javax.swing.JButton();
        lblEmailAC = new javax.swing.JLabel();
        txtIdentificacionAC = new javax.swing.JTextField();
        lblIdentificaciónAC = new javax.swing.JLabel();
        lblApellidosAC = new javax.swing.JLabel();
        lblNombresAC = new javax.swing.JLabel();
        lblGeneroAC = new javax.swing.JLabel();
        txtEmailAC = new javax.swing.JTextField();
        txtCelularAC = new javax.swing.JTextField();
        txtCiudadResidenciaAC = new javax.swing.JTextField();
        txtDireccionAC = new javax.swing.JTextField();
        txtApellidosAC = new javax.swing.JTextField();
        txtNombresAC = new javax.swing.JTextField();
        lblInfo2AC = new javax.swing.JLabel();
        rbtnMAC = new javax.swing.JRadioButton();
        rbtnFAC = new javax.swing.JRadioButton();
        btnAgregarCliente = new javax.swing.JButton();
        lblDiaNacAC = new javax.swing.JLabel();
        txtDiaNacAC = new javax.swing.JTextField();
        lblAnioNacAC = new javax.swing.JLabel();
        txtAnioNacAC = new javax.swing.JTextField();
        lblMesNacAC = new javax.swing.JLabel();
        cbmxMesNacAC = new javax.swing.JComboBox<>();
        lblInfoAC = new javax.swing.JLabel();
        pnlActualizarCliente = new javax.swing.JPanel();
        lblFechaNacUC = new javax.swing.JLabel();
        lblDireccionUC = new javax.swing.JLabel();
        lblCiudadResidenciaUC = new javax.swing.JLabel();
        lblCelularUC = new javax.swing.JLabel();
        btnBuscarUC = new javax.swing.JButton();
        lblEmailUC = new javax.swing.JLabel();
        txtIdentificacionUC = new javax.swing.JTextField();
        lblIdentificaciónUC = new javax.swing.JLabel();
        lblApellidosUC = new javax.swing.JLabel();
        lblNombresUC = new javax.swing.JLabel();
        lblGeneroUC = new javax.swing.JLabel();
        txtEmailUC = new javax.swing.JTextField();
        txtCelularUC = new javax.swing.JTextField();
        txtCiudadResidenciaUC = new javax.swing.JTextField();
        txtDireccionUC = new javax.swing.JTextField();
        txtApellidosUC = new javax.swing.JTextField();
        txtNombresUC = new javax.swing.JTextField();
        rbtnMUC = new javax.swing.JRadioButton();
        rbtnFUC = new javax.swing.JRadioButton();
        btnEditarCliente = new javax.swing.JButton();
        lblDiaNacAC2 = new javax.swing.JLabel();
        txtDiaNacUC = new javax.swing.JTextField();
        lblAnioNacUC = new javax.swing.JLabel();
        txtAnioNacUC = new javax.swing.JTextField();
        lblMesNacUC = new javax.swing.JLabel();
        cbmxMesNacUC = new javax.swing.JComboBox<>();
        lblInfoUC = new javax.swing.JLabel();
        pnlConsultarCliente = new javax.swing.JPanel();
        lblIdentificaciónCC = new javax.swing.JLabel();
        lblApellidosCC = new javax.swing.JLabel();
        lblNombresCC = new javax.swing.JLabel();
        lblGeneroCC = new javax.swing.JLabel();
        lblFechaNacCC = new javax.swing.JLabel();
        lblDireccionCC = new javax.swing.JLabel();
        lblCiudadResidenciaCC = new javax.swing.JLabel();
        lblCelularCC = new javax.swing.JLabel();
        lblEmailCC = new javax.swing.JLabel();
        txtIdentificacionCC = new javax.swing.JTextField();
        txtNombresCC = new javax.swing.JTextField();
        txtApellidosCC = new javax.swing.JTextField();
        txtFechaNacCC = new javax.swing.JTextField();
        txtGeneroCC = new javax.swing.JTextField();
        txtDireccionCC = new javax.swing.JTextField();
        txtCiudadResidenciaCC = new javax.swing.JTextField();
        txtCelularCC = new javax.swing.JTextField();
        txtEmailCC = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        pnlEliminarCliente = new javax.swing.JPanel();
        lblIdentificaciónEC = new javax.swing.JLabel();
        btnEliminarCliente = new javax.swing.JButton();
        txtIdentificacionEC = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setResizable(true);
        setTitle("Gestion Clientes");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        pnlGestionClientes.setBackground(new java.awt.Color(255, 255, 255));

        lblGestionClientes.setFont(new java.awt.Font("Quicksand", 0, 22)); // NOI18N
        lblGestionClientes.setForeground(new java.awt.Color(25, 25, 25));
        lblGestionClientes.setText("Gestion Clientes");

        lblImagenDataBase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/collaboration.png"))); // NOI18N
        lblImagenDataBase.setMaximumSize(new java.awt.Dimension(67, 67));
        lblImagenDataBase.setMinimumSize(new java.awt.Dimension(67, 67));
        lblImagenDataBase.setPreferredSize(new java.awt.Dimension(67, 67));

        lblImgGestionClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/database-1.png"))); // NOI18N

        pnlsGestionCliente.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        pnlsGestionCliente.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        pnlsGestionCliente.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                pnlsGestionClienteComponentRemoved(evt);
            }
        });

        pnlAgregarCliente.setBackground(new java.awt.Color(255, 255, 255));
        pnlAgregarCliente.setForeground(new java.awt.Color(230, 232, 230));

        lblFechaNacAC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblFechaNacAC.setText("Fecha Nacimiento:");
        lblFechaNacAC.setToolTipText("");

        lblDireccionAC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblDireccionAC.setText("Direccion:");

        lblCiudadResidenciaAC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblCiudadResidenciaAC.setText("Ciudad Residencia:");

        lblCelularAC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblCelularAC.setText("Celular:");

        btnComprobarAC.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        btnComprobarAC.setText("Comprobar");
        btnComprobarAC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnComprobarAC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComprobarAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobarACActionPerformed(evt);
            }
        });

        lblEmailAC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblEmailAC.setText("Email * :");
        lblEmailAC.setToolTipText("");

        txtIdentificacionAC.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        txtIdentificacionAC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificacionACKeyTyped(evt);
            }
        });

        lblIdentificaciónAC.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        lblIdentificaciónAC.setText("Identificación * :");

        lblApellidosAC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblApellidosAC.setText("Apellidos * :");

        lblNombresAC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblNombresAC.setText("Nombres * :");
        lblNombresAC.setToolTipText("");

        lblGeneroAC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblGeneroAC.setText("Genero * :");
        lblGeneroAC.setToolTipText("");

        txtEmailAC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N

        txtCelularAC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        txtCelularAC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularACKeyTyped(evt);
            }
        });

        txtCiudadResidenciaAC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N

        txtDireccionAC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N

        txtApellidosAC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N

        txtNombresAC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N

        lblInfo2AC.setFont(new java.awt.Font("Quicksand", 2, 12)); // NOI18N
        lblInfo2AC.setText("Puede verificar si un cliente existe con el boton \"Comprobar\"");

        rbtnMAC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        rbtnMAC.setText("M ");
        rbtnMAC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        rbtnFAC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        rbtnFAC.setText("F");
        rbtnFAC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/save.png"))); // NOI18N
        btnAgregarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });

        lblDiaNacAC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblDiaNacAC.setText("Dia:");

        txtDiaNacAC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        txtDiaNacAC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiaNacACKeyTyped(evt);
            }
        });

        lblAnioNacAC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblAnioNacAC.setText("Año:");

        txtAnioNacAC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        txtAnioNacAC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnioNacACKeyTyped(evt);
            }
        });

        lblMesNacAC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblMesNacAC.setText("Mes:");

        cbmxMesNacAC.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        cbmxMesNacAC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        lblInfoAC.setFont(new java.awt.Font("Quicksand", 2, 12)); // NOI18N
        lblInfoAC.setText("Los campos seguidos de * son obligatorios");

        javax.swing.GroupLayout pnlAgregarClienteLayout = new javax.swing.GroupLayout(pnlAgregarCliente);
        pnlAgregarCliente.setLayout(pnlAgregarClienteLayout);
        pnlAgregarClienteLayout.setHorizontalGroup(
            pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgregarClienteLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfo2AC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgregarClienteLayout.createSequentialGroup()
                        .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdentificaciónAC)
                            .addComponent(lblEmailAC)
                            .addComponent(lblGeneroAC)
                            .addComponent(lblDireccionAC)
                            .addComponent(lblFechaNacAC)
                            .addComponent(lblCiudadResidenciaAC)
                            .addComponent(lblCelularAC)
                            .addComponent(lblApellidosAC)
                            .addComponent(lblNombresAC))
                        .addGap(63, 63, 63)
                        .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAgregarClienteLayout.createSequentialGroup()
                                .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbtnMAC)
                                    .addComponent(lblDiaNacAC))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlAgregarClienteLayout.createSequentialGroup()
                                        .addComponent(rbtnFAC)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(pnlAgregarClienteLayout.createSequentialGroup()
                                        .addComponent(txtDiaNacAC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblMesNacAC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbmxMesNacAC, 0, 149, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAnioNacAC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAnioNacAC, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlAgregarClienteLayout.createSequentialGroup()
                                .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombresAC, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addComponent(txtApellidosAC, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addComponent(txtDireccionAC, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addComponent(txtCiudadResidenciaAC, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addComponent(txtCelularAC, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addComponent(txtEmailAC)
                                    .addComponent(txtIdentificacionAC))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgregarClienteLayout.createSequentialGroup()
                                        .addComponent(btnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgregarClienteLayout.createSequentialGroup()
                                        .addComponent(btnComprobarAC, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11))))))
                    .addComponent(lblInfoAC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlAgregarClienteLayout.setVerticalGroup(
            pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgregarClienteLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblInfoAC)
                .addGap(18, 18, 18)
                .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdentificacionAC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnComprobarAC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblIdentificaciónAC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombresAC)
                    .addComponent(txtNombresAC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidosAC)
                    .addComponent(txtApellidosAC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbmxMesNacAC, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFechaNacAC)
                        .addComponent(lblDiaNacAC)
                        .addComponent(txtDiaNacAC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAnioNacAC)
                        .addComponent(txtAnioNacAC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMesNacAC)))
                .addGap(21, 21, 21)
                .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGeneroAC)
                    .addComponent(rbtnMAC)
                    .addComponent(rbtnFAC))
                .addGap(18, 18, 18)
                .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionAC)
                    .addComponent(txtDireccionAC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAgregarClienteLayout.createSequentialGroup()
                        .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCiudadResidenciaAC)
                            .addComponent(txtCiudadResidenciaAC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCelularAC)
                            .addComponent(txtCelularAC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmailAC)
                            .addComponent(txtEmailAC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInfo2AC)
                .addGap(40, 40, 40))
        );

        pnlsGestionCliente.addTab("Nuevo cliente", pnlAgregarCliente);

        pnlActualizarCliente.setBackground(new java.awt.Color(255, 255, 255));
        pnlActualizarCliente.setForeground(new java.awt.Color(230, 232, 230));

        lblFechaNacUC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblFechaNacUC.setText("Fecha Nacimiento:");
        lblFechaNacUC.setToolTipText("");

        lblDireccionUC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblDireccionUC.setText("Direccion:");

        lblCiudadResidenciaUC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblCiudadResidenciaUC.setText("Ciudad Residencia:");

        lblCelularUC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblCelularUC.setText("Celular:");

        btnBuscarUC.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        btnBuscarUC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/search.png"))); // NOI18N
        btnBuscarUC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarUC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarUC.setMaximumSize(new java.awt.Dimension(68, 68));
        btnBuscarUC.setMinimumSize(new java.awt.Dimension(68, 68));
        btnBuscarUC.setPreferredSize(new java.awt.Dimension(68, 68));
        btnBuscarUC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUCActionPerformed(evt);
            }
        });

        lblEmailUC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblEmailUC.setText("Email * :");
        lblEmailUC.setToolTipText("");

        txtIdentificacionUC.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        txtIdentificacionUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificacionUCKeyTyped(evt);
            }
        });

        lblIdentificaciónUC.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        lblIdentificaciónUC.setText("Identificación * :");

        lblApellidosUC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblApellidosUC.setText("Apellidos * :");

        lblNombresUC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblNombresUC.setText("Nombres * :");
        lblNombresUC.setToolTipText("");

        lblGeneroUC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblGeneroUC.setText("Genero * :");
        lblGeneroUC.setToolTipText("");

        txtEmailUC.setBackground(new java.awt.Color(246, 246, 246));
        txtEmailUC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N

        txtCelularUC.setBackground(new java.awt.Color(246, 246, 246));
        txtCelularUC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        txtCelularUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularUCKeyTyped(evt);
            }
        });

        txtCiudadResidenciaUC.setBackground(new java.awt.Color(246, 246, 246));
        txtCiudadResidenciaUC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N

        txtDireccionUC.setBackground(new java.awt.Color(246, 246, 246));
        txtDireccionUC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N

        txtApellidosUC.setBackground(new java.awt.Color(246, 246, 246));
        txtApellidosUC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N

        txtNombresUC.setBackground(new java.awt.Color(246, 246, 246));
        txtNombresUC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N

        rbtnMUC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        rbtnMUC.setText("M ");
        rbtnMUC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        rbtnFUC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        rbtnFUC.setText("F");
        rbtnFUC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/save.png"))); // NOI18N
        btnEditarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        lblDiaNacAC2.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblDiaNacAC2.setText("Dia:");

        txtDiaNacUC.setBackground(new java.awt.Color(204, 204, 204));
        txtDiaNacUC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        txtDiaNacUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiaNacUCKeyTyped(evt);
            }
        });

        lblAnioNacUC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblAnioNacUC.setText("Año:");

        txtAnioNacUC.setBackground(new java.awt.Color(246, 246, 246));
        txtAnioNacUC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        txtAnioNacUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnioNacUCKeyTyped(evt);
            }
        });

        lblMesNacUC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblMesNacUC.setText("Mes:");

        cbmxMesNacUC.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        cbmxMesNacUC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        lblInfoUC.setFont(new java.awt.Font("Quicksand", 2, 12)); // NOI18N
        lblInfoUC.setText("Los campos seguidos de * son obligatorios");

        javax.swing.GroupLayout pnlActualizarClienteLayout = new javax.swing.GroupLayout(pnlActualizarCliente);
        pnlActualizarCliente.setLayout(pnlActualizarClienteLayout);
        pnlActualizarClienteLayout.setHorizontalGroup(
            pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlActualizarClienteLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlActualizarClienteLayout.createSequentialGroup()
                        .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdentificaciónUC)
                            .addComponent(lblEmailUC)
                            .addComponent(lblGeneroUC)
                            .addComponent(lblDireccionUC)
                            .addComponent(lblFechaNacUC)
                            .addComponent(lblCiudadResidenciaUC)
                            .addComponent(lblCelularUC)
                            .addComponent(lblApellidosUC)
                            .addComponent(lblNombresUC))
                        .addGap(63, 63, 63)
                        .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlActualizarClienteLayout.createSequentialGroup()
                                .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbtnMUC)
                                    .addComponent(lblDiaNacAC2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlActualizarClienteLayout.createSequentialGroup()
                                        .addComponent(rbtnFUC)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(pnlActualizarClienteLayout.createSequentialGroup()
                                        .addComponent(txtDiaNacUC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblMesNacUC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbmxMesNacUC, 0, 147, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAnioNacUC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAnioNacUC, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlActualizarClienteLayout.createSequentialGroup()
                                .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombresUC, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addComponent(txtApellidosUC, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addComponent(txtDireccionUC, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addComponent(txtCiudadResidenciaUC, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addComponent(txtCelularUC, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addComponent(txtEmailUC)
                                    .addComponent(txtIdentificacionUC))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlActualizarClienteLayout.createSequentialGroup()
                                        .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlActualizarClienteLayout.createSequentialGroup()
                                        .addComponent(btnBuscarUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30))))))
                    .addComponent(lblInfoUC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlActualizarClienteLayout.setVerticalGroup(
            pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlActualizarClienteLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblInfoUC)
                .addGap(18, 18, 18)
                .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlActualizarClienteLayout.createSequentialGroup()
                        .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdentificacionUC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdentificaciónUC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombresUC)
                            .addComponent(txtNombresUC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnBuscarUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidosUC)
                    .addComponent(txtApellidosUC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbmxMesNacUC, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFechaNacUC)
                        .addComponent(lblDiaNacAC2)
                        .addComponent(txtDiaNacUC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAnioNacUC)
                        .addComponent(txtAnioNacUC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMesNacUC)))
                .addGap(21, 21, 21)
                .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGeneroUC)
                    .addComponent(rbtnMUC)
                    .addComponent(rbtnFUC))
                .addGap(18, 18, 18)
                .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionUC)
                    .addComponent(txtDireccionUC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlActualizarClienteLayout.createSequentialGroup()
                        .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCiudadResidenciaUC)
                            .addComponent(txtCiudadResidenciaUC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCelularUC)
                            .addComponent(txtCelularUC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlActualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmailUC)
                            .addComponent(txtEmailUC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)))
                .addGap(66, 66, 66))
        );

        pnlsGestionCliente.addTab("Actualizar Cliente", pnlActualizarCliente);

        pnlConsultarCliente.setBackground(new java.awt.Color(255, 255, 255));
        pnlConsultarCliente.setForeground(new java.awt.Color(230, 232, 230));

        lblIdentificaciónCC.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        lblIdentificaciónCC.setText("Identificación:");

        lblApellidosCC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblApellidosCC.setText("Apellidos:");

        lblNombresCC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblNombresCC.setText("Nombres:");
        lblNombresCC.setToolTipText("");

        lblGeneroCC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblGeneroCC.setText("Genero:");

        lblFechaNacCC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblFechaNacCC.setText("Fecha Nacimiento:");

        lblDireccionCC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblDireccionCC.setText("Direccion:");

        lblCiudadResidenciaCC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblCiudadResidenciaCC.setText("Ciudad Residencia:");

        lblCelularCC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblCelularCC.setText("Celular:");

        lblEmailCC.setFont(new java.awt.Font("Quicksand", 0, 16)); // NOI18N
        lblEmailCC.setText("Email:");

        txtIdentificacionCC.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        txtIdentificacionCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificacionCCKeyTyped(evt);
            }
        });

        txtNombresCC.setEditable(false);
        txtNombresCC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        txtNombresCC.setOpaque(false);

        txtApellidosCC.setEditable(false);
        txtApellidosCC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        txtApellidosCC.setOpaque(false);

        txtFechaNacCC.setEditable(false);
        txtFechaNacCC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        txtFechaNacCC.setOpaque(false);

        txtGeneroCC.setEditable(false);
        txtGeneroCC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        txtGeneroCC.setOpaque(false);

        txtDireccionCC.setEditable(false);
        txtDireccionCC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        txtDireccionCC.setOpaque(false);

        txtCiudadResidenciaCC.setEditable(false);
        txtCiudadResidenciaCC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        txtCiudadResidenciaCC.setOpaque(false);

        txtCelularCC.setEditable(false);
        txtCelularCC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        txtCelularCC.setOpaque(false);

        txtEmailCC.setEditable(false);
        txtEmailCC.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        txtEmailCC.setOpaque(false);

        btnBuscarCliente.setBackground(new java.awt.Color(51, 0, 255));
        btnBuscarCliente.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/search.png"))); // NOI18N
        btnBuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCliente.setMaximumSize(new java.awt.Dimension(68, 68));
        btnBuscarCliente.setMinimumSize(new java.awt.Dimension(68, 68));
        btnBuscarCliente.setPreferredSize(new java.awt.Dimension(68, 68));
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConsultarClienteLayout = new javax.swing.GroupLayout(pnlConsultarCliente);
        pnlConsultarCliente.setLayout(pnlConsultarClienteLayout);
        pnlConsultarClienteLayout.setHorizontalGroup(
            pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultarClienteLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lblIdentificaciónCC)
                .addGap(91, 91, 91)
                .addComponent(txtIdentificacionCC, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlConsultarClienteLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmailCC)
                    .addComponent(lblGeneroCC)
                    .addComponent(lblDireccionCC)
                    .addComponent(lblFechaNacCC)
                    .addComponent(lblCiudadResidenciaCC)
                    .addComponent(lblCelularCC)
                    .addComponent(lblApellidosCC)
                    .addComponent(lblNombresCC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addGroup(pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellidosCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombresCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNacCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGeneroCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCiudadResidenciaCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelularCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93))
        );
        pnlConsultarClienteLayout.setVerticalGroup(
            pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConsultarClienteLayout.createSequentialGroup()
                .addGroup(pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConsultarClienteLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdentificaciónCC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdentificacionCC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlConsultarClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConsultarClienteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNombresCC)
                        .addGap(18, 18, 18))
                    .addGroup(pnlConsultarClienteLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtNombresCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidosCC)
                    .addComponent(txtApellidosCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaNacCC)
                    .addComponent(txtFechaNacCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblGeneroCC)
                    .addComponent(txtGeneroCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionCC)
                    .addComponent(txtDireccionCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCiudadResidenciaCC)
                    .addComponent(txtCiudadResidenciaCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCelularCC)
                    .addComponent(txtCelularCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmailCC)
                    .addComponent(txtEmailCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        pnlsGestionCliente.addTab("Consultar Cliente", pnlConsultarCliente);

        pnlEliminarCliente.setBackground(new java.awt.Color(255, 255, 255));
        pnlEliminarCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnlEliminarCliente.setForeground(new java.awt.Color(230, 232, 230));

        lblIdentificaciónEC.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        lblIdentificaciónEC.setText("Identificación:");

        btnEliminarCliente.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        btnEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/delete.png"))); // NOI18N
        btnEliminarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarCliente.setMaximumSize(new java.awt.Dimension(68, 68));
        btnEliminarCliente.setMinimumSize(new java.awt.Dimension(68, 68));
        btnEliminarCliente.setPreferredSize(new java.awt.Dimension(68, 68));
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        txtIdentificacionEC.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        txtIdentificacionEC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificacionECKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlEliminarClienteLayout = new javax.swing.GroupLayout(pnlEliminarCliente);
        pnlEliminarCliente.setLayout(pnlEliminarClienteLayout);
        pnlEliminarClienteLayout.setHorizontalGroup(
            pnlEliminarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEliminarClienteLayout.createSequentialGroup()
                .addContainerGap(494, Short.MAX_VALUE)
                .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(pnlEliminarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEliminarClienteLayout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(lblIdentificaciónEC)
                    .addContainerGap(492, Short.MAX_VALUE)))
            .addGroup(pnlEliminarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEliminarClienteLayout.createSequentialGroup()
                    .addGap(233, 233, 233)
                    .addComponent(txtIdentificacionEC, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(253, Short.MAX_VALUE)))
        );
        pnlEliminarClienteLayout.setVerticalGroup(
            pnlEliminarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEliminarClienteLayout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
            .addGroup(pnlEliminarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEliminarClienteLayout.createSequentialGroup()
                    .addGap(214, 214, 214)
                    .addComponent(lblIdentificaciónEC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(209, Short.MAX_VALUE)))
            .addGroup(pnlEliminarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEliminarClienteLayout.createSequentialGroup()
                    .addGap(214, 214, 214)
                    .addComponent(txtIdentificacionEC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(209, Short.MAX_VALUE)))
        );

        pnlsGestionCliente.addTab("Eliminar Cliente", pnlEliminarCliente);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGestionClientesLayout = new javax.swing.GroupLayout(pnlGestionClientes);
        pnlGestionClientes.setLayout(pnlGestionClientesLayout);
        pnlGestionClientesLayout.setHorizontalGroup(
            pnlGestionClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGestionClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGestionClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGestionClientesLayout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addGap(38, 38, 38)
                        .addComponent(lblImgGestionClientes)
                        .addGap(63, 63, 63)
                        .addComponent(lblGestionClientes)
                        .addGap(61, 61, 61)
                        .addComponent(lblImagenDataBase, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlsGestionCliente))
                .addContainerGap())
        );
        pnlGestionClientesLayout.setVerticalGroup(
            pnlGestionClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGestionClientesLayout.createSequentialGroup()
                .addGroup(pnlGestionClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImgGestionClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImagenDataBase, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlGestionClientesLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblGestionClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlGestionClientesLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnSalir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlsGestionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGestionClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlGestionClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void imprimirInfoClientePnlConsultar(Cliente cliente){
        txtNombresCC.setText(cliente.getNombres());
        txtApellidosCC.setText(cliente.getApellidos());
        txtFechaNacCC.setText(cliente.getFechaNac());
        txtGeneroCC.setText(cliente.getGenero()+"");
        txtDireccionCC.setText(cliente.getDireccion());
        txtCiudadResidenciaCC.setText(cliente.getCiudadResidencia());
        txtCelularCC.setText(cliente.getCelular()+"");
        txtEmailCC.setText(cliente.getEmail());
    }
    private void limpiarCamposBuscarCliente(){
        txtNombresCC.setText(" ");
        txtApellidosCC.setText(" ");
        txtFechaNacCC.setText(" ");
        txtGeneroCC.setText(" ");
        txtDireccionCC.setText(" ");
        txtCiudadResidenciaCC.setText(" ");
        txtCelularCC.setText(" ");
        txtEmailCC.setText(" ");
    }
    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        limpiarCamposBuscarCliente();
        Cliente clienteConsulta=null;
        long v_identificacion=0;
        try{
            v_identificacion=Long.parseLong(txtIdentificacionCC.getText());
            if(v_identificacion<=0){
                Utilidades.mensajeInformacion("Digite un numero de identificacion valido", "Informacion");
                return;
            }
            clienteConsulta = funcionario.consultarCliente(v_identificacion);        
            if(clienteConsulta!=null){
                imprimirInfoClientePnlConsultar(clienteConsulta);
            }else{
                 Utilidades.mensajeError("La identificacion ingresada no esta en la base de datos", "Error");
            } 
        }catch (IOException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            Utilidades.mensajeAdvertencia("Se ha interrumpido la conexion con el servidor", "Error");
        }
        catch(NumberFormatException ex){
            Utilidades.mensajeInformacion("Digite un numero de identificacion valido", "Informacion");
            return;
        }      
        
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void txtIdentificacionCCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacionCCKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();
    }//GEN-LAST:event_txtIdentificacionCCKeyTyped

    private void pnlsGestionClienteComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_pnlsGestionClienteComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlsGestionClienteComponentRemoved

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        long v_identificacion=0;
        try{
            v_identificacion=Long.parseLong(txtIdentificacionEC.getText());
            if(v_identificacion<=0){
                Utilidades.mensajeInformacion("Digite un numero de identificacion valido", "Informacion");
                return;
            }
            int respuestaConfirmacion = JOptionPane.showConfirmDialog(null, "Esta seguro que desea realizar esta operacion", "Confirmacion", JOptionPane.YES_NO_OPTION,2, new ImageIcon("./src/Recursos/question.png"));
            boolean eliminado=false;
            if (respuestaConfirmacion == JOptionPane.YES_OPTION) {
                eliminado=funcionario.eliminarCliente(v_identificacion);
            }
            else {
               return;
            }
            
            if(eliminado){
                Utilidades.mensajeExito("Se elimino el Cliente", "Borrado Exitoso");
            }else{
                Utilidades.mensajeError("El cliente a eliminar no existe", "Error");         
            }        
        } catch (IOException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            Utilidades.mensajeAdvertencia("Se ha interrumpido la conexion con el servidor", "Error");
        }
        catch(NumberFormatException ex){
            Utilidades.mensajeInformacion("Digite un numero de identificacion valido", "Informacion");
        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void txtIdentificacionECKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacionECKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();
    }//GEN-LAST:event_txtIdentificacionECKeyTyped
    private void limpiarCamposAgregarCliente(){
        txtNombresAC.setText(" ");
        txtApellidosAC.setText(" ");
        txtDiaNacAC.setText(" ");
        txtAnioNacAC.setText(" ");
        btnGroupSexoAC.clearSelection();
        txtDireccionAC.setText(" ");
        txtCiudadResidenciaAC.setText(" ");
        txtCelularAC.setText(" ");
        txtEmailAC.setText(" ");
    }
    private void btnComprobarACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprobarACActionPerformed
        Cliente clienteConsulta=null;
        long v_identificacion=0;
        try{
            v_identificacion=Long.parseLong(txtIdentificacionAC.getText());
            if(v_identificacion<=0){
                Utilidades.mensajeInformacion("Digite un numero de identificacion valido", "Informacion");
                return;
            }
            clienteConsulta = funcionario.consultarCliente(v_identificacion);        
            if(clienteConsulta!=null){
                Utilidades.mensajeAdvertencia("El cliente ya esta registrado", "Advertencia");
            }else{
                 Utilidades.mensajeExito("La identificacion ingresada no esta en la base de datos", "Informacion");
            }           
        }catch (IOException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            Utilidades.mensajeAdvertencia("Se ha interrumpido la conexion con el servidor", "Error");
        }
        catch(NumberFormatException ex){
            Utilidades.mensajeError("Digite un numero de identificacion valido", "Campo Identificacion");
            return;
        }
    }//GEN-LAST:event_btnComprobarACActionPerformed

    private void txtIdentificacionACKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacionACKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();
    }//GEN-LAST:event_txtIdentificacionACKeyTyped

    private void txtCelularACKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularACKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();
    }//GEN-LAST:event_txtCelularACKeyTyped

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        //Valido la identificacion
        long v_identificacion=0;
        try{
            v_identificacion=Long.parseLong(txtIdentificacionAC.getText());
            if(v_identificacion<=0){
                Utilidades.mensajeInformacion("Digite un numero de identificacion valido", "Informacion");
                return;
            }
        }catch(NumberFormatException ex){
                Utilidades.mensajeInformacion("Digite un numero de identificacion valido", "Informacion");
            return;
        }    
        //Valido el nombre
        if(txtNombresAC.getText().length()==0){
            Utilidades.mensajeInformacion("Es obligatorio ingresar un nombre", "Informacion");
            return;
        }
        String v_nombre=txtNombresAC.getText();
        //Valido los appellidos
        if(txtApellidosAC.getText().length()==0){
            Utilidades.mensajeInformacion("Es obligatorio ingresar los apellidos", "Informacion");
            return;
        }
        String v_apellidos=txtApellidosAC.getText();
        //Valido el email
        if(txtEmailAC.getText().length()==0){
            Utilidades.mensajeInformacion("Es obligatorio ingresar un email", "Informacion");
            return;
        }
        String v_email=txtEmailAC.getText();   
        //Valido el numero de celular
        long v_celular=0;        
        if(txtCelularAC.getText().length()!=0){
            try{
                v_celular=Long.parseLong(txtCelularAC.getText());
                if(v_celular<=0){
                    Utilidades.mensajeInformacion("Digite un numero de celular valido", "Informacion");
                    return;
                }
            }catch(NumberFormatException ex){
                Utilidades.mensajeInformacion("Digite un numero de celular valido", "Informacion");
                return;
            } 
        }
        //Valido que se escogio un valor para el genero
        char v_genero=new Character(' ');
        if(rbtnFAC.isSelected()){
            v_genero='F';
        }else if(rbtnMAC.isSelected()){
            v_genero='M';
        }else{
             Utilidades.mensajeInformacion("Escoga un genero", "Informacion");
            return;
        }
        
        //Valido la fecha 
        String v_fechaNac=null;
        if(txtDiaNacAC.getText().length()!=0&&txtAnioNacAC.getText().length()!=0){
            Calendar fechaActual = Calendar.getInstance();
            int v_diaNac=0;
            int v_mesNac=cbmxMesNacAC.getSelectedIndex()+1;
            int v_anioNac=0;
            try{
                v_diaNac=Integer.parseInt(txtDiaNacAC.getText());
                v_anioNac=Integer.parseInt(txtAnioNacAC.getText());
                System.out.println("Dia : "+fechaActual.get(Calendar.DATE));
                if(v_diaNac<=0||v_diaNac>31||v_anioNac<0||v_anioNac>fechaActual.get(Calendar.YEAR)){
                    Utilidades.mensajeInformacion("Digite una fecha de nacimiento valida", "Informacion");
                    return;
                }

                if(v_anioNac==fechaActual.get(Calendar.YEAR)){
                    if(v_mesNac==(fechaActual.get(Calendar.MONTH)+1)){
                        if(v_anioNac>=fechaActual.get(Calendar.DATE)){
                            Utilidades.mensajeInformacion("Digite una fecha de nacimiento valida", "Informacion");                       
                        }
                    }
                }
            }catch(NumberFormatException ex){
                Utilidades.mensajeInformacion("Digite una fecha de nacimiento valida", "Informacion");                       
                return;
            }
            v_fechaNac="";
            v_fechaNac=v_anioNac+"-";
            if(v_mesNac<10){
                v_fechaNac=v_fechaNac+"0";
            }
            v_fechaNac=v_fechaNac+v_mesNac+"-";
            if(v_diaNac<10){
                v_fechaNac=v_fechaNac+"0";
            }
            v_fechaNac=v_fechaNac+v_diaNac;
            System.out.println(v_fechaNac);
        }
        //Valido la direccion
        String v_direccion=null;
        if(txtDireccionAC.getText().length()!=0){
            v_direccion=txtDireccionAC.getText();
        }
        //Valido la ciudad
        String v_ciudadResidencia=null;
        if(txtCiudadResidenciaAC.getText().length()!=0){
            v_ciudadResidencia=txtCiudadResidenciaAC.getText();
        }
        
        //Creo el Cliente        
        Cliente nuevoCliente=new Cliente(v_identificacion, v_nombre, v_apellidos, v_fechaNac, v_genero, v_direccion, v_ciudadResidencia, v_celular, v_email);
      
        try{
            boolean agregado = funcionario.agregarCliente(nuevoCliente);
            if(agregado){
                Utilidades.mensajeExito("Se agrego el Cliente", "Agregacion Exitosa");
                limpiarCamposAgregarCliente();
            }else{
                Utilidades.mensajeError("El cliente a agregar ya existe", "Error");         
            }
            
        }catch (IOException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            Utilidades.mensajeAdvertencia("Se ha interrumpido la conexion con el servidor", "Error");
        }
        
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void txtDiaNacACKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaNacACKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();
    }//GEN-LAST:event_txtDiaNacACKeyTyped

    private void txtAnioNacACKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnioNacACKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();
    }//GEN-LAST:event_txtAnioNacACKeyTyped

    private void imprimirInfoClientePnlActualizar(Cliente cliente){
        txtNombresUC.setText(cliente.getNombres());
        txtApellidosUC.setText(cliente.getApellidos());
        String fecha=cliente.getFechaNac();
        txtDiaNacUC.setText(fecha.substring(8, 10));
        txtAnioNacUC.setText(fecha.substring(0, 4));
        int mes=Integer.parseInt(fecha.substring(5, 7))-1;
        cbmxMesNacUC.setSelectedIndex(mes);
        if(cliente.getGenero()=='F'){
            rbtnFUC.setSelected(true);
        }else{
            rbtnMUC.setSelected(true);
        }
        txtDireccionUC.setText(cliente.getDireccion());
        txtCiudadResidenciaUC.setText(cliente.getCiudadResidencia());
        txtCelularUC.setText(cliente.getCelular()+"");
        txtEmailUC.setText(cliente.getEmail());
    }
    private void limpiarCamposEditarCliente(){
        txtNombresUC.setText(" ");
        txtApellidosUC.setText(" ");
        txtDiaNacUC.setText(" ");
        txtAnioNacUC.setText(" ");
        btnGroupSexoUC.clearSelection();
        txtDireccionUC.setText(" ");
        txtCiudadResidenciaUC.setText(" ");
        txtCelularUC.setText(" ");
        txtEmailUC.setText(" ");
    }
    private void btnBuscarUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUCActionPerformed
        Cliente clienteConsulta=null;
        long v_identificacion=0;
        try{
            v_identificacion=Long.parseLong(txtIdentificacionUC.getText());
            if(v_identificacion<=0){
                Utilidades.mensajeInformacion("Digite un numero de identificacion valido", "Informacion");
                return;
            }
            clienteConsulta = funcionario.consultarCliente(v_identificacion);        
            if(clienteConsulta!=null){
                imprimirInfoClientePnlActualizar(clienteConsulta);
            }else{
                 Utilidades.mensajeError("La identificacion ingresada no esta en la base de datos", "Error");
            } 
        }catch (IOException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            Utilidades.mensajeAdvertencia("Se ha interrumpido la conexion con el servidor", "Error");
        }
        catch(NumberFormatException ex){
            Utilidades.mensajeInformacion("Digite un numero de identificacion valido", "Informacion");
            return;
        } 
    }//GEN-LAST:event_btnBuscarUCActionPerformed

    private void txtIdentificacionUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacionUCKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();
    }//GEN-LAST:event_txtIdentificacionUCKeyTyped

    private void txtCelularUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularUCKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();
    }//GEN-LAST:event_txtCelularUCKeyTyped

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        //Valido la identificacion
        long v_identificacion=0;
        try{
            v_identificacion=Long.parseLong(txtIdentificacionUC.getText());
            if(v_identificacion<=0){
                Utilidades.mensajeInformacion("Digite un numero de identificacion valido", "Informacion");
                return;
            }
        }catch(NumberFormatException ex){
                Utilidades.mensajeInformacion("Digite un numero de identificacion valido", "Informacion");
            return;
        }    
        //Valido el nombre
        if(txtNombresUC.getText().length()==0){
            Utilidades.mensajeInformacion("Es obligatorio ingresar un nombre", "Informacion");
            return;
        }
        String v_nombre=txtNombresUC.getText();
        //Valido los appellidos
        if(txtApellidosUC.getText().length()==0){
            Utilidades.mensajeInformacion("Es obligatorio ingresar los apellidos", "Informacion");
            return;
        }
        String v_apellidos=txtApellidosUC.getText();
        //Valido el email
        if(txtEmailUC.getText().length()==0){
            Utilidades.mensajeInformacion("Es obligatorio ingresar un email", "Informacion");
            return;
        }
        String v_email=txtEmailUC.getText();   
        //Valido el numero de celular
        long v_celular=0;        
        if(txtCelularUC.getText().length()!=0){
            try{
                v_celular=Long.parseLong(txtCelularUC.getText());
                if(v_celular<=0){
                    Utilidades.mensajeInformacion("Digite un numero de celular valido", "Informacion");
                    return;
                }
            }catch(NumberFormatException ex){
                Utilidades.mensajeInformacion("Digite un numero de celular valido", "Informacion");
                return;
            } 
        }
        //Valido que se escogio un valor para el genero
        char v_genero=new Character(' ');
        if(rbtnFUC.isSelected()){
            v_genero='F';
        }else if(rbtnMUC.isSelected()){
            v_genero='M';
        }else{
             Utilidades.mensajeInformacion("Escoga un genero", "Informacion");
            return;
        }
        
        //Valido la fecha 
        String v_fechaNac=null;
        if(txtDiaNacUC.getText().length()!=0&&txtAnioNacUC.getText().length()!=0){
            Calendar fechaActual = Calendar.getInstance();
            int v_diaNac=0;
            int v_mesNac=cbmxMesNacUC.getSelectedIndex()+1;
            int v_anioNac=0;
            try{
                v_diaNac=Integer.parseInt(txtDiaNacUC.getText());
                v_anioNac=Integer.parseInt(txtAnioNacUC.getText());
                System.out.println("Dia : "+fechaActual.get(Calendar.DATE));
                if(v_diaNac<=0||v_diaNac>31||v_anioNac<0||v_anioNac>fechaActual.get(Calendar.YEAR)){
                    Utilidades.mensajeInformacion("Digite una fecha de nacimiento valida", "Informacion");
                    return;
                }

                if(v_anioNac==fechaActual.get(Calendar.YEAR)){
                    if(v_mesNac==(fechaActual.get(Calendar.MONTH)+1)){
                        if(v_anioNac>=fechaActual.get(Calendar.DATE)){
                            Utilidades.mensajeInformacion("Digite una fecha de nacimiento valida", "Informacion");                       
                        }
                    }
                }
            }catch(NumberFormatException ex){
                Utilidades.mensajeInformacion("Digite una fecha de nacimiento valida", "Informacion");                       
                return;
            }
            v_fechaNac="";
            v_fechaNac=v_anioNac+"-";
            if(v_mesNac<10){
                v_fechaNac=v_fechaNac+"0";
            }
            v_fechaNac=v_fechaNac+v_mesNac+"-";
            if(v_diaNac<10){
                v_fechaNac=v_fechaNac+"0";
            }
            v_fechaNac=v_fechaNac+v_diaNac;
            System.out.println(v_fechaNac);
        }
        //Valido la direccion
        String v_direccion=null;
        if(txtDireccionUC.getText().length()!=0){
            v_direccion=txtDireccionUC.getText();
        }
        //Valido la ciudad
        String v_ciudadResidencia=null;
        if(txtCiudadResidenciaUC.getText().length()!=0){
            v_ciudadResidencia=txtCiudadResidenciaUC.getText();
        }
        
        //Creo el Cliente        
        Cliente nuevoCliente=new Cliente(v_identificacion, v_nombre, v_apellidos, v_fechaNac, v_genero, v_direccion, v_ciudadResidencia, v_celular, v_email);
        
        try{
            boolean actualizado = funcionario.editarCliente(nuevoCliente);
            if(actualizado){
                Utilidades.mensajeExito("Se actualizo el cliente correctamente", "Actualizacion Exitosa");
                limpiarCamposEditarCliente();
            }else{
                Utilidades.mensajeError("El cliente a actualizar no esta registrado", "Error");         
            }
            
        }catch (IOException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            Utilidades.mensajeAdvertencia("Se ha interrumpido la conexion con el servidor", "Error");
        }
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void txtDiaNacUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaNacUCKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();
    }//GEN-LAST:event_txtDiaNacUCKeyTyped

    private void txtAnioNacUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnioNacUCKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();
    }//GEN-LAST:event_txtAnioNacUCKeyTyped

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        //this.dispose();
    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        //this.dispose();
    }//GEN-LAST:event_formInternalFrameClosing

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        //this.dispose();
    }//GEN-LAST:event_formMouseExited

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
        myUnicaVentana.setNuevaVentana(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[],Funcionario funcionario) {
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
            java.util.logging.Logger.getLogger(GUIGestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIGestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIGestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIGestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIGestionClientes(funcionario, new VentanaDisponible()).setVisible(true);         
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarUC;
    private javax.swing.JButton btnComprobarAC;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.ButtonGroup btnGroupSexoAC;
    private javax.swing.ButtonGroup btnGroupSexoUC;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbmxMesNacAC;
    private javax.swing.JComboBox<String> cbmxMesNacUC;
    private javax.swing.JLabel lblAnioNacAC;
    private javax.swing.JLabel lblAnioNacUC;
    private javax.swing.JLabel lblApellidosAC;
    private javax.swing.JLabel lblApellidosCC;
    private javax.swing.JLabel lblApellidosUC;
    private javax.swing.JLabel lblCelularAC;
    private javax.swing.JLabel lblCelularCC;
    private javax.swing.JLabel lblCelularUC;
    private javax.swing.JLabel lblCiudadResidenciaAC;
    private javax.swing.JLabel lblCiudadResidenciaCC;
    private javax.swing.JLabel lblCiudadResidenciaUC;
    private javax.swing.JLabel lblDiaNacAC;
    private javax.swing.JLabel lblDiaNacAC2;
    private javax.swing.JLabel lblDireccionAC;
    private javax.swing.JLabel lblDireccionCC;
    private javax.swing.JLabel lblDireccionUC;
    private javax.swing.JLabel lblEmailAC;
    private javax.swing.JLabel lblEmailCC;
    private javax.swing.JLabel lblEmailUC;
    private javax.swing.JLabel lblFechaNacAC;
    private javax.swing.JLabel lblFechaNacCC;
    private javax.swing.JLabel lblFechaNacUC;
    private javax.swing.JLabel lblGeneroAC;
    private javax.swing.JLabel lblGeneroCC;
    private javax.swing.JLabel lblGeneroUC;
    private javax.swing.JLabel lblGestionClientes;
    private javax.swing.JLabel lblIdentificaciónAC;
    private javax.swing.JLabel lblIdentificaciónCC;
    private javax.swing.JLabel lblIdentificaciónEC;
    private javax.swing.JLabel lblIdentificaciónUC;
    private javax.swing.JLabel lblImagenDataBase;
    private javax.swing.JLabel lblImgGestionClientes;
    private javax.swing.JLabel lblInfo2AC;
    private javax.swing.JLabel lblInfoAC;
    private javax.swing.JLabel lblInfoUC;
    private javax.swing.JLabel lblMesNacAC;
    private javax.swing.JLabel lblMesNacUC;
    private javax.swing.JLabel lblNombresAC;
    private javax.swing.JLabel lblNombresCC;
    private javax.swing.JLabel lblNombresUC;
    private javax.swing.JPanel pnlActualizarCliente;
    private javax.swing.JPanel pnlAgregarCliente;
    private javax.swing.JPanel pnlConsultarCliente;
    private javax.swing.JPanel pnlEliminarCliente;
    private javax.swing.JPanel pnlGestionClientes;
    private javax.swing.JTabbedPane pnlsGestionCliente;
    private javax.swing.JRadioButton rbtnFAC;
    private javax.swing.JRadioButton rbtnFUC;
    private javax.swing.JRadioButton rbtnMAC;
    private javax.swing.JRadioButton rbtnMUC;
    private javax.swing.JTextField txtAnioNacAC;
    private javax.swing.JTextField txtAnioNacUC;
    private javax.swing.JTextField txtApellidosAC;
    private javax.swing.JTextField txtApellidosCC;
    private javax.swing.JTextField txtApellidosUC;
    private javax.swing.JTextField txtCelularAC;
    private javax.swing.JTextField txtCelularCC;
    private javax.swing.JTextField txtCelularUC;
    private javax.swing.JTextField txtCiudadResidenciaAC;
    private javax.swing.JTextField txtCiudadResidenciaCC;
    private javax.swing.JTextField txtCiudadResidenciaUC;
    private javax.swing.JTextField txtDiaNacAC;
    private javax.swing.JTextField txtDiaNacUC;
    private javax.swing.JTextField txtDireccionAC;
    private javax.swing.JTextField txtDireccionCC;
    private javax.swing.JTextField txtDireccionUC;
    private javax.swing.JTextField txtEmailAC;
    private javax.swing.JTextField txtEmailCC;
    private javax.swing.JTextField txtEmailUC;
    private javax.swing.JTextField txtFechaNacCC;
    private javax.swing.JTextField txtGeneroCC;
    private javax.swing.JTextField txtIdentificacionAC;
    private javax.swing.JTextField txtIdentificacionCC;
    private javax.swing.JTextField txtIdentificacionEC;
    private javax.swing.JTextField txtIdentificacionUC;
    private javax.swing.JTextField txtNombresAC;
    private javax.swing.JTextField txtNombresCC;
    private javax.swing.JTextField txtNombresUC;
    // End of variables declaration//GEN-END:variables
}
