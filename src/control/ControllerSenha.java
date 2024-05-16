package control;

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
import view.Login;
import view.Saldo;
import view.Senha;

public class ControllerSenha {
    private Senha view;

    public ControllerSenha(Senha view) {
        this.view = view;
    }
    
    public void ConsultaSenha(Login l){
        Investidor investidor = new Investidor(null, l.getTxtCPF().getText(),
                view.getTxtsenha().getText());   
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.verificaSenha(investidor);
            if(res.next()){
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                double saldoReal = res.getDouble("saldo_real");
                double saldoBitcoin = res.getDouble("saldo_btc");
                double saldoEthereum = res.getDouble("saldo_eth");
                double saldoRipple = res.getDouble("saldo_ripple");
                
                ArrayList<Moedas> moedas = new ArrayList<Moedas>();
                moedas.add(new Real(saldoReal,0));
                moedas.add(new Bitcoin(saldoBitcoin,0.0000029));
                moedas.add(new Ethereum(saldoEthereum, 0.000064));
                moedas.add(new Ripple(saldoRipple, 0.38));
                
                Saldo sf = new Saldo();
                sf.getAreasaldo().append("CPF: " + cpf + "\n");
                for (int i = 0; i < moedas.size(); i++) {
                    Moedas moeda = moedas.get(i);
                    sf.getAreasaldo().append("Real: " + ": " + moeda.getSaldo() + "\n\n");
                    sf.getAreasaldo().append("BTC: " + ": " + moeda.getSaldo() + "\n\n");
                    sf.getAreasaldo().append("ETH: " + ": " + moeda.getSaldo() + "\n\n");
                    sf.getAreasaldo().append("Ripple: " + ": " + moeda.getSaldo() + "\n\n");
                }
                JOptionPane.showMessageDialog(view, "Login feito!");
                Saldo s = new Saldo();
                s.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(view, "Login nao foi efetuado!");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
}