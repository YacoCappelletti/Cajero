package cliente;

import datos.TransaccionDAO;
import dominio.Cliente;
import dominio.Transaccion;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import javax.swing.JOptionPane;


public class RetirarForm extends javax.swing.JFrame {
    
    private Cliente cliente;
    private List<Transaccion> transacciones;
    private double saldo;
    public RetirarForm(Cliente cliente) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cliente = cliente;
        this.saldo = 0;
        
        TransaccionDAO transaccionDAO = new TransaccionDAO();
        transacciones = transaccionDAO.filtrar(cliente.getId());
        
        for(Transaccion e : transacciones){
            if(e.getTipo().equals("ingreso")){
                saldo += e.getMonto();
            }
            else if (e.getTipo().equals("retiro")){
                saldo -= e.getMonto();
            }
        }
        saldoText.setText(String.valueOf(saldo));
        
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        montoText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        saldoText = new javax.swing.JTextField();
        cancelarBtn = new javax.swing.JButton();
        retirarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 300));
        setPreferredSize(new java.awt.Dimension(300, 300));
        setResizable(false);
        setSize(new java.awt.Dimension(300, 300));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Monto a retirar");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 140, 170, 30);

        montoText.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(montoText);
        montoText.setBounds(20, 170, 260, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Saldo de su cuenta");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 50, 170, 30);

        saldoText.setEditable(false);
        saldoText.setBackground(new java.awt.Color(255, 255, 255));
        saldoText.setForeground(new java.awt.Color(0, 0, 0));
        saldoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saldoTextActionPerformed(evt);
            }
        });
        getContentPane().add(saldoText);
        saldoText.setBounds(20, 80, 260, 30);

        cancelarBtn.setText("Cancelar");
        cancelarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(cancelarBtn);
        cancelarBtn.setBounds(20, 220, 90, 40);

        retirarBtn.setText("Retirar");
        retirarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retirarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retirarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(retirarBtn);
        retirarBtn.setBounds(190, 220, 90, 40);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yaco\\Desktop\\Proyectos Portfolio\\CajeroAutomatico\\src\\main\\java\\imagenes\\imagenFondo.jpg")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 300, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void retirarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retirarBtnActionPerformed
        TransaccionDAO transaccionDAO = new TransaccionDAO();
        
        
        if(montoText.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe indicar el monto que desea retirar.", "Ocurrió un evento inesperado", JOptionPane.ERROR_MESSAGE);
        }
        else{
            double monto = Double.valueOf(montoText.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String fecha = sdf.format(date);

            
            if((saldo - monto) < 0){
                JOptionPane.showMessageDialog(null, "No dispone de saldo suficiente en su cuenta.", "Ocurrió un evento inesperado", JOptionPane.ERROR_MESSAGE);
            }
            else{

                Transaccion transaccion = new Transaccion(cliente.getId(),fecha,"retiro",monto);
                transaccionDAO.insertar(transaccion);
                JOptionPane.showMessageDialog(null, "La transacción se realizó de forma correcta.", "Mensaje informativo", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();

            }
        }
        
      
        
       
        
    }//GEN-LAST:event_retirarBtnActionPerformed

    private void saldoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saldoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saldoTextActionPerformed

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
//            java.util.logging.Logger.getLogger(RetirarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RetirarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RetirarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RetirarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RetirarForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField montoText;
    private javax.swing.JButton retirarBtn;
    private javax.swing.JTextField saldoText;
    // End of variables declaration//GEN-END:variables
}
