/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Modelo.Parte;
import Modelo.Trabajador;
import Modelo.Vehiculo;
import java.awt.GraphicsConfiguration;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class VentanaParte extends javax.swing.JFrame {   
    private VentanaReparto vr;
    private Trabajador t;
    private Parte p;
    private Vehiculo v;
    private BuscarVehiculo bv;
    private int id;
    private DefaultTableModel model;
    private int fila;
    private List<Modelo.Reparto> repartos=new ArrayList<>();

    public void setJtVehiculo(String id) {
        this.jtVehiculo.setText(id);
    }
    

    public void recargarTabla() {
        model= (DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        repartos = p.getRepartos();
        for(Modelo.Reparto r:repartos){
            model.insertRow(model.getRowCount(), new Object[]{r.getAlbaran(),r.getHoraInicio(),r.getHoraFin()});
        }
    }
    
    public void añadeReparto(Modelo.Reparto r){
        repartos.add(r);
    }

    /**
     * Creates new form VentanaParte
     */
    
    public void setId(int id) {
        this.id = id;
    }

    public void setP(Parte p) {
        this.p = p;
    }

    public VentanaParte(GraphicsConfiguration gc) {
        super(gc);
    }
    public void setPRell(Parte p){
        this.p = p;
        rellenarForm();
        jbGuardar.setEnabled(false);
        jbUpdate.setEnabled(true);
        
    }

    public void setT(Trabajador t) {
        this.t = t;
    }
    
    public void rellenarForm(){
        if(p.getFecha()!=null){
            
            Double kmINI = p.getKmInicio();
            String kmINi = kmINI.toString();
            jtKmIni.setText(kmINi);
            Double kmFIN = p.getKmFin();
            String kmFin = kmFIN.toString();
            jtKmFin.setText(kmFin);
            Double gD = p.getGasoil();
            String g = gD.toString();
            jtGasoil.setText(g);
            Double aD = p.getAutopista();
            String a= aD.toString();
            jtAutopista.setText(a);
            Double dd = p.getDietas();
            String d = dd.toString();
            jtDietas.setText(d);
            Double od = p.getOtrosGastos();
            String o = od.toString();
            jtOtros.setText(o);
            jtIncidencias.setText(p.getIncidencias());
            Integer idv=p.getVehiculo().getIdVehiculo();
            String idVe=idv.toString();
            jtVehiculo.setText(idVe);
            recargarTabla();
        }
        
    }

    public VentanaParte() {
        initComponents();
        jbUpdate.setEnabled(false);
        jbGuardar.setEnabled(true);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbañadirRep = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtKmIni = new javax.swing.JTextField();
        jtKmFin = new javax.swing.JTextField();
        jtGasoil = new javax.swing.JTextField();
        jtAutopista = new javax.swing.JTextField();
        jtDietas = new javax.swing.JTextField();
        jtOtros = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtVehiculo = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtIncidencias = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbCerrar = new javax.swing.JButton();
        jlAviso = new javax.swing.JLabel();
        jbBorrarRep = new javax.swing.JButton();
        jbUpdate = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbañadirRep.setText("AÑADIR REPARTO");
        jbañadirRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbañadirRepActionPerformed(evt);
            }
        });

        jLabel1.setText("KM INICIALES");

        jLabel2.setText("KM FINALES");

        jLabel3.setText("GASOIL");

        jLabel4.setText("AUTOPISTA");

        jLabel5.setText("DIETAS");

        jLabel6.setText("OTROS GASTOS");

        jLabel7.setText("INCIDENCIAS");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("PARTE");

        jtKmFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtKmFinActionPerformed(evt);
            }
        });

        jtAutopista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtAutopistaActionPerformed(evt);
            }
        });

        jLabel10.setText("VEHICULO");

        jtVehiculo.setEditable(false);
        jtVehiculo.setEnabled(false);
        jtVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtVehiculoActionPerformed(evt);
            }
        });

        jbBuscar.setText("BUSCAR");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jtIncidencias.setColumns(20);
        jtIncidencias.setRows(5);
        jScrollPane1.setViewportView(jtIncidencias);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ALBARÁN", "HORA INICIO", "HORA FIN"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jbGuardar.setText("GUARDAR");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbCerrar.setText("CERRAR PARTE");
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });

        jlAviso.setForeground(new java.awt.Color(51, 255, 0));

        jbBorrarRep.setText("BORRAR REPARTO");
        jbBorrarRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarRepActionPerformed(evt);
            }
        });

        jbUpdate.setText("GUARDAR CAMBIOS");
        jbUpdate.setEnabled(false);
        jbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });

        jButton1.setText("CERRAR VENTANA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlAviso)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(119, 119, 119)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jbañadirRep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbBorrarRep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(119, 119, 119))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbBuscar)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtGasoil, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtKmIni)
                                    .addComponent(jtAutopista)
                                    .addComponent(jtDietas)
                                    .addComponent(jtOtros)
                                    .addComponent(jtKmFin)
                                    .addComponent(jtVehiculo)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(301, 301, 301)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbUpdate)
                                .addGap(74, 74, 74)
                                .addComponent(jbGuardar)
                                .addGap(68, 68, 68)
                                .addComponent(jbCerrar)
                                .addGap(103, 103, 103)
                                .addComponent(jButton1)))
                        .addGap(89, 89, 89))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtKmIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jtKmFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtGasoil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jtAutopista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtDietas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtOtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbañadirRep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBorrarRep)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbUpdate)
                    .addComponent(jbGuardar)
                    .addComponent(jbCerrar)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlAviso)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        bv=new BuscarVehiculo();
        bv.setVp(this);
        bv.setVisible(true);
       
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jtAutopistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtAutopistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtAutopistaActionPerformed

    private void jtKmFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtKmFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtKmFinActionPerformed

    private void jtVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtVehiculoActionPerformed

    private void jbañadirRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbañadirRepActionPerformed
        vr=new VentanaReparto();
        vr.setVp(this);
        vr.setVisible(true);
    }//GEN-LAST:event_jbañadirRepActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        p.setKmInicio(Double.parseDouble(jtKmIni.getText()));
        p.setKmFin(Double.parseDouble(jtKmFin.getText()));
        if(!jtGasoil.getText().equalsIgnoreCase("")){
            p.setGasoil(Double.parseDouble(jtGasoil.getText()));
        }
        if(!jtAutopista.getText().equalsIgnoreCase("")){
            p.setAutopista(Double.parseDouble(jtAutopista.getText()));
        }
        if(!jtDietas.getText().equalsIgnoreCase("")){
            p.setDietas(Double.parseDouble(jtDietas.getText()));
        }
        if(!jtOtros.getText().equalsIgnoreCase("")){
            p.setOtrosGastos(Double.parseDouble(jtOtros.getText()));
        }
        p.setIncidencias(jtIncidencias.getText());
        Date fecha= new Date();
        p.setFecha(fecha);
        boolean correcto=false;
        try {
            correcto = p.guardarParte(t.getId_trabajador(),Integer.parseInt(jtVehiculo.getText()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema \n" + ex.getMessage());        }
        if(correcto){
            jlAviso.setText("Guardado correctamente");
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
       t = Modelo.Usuario.getT();
        boolean correcto = p.cerrarParte();
        if(correcto){
            jlAviso.setText("Parte cerrado correctamente");
        }
    }//GEN-LAST:event_jbCerrarActionPerformed

    private void jbBorrarRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarRepActionPerformed
        p.getRepartos().remove(fila);
        model.removeRow(fila);
    }//GEN-LAST:event_jbBorrarRepActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        fila = jTable1.getSelectedRow();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
        p.setKmInicio(Double.parseDouble(jtKmIni.getText()));
        p.setKmFin(Double.parseDouble(jtKmFin.getText()));
        System.out.println(jtGasoil.getText());
        if(!jtGasoil.getText().equalsIgnoreCase("")){
            p.setGasoil(Double.parseDouble(jtGasoil.getText()));
        }
        if(!jtAutopista.getText().equalsIgnoreCase("")){
            p.setAutopista(Double.parseDouble(jtAutopista.getText()));
        }
        if(!jtDietas.getText().equalsIgnoreCase("")){
            p.setDietas(Double.parseDouble(jtDietas.getText()));
        }
        if(!jtOtros.getText().equalsIgnoreCase("")){
            p.setOtrosGastos(Double.parseDouble(jtOtros.getText()));
        }
        p.setIncidencias(jtIncidencias.getText());
        Date fecha= new Date();
        p.setFecha(fecha);
        boolean correcto=false;
        try {
            correcto = p.actualizarParte(id,Integer.parseInt(jtVehiculo.getText()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema \n" + ex.getMessage());
        }
        if(correcto){
            jlAviso.setText("Guardado correctamente");
        }
    }//GEN-LAST:event_jbUpdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
                                
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaParte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaParte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaParte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaParte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
          
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaParte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbBorrarRep;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JButton jbañadirRep;
    private javax.swing.JLabel jlAviso;
    private javax.swing.JTextField jtAutopista;
    private javax.swing.JTextField jtDietas;
    private javax.swing.JTextField jtGasoil;
    private javax.swing.JTextArea jtIncidencias;
    private javax.swing.JTextField jtKmFin;
    private javax.swing.JTextField jtKmIni;
    private javax.swing.JTextField jtOtros;
    private javax.swing.JTextField jtVehiculo;
    // End of variables declaration//GEN-END:variables
}
