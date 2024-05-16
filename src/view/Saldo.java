
package view;



import javax.swing.JButton;
import javax.swing.JTextArea;

        
    
/**
 *
 * @author unifphirata
 */
public class Saldo extends javax.swing.JFrame {
    /**
     * Creates new form Saldo
     */
    public Saldo() {
        initComponents();
        
        
    }
    
    public JTextArea getAreasaldo() {
        return areasaldo;
    }

    public void setAreasaldo(JTextArea areasaldo) {
        this.areasaldo = areasaldo;
    }

    public JButton getBtextrato() {
        return btextrato;
    }

    public void setBtextrato(JButton btextrato) {
        this.btextrato = btextrato;
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
        btextrato = new javax.swing.JButton();
        btsair = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        areasaldo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Saldo");

        btextrato.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btextrato.setText("Extrato");
        btextrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btextratoActionPerformed(evt);
            }
        });

        btsair.setText("Voltar");
        btsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsairActionPerformed(evt);
            }
        });

        areasaldo.setColumns(20);
        areasaldo.setRows(5);
        jScrollPane2.setViewportView(areasaldo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btsair)
                    .addComponent(btextrato))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 92, Short.MAX_VALUE)
                        .addComponent(btextrato)
                        .addGap(90, 90, 90)
                        .addComponent(btsair))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btextratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btextratoActionPerformed
        ConsultarExtrato e = new ConsultarExtrato();
        e.setVisible(true);
    }//GEN-LAST:event_btextratoActionPerformed

    private void btsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsairActionPerformed
        Menu m = new Menu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btsairActionPerformed
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areasaldo;
    private javax.swing.JButton btextrato;
    private javax.swing.JButton btsair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
