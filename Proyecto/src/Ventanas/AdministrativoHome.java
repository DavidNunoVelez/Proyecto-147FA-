/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventanas;

/**
 *
 * @author sirlocus
 */
public class AdministrativoHome extends javax.swing.JFrame {

    private CentroFormulario cf;
    private CentroDetalle cd;
    private CentroListado cl;
    private TrabajadorFormulario tf;
    private TrabajadorDetalle td;
    private TrabajadorListado tl;
    private VehiculoFormulario vf;
    private VehiculoListado vl;
    /** Creates new form AdministrativoHome */
    public AdministrativoHome() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jltitulo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmNuevoCen = new javax.swing.JMenuItem();
        jmTrabaCentro = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmNuevoTrab = new javax.swing.JMenuItem();
        jmListarTrab = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmNuevoUsu = new javax.swing.JMenuItem();
        jmDetalleUsu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jltitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo.setText("Bienvenido ");

        jMenu1.setText("Centros");

        jmNuevoCen.setText("Nuevo centro");
        jmNuevoCen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmNuevoCenActionPerformed(evt);
            }
        });
        jMenu1.add(jmNuevoCen);

        jmTrabaCentro.setText("Listado centros");
        jmTrabaCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmTrabaCentroActionPerformed(evt);
            }
        });
        jMenu1.add(jmTrabaCentro);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Trabajadores");

        jmNuevoTrab.setText("Nuevo trabajador");
        jmNuevoTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmNuevoTrabActionPerformed(evt);
            }
        });
        jMenu2.add(jmNuevoTrab);

        jmListarTrab.setText("Listar trabajadores");
        jmListarTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmListarTrabActionPerformed(evt);
            }
        });
        jMenu2.add(jmListarTrab);
        jMenu2.add(jSeparator2);

        jmNuevoUsu.setText("Nuevo usuario");
        jMenu2.add(jmNuevoUsu);

        jmDetalleUsu.setText("Detalle usuario");
        jMenu2.add(jmDetalleUsu);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Vehículos");

        jMenuItem1.setText("Nuevo Vehículo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Listar Vehículo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(340, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(348, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmNuevoCenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmNuevoCenActionPerformed
        cf = new CentroFormulario();
        cf.setVisible(true);
    }//GEN-LAST:event_jmNuevoCenActionPerformed

    private void jmTrabaCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmTrabaCentroActionPerformed
        cl = new CentroListado();
        cl.setVisible(true);
    }//GEN-LAST:event_jmTrabaCentroActionPerformed

    private void jmNuevoTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmNuevoTrabActionPerformed
        tf = new TrabajadorFormulario();
        tf.setVisible(true);
    }//GEN-LAST:event_jmNuevoTrabActionPerformed

    private void jmListarTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmListarTrabActionPerformed
        tl = new TrabajadorListado();
        tl.setVisible(true);
    }//GEN-LAST:event_jmListarTrabActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        vf= new VehiculoFormulario();
        vf.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        vl=new VehiculoListado();
        vl.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(AdministrativoHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministrativoHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministrativoHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministrativoHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministrativoHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel jltitulo;
    private javax.swing.JMenuItem jmDetalleUsu;
    private javax.swing.JMenuItem jmListarTrab;
    private javax.swing.JMenuItem jmNuevoCen;
    private javax.swing.JMenuItem jmNuevoTrab;
    private javax.swing.JMenuItem jmNuevoUsu;
    private javax.swing.JMenuItem jmTrabaCentro;
    // End of variables declaration//GEN-END:variables

}
