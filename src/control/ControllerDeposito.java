
package control;

import DAO.InvestidorDAO;
import DAO.Conexao;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Investidor;
import view.Depositar;


public class ControllerDeposito {
    private Depositar view;
    private Investidor investidor;
    
    public ControllerDeposito(Depositar view, Investidor investidor){
        this.view = view;
        this.investidor = investidor;
        
    }

    public Depositar getView() {
        return view;
    }

    public void setView(Depositar view) {
        this.view = view;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }
    
    
    public void depositos(){
        String valorE = view.getTxtdeposito().getText();
        double valor = Double.parseDouble(valorE);
        double saldo = investidor.getCarteira().getMoedas().get(0).getSaldo();
        double posdeposito = saldo + valor;
        investidor.getCarteira().getMoedas().get(0).setSaldo(posdeposito);
        Conexao conexao = new Conexao();
       try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            dao.atualizar(investidor);
            dao.geraExtratodep(investidor, valor);
            JOptionPane.showMessageDialog(view, "Deposito feito!");
       }catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
  }
        
    
