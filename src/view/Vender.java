/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.ControllerVendas;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Investidor;

/**
 *
 * @author Paulo
 */
public class Vender extends javax.swing.JFrame {

    /**
     * Creates new form Vender
     * @param investidor
     */
    public Vender(Investidor investidor) {
        initComponents();
        lblnome.setText(investidor.getNome());
        lblcpf.setText(investidor.getCPF());
        controller = new ControllerVendas(this, investidor);
        this.investidor = investidor;
    }

    public JButton getBtbit() {
        return btbit;
    }

    public void setBtbit(JButton btbit) {
        this.btbit = btbit;
    }

    public JButton getBteth() {
        return bteth;
    }

    public void setBteth(JButton bteth) {
        this.bteth = bteth;
    }

    public JButton getBtrip() {
        return btrip;
    }

    public void setBtrip(JButton btrip) {
        this.btrip = btrip;
    }

    public JButton getBtvoltar() {
        return btvoltar;
    }

    public void setBtvoltar(JButton btvoltar) {
        this.btvoltar = btvoltar;
    }

    public JLabel getLblcotab() {
        return lblcotab;
    }

    public void setLblcotab(JLabel lblcotab) {
        this.lblcotab = lblcotab;
    }

    public JLabel getLblcotaet() {
        return lblcotaet;
    }

    public void setLblcotaet(JLabel lblcotaet) {
        this.lblcotaet = lblcotaet;
    }

    public JLabel getLblcotarip() {
        return lblcotarip;
    }

    public void setLblcotarip(JLabel lblcotarip) {
        this.lblcotarip = lblcotarip;
    }

    public JLabel getLblcpf() {
        return lblcpf;
    }

    public void setLblcpf(JLabel lblcpf) {
        this.lblcpf = lblcpf;
    }

    public JLabel getLblnome() {
        return lblnome;
    }

    public void setLblnome(JLabel lblnome) {
        this.lblnome = lblnome;
    }

    public JTextField getTxtbit() {
        return txtbit;
    }

    public void setTxtbit(JTextField txtbit) {
        this.txtbit = txtbit;
    }

    public JTextField getTxteth() {
        return txteth;
    }

    public void setTxteth(JTextField txteth) {
        this.txteth = txteth;
    }

    public JTextField getTxtrip() {
        return txtrip;
    }

    public void setTxtrip(JTextField txtrip) {
        this.txtrip = txtrip;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txteth = new javax.swing.JTextField();
        txtrip = new javax.swing.JTextField();
        btbit = new javax.swing.JButton();
        bteth = new javax.swing.JButton();
        btrip = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btvoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtbit = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblnome = new javax.swing.JLabel();
        lblcpf = new javax.swing.JLabel();
        lblcotab = new javax.swing.JLabel();
        lblcotaet = new javax.swing.JLabel();
        lblcotarip = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btbit.setText("Vender");
        btbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbitActionPerformed(evt);
            }
        });

        bteth.setText("Vender");
        bteth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btethActionPerformed(evt);
            }
        });

        btrip.setText("Vender");
        btrip.setToolTipText("");
        btrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btripActionPerformed(evt);
            }
        });

        jLabel7.setText("Valor:");

        jLabel8.setText("Valor:");

        jLabel9.setText("Valor:");

        btvoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btvoltar.setText("Voltar");
        btvoltar.setToolTipText("");
        btvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btvoltarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Central de vendas");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Bitcoin");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Ethereum");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Ripple");

        txtbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbitActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Nome:");

        jLabel14.setText("CPF:");

        lblnome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblcpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblcpf))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblnome))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(lblcotab)
                                .addGap(184, 184, 184)
                                .addComponent(lblcotaet)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btrip)
                                    .addComponent(txtrip, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblcotarip)
                                    .addComponent(btvoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(81, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btbit)
                                    .addComponent(txtbit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addComponent(jLabel8))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txteth, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bteth)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(101, 101, 101)
                                .addComponent(jLabel4)))
                        .addGap(133, 133, 133))))
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblnome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblcpf))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcotab)
                    .addComponent(lblcotaet)
                    .addComponent(lblcotarip))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtbit, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txteth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btbit)
                    .addComponent(bteth)
                    .addComponent(btrip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(btvoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbitActionPerformed
    controller.venderBit();
    }//GEN-LAST:event_btbitActionPerformed

    private void btethActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btethActionPerformed
    controller.venderEth();
    }//GEN-LAST:event_btethActionPerformed

    private void btripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btripActionPerformed
    controller.venderRip();
    }//GEN-LAST:event_btripActionPerformed

    private void btvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btvoltarActionPerformed
    this.setVisible(false);
    }//GEN-LAST:event_btvoltarActionPerformed

    private void txtbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbitActionPerformed

    /**
     * @param args the command line arguments
     */
    private ControllerVendas controller;
    private Investidor investidor;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbit;
    private javax.swing.JButton bteth;
    private javax.swing.JButton btrip;
    private javax.swing.JButton btvoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblcotab;
    private javax.swing.JLabel lblcotaet;
    private javax.swing.JLabel lblcotarip;
    private javax.swing.JLabel lblcpf;
    private javax.swing.JLabel lblnome;
    private javax.swing.JTextField txtbit;
    private javax.swing.JTextField txteth;
    private javax.swing.JTextField txtrip;
    // End of variables declaration//GEN-END:variables
}
