/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cliente;

import datos.ClienteDAO;
import dominio.Cliente;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Yaco
 */
public class Registro extends javax.swing.JFrame {

    /**
     * Creates new form LoginUI
     */
    public Registro() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usuarioText = new javax.swing.JTextField();
        passwordText = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        registroBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 500));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Contraseña");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 200, 200, 60);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Usuario");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 110, 200, 60);

        usuarioText.setBackground(new java.awt.Color(255, 255, 255));
        usuarioText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioTextActionPerformed(evt);
            }
        });
        getContentPane().add(usuarioText);
        usuarioText.setBounds(50, 160, 300, 40);

        passwordText.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(passwordText);
        passwordText.setBounds(50, 250, 300, 40);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Registro");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 30, 400, 50);

        registroBtn.setText("Registrarse");
        registroBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroBtnActionPerformed(evt);
            }
        });
        getContentPane().add(registroBtn);
        registroBtn.setBounds(230, 400, 120, 40);

        cancelarBtn.setText("Cancelar");
        cancelarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(cancelarBtn);
        cancelarBtn.setBounds(40, 400, 120, 40);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yaco\\Desktop\\Proyectos Portfolio\\CajeroAutomatico\\src\\main\\java\\imagenes\\imagenFondo.jpg")); // NOI18N
        jLabel3.setToolTipText("");
        jLabel3.setPreferredSize(new java.awt.Dimension(400, 500));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 400, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTextActionPerformed

    private void registroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroBtnActionPerformed
        //Login rudimentario
        Cliente cliente = null;
        boolean existe = false;
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> clientes = clienteDAO.seleccionar();
        String usuario = this.usuarioText.getText();
        String password = this.passwordText.getText();
        
        
        if(usuario.equals("") || password.equals("") ){
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos", "Ocurrió un evento inesperado", JOptionPane.ERROR_MESSAGE);
        }
        else{
            for( Cliente e : clientes){
                if(e.getUsuario().equals(usuario) && e.getContraseña().equals(password)){
                    
                    JOptionPane.showMessageDialog(null, "Ya existe una cuenta con ese nombre, pruebe con uno diferente ", "Ocurrió un evento inesperado", JOptionPane.ERROR_MESSAGE);
                    existe = true; 
                }
            }  
            
            if( !existe){
                cliente = new Cliente(usuario, password, 0.0);
                clienteDAO.insertar(cliente);
                JOptionPane.showMessageDialog(null, "Su cuenta fue creada exitosamente", "Mensaje de bienvenida", JOptionPane.INFORMATION_MESSAGE);
                Login login = new Login();
                login.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_registroBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JButton registroBtn;
    private javax.swing.JTextField usuarioText;
    // End of variables declaration//GEN-END:variables
}