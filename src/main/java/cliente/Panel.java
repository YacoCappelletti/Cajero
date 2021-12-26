
package cliente;

import dominio.Cliente;


public class Panel extends javax.swing.JFrame {
    
    private Cliente cliente;
    
    public Panel(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        this.setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saldoBtn = new javax.swing.JButton();
        salirBtn = new javax.swing.JButton();
        retirarBtn = new javax.swing.JButton();
        ingresarBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        saldoBtn.setText("Consultar saldo y movimientos");
        saldoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saldoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saldoBtnActionPerformed(evt);
            }
        });
        getContentPane().add(saldoBtn);
        saldoBtn.setBounds(430, 120, 210, 130);

        salirBtn.setText("Salir");
        salirBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });
        getContentPane().add(salirBtn);
        salirBtn.setBounds(430, 270, 210, 130);

        retirarBtn.setText("Retirar dinero");
        retirarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retirarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retirarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(retirarBtn);
        retirarBtn.setBounds(170, 120, 210, 130);

        ingresarBtn.setText("Ingresar dinero a la cuenta");
        ingresarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ingresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(ingresarBtn);
        ingresarBtn.setBounds(170, 270, 210, 130);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bienvenido, ¿que operación desea realizar?");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 20, 800, 40);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yaco\\Desktop\\Proyectos Portfolio\\CajeroAutomatico\\src\\main\\java\\imagenes\\imagenFondo.jpg")); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setMaximumSize(new java.awt.Dimension(800, 500));
        jLabel1.setMinimumSize(new java.awt.Dimension(800, 500));
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saldoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saldoBtnActionPerformed
        Resumen resumen = new Resumen(cliente);
        resumen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_saldoBtnActionPerformed

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();;
    }//GEN-LAST:event_salirBtnActionPerformed

    private void ingresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarBtnActionPerformed
        IngresarForm ingresar = new IngresarForm(cliente);
        ingresar.setVisible(true);
    }//GEN-LAST:event_ingresarBtnActionPerformed

    private void retirarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retirarBtnActionPerformed
        RetirarForm retirar = new RetirarForm(cliente);
        retirar.setVisible(true);
    }//GEN-LAST:event_retirarBtnActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Panel().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ingresarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton retirarBtn;
    private javax.swing.JButton saldoBtn;
    private javax.swing.JButton salirBtn;
    // End of variables declaration//GEN-END:variables
}
