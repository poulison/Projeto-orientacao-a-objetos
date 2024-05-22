package control;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Investidor;
import view.Comprar;

/**
 *
 * @author Paulo
 */
public class ControllerCompras {
    private Comprar view;
    private Investidor investidor; 
    
    public ControllerCompras(Comprar view, Investidor investidor){
        this.view = view;
        this.investidor = investidor;
    }

    public Comprar getView() {
        return view;
    }

    public void setView(Comprar view) {
        this.view = view;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }
    
    
    public void comprarBit(){
        String valorE = view.getTxtbit().getText();
        double valor = Double.parseDouble(valorE);
        double saldoR = investidor.getCarteira().getMoedas().get(0).getSaldo();
        double cotacaoBit = investidor.getCarteira().getMoedas().get(1).getCotas();
        double saldoB = investidor.getCarteira().getMoedas().get(1).getSaldo();
        double taxaCompraB = 0.02;
        double reais = saldoR - valor;
        double compra = reais * cotacaoBit;
            if (compra < 0){
                JOptionPane.showMessageDialog(view, "Saldo insuficiente!");
                return;
            }
            double Diff = taxaCompraB * compra;
            double novoSaldoB = saldoB + Diff;
            investidor.getCarteira().getMoedas().get(0).setSaldo(reais);
            investidor.getCarteira().getMoedas().get(1).setSaldo(novoSaldoB);
            Conexao conexao = new Conexao();
                try{
                    Connection conn = conexao.getConnection();
                    InvestidorDAO dao = new InvestidorDAO(conn);
                    dao.atualizar(investidor);
                    dao.atualizarB(investidor);
                    JOptionPane.showMessageDialog(view, "Compra realizada!");
                }catch (SQLException e){
                    JOptionPane.showMessageDialog(view, "Erro de conexao!");
            }
        }
    
    
    
    public void comprarEth(){
        String valorE2 = view.getTxteth().getText();
        double valore = Double.parseDouble(valorE2);
        double saldoR = investidor.getCarteira().getMoedas().get(0).getSaldo();
        double cotacaoEt = investidor.getCarteira().getMoedas().get(2).getCotas();
        double saldoE = investidor.getCarteira().getMoedas().get(2).getSaldo();
        double taxaCompraE = 0.01;
        double reais = saldoR - valore;
        double compra = reais * cotacaoEt;
            if (compra < 0){
                JOptionPane.showMessageDialog(view, "Saldo insuficiente!");
                return;
            }
            double Diff = taxaCompraE * compra;
            double novoSaldoE = saldoE + Diff;
            investidor.getCarteira().getMoedas().get(0).setSaldo(reais);
            investidor.getCarteira().getMoedas().get(2).setSaldo(novoSaldoE);
            Conexao conexao = new Conexao();
                try{
                    Connection conn = conexao.getConnection();
                    InvestidorDAO dao = new InvestidorDAO(conn);
                    dao.atualizar(investidor);
                    dao.atualizarE(investidor);
                    JOptionPane.showMessageDialog(view, "Compra realizada!");
                }catch (SQLException e){
                    JOptionPane.showMessageDialog(view, "Erro de conexao!");
            }
        }
    
    public void comprarRip(){
        String valorE3 = view.getTxtrip().getText();
        double valor = Double.parseDouble(valorE3);
        double saldoR = investidor.getCarteira().getMoedas().get(0).getSaldo();
        double cotacaoRip = investidor.getCarteira().getMoedas().get(3).getCotas();
        double saldoRi = investidor.getCarteira().getMoedas().get(3).getSaldo();
        double taxaCompraRi = 0.01;
        double reais = saldoR - valor;
        double compra = reais * cotacaoRip;
            if (compra < 0){
                JOptionPane.showMessageDialog(view, "Saldo insuficiente!");
                return;
            }
            double Diff = taxaCompraRi * compra;
            double novoSaldoRi = saldoRi + Diff;
            investidor.getCarteira().getMoedas().get(0).setSaldo(reais);
            investidor.getCarteira().getMoedas().get(3).setSaldo(novoSaldoRi);
            Conexao conexao = new Conexao();
                try{
                    Connection conn = conexao.getConnection();
                    InvestidorDAO dao = new InvestidorDAO(conn);
                    dao.atualizar(investidor);
                    dao.atualizarR(investidor);
                    JOptionPane.showMessageDialog(view, "Compra realizada!");
                }catch (SQLException e){
                    JOptionPane.showMessageDialog(view, "Erro de conexao!");
            }
        }
}
