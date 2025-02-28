package view;

import control.ControllerDeposito;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Investidor;

/**
 *
 * @author Paulo
 */
public class Depositar extends javax.swing.JFrame {
    
    
    public Depositar(Investidor investidor) {
        initComponents();
        lblcpf.setText(investidor.getCPF());
        controller = new ControllerDeposito(this, investidor);
        this.investidor = investidor;
        
    }

    public JLabel getLblcpf() {
        return lblcpf;
    }

    public void setLblcpf(JLabel lblcpf) {
        this.lblcpf = lblcpf;
    }
    
    
    public JButton getBtdeposito() {
        return btdeposito;
    }

    public void setBtdeposito(JButton btdeposito) {
        this.btdeposito = btdeposito;
    }

    public JTextField getTxtdeposito() {
        return txtdeposito;
    }

    public void setTxtdeposito(JTextField txtdeposito) {
        this.txtdeposito = txtdeposito;
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
        txtdeposito = new javax.swing.JTextField();
        btdeposito = new javax.swing.JButton();
        btsair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblcpf = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Depositar");

        jLabel2.setText("Insira o valor em reais:");

        txtdeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdepositoActionPerformed(evt);
            }
        });

        btdeposito.setText("Depositar");
        btdeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdepositoActionPerformed(evt);
            }
        });

        btsair.setText("voltar");
        btsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsairActionPerformed(evt);
            }
        });

        jLabel3.setText("CPF:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblcpf))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btdeposito)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btsair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtdeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblcpf))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtdeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btdeposito)
                    .addComponent(btsair))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdepositoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdepositoActionPerformed

    private void btdepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdepositoActionPerformed
    controller.depositos();
    
    }//GEN-LAST:event_btdepositoActionPerformed

    private void btsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsairActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_btsairActionPerformed

    /**
     * @param args the command line arguments
     */
     private ControllerDeposito controller;
     private Investidor investidor;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdeposito;
    private javax.swing.JButton btsair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblcpf;
    private javax.swing.JTextField txtdeposito;
    // End of variables declaration//GEN-END:variables
}
