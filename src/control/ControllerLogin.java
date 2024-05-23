
package control;

import DAO.InvestidorDAO;
import DAO.Conexao;
import view.Login;
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

import view.Menu;

public class ControllerLogin {
    private Login view;

    public ControllerLogin(Login view) {
        this.view = view;
    }
    
    public void LoginInvestidor(){
        Investidor investidor = new Investidor(null, view.getTxtCPF().getText(), 
                                      view.getTxtsenha().getText());   
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
                double cotasB = investidor.getCarteira().getMoedas().get(1).getCotas();
                double cotasE = investidor.getCarteira().getMoedas().get(2).getCotas();
                double cotasR = investidor.getCarteira().getMoedas().get(3).getCotas();
                moedas.add(new Real(Real, 0.0));
                moedas.add(new Bitcoin(Bitcoin, cotasB));
                moedas.add(new Ethereum(Ethereum,cotasE));
                moedas.add(new Ripple(Ripple, cotasR));
                Carteira carteira = new Carteira(moedas);
                Menu m = new Menu(new Investidor(carteira, nome,CPF,senha));
                m.setVisible(true);
                
                
            } else {
                JOptionPane.showMessageDialog(view, "Login nao foi efetuado!");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
}

