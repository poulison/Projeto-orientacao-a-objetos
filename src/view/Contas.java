/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.ControllerContas;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.Investidor;

/**
 *
 * @author unifphirata
 */
public class Contas extends javax.swing.JFrame {
    private Investidor investidor;
    
    /**
     * Creates new form Contas
     * @param investidor
     */
    public Contas(Investidor investidor) {
        initComponents();
        lblnome.setText(investidor.getNome());
        lblcpf.setText(investidor.getCPF());
        controller = new ControllerContas(this, investidor);
        this.investidor = investidor;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public JButton getBtcomprar() {
        return btcomprar;
    }

    public void setBtcomprar(JButton btcomprar) {
        this.btcomprar = btcomprar;
    }

    public JButton getBtdepositar() {
        return btdepositar;
    }

    public void setBtdepositar(JButton btdepositar) {
        this.btdepositar = btdepositar;
    }

    public JButton getBtsacar() {
        return btsacar;
    }

    public void setBtsacar(JButton btsacar) {
        this.btsacar = btsacar;
    }

    public JButton getBtvender() {
        return btvender;
    }

    public void setBtvender(JButton btvender) {
        this.btvender = btvender;
    }

    public JButton getBtvoltar() {
        return btvoltar;
    }

    public void setBtvoltar(JButton btvoltar) {
        this.btvoltar = btvoltar;
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

    public JLabel getLblsenha() {
        return lblsenha;
    }

    public void setLblsenha(JLabel lblsenha) {
        this.lblsenha = lblsenha;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btdepositar = new javax.swing.JButton();
        btsacar = new javax.swing.JButton();
        btcomprar = new javax.swing.JButton();
        btvender = new javax.swing.JButton();
        btvoltar = new javax.swing.JButton();
        Nome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblnome = new javax.swing.JLabel();
        lblcpf = new javax.swing.JLabel();
        lblsenha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Operações");

        btdepositar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btdepositar.setText("Depositar");
        btdepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdepositarActionPerformed(evt);
            }
        });

        btsacar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btsacar.setText("Sacar");
        btsacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsacarActionPerformed(evt);
            }
        });

        btcomprar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btcomprar.setText("Comprar");
        btcomprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcomprarActionPerformed(evt);
            }
        });

        btvender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btvender.setText("Vender");
        btvender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btvenderActionPerformed(evt);
            }
        });

        btvoltar.setText("Voltar");
        btvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btvoltarActionPerformed(evt);
            }
        });

        Nome.setText("Nome");

        jLabel3.setText("CPF");

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
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btcomprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btdepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btvender, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btsacar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95)
                                .addComponent(btvoltar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblcpf))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Nome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblnome))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(lblsenha)))))
                .addGap(119, 119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nome)
                    .addComponent(lblnome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblcpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblsenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btvoltar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btdepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btcomprar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btvender, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btsacar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btdepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdepositarActionPerformed
        Depositar d = new Depositar(investidor);
        d.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btdepositarActionPerformed

    private void btsacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsacarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btsacarActionPerformed

    private void btcomprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcomprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btcomprarActionPerformed

    private void btvenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btvenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btvenderActionPerformed

    private void btvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btvoltarActionPerformed
    
    this.setVisible(false);
    }//GEN-LAST:event_btvoltarActionPerformed

    /**
     * @param args the command line arguments
     */
    private ControllerContas controller;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nome;
    private javax.swing.JButton btcomprar;
    private javax.swing.JButton btdepositar;
    private javax.swing.JButton btsacar;
    private javax.swing.JButton btvender;
    private javax.swing.JButton btvoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblcpf;
    private javax.swing.JLabel lblnome;
    private javax.swing.JLabel lblsenha;
    // End of variables declaration//GEN-END:variables
}
