/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Modelo.Aviso;
import Modelo.Parte;
import Modelo.Reparto;
import Modelo.Trabajador;
import Modelo.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class TodosLosPartes extends javax.swing.JFrame {

    /**
     * Creates new form TodosLosPartes
     */
    
    private DefaultTableModel dm;
    private ArrayList<Parte> partes = new ArrayList<>();
    private AdministrativoHome ah;
    private Trabajador tLogin=Usuario.getT();
    private Trabajador tParte=new Trabajador();
    private java.util.Date fecha;
    private BuscarTrabajador bt;
    private Parte p = new Parte();
    private VentanaParte vp;
    private int fila;
    private int id_trabajador;

    public void setBt(BuscarTrabajador bt) {
        this.bt = bt;
    }

    public AdministrativoHome getAh() {
        return ah;
    }

    public void setAh(AdministrativoHome ah) {
        this.ah = ah;
    }

    public void setDm(DefaultTableModel dm) {
        this.dm = dm;
    }

    public void setJtTrabajador(String id) {
        jtTrabajador.setText(id);
    }
          
    public TodosLosPartes() {
        initComponents();
        dm= (DefaultTableModel)jTable1.getModel();
        partes = Parte.todosPartes();
        for(Parte p : partes){
            String abierto;
            if(p.isAbierto()){
                abierto="Abierto";
            }else{
                abierto="Cerrado";
            }
            String validado;
            if(p.isValidado()){
                validado="Si";
            }else{
                validado="No";
            }
            dm.insertRow(dm.getRowCount(), new Object[]{p.getTrabajador()
                    .getId_trabajador(),p.getTrabajador().getNombre()+" "+
                    p.getTrabajador().getAp1(),p.getFecha(),p.getHorasTotales(),
                    abierto,validado
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jbCrearAviso = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jbFiltrarFecha = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbFiltrarFechaTra = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jbBuscarTra = new javax.swing.JButton();
        jtTrabajador = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlAviso = new javax.swing.JLabel();
        jdFechaIniSolo = new com.toedter.calendar.JDateChooser();
        jdFechaIniSolo2 = new com.toedter.calendar.JDateChooser();
        jdFechaFinSolo = new com.toedter.calendar.JDateChooser();
        jdFechaFinSolo2 = new com.toedter.calendar.JDateChooser();
        jbValidar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Trab.", "Trabajador", "Fecha", "Horas Totales", "Abierto", "Validado"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Listado de partes");

        jbCrearAviso.setText("Crear aviso");
        jbCrearAviso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearAvisoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jbFiltrarFecha.setText("Filtrar");
        jbFiltrarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFiltrarFechaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Filtrar partes por fecha");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Filtrar partes por fecha y trabajador");

        jLabel4.setText("Fecha inicio");

        jLabel5.setText("Fecha fin");

        jbFiltrarFechaTra.setText("Filtrar");
        jbFiltrarFechaTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFiltrarFechaTraActionPerformed(evt);
            }
        });

        jLabel6.setText("Trabajador");

        jbBuscarTra.setText("Buscar");
        jbBuscarTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarTraActionPerformed(evt);
            }
        });

        jtTrabajador.setEditable(false);
        jtTrabajador.setEnabled(false);

        jLabel7.setText("Fecha fin");

        jLabel8.setText("Fecha inicio");

        jlAviso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlAviso.setForeground(new java.awt.Color(0, 204, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbBuscarTra)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtTrabajador))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jdFechaFinSolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51)
                                                .addComponent(jbFiltrarFecha))
                                            .addComponent(jdFechaIniSolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 11, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdFechaFinSolo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdFechaIniSolo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(74, 84, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jlAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jbFiltrarFechaTra)
                                .addGap(17, 17, 17))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jdFechaIniSolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7))
                    .addComponent(jbFiltrarFecha)
                    .addComponent(jdFechaFinSolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addComponent(jdFechaIniSolo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jdFechaFinSolo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jbBuscarTra)
                    .addComponent(jtTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbFiltrarFechaTra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jlAviso)
                .addContainerGap())
        );

        jbValidar.setText("Validar parte");
        jbValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbValidarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar parte");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbBorrar.setText("Borrar parte");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbCrearAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(419, 419, 419))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbCrearAviso)
                            .addComponent(jbValidar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbModificar)
                            .addComponent(jbBorrar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        fila=jTable1.getSelectedRow();
        id_trabajador=Integer.parseInt(dm.getValueAt(fila,0).toString());
        tParte.setId_trabajador(id_trabajador);
        fecha = (java.util.Date) dm.getValueAt(fila, 2);       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jbCrearAvisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearAvisoActionPerformed
        Aviso a = new Aviso();
        a.setIdTrabajadorE(tLogin.getId_trabajador());
        a.setIdTrabajadorR(tParte.getId_trabajador());
        a.setParteFecha(fecha);
        a.setTexto("Revise el parte con fecha "+fecha+" ya que permanece abierto.");
        boolean correcto = a.guardarAviso();
        if(correcto){
            jlAviso.setText("Aviso creado");
        }
    }//GEN-LAST:event_jbCrearAvisoActionPerformed

    private void jbFiltrarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFiltrarFechaActionPerformed
        dm.setRowCount(0);
        dm= (DefaultTableModel)jTable1.getModel();
        partes = Parte.todosPartesFecha(jdFechaIniSolo.getDate(),jdFechaFinSolo.getDate());
        for(Parte p : partes){
            String abierto;
            if(p.isAbierto()){
                abierto="Abierto";
            }else{
                abierto="Cerrado";
            }
            dm.insertRow(dm.getRowCount(), new Object[]{p.getTrabajador().getId_trabajador(),p.getTrabajador().getNombre()+" "+p.getTrabajador().getAp1(),p.getFecha(),p.getHorasTotales(),abierto});
        }
    }//GEN-LAST:event_jbFiltrarFechaActionPerformed

    private void jbBuscarTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarTraActionPerformed
        bt = new BuscarTrabajador();
        bt.setTf(this);
        bt.setVisible(true);
    }//GEN-LAST:event_jbBuscarTraActionPerformed

    private void jbFiltrarFechaTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFiltrarFechaTraActionPerformed
        dm.setRowCount(0);
        dm= (DefaultTableModel)jTable1.getModel();
        partes = Parte.todosPartesFechaTra(jdFechaIniSolo2.getDate(),jdFechaFinSolo2.getDate(),Integer.parseInt(jtTrabajador.getText()));
        for(Parte p : partes){
            String abierto;
            if(p.isAbierto()){
                abierto="Abierto";
            }else{
                abierto="Cerrado";
            }
            dm.insertRow(dm.getRowCount(), new Object[]{p.getTrabajador().getId_trabajador(),p.getTrabajador().getNombre()+" "+p.getTrabajador().getAp1(),p.getFecha(),p.getHorasTotales(),abierto});
        }
    }//GEN-LAST:event_jbFiltrarFechaTraActionPerformed

    private void jbValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbValidarActionPerformed
        p.setFecha(fecha);
        p.setTrabajador(tParte);
        boolean correcto = p.validarParte();
        if(correcto){
            jlAviso.setText("Validado correctamente");
        }
    }//GEN-LAST:event_jbValidarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        String validado = dm.getValueAt(fila, 5).toString();
        if(validado.equalsIgnoreCase("No")){
            Parte a = Parte.verParte(fecha,id_trabajador);
            a.setVehiculo(Parte.getVehiculoSt());
            Trabajador t = new Trabajador();
            t.setId_trabajador(id_trabajador);

            vp = new VentanaParte();
            vp.setPRell(a);
            ArrayList<Modelo.Reparto> repartos = new ArrayList<>();
            repartos = (ArrayList<Reparto>) Parte.getRepartosSt();
            for(Modelo.Reparto r: repartos){
                vp.añadeReparto(r);
            }
            vp.setId(id_trabajador);
            vp.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Los partes validados no se pueden modificar");
        }  
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
       String validado = dm.getValueAt(fila, 5).toString();
        if(validado.equalsIgnoreCase("No")){
            boolean correcto = Parte.borrarParte(id_trabajador, fecha);
            if(correcto){
                jlAviso.setText("Validado correctamente");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Los partes validados no se pueden modificar");
        }  
    }//GEN-LAST:event_jbBorrarActionPerformed

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
            java.util.logging.Logger.getLogger(TodosLosPartes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TodosLosPartes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TodosLosPartes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TodosLosPartes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TodosLosPartes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbBuscarTra;
    private javax.swing.JButton jbCrearAviso;
    private javax.swing.JButton jbFiltrarFecha;
    private javax.swing.JButton jbFiltrarFechaTra;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbValidar;
    private com.toedter.calendar.JDateChooser jdFechaFinSolo;
    private com.toedter.calendar.JDateChooser jdFechaFinSolo2;
    private com.toedter.calendar.JDateChooser jdFechaIniSolo;
    private com.toedter.calendar.JDateChooser jdFechaIniSolo2;
    private javax.swing.JLabel jlAviso;
    private javax.swing.JTextField jtTrabajador;
    // End of variables declaration//GEN-END:variables
}
