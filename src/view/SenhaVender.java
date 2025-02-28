/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.ControllerSvenda;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Investidor;

/**
 *
 * @author Paulo
 */
public class SenhaVender extends javax.swing.JFrame {
    private Contas s;
    /**
     * Creates new form SenhaVender
     * @param s
     */
    public SenhaVender(Contas s) {
        initComponents();
        controller = new ControllerSvenda(this, investidor, s);
        this.s= s;
    }

    
    
    
    
    public JTextField getTxtsenha() {

        return Txtsenha;
    }

    public void setTxtsenha(JTextField Txtsenha) {
        this.Txtsenha = Txtsenha;
    }

    public JButton getBtsennha() {
        return btsennha;
    }

    public void setBtsennha(JButton btsennha) {
        this.btsennha = btsennha;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getLblsenha() {
        return lblsenha;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private Investidor investidor; 
    private ControllerSvenda controller;
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblsenha = new javax.swing.JLabel();
        Txtsenha = new javax.swing.JTextField();
        btsennha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Confirmação de identidade");

        lblsenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblsenha.setText("Senha:");

        btsennha.setText("Inserir");
        btsennha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsennhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblsenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btsennha)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsenha)
                    .addComponent(Txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btsennha)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btsennhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsennhaActionPerformed
        controller.checar();
        this.setVisible(false);
    }//GEN-LAST:event_btsennhaActionPerformed

    /**
     * @param args the command line arguments
     */
    

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Txtsenha;
    private javax.swing.JButton btsennha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblsenha;
    // End of variables declaration//GEN-END:variables
}
