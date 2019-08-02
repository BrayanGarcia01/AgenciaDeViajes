package presentacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import negocio.Ciudad;
import negocio.Funcionario;
import negocio.Paquete;
import negocio.PaqueteComponent;
import negocio.Vuelo;
import recursos.MyException;
import recursos.Utilidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brayangarcia
 */
public class JDVuelo extends javax.swing.JDialog  {

    /**
     * Creates new form JDCiudad
     */
    Funcionario myFuncionario;
    Ciudad myCiudad; 
    Paquete myPaquete;
    String destino;
    String origen;
    public JDVuelo(java.awt.Frame parent, boolean modal,Funcionario myFuncionario,Ciudad myCiudad,Paquete myPaquete,String destino,String origen) {
        super(parent, modal);
        this.myFuncionario = myFuncionario;
        this.myCiudad = myCiudad;
        this.myPaquete= myPaquete;
        this.destino=destino;
        initComponents();
        fixTableLayout(jTblVuelos);
        this.origen = origen;
        myBtnGroup = new ButtonGroup();
        myBtnGroup.add(JRBtnVueloIda);
        myBtnGroup.add(JRBtnVueloVuelta);
        String[] ciudad=destino.split("-");
        String ciudadDestino=ciudad[2];
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel6 = new javax.swing.JLabel();
        JSPVuelos = new javax.swing.JScrollPane();
        jTblVuelos = new javax.swing.JTable();
        JDChfechaSalidaVuelos = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JDChFechaLlegadaVuelos = new com.toedter.calendar.JDateChooser();
        btnBuscarVuelos1 = new javax.swing.JButton();
        jBtnVuelo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbxCiudadOrigen = new javax.swing.JComboBox<>();
        JRBtnVueloIda = new javax.swing.JRadioButton();
        JRBtnVueloVuelta = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel6.setText("Vuelos:");

        jTblVuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Aerolinea", "Ciudad origen", "Ciudad Destino","Fecha Salida","Fecha Llegada","Precio"
            }
        ));
        JSPVuelos.setViewportView(jTblVuelos);

        jLabel7.setText("Fecha salida");

        jLabel8.setText("Fecha Llegada");

        btnBuscarVuelos1.setText("Buscar");
        btnBuscarVuelos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVuelos1ActionPerformed(evt);
            }
        });

        jBtnVuelo.setText("Agregar Vuelo");
        jBtnVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVueloActionPerformed(evt);
            }
        });

        jLabel1.setText("Escoge ciudad origen");

        cbxCiudadOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JRBtnVueloIda.setText("Vuelo Ida");

        JRBtnVueloVuelta.setText("Vuelo Vuelta");

        jLabel2.setText("Tipo de vuelo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JDChfechaSalidaVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JDChFechaLlegadaVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarVuelos1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtnVuelo)
                            .addComponent(JSPVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(JRBtnVueloIda)
                                .addGap(18, 18, 18)
                                .addComponent(JRBtnVueloVuelta)
                                .addGap(141, 141, 141))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCiudadOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCiudadOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JRBtnVueloIda)
                    .addComponent(JRBtnVueloVuelta)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JDChfechaSalidaVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JDChFechaLlegadaVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(JSPVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnVuelo))
                    .addComponent(btnBuscarVuelos1))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarVuelos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVuelos1ActionPerformed
        // TODO add your handling code here:
                
            // TODO add your handling code here:
            Calendar f=JDChfechaSalidaVuelos.getCalendar();
            String diaSalida=convertirDiaoMesAHsqldb(f.get(Calendar.DATE));
            String mesSalida=convertirDiaoMesAHsqldb((f.get(Calendar.MONTH)+1));
            int anioSalida =(f.get(Calendar.YEAR));
            
            String fechaSalida = anioSalida+"-"+mesSalida+"-"+diaSalida;
            System.out.println(fechaSalida);
            Calendar f2=JDChFechaLlegadaVuelos.getCalendar();
            String diaLLegada=convertirDiaoMesAHsqldb(f2.get(Calendar.DATE));
            String mesLlegada=convertirDiaoMesAHsqldb((f2.get(Calendar.MONTH)+1));
            String anioLlegada = String.valueOf(f2.get(Calendar.YEAR));
            String fechaLlegada=anioLlegada+"-"+mesLlegada+"-"+diaLLegada;
            System.out.println(fechaLlegada);
            Vuelo[] vuelos;
            if(JRBtnVueloIda.isSelected()){
               vuelos=myFuncionario.consultarVuelos(fechaSalida, fechaLlegada,origen,destino);
            }else{
                vuelos=myFuncionario.consultarVuelos(fechaSalida, fechaLlegada,destino,origen);

            }
            
            if(vuelos.length==0)return;
             mostrarVuelosEnLista(vuelos);
        
    }//GEN-LAST:event_btnBuscarVuelos1ActionPerformed

    private void jBtnVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVueloActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada=jTblVuelos.getSelectedRow();
        long idVuelo=Long.parseLong(((String)( jTblVuelos.getValueAt(filaSeleccionada,0))));
        String aerolinea=(String)jTblVuelos.getValueAt(filaSeleccionada,1);
        String ciudadOrigen=(String)jTblVuelos.getValueAt(filaSeleccionada,2);
        String ciudadDestino=(String)jTblVuelos.getValueAt(filaSeleccionada,3);
        String fechaSalida=(String)jTblVuelos.getValueAt(filaSeleccionada,4);
        String fechaLlegada=(String)jTblVuelos.getValueAt(filaSeleccionada,5);
        int precio=Integer.parseInt(((String)jTblVuelos.getValueAt(filaSeleccionada,6)));
        String [] vecDestino =  destino.split("-");
        String veContinenteDestino=vecDestino[0];
        String vecPaisDestino=vecDestino[1];
        String vecCiudadDestino = vecDestino[2];
        System.out.println("Va a añadir componente");
        Vuelo myVuelo =new Vuelo(idVuelo,aerolinea,ciudadOrigen,ciudadDestino,fechaSalida,fechaLlegada,precio);
        if(myCiudad.buscarVuelo(idVuelo)==null){
                myCiudad.addComponent(myVuelo);
                myPaquete.notificar();
                Utilidades.mensajeExito("Vuelo agregado al paquete", "Exito");
        }else{
             Utilidades.mensajeError("El vuelo seleccionado ya se encuentra en el paquete", "Error");

        }

        
    }//GEN-LAST:event_jBtnVueloActionPerformed
    public void mostrarVuelosEnLista(Vuelo[] vuelos){
        
        String [][] vecVuelos = new String [vuelos.length][7];
        String [] vecCiudad = destino.split("-");
        for (int i = 0; i < vuelos.length; i++) {
           
                vecVuelos[i][0] = String.valueOf(vuelos[i].getIdVuelo());
                vecVuelos[i][1] = vuelos[i].getAerolinea();
                vecVuelos[i][2] = vuelos[i].getNombreCiudadOrigen();
                vecVuelos[i][3] = vuelos[i].getNombreCiudadDestino();
                vecVuelos[i][4] = vuelos[i].getFechaHoraSalida();
                vecVuelos[i][5] = vuelos[i].getFechaHoraLlegada();
                vecVuelos[i][6] = String.valueOf(vuelos[i].getPrecio());

        }
        jTblVuelos.setModel(new javax.swing.table.DefaultTableModel(
                vecVuelos,
        new String [] {
          "Id del vuelo", "Aerolinea", "Ciudad origen", "Ciudad Destino","Fecha Salida","Fecha Llegada","Precio"
     }
        ));
        fixTableLayout(jTblVuelos);

    }
    public String convertirDiaoMesAHsqldb(int diaoMes){
        
        String conversion=String.valueOf(diaoMes);
        if(diaoMes<10){
            conversion = "0"+diaoMes;
        }
        return conversion;
        
    }
     
    public void fixTableLayout(JTable jTblVuelos){
        jTblVuelos.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTblVuelos.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTblVuelos.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTblVuelos.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTblVuelos.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTblVuelos.getColumnModel().getColumn(5).setPreferredWidth(50);
        jTblVuelos.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    private javax.swing.ButtonGroup myBtnGroup;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDChFechaLlegadaVuelos;
    private com.toedter.calendar.JDateChooser JDChfechaSalidaVuelos;
    private javax.swing.JRadioButton JRBtnVueloIda;
    private javax.swing.JRadioButton JRBtnVueloVuelta;
    private javax.swing.JScrollPane JSPVuelos;
    private javax.swing.JButton btnBuscarVuelos1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbxCiudadOrigen;
    private javax.swing.JButton jBtnVuelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTable jTblVuelos;
    // End of variables declaration//GEN-END:variables
}

