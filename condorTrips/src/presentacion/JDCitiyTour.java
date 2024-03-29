/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.util.Calendar;
import negocio.CityTour;
import negocio.Ciudad;
import negocio.Funcionario;
import negocio.Habitacion;
import negocio.Hotel;
import negocio.Paquete;
import negocio.Vuelo;
import recursos.Utilidades;

/**
 *
 * @author brayangarcia
 */
public class JDCitiyTour extends javax.swing.JDialog {

    /**
     * Creates new form JDCitiyTour
     */
    Funcionario myFuncionario;
    Ciudad myCiudad;
    Paquete myPaquete;
    String destino;
    public JDCitiyTour(java.awt.Frame parent, boolean modal,Funcionario myFuncionario,Ciudad myCiudad,Paquete myPaquete,String destino) {
        super(parent, modal);
        initComponents();
        this.myFuncionario = myFuncionario;
        this.myCiudad = myCiudad;
        this.myPaquete = myPaquete;
        this.destino=destino;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JSPCityTour = new javax.swing.JScrollPane();
        JTblCityTour = new javax.swing.JTable();
        lblFin = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        lblCityTour = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        JDChFechaInicio = new com.toedter.calendar.JDateChooser();
        JDChFechaFin = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JTblCityTour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id CityTour","Ciudad" ,"Descripcion", "Fecha Inicio", "fecha Fin","precio"
            }
        ));
        JSPCityTour.setViewportView(JTblCityTour);

        lblFin.setText("Fecha Fin");

        lblFechaInicio.setText("Fecha inicio");

        lblCityTour.setText("City Tour");

        jButton1.setText("Agregar City Tour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(lblCityTour))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(lblFechaInicio)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JDChFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblFin, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JDChFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(JSPCityTour, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblCityTour)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFin, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JDChFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JDChFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addComponent(JSPCityTour, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jButton2))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
            Calendar f=JDChFechaInicio.getCalendar();
            String diaInicio=convertirDiaoMesAHsqldb(f.get(Calendar.DATE));
            String mesInicio=convertirDiaoMesAHsqldb((f.get(Calendar.MONTH)+1));
            int anioInicio =(f.get(Calendar.YEAR));
            
            String fechaInicio = anioInicio+"-"+mesInicio+"-"+diaInicio;
            System.out.println(fechaInicio);
            Calendar f2=JDChFechaFin.getCalendar();
            String diaFin=convertirDiaoMesAHsqldb(f2.get(Calendar.DATE));
            String mesFin=convertirDiaoMesAHsqldb((f2.get(Calendar.MONTH)+1));
            String anioFin = String.valueOf(f2.get(Calendar.YEAR));
            String fechaFin=anioFin+"-"+mesFin+"-"+diaFin;
            System.out.println(fechaFin);
            
   
            CityTour[] cityTours;
            cityTours=myFuncionario.consultarCityTours(fechaInicio, fechaFin,destino);

            if(cityTours.length==0)return;
             mostrarCityTours(cityTours);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         int filaSeleccionada=JTblCityTour.getSelectedRow();
            Utilidades myUtility = new Utilidades();
            long idCitytour=Long.parseLong(((String)( JTblCityTour.getValueAt(filaSeleccionada,0))));
            String descripcion=(String)JTblCityTour.getValueAt(filaSeleccionada,2);
            String fechaInicio=(String)JTblCityTour.getValueAt(filaSeleccionada,3);          
            String fechaFin=(String)JTblCityTour.getValueAt(filaSeleccionada,4);
            int precio=Integer.parseInt((String)JTblCityTour.getValueAt(filaSeleccionada,5));

            CityTour myCityTour = new CityTour(idCitytour, fechaInicio, fechaFin, descripcion, precio);
            if(myCiudad.buscarCityTour(idCitytour)==null){
                    myCiudad.addComponent(myCityTour);
                    myPaquete.notificar();
                    Utilidades.mensajeExito("CityTour agregado al paquete", "Exito");
            }else{
                Utilidades.mensajeError("El CityTour seleccionada ya se encuentra en el paquete", "Error");

            }
            

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDChFechaFin;
    private com.toedter.calendar.JDateChooser JDChFechaInicio;
    private javax.swing.JScrollPane JSPCityTour;
    private javax.swing.JTable JTblCityTour;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lblCityTour;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblFin;
    // End of variables declaration//GEN-END:variables

    private String convertirDiaoMesAHsqldb(int diaoMes) {
          
        String conversion=String.valueOf(diaoMes);
        if(diaoMes<10){
            conversion = "0"+diaoMes;
        }
        return conversion;
    }

    private void mostrarCityTours(CityTour[] cityTours) {
         String [][] vecCityTour = new String [cityTours.length][6];
         String ciudad = destino.split("-")[2];
        for (int i = 0; i < cityTours.length; i++) {
           
                vecCityTour[i][0] = String.valueOf(cityTours[i].getIdCityTour());
                vecCityTour[i][1]= ciudad;
                vecCityTour[i][2] = cityTours[i].getDescripcion();
                vecCityTour[i][3] = cityTours[i].getFechaInicio();
                vecCityTour[i][4] = cityTours[i].getFechaFin();
                vecCityTour[i][5] = String.valueOf(cityTours[i].getPrecio());

        }
        JTblCityTour.setModel(new javax.swing.table.DefaultTableModel(
                vecCityTour,
        new String [] {
          "Id CityTour", "Ciudad","Descripcion", "Fecha Inicio", "fecha Fin","precio"
     }
        ));
    }
    
}
