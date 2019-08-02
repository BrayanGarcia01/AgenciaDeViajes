/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ComboBoxModel;
import javax.swing.JTable;
import negocio.CityTour;
import negocio.Ciudad;
import negocio.Funcionario;
import negocio.Habitacion;
import negocio.Hotel;
import negocio.Paquete;
import negocio.PlanAlimentacionHotel;
import negocio.Vuelo;
import recursos.Utilidades;

/**
 *
 * @author brayangarcia
 */
public class JDHotel extends javax.swing.JDialog {

    /**
     * Creates new form JDHotel
     */    
    Funcionario myFuncionario;
    Ciudad myCiudad;
    Paquete myPaquete;
    String destino;

    
    public JDHotel(java.awt.Frame parent, boolean modal,Funcionario myFuncionario,Ciudad myCiudad,Paquete myPaquete,String destino) {
        super(parent, modal);
        initComponents();
         this.myFuncionario = myFuncionario;
        this.myCiudad = myCiudad;
        this.myPaquete=myPaquete;
        this.destino=destino;
        fixTablePlanAlimenLayout(JTblPlanAlimen);
        fixTableHotelesLayout(JTbHoteles);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JSPHotel = new javax.swing.JScrollPane();
        JTbHoteles = new javax.swing.JTable();
        lblFechaLlegada = new javax.swing.JLabel();
        lblFechaSalida = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        JSPPlanAlimen = new javax.swing.JScrollPane();
        JTblPlanAlimen = new javax.swing.JTable();
        btnPlanAlimentacion = new javax.swing.JButton();
        JCBXHoteles = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        JBtnBuscarAlimentacion = new javax.swing.JButton();
        JDChFechaSalida = new com.toedter.calendar.JDateChooser();
        JDChFechaLlegada = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JTbHoteles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ciudad","Id Hotel", "Nombre Hotel", "Numero Habitacion","Descripcion","Precio"
            }
        ));
        JSPHotel.setViewportView(JTbHoteles);

        lblFechaLlegada.setText("Fecha Llegada");

        lblFechaSalida.setText("Fecha Salida");

        jLabel3.setText("Hoteles");

        jButton1.setText("Buscar hotel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar Hotel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        JTblPlanAlimen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Plan Ali.","Nombre Hotel","Ciudad","Descripcion plan alimentacion","Precio"
            }
        ));
        JSPPlanAlimen.setViewportView(JTblPlanAlimen);

        btnPlanAlimentacion.setText("Agregar Plan Alimentacion");
        btnPlanAlimentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlanAlimentacionActionPerformed(evt);
            }
        });

        jLabel1.setText("HOTELES");

        JBtnBuscarAlimentacion.setText("Buscar Planes de Alimentacion");
        JBtnBuscarAlimentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnBuscarAlimentacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPlanAlimentacion)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JCBXHoteles, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(JBtnBuscarAlimentacion))
                        .addComponent(JSPPlanAlimen, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSPHotel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(234, 234, 234)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFechaLlegada)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JDChFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblFechaSalida)
                                        .addGap(18, 18, 18)
                                        .addComponent(JDChFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JDChFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JDChFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(JSPHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JCBXHoteles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBtnBuscarAlimentacion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSPPlanAlimen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPlanAlimentacion)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
            Calendar f=JDChFechaLlegada.getCalendar();
            String diaLlegada=convertirDiaoMesAHsqldb(f.get(Calendar.DATE));
            String mesLlegada=convertirDiaoMesAHsqldb((f.get(Calendar.MONTH)+1));
            int anioLlegada =(f.get(Calendar.YEAR));
            
            String fechaLlegada = anioLlegada+"-"+mesLlegada+"-"+diaLlegada;
            Calendar f2=JDChFechaSalida.getCalendar();
            String diaSalida=convertirDiaoMesAHsqldb(f2.get(Calendar.DATE));
            String mesSalida=convertirDiaoMesAHsqldb((f2.get(Calendar.MONTH)+1));
            String anioSalida = String.valueOf(f2.get(Calendar.YEAR));
            String fechaSalida=anioSalida+"-"+mesSalida+"-"+diaSalida;
            
   
            Hotel[] misHoteles;
            misHoteles=myFuncionario.consultarHoteles(fechaLlegada, fechaSalida, destino);

            if(misHoteles.length==0) resetHotelTable();
             mostrarCityTours(misHoteles);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int filaSeleccionada=JTbHoteles.getSelectedRow();
            Utilidades myUtility = new Utilidades();
            long idHotel=Long.parseLong(((String)( JTbHoteles.getValueAt(filaSeleccionada,0))));
            String nombreHotel=(String)JTbHoteles.getValueAt(filaSeleccionada,1);
            int numeroHabitacion=Integer.parseInt((String)JTbHoteles.getValueAt(filaSeleccionada,3));          
            String descripcionHabitacion=(String)JTbHoteles.getValueAt(filaSeleccionada,4);
            int precio=Integer.parseInt((String)JTbHoteles.getValueAt(filaSeleccionada,5));
            // Hotel myHotel = new Hotel(idHotel, nombreHotel);
            Hotel hotelDelPaquete=myCiudad.buscarHotel(idHotel);
            if(hotelDelPaquete==null){
                    Hotel myHotel = new Hotel(idHotel, nombreHotel);
                
                    Habitacion myHabitacion =  new Habitacion(numeroHabitacion,descripcionHabitacion, 'D', precio);
                    myHotel.addComponent(myHabitacion);
                    myCiudad.addComponent(myHotel);
                    myPaquete.notificar();
                    //Nuevo Hotel
                    inicializarComboHoteles();
                  

            }else {
                Habitacion habitacionDelPaquete= hotelDelPaquete.buscarHabitacion(numeroHabitacion);
                if(habitacionDelPaquete==null){
                    Habitacion myHabitacion = new Habitacion(numeroHabitacion, descripcionHabitacion, 'D', precio);
                    hotelDelPaquete.addComponent(myHabitacion);
                    myPaquete.notificar();
                    
                }else{
                    Utilidades.mensajeError("La habitacion seleccionada ya se encuentra en el paquete","Error");
                    return;
                }
                
            }
             Utilidades.mensajeExito("habitacion de hotel agregada exitosamente","Exito");
             
             
    }//GEN-LAST:event_jButton2ActionPerformed
    private void inicializarComboHoteles(){
        ArrayList<Hotel> misHoteles=myCiudad.devolverHotelesDelPaquete();
        for (Hotel myHotel: misHoteles) {
            JCBXHoteles.addItem(myHotel.getNombreHotel());
        }
    }
    private void btnPlanAlimentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlanAlimentacionActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        int filaSeleccionada=JTblPlanAlimen.getSelectedRow();
        long idPlan=Long.parseLong((String)( JTblPlanAlimen.getValueAt(filaSeleccionada,0)));
        String nombreHotel=((String)( JTblPlanAlimen.getValueAt(filaSeleccionada,1)));
        String descripcion=((String)( JTblPlanAlimen.getValueAt(filaSeleccionada,3)));
        int precio=Integer.parseInt(((String)( JTblPlanAlimen.getValueAt(filaSeleccionada,4))));


        Hotel myHotel =myCiudad.buscarHotel(nombreHotel);
        PlanAlimentacionHotel myPlanAli = myHotel.buscarPlanAlimentacion(idPlan);
        if (myPlanAli ==null){
            myPlanAli = new PlanAlimentacionHotel(idPlan,descripcion,precio);
            myHotel.addComponent(myPlanAli);
            myPaquete.notificar();
            Utilidades.mensajeExito("Plan de alimentacion de hotel agregado exitosamente","Exito");

            
        }else{
            Utilidades.mensajeError("El plan de alimentacion seleccionado ya se encuentra en el paquete","Error");

        }
        
    }//GEN-LAST:event_btnPlanAlimentacionActionPerformed

    private void JBtnBuscarAlimentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnBuscarAlimentacionActionPerformed
        // TODO add your handling code here:
            String nombreHotel =(String)JCBXHoteles.getSelectedItem();
             
            Hotel myHotel = myCiudad.buscarHotel(nombreHotel);
            PlanAlimentacionHotel[] planesAlimen= myFuncionario.consultarPlanesAlimentacion(myHotel.getIdHotel());
            if(planesAlimen.length==0) resetPlanTable();
            mostrarPlanesAlimentacion(planesAlimen, myHotel);
        
    }//GEN-LAST:event_JBtnBuscarAlimentacionActionPerformed

    
    
    
    private String convertirDiaoMesAHsqldb(int diaoMes) {
         String conversion=String.valueOf(diaoMes);
        if(diaoMes<10){
            conversion = "0"+diaoMes;
        }
        return conversion;
    }
    private void  resetHotelTable(){
        JTbHoteles.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null},
                {null, null, null, null,null,null}
            },
         new String [] {
          "Id Hotel", "Nombre Hotel","Ciudad", "Numero Habitacion","Descripcion","Precio"
         }
           ));
       fixTableHotelesLayout(JTbHoteles);
    }
    private void resetPlanTable(){
        JTblPlanAlimen.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                {null, null, null, null,null},
                {null, null, null, null,null},
                {null, null, null, null,null},
                {null, null, null, null,null},
                {null, null, null, null,null},
                {null, null, null, null,null}
            },
        new String [] {
                 "Id Hotel","Nombre Hotel","Ciudad","Descripcion plan alimentacion","Precio"

     }
        ));
      fixTablePlanAlimenLayout(JTblPlanAlimen);
    
    }
private void mostrarCityTours(Hotel[] vec) {
         String [][] vecHoteles = new String [vec.length][6];
        for (int i = 0; i < vec.length; i++) {
            vecHoteles[i][0] = String.valueOf(vec[i].getIdHotel());
            vecHoteles[i][1]=vec[i].getNombreHotel();
            vecHoteles[i][2]=destino.split("-")[2];
            if(vec[i].getArrayComponentes().get(0) instanceof Habitacion){
                Habitacion myHabitacion = (Habitacion)vec[i].getArrayComponentes().get(0);
                vecHoteles[i][3] = String.valueOf(myHabitacion.getNumeroHabitacion());
                vecHoteles[i][4]= myHabitacion.getDescripcion();
                vecHoteles[i][5]= String.valueOf(myHabitacion.getPrecio());
            } 
        }
       JTbHoteles.setModel(new javax.swing.table.DefaultTableModel(
                vecHoteles,
        new String [] {
          "Id Hotel", "Nombre Hotel","Ciudad", "Numero Habitacion","Descripcion","Precio"
     }
        ));
       fixTableHotelesLayout(JTbHoteles);

    }
    private void mostrarPlanesAlimentacion(PlanAlimentacionHotel[] vec,Hotel myHotel) {
         String [][] vecPlanesAli = new String [vec.length][5];
         String ciudad=destino.split("-")[2];
        for (int i = 0; i < vec.length; i++) {
            
           vecPlanesAli[i][0]=String.valueOf(vec[i].getIdPlanAlimentacion());
           vecPlanesAli[i][1]=myHotel.getNombreHotel();
           vecPlanesAli[i][2]=ciudad;
           vecPlanesAli[i][3]=String.valueOf(vec[i].getDescripcion());
           vecPlanesAli[i][4]=String.valueOf(vec[i].getPrecio());


        }
       JTblPlanAlimen.setModel(new javax.swing.table.DefaultTableModel(
                vecPlanesAli,
        new String [] {
                 "Id Hotel","Nombre Hotel","Ciudad","Descripcion plan alimentacion","Precio"

     }
        ));
      fixTablePlanAlimenLayout(JTblPlanAlimen);


    }
     public void fixTableHotelesLayout(JTable jTblVuelos){
        jTblVuelos.getColumnModel().getColumn(0).setPreferredWidth(15);
        jTblVuelos.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTblVuelos.getColumnModel().getColumn(2).setPreferredWidth(55);
        jTblVuelos.getColumnModel().getColumn(3).setPreferredWidth(55);
        jTblVuelos.getColumnModel().getColumn(4).setPreferredWidth(55);
        jTblVuelos.getColumnModel().getColumn(5).setPreferredWidth(36);
    }
    public void fixTablePlanAlimenLayout(JTable jTblVuelos){
        jTblVuelos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTblVuelos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTblVuelos.getColumnModel().getColumn(2).setPreferredWidth(40);
        jTblVuelos.getColumnModel().getColumn(3).setPreferredWidth(160);
        jTblVuelos.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBtnBuscarAlimentacion;
    private javax.swing.JComboBox<String> JCBXHoteles;
    private com.toedter.calendar.JDateChooser JDChFechaLlegada;
    private com.toedter.calendar.JDateChooser JDChFechaSalida;
    private javax.swing.JScrollPane JSPHotel;
    private javax.swing.JScrollPane JSPPlanAlimen;
    private javax.swing.JTable JTbHoteles;
    private javax.swing.JTable JTblPlanAlimen;
    private javax.swing.JButton btnPlanAlimentacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblFechaLlegada;
    private javax.swing.JLabel lblFechaSalida;
    // End of variables declaration//GEN-END:variables

}