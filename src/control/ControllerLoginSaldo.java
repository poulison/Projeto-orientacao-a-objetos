/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DAO.Conexao;
import model.Investidor;
import view.Menu;
import DAO.InvestidorDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Investidor;
import model.Moedas;
import view.Saldo;
/**
 *
 * @author unifphirata
 */
public class ControllerLoginSaldo {
    private Menu view;
    private Investidor investidor ;

    public ControllerLoginSaldo(Menu view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    public Menu getView() {
        return view;
    }

    public void setView(Menu view) {
        this.view = view;
    }

    public Investidor getAluno() {
        return investidor;
    }

    public void setAluno(Investidor investidor) {
        this.investidor = investidor;
    }
    
    public void checar(){ 
       
        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Login feito!");
                String nome = res.getString("nome");
                String CPF = res.getString("cpf");
                String senha = res.getString("senha");
                double Real = res.getDouble("saldo_real");
                double Bitcoin = res.getDouble("saldo_btc");
                double Ethereum = res.getDouble("saldo_eth");
                double Ripple = res.getDouble("saldo_ripple");
                ArrayList<Moedas> moedas = new ArrayList<Moedas>();
                Saldo s = new Saldo();
                s.setVisible(true);
               
            } else {
                JOptionPane.showMessageDialog(view, "Senha incorreta!");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
}
