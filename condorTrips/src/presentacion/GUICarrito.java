/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import javax.swing.table.DefaultTableModel;
import mvcf.AModel;
import mvcf.AView;
import negocio.CityTour;
import negocio.Ciudad;
import negocio.Habitacion;
import negocio.Hotel;
import negocio.Paquete;
import negocio.PlanAlimentacionHotel;
import negocio.Vuelo;

/**
 *
 * @author brayangarcia
 */
public class GUICarrito extends javax.swing.JFrame implements AView {

    /**
     * Creates new form JDCarrito
     */
    Paquete myPaquete;
    public GUICarrito(Paquete myPaquete) {
        initComponents();
        this.myPaquete=myPaquete;
        inicializarTablaHoteles();
        inicializarTablaVuelos();
        inicializarTablaCityTours();
        inicializarTablaPlanesAlimentacion();
        
    }
    
    public void inicializarTablaHoteles(){
        String [][] vecHoteles= new String[7][10];
        int indiceParaTabla=0;

        for (int i = 0; i < myPaquete.getComponentes().size(); i++) {
            Ciudad myCiudad =  (Ciudad) myPaquete.getComponentes().get(i);
            
            for (int j = 0; j < myCiudad.getComponentes().size(); j++) {
                if(myCiudad.getComponentes().get(j) instanceof Hotel){
                    
                    Hotel myHotel = (Hotel)myCiudad.getComponentes().get(j);
                    
                    for (int k = 0; k < myHotel.getArrayComponentes().size(); k++) {
                        
                        if( myHotel.getArrayComponentes().get(k) instanceof Habitacion){
                            
                            Habitacion myHabitacion = (Habitacion) myHotel.getArrayComponentes().get(k);
                            vecHoteles[indiceParaTabla][0]= String.valueOf(myCiudad.getIdCiudad());

                            vecHoteles[indiceParaTabla][1]= myCiudad.getNombreCiudad();
                            vecHoteles[indiceParaTabla][2]= String.valueOf(myHotel.getIdHotel());
                            vecHoteles[indiceParaTabla][3]= myHotel.getNombreHotel();
                            vecHoteles[indiceParaTabla][4]=String.valueOf(myHabitacion.getNumeroHabitacion());
                            vecHoteles[indiceParaTabla][5]= myHabitacion.getDescripcion();
                            vecHoteles[indiceParaTabla][6]= String.valueOf(myHabitacion.getPrecio());
                            indiceParaTabla+=1;
                        }
                    }
                }
            }
        }
        String [] columnIdentifiers = {"Id Ciudad","Nombre Ciudad", "Id Hotel", "Nombre Hotel", "Numero Habitacion",
        "Descripcion","Precio"};
        TblHoteles.setModel(new javax.swing.table.DefaultTableModel(
                vecHoteles,columnIdentifiers));
    }
    public void inicializarTablaVuelos(){
        String [][] vecVuelos= new String[8][10];
        int indiceParaTabla=0;

        for (int i = 0; i < myPaquete.getComponentes().size(); i++) {
            Ciudad myCiudad = (Ciudad) myPaquete.getComponentes().get(i);
            
            for (int j = 0; j < myCiudad.getComponentes().size(); j++) {
                
                if(myCiudad.getComponentes().get(j) instanceof Vuelo){
                    
                        Vuelo myVuelo = (Vuelo)myCiudad.getComponentes().get(j);
                        vecVuelos[indiceParaTabla][0]=String.valueOf(myVuelo.getIdVuelo());
                        vecVuelos[indiceParaTabla][1]=myVuelo.getAerolinea();
                        vecVuelos[indiceParaTabla][2]=String.valueOf(myCiudad.getIdCiudad());
                        vecVuelos[indiceParaTabla][3]=myVuelo.getNombreCiudadOrigen();
                        vecVuelos[indiceParaTabla][4]=myVuelo.getNombreCiudadDestino();
                        vecVuelos[indiceParaTabla][5]=myVuelo.getFechaHoraSalida();
                        vecVuelos[indiceParaTabla][6]=myVuelo.getFechaHoraLlegada();
                        vecVuelos[indiceParaTabla][7]=String.valueOf(myVuelo.getPrecio());
                        indiceParaTabla+=1;
                        
                    }
                }
            }
        String [] columnIdentifiers = {"Id", "Aerolinea","id Ciudad Ori.", "Ciudad origen", "Ciudad Destino","Fecha Salida","Fecha Llegada","Precio"};
        TblVuelos.setModel(new javax.swing.table.DefaultTableModel(
                vecVuelos,columnIdentifiers));
     }
     public void inicializarTablaCityTours(){
        String [][] vecCityTours= new String[7][10];
        int indiceParaTabla=0;
        for (int i = 0; i < myPaquete.getComponentes().size(); i++) {
            Ciudad myCiudad = (Ciudad) myPaquete.getComponentes().get(i);
            
            for (int j = 0; j < myCiudad.getComponentes().size(); j++) {
                
                if(myCiudad.getComponentes().get(j) instanceof CityTour){
                    
                        CityTour myCityTour = (CityTour)myCiudad.getComponentes().get(j);
                        vecCityTours[indiceParaTabla][0]= String.valueOf(myCityTour.getIdCityTour());
                        vecCityTours[indiceParaTabla][1]= String.valueOf(myCiudad.getIdCiudad());
                        
                        vecCityTours[indiceParaTabla][2]= myCiudad.getNombreCiudad();
                        vecCityTours[indiceParaTabla][3]= myCityTour.getDescripcion();
                        vecCityTours[indiceParaTabla][4]= myCityTour.getFechaInicio();
                        vecCityTours[indiceParaTabla][5]= myCityTour.getFechaFin();
                        vecCityTours[indiceParaTabla][6]= String.valueOf(myCityTour.getPrecio());
                        indiceParaTabla+=1;
 
                    }
                }
            }
        String [] columnIdentifiers = {"Id CityTour","Id Ciudad","Nombre Ciudad" ,"Descripcion", "Fecha Inicio", "fecha Fin","precio"};
        TblCityTour.setModel(new javax.swing.table.DefaultTableModel(
                vecCityTours,columnIdentifiers));
     }
     
     
    public void inicializarTablaPlanesAlimentacion(){
 
        String [][] vecHoteles= new String[10][7];
        int indiceParaTabla=0;

        for (int i = 0; i < myPaquete.getComponentes().size(); i++) {
            Ciudad myCiudad = (Ciudad) myPaquete.getComponentes().get(i);
            
            for (int j = 0; j < myCiudad.getComponentes().size(); j++) {
                if(myCiudad.getComponentes().get(j) instanceof Hotel){
                    
                    Hotel myHotel = (Hotel)myCiudad.getComponentes().get(j);
                    
                    for (int k = 0; k < myHotel.getArrayComponentes().size(); k++) {
                        
                        if( myHotel.getArrayComponentes().get(k) instanceof PlanAlimentacionHotel){
                            
                            PlanAlimentacionHotel myPlanAli = (PlanAlimentacionHotel) myHotel.getArrayComponentes().get(k);
                            vecHoteles[indiceParaTabla][0]= String.valueOf(myPlanAli.getIdPlanAlimentacion()); 
                            vecHoteles[indiceParaTabla][1]= String.valueOf(myHotel.getIdHotel());          
                            
                            vecHoteles[indiceParaTabla][2]= String.valueOf(myHotel.getNombreHotel());
                            vecHoteles[indiceParaTabla][3]= String.valueOf(myCiudad.getIdCiudad());
                            vecHoteles[indiceParaTabla][4]= myCiudad.getNombreCiudad();
                            vecHoteles[indiceParaTabla][5]= myPlanAli.getDescripcion();
                            vecHoteles[indiceParaTabla][6]= String.valueOf(myPlanAli.getPrecio());
                            indiceParaTabla+=1;
                        }
                    }
                }
            }
        }
        
        String [] columnIdentifiers = {"Id Plan Ali.","Id Hotel","Nombre Hotel","Id ciudad","Ciudad","Descripcion plan alimentacion","Precio"};
        TblPlanAlimentacion.setModel(new javax.swing.table.DefaultTableModel(
                vecHoteles,columnIdentifiers));
        
    
     }
        
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JSPVuelos = new javax.swing.JScrollPane();
        TblVuelos = new javax.swing.JTable();
        JSPHoteles = new javax.swing.JScrollPane();
        TblHoteles = new javax.swing.JTable();
        JSPPlanAlimentacion = new javax.swing.JScrollPane();
        TblPlanAlimentacion = new javax.swing.JTable();
        JSPCityTour = new javax.swing.JScrollPane();
        TblCityTour = new javax.swing.JTable();
        BtnEliminarVuelo = new javax.swing.JButton();
        BtnEliminarHotel = new javax.swing.JButton();
        BtnEliminarPlanAlimentacion = new javax.swing.JButton();
        BtnEliminarCityTour = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TblVuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Vuelo", "Aerolinea", "Ciudad Origen", "Ciudad Destino",
                "Fecha Salida","Fecha Llegada","Precio"
            }
        ));
        JSPVuelos.setViewportView(TblVuelos);

        TblHoteles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ciudad", "Id Hotel", "Nombre Hotel", "nNumero Habitacion",
                "Descripcion","Precio"
            }
        ));
        JSPHoteles.setViewportView(TblHoteles);

        TblPlanAlimentacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Plan Ali.", "Nombre Hotel", "Ciudad", "Descripcion del plan alimentacion",
                "Precio"
            }
        ));
        JSPPlanAlimentacion.setViewportView(TblPlanAlimentacion);

        TblCityTour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id CityTour", "Ciudad", "Descripcion", "Fecha Inicio",
                "Fecha Fin","Precio"
            }
        ));
        JSPCityTour.setViewportView(TblCityTour);

        BtnEliminarVuelo.setText("Eliminar");
        BtnEliminarVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarVueloActionPerformed(evt);
            }
        });

        BtnEliminarHotel.setText("Eliminar");
        BtnEliminarHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarHotelActionPerformed(evt);
            }
        });

        BtnEliminarPlanAlimentacion.setText("Eliminar");
        BtnEliminarPlanAlimentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarPlanAlimentacionActionPerformed(evt);
            }
        });

        BtnEliminarCityTour.setText("Eliminar");
        BtnEliminarCityTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarCityTourActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Hoteles del Paquete");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Vuelos del Paquete");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Planes de alimentacion del Paquete");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setText("City tours del Paquete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnEliminarCityTour)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JSPCityTour, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JSPHoteles, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(JSPVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BtnEliminarVuelo)
                            .addComponent(BtnEliminarHotel)
                            .addComponent(JSPPlanAlimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnEliminarPlanAlimentacion))
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addGap(0, 59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSPVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEliminarVuelo)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSPHoteles, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEliminarHotel)
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(JSPPlanAlimentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEliminarPlanAlimentacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSPCityTour, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEliminarCityTour)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEliminarHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarHotelActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada=TblHoteles.getSelectedRow();
        long idCiudad=Long.parseLong(((String)( TblHoteles.getValueAt(filaSeleccionada,0))));
        long idHotel=Long.parseLong(((String)( TblHoteles.getValueAt(filaSeleccionada,2))));
        int numHabitacion=Integer.parseInt(((String)( TblHoteles.getValueAt(filaSeleccionada,4))));

        Ciudad myCiudad= myPaquete.buscarCiudad(idCiudad);
        Hotel myHotel=myCiudad.buscarHotel(idHotel);
        Habitacion myHabitacion=myHotel.buscarHabitacion(numHabitacion);
        myHotel.removeComponent(myHabitacion);
        if(hotelSinHabitacionesReservadas(myHotel)){
            //SI el paquete no tiene reservas de habitaciones,
            //quiere decir que no va a quedarse en el hotel(también se eliminan los planes de ali).
            myCiudad.removeComponent(myHotel);
        }
        myPaquete.notificar();

        
    }//GEN-LAST:event_BtnEliminarHotelActionPerformed
    private boolean hotelSinHabitacionesReservadas(Hotel myHotel){
        for (int i = 0; i < myHotel.getArrayComponentes().size(); i++) {
            if(myHotel.getArrayComponentes().get(i) instanceof Habitacion){
                return false;
            }
        }
            return true;
        
        
    }
    private void BtnEliminarVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarVueloActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada=TblVuelos.getSelectedRow();
        long idVuelo=Long.parseLong(((String)( TblVuelos.getValueAt(filaSeleccionada,0))));
        long idCiudadOrigen=Long.parseLong(((String)( TblVuelos.getValueAt(filaSeleccionada,2))));
        Ciudad myCiudad= myPaquete.buscarCiudad(idCiudadOrigen);
        Vuelo myVuelo =myCiudad.buscarVuelo(idVuelo);
        myCiudad.removeComponent(myVuelo);
        myPaquete.notificar();
        
    }//GEN-LAST:event_BtnEliminarVueloActionPerformed

    private void BtnEliminarPlanAlimentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarPlanAlimentacionActionPerformed
        // TODO add your handling code here:
         int filaSeleccionada=TblPlanAlimentacion.getSelectedRow();
        long idPlanAli=Long.parseLong(((String)( TblPlanAlimentacion.getValueAt(filaSeleccionada,0))));
        long idHotel=Long.parseLong(((String)( TblPlanAlimentacion.getValueAt(filaSeleccionada,1))));
        long idCiudad=Long.parseLong(((String)( TblPlanAlimentacion.getValueAt(filaSeleccionada,3))));
        
        Ciudad myCiudad=myPaquete.buscarCiudad(idCiudad);
        Hotel myHotel=myCiudad.buscarHotel(idHotel);
        PlanAlimentacionHotel myPlaAli=myHotel.buscarPlanAlimentacion(idPlanAli);
        myHotel.removeComponent(myPlaAli);
        myPaquete.notificar();
        
    }//GEN-LAST:event_BtnEliminarPlanAlimentacionActionPerformed

    private void BtnEliminarCityTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarCityTourActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada=TblCityTour.getSelectedRow();
        long idCItyTour=Long.parseLong(((String)( TblCityTour.getValueAt(filaSeleccionada,0))));
        long idCiudad=Long.parseLong(((String)( TblCityTour.getValueAt(filaSeleccionada,1))));
        Ciudad myCiudad= myPaquete.buscarCiudad(idCiudad);
        CityTour myCiyTour =myCiudad.buscarCityTour(idCItyTour);
        myCiudad.removeComponent(myCiyTour);
        myPaquete.notificar();
        
    }//GEN-LAST:event_BtnEliminarCityTourActionPerformed
    @Override
    public void actualizar(AModel amodel) {
        inicializarTablaHoteles();
        inicializarTablaVuelos();
        inicializarTablaCityTours();
        inicializarTablaPlanesAlimentacion();
    }

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminarCityTour;
    private javax.swing.JButton BtnEliminarHotel;
    private javax.swing.JButton BtnEliminarPlanAlimentacion;
    private javax.swing.JButton BtnEliminarVuelo;
    private javax.swing.JScrollPane JSPCityTour;
    private javax.swing.JScrollPane JSPHoteles;
    private javax.swing.JScrollPane JSPPlanAlimentacion;
    private javax.swing.JScrollPane JSPVuelos;
    private javax.swing.JTable TblCityTour;
    private javax.swing.JTable TblHoteles;
    private javax.swing.JTable TblPlanAlimentacion;
    private javax.swing.JTable TblVuelos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

}
