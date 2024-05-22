/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Investidor;
import view.Contas;
import DAO.InvestidorDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Bitcoin;
import model.Carteira;
import model.Ethereum;
import model.Investidor;
import model.Moedas;
import model.Real;
import model.Ripple;
import view.SenhaVender;
import view.Vender;

/**
 *
 * @author Paulo
 */
public class ControllerSvenda {
    Contas s;
    private SenhaVender view;
    private Investidor investidor ;

    public ControllerSvenda(SenhaVender view, Investidor investidor, Contas s) {
        this.view = view;
        this.investidor = investidor;
        this.s = s;
    }
    public SenhaVender getView() {
        return view;
    }

    public void setView(SenhaVender view) {
        this.view = view;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestior(Investidor investidor) {
        this.investidor = investidor;
    }
    
    public void checar(){ 
       Investidor investidor = new Investidor(null, s.getLblcpf().getText(),
                view.getTxtsenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Senha confirmada!");
                String nome = res.getString("nome");
                String CPF = res.getString("cpf");
                String senha = res.getString("senha");
                double Real = res.getDouble("saldo_real");
                double Bitcoin = res.getDouble("saldo_btc");
                double Ethereum = res.getDouble("saldo_eth");
                double Ripple = res.getDouble("saldo_ripple");
                ArrayList<Moedas> moedas = new ArrayList<Moedas>();
                moedas.add(new Real(Real, 0.0));
                moedas.add(new Bitcoin(Bitcoin, 0.0000029));
                moedas.add(new Ethereum(Ethereum,0.000064));
                moedas.add(new Ripple(Ripple, 0.38));
                Carteira carteira = new Carteira(moedas);
                Vender v = new Vender(new Investidor(carteira, nome, CPF, senha));
                v.setVisible(true);
               
            } else { 
                JOptionPane.showMessageDialog(view, "Senha incorreta!");
                
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    } 
}
