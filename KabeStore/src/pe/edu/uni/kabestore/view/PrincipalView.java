package pe.edu.uni.kabestore.view;

import pe.edu.uni.kabestore.dto.UsuarioDto;
import pe.edu.uni.kabestore.util.Session;

public class PrincipalView extends javax.swing.JFrame { 
    
    public PrincipalView() {
        initComponents();
        establecerTitulo();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(this);
  
    }

    private void establecerTitulo(){
        UsuarioDto usuario = (UsuarioDto) Session.get("USUARIO");
        String titulo = "Venta de libre ::: Usuario : " + usuario.getNombre()+" " + usuario.getApellido();
        this.setTitle(titulo);
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menuConsultaPublicacion = new javax.swing.JMenuBar();
        itemVentas = new javax.swing.JMenu();
        itemsVenta = new javax.swing.JMenuItem();
        itemConsultaPublicacion = new javax.swing.JMenuItem();
        itemRegistroPublicacion = new javax.swing.JMenuItem();
        itemConsultaVentas = new javax.swing.JMenuItem();
        itemControl = new javax.swing.JMenuItem();
        mnSalir = new javax.swing.JMenu();
        itemCerrarSesion = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(73, 181, 172));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\UNIVERSIDAD\\PROGRAMACION CON JAVA\\PROYECTOS\\KabeStore\\iconos\\KABESTORE.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        itemVentas.setText("Procesos");

        itemsVenta.setText("Ventas");
        itemsVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemsVentaActionPerformed(evt);
            }
        });
        itemVentas.add(itemsVenta);

        itemConsultaPublicacion.setText("Consulta Publicación Por Tipo");
        itemConsultaPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultaPublicacionActionPerformed(evt);
            }
        });
        itemVentas.add(itemConsultaPublicacion);

        itemRegistroPublicacion.setText("Mantenimiento Publicación");
        itemRegistroPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistroPublicacionActionPerformed(evt);
            }
        });
        itemVentas.add(itemRegistroPublicacion);

        itemConsultaVentas.setText("Consulta Ventas");
        itemConsultaVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultaVentasActionPerformed(evt);
            }
        });
        itemVentas.add(itemConsultaVentas);

        itemControl.setText("Control");
        itemControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemControlActionPerformed(evt);
            }
        });
        itemVentas.add(itemControl);

        menuConsultaPublicacion.add(itemVentas);

        mnSalir.setText("Salir");

        itemCerrarSesion.setText("Cerrar sesión");
        itemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarSesionActionPerformed(evt);
            }
        });
        mnSalir.add(itemCerrarSesion);

        menuConsultaPublicacion.add(mnSalir);

        setJMenuBar(menuConsultaPublicacion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemConsultaPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultaPublicacionActionPerformed
        
        ConsultaPublicacionPorTipoView.main();
        // TODO add your handling code here:
    }//GEN-LAST:event_itemConsultaPublicacionActionPerformed

    private void itemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarSesionActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemCerrarSesionActionPerformed

    private void itemsVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemsVentaActionPerformed

        
             VentaView.main(null);
    }//GEN-LAST:event_itemsVentaActionPerformed

    private void itemRegistroPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistroPublicacionActionPerformed
       
        MantenimientoPublicacionView.main(null);
    }//GEN-LAST:event_itemRegistroPublicacionActionPerformed

    private void itemConsultaVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultaVentasActionPerformed

        ConsultaVentaView.main(null);
    }//GEN-LAST:event_itemConsultaVentasActionPerformed

    private void itemControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemControlActionPerformed
      ControlView.main(null);
    }//GEN-LAST:event_itemControlActionPerformed

    public static void main(String args[]) {
//UsuarioDto usuariodto
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
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemCerrarSesion;
    private javax.swing.JMenuItem itemConsultaPublicacion;
    private javax.swing.JMenuItem itemConsultaVentas;
    private javax.swing.JMenuItem itemControl;
    private javax.swing.JMenuItem itemRegistroPublicacion;
    private javax.swing.JMenu itemVentas;
    private javax.swing.JMenuItem itemsVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menuConsultaPublicacion;
    private javax.swing.JMenu mnSalir;
    // End of variables declaration//GEN-END:variables


}
