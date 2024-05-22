/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DAO.Conexao;
import DAO.CotaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.Contas;

/**
 *
 * @author Paulo
 */
public class ControllerContas {
    private Contas view;
    private Investidor investidor; 
    
    public ControllerContas(Contas view, Investidor investidor){
        this.view = view;
        this.investidor = investidor;
    }
    public void atualizar(Investidor investidor){
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            CotaDAO dao = new CotaDAO(conn);
            dao.atualizarC(investidor);
            JOptionPane.showMessageDialog(view, "Atualizadas!");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro!");
        }
    }
    
    
}
