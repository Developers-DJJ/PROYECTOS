package pe.edu.uni.kabestore.view;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.uni.kabestore.controller.VentaController;
import pe.edu.uni.kabestore.dto.PublicacionDto;
import pe.edu.uni.kabestore.dto.UsuarioDto;
import pe.edu.uni.kabestore.dto.VentaDto;
import pe.edu.uni.kabestore.util.Session;

public class VentaView extends javax.swing.JDialog {

    private VentaController controller;

    private DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public VentaView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        controller = new VentaController();
        this.tblVentas.setModel(model);

        model.addColumn("Id");
        model.addColumn("Cliente");
        model.addColumn("Fecha");
        model.addColumn("Id Empleado");
        model.addColumn("Id Publicacion");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        model.addColumn("Descuento");
        model.addColumn("Sub Total");
        model.addColumn("Impuesto");
        model.addColumn("Total");

        this.setLocationRelativeTo(this);

        try {
            cargarEmpleado();
            cargarComboPublicacion();
            //cargar ventas
            cargarVentas();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar combo: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtVenta = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        cboEmpleado = new javax.swing.JComboBox<>();
        cboPublicacion = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        txtImpuesto = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Ventas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 153))); // NOI18N

        txtVenta.setEditable(false);

        cboPublicacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPublicacionItemStateChanged(evt);
            }
        });
        cboPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPublicacionActionPerformed(evt);
            }
        });

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        txtPrecio.setEditable(false);

        txtDescuento.setEditable(false);

        txtSubTotal.setEditable(false);

        txtImpuesto.setEditable(false);

        txtTotal.setEditable(false);

        txtStock.setEditable(false);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/imgs/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/imgs/grabar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/imgs/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setToolTipText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Id Venta:");

        jLabel2.setText("Cliente:");

        jLabel3.setText("Fecha de Venta:");

        jLabel4.setText("Id Empleado:");

        jLabel5.setText("Id Publicación:");

        jLabel6.setText("Cantidad:");

        jLabel7.setText("Precio:");

        jLabel8.setText("Stock:");

        jLabel9.setText("Descuento:");

        jLabel10.setText("Sub Total:");

        jLabel11.setText("Impuesto:");

        jLabel12.setText("Total:");

        txtFecha.setEditable(false);

        jLabel13.setText("Ingrese cantidad, luego presione ENTER");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboPublicacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCliente)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtImpuesto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStock)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnNuevo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnGuardar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSalir)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo)
                            .addComponent(btnGuardar)
                            .addComponent(btnSalir))))
                .addGap(77, 77, 77))
        );

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblVentas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {
            if (txtCliente.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Ingrese nombre de cliente");
              return;
            }
            if (cboPublicacion.getSelectedItem()=="--Seleccionar Publicación--") {
                JOptionPane.showMessageDialog(null, "Seleccione publicación");
                return;
            }
            if (txtCantidad.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Ingrese Cantidad");
                return;
            }
            if (txtDescuento.getText().trim().length()==0) {
                JOptionPane.showMessageDialog(null, "precione enter en cantidad para calcular descuento");
                return;
            }
            VentaDto dto = new VentaDto();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            int stock = Integer.parseInt(txtStock.getText());

            if (stock == 0) {
                JOptionPane.showMessageDialog(null, "no hay stock");
            } else {
                if (cantidad > stock) {
                    JOptionPane.showMessageDialog(null, "No existe suficiente stock para la venta");
                } else {
                    int idEmpleado = Integer.parseInt(cboEmpleado.getSelectedItem().toString().split("-")[0].trim());
                    String idPublicacion = cboPublicacion.getSelectedItem().toString().split("-")[0].trim();
                    dto.setIdVenta(Integer.parseInt(txtVenta.getText()));
                    dto.setCliente(txtCliente.getText());

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    String date = txtFecha.getText();
                    LocalDate localDate = LocalDate.parse(date, formatter);

                    dto.setFecha(localDate);
                    dto.setIdEmpleado(idEmpleado);
                    dto.setIdPublicacion(idPublicacion);
                    dto.setCantidad(cantidad);

                    dto.setPrecio(Double.valueOf(txtPrecio.getText()));
                    dto.setDcto(Double.valueOf(txtDescuento.getText()));
                    dto.setSubTotal(Double.parseDouble(txtSubTotal.getText()));
                    dto.setImpuesto(Double.parseDouble(txtImpuesto.getText()));
                    dto.setTotal(Double.valueOf(txtTotal.getText()));
                    //JOptionPane.showMessageDialog(null, "se insertaron los datos correctamente ");
                    boolean Stock = controller.actualizarStock(cantidad, idPublicacion);

                    if (controller.insertarVenta(dto)) {
                        controller.sumVenta();
                        cargarVentas();
                        cargarComboPublicacion();
                        limpiar();
                        JOptionPane.showMessageDialog(null, "se insertaron los datos correctamente ");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se insertaron datos");
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error : " + e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cboPublicacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPublicacionItemStateChanged

        try {

            String idPublicacion = cboPublicacion.getSelectedItem().toString().split("-")[0].trim();

            PublicacionDto publicacion = controller.getPublicacionPorId(idPublicacion);
            txtStock.setText("" + publicacion.getStock());
            txtPrecio.setText("" + publicacion.getPrecio());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error : " + e.getMessage());
        }

    }//GEN-LAST:event_cboPublicacionItemStateChanged

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (txtCantidad.getText().length() == 0) {
                limpiar();
                txtCantidad.setEnabled(false);
            } else {
                int cantidad = Integer.parseInt(txtCantidad.getText());
                if (cantidad == 0) {
                    JOptionPane.showMessageDialog(null, "ingrese cantidad validad");
                } else {
                    cargarPromocion();
                }
            }
        }

    }//GEN-LAST:event_txtCantidadKeyReleased

    private void cboPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPublicacionActionPerformed
        if (cboPublicacion.getSelectedItem() == "--Seleccionar Publicación--") {
            txtCantidad.setEnabled(false);
            limpiar();
        } else {
         txtCantidad.setText("");
         txtImpuesto.setText("");
         txtSubTotal.setText("");
         txtTotal.setText("");
         txtDescuento.setText("");
         txtCantidad.setEnabled(true);
         txtCantidad.requestFocus();
            // cargarPromocion();
        }
    }//GEN-LAST:event_cboPublicacionActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txtCantidad.getText().trim().length() == Float.POSITIVE_INFINITY) {
            evt.consume();
        }        // TO
    }//GEN-LAST:event_txtCantidadKeyTyped

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
            java.util.logging.Logger.getLogger(VentaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                VentaView dialog = new VentaView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    //aqui se cerraba la ventanaaa
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboEmpleado;
    private javax.swing.JComboBox<String> cboPublicacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVenta;
    // End of variables declaration//GEN-END:variables

    private void cargarEmpleado() throws SQLException {
        UsuarioDto usuario = (UsuarioDto) Session.get("USUARIO");
        int i = usuario.getIdEmpleado();
        cboEmpleado.addItem(usuario.getIdEmpleado() + " - " + usuario.getApellido() + " " + usuario.getNombre());
    }

    public void cargarComboPublicacion() throws SQLException {
        cboPublicacion.addItem("--Seleccionar Publicación--");
        //cboPublicacion.removeAllItems();
        List<PublicacionDto> publicaciones = controller.listarPublicaciones();
        for (int i = 0; i < publicaciones.size(); i++) {
            cboPublicacion.addItem(publicaciones.get(i).getIdPublicacion() + " - " + publicaciones.get(i).getTitulo());
        }
    }

    private void cargarVentas() {

        try {
            txtCantidad.setEnabled(false);

            int idventa = controller.getIdventa();
            txtVenta.setText(String.valueOf(idventa));
            model.setRowCount(0);
            List<VentaDto> ventas = controller.listarVentas();
            for (int i = 0; i < ventas.size(); i++) {
                Object[] row = new Object[]{
                    ventas.get(i).getIdVenta(),
                    ventas.get(i).getCliente(),
                    ventas.get(i).getFecha(),
                    ventas.get(i).getIdEmpleado(),
                    ventas.get(i).getIdPublicacion(),
                    ventas.get(i).getCantidad(),
                    ventas.get(i).getPrecio(),
                    ventas.get(i).getDcto(),
                    ventas.get(i).getSubTotal(),
                    ventas.get(i).getImpuesto(),
                    ventas.get(i).getTotal(),};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error : " + e.getMessage());
        }
    }

    public void cargarPromocion() {
        try {

            VentaDto dto = new VentaDto();
            dto.setCantidad(Integer.parseInt(txtCantidad.getText()));
            dto.setPrecio(Double.parseDouble(txtPrecio.getText()));
            double igv = controller.getIgv();   
            VentaDto ventas = controller.calcular(dto, igv);

            txtDescuento.setText(String.valueOf(ventas.getDcto()));
            double porcentaje = ventas.getPorcentaje();

            if (porcentaje == 0.0) {
                JOptionPane.showMessageDialog(null, "usted no tiene descuento ");
            } else {
                JOptionPane.showMessageDialog(null, "promocion aplicada en: " + (porcentaje * 100) + " %");
            }
            DecimalFormat formato = new DecimalFormat("#0,00");
            txtSubTotal.setText(String.valueOf(ventas.getSubTotal()));
            txtImpuesto.setText(String.valueOf(formato.format(ventas.getImpuesto())));
            txtTotal.setText(String.valueOf(ventas.getTotal()));
//se muestra mensaje de error
        } catch (Exception e) {
            limpiar();
            JOptionPane.showMessageDialog(null, "Ingrese cantidad valida");
        }

    }

    public void limpiar() {
        txtCliente.setText("");
        txtCantidad.setText("");
        txtDescuento.setText("");
        txtSubTotal.setText("");
        txtImpuesto.setText("");
        txtTotal.setText("");
        txtPrecio.setText(null);
        txtStock.setText(null);
        cboEmpleado.setSelectedIndex(0);
        cboPublicacion.setSelectedItem("--Seleccionar Publicación--");

        fechaActual();

    }

    public void fechaActual() {

        SimpleDateFormat MI_FORMATO = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

        Date Ahora = new Date();
        txtFecha.setText(MI_FORMATO.format(Ahora));

    }

}