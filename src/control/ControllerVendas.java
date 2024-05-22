/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Investidor;
import view.Vender;

/**
 *
 * @author Paulo
 */
public class ControllerVendas {
    private Vender view;
    private Investidor investidor; 
    
    public ControllerVendas(Vender view, Investidor investidor){
        this.view = view;
        this.investidor = investidor;
    }

    public Vender getView() {
        return view;
    }

    public void setView(Vender view) {
        this.view = view;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }
    
    
    public void venderBit(){
        String valorE = view.getTxtbit().getText();
        double valor = Double.parseDouble(valorE);
        double saldoR = investidor.getCarteira().getMoedas().get(0).getSaldo();
        double cotacaoBit = investidor.getCarteira().getMoedas().get(1).getCotas();
        double saldoB = investidor.getCarteira().getMoedas().get(1).getSaldo();
        double taxaVendaB = 0.03;
        double reais = saldoR + valor;
        double venda = reais * cotacaoBit;
                 if (saldoB < 0){
                JOptionPane.showMessageDialog(view, "Saldo insuficiente!");
                return;
            }
            double Diff = taxaVendaB * venda;
            double novoSaldoB = saldoB - Diff;
            investidor.getCarteira().getMoedas().get(0).setSaldo(reais);
            investidor.getCarteira().getMoedas().get(1).setSaldo(novoSaldoB);
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
    
    
    public void venderEth(){
        String valorE2 = view.getTxteth().getText();
        double valore = Double.parseDouble(valorE2);
        double saldoR = investidor.getCarteira().getMoedas().get(0).getSaldo();
        double cotacaoEt = investidor.getCarteira().getMoedas().get(2).getCotas();
        double saldoE = investidor.getCarteira().getMoedas().get(2).getSaldo();
        double taxaVendaE = 0.02;
        double reais = saldoR + valore;
        double venda = reais * cotacaoEt;
                 if (saldoE < 0){
                JOptionPane.showMessageDialog(view, "Saldo insuficiente!");
                return;
            }
            double Diff = taxaVendaE * venda;
            double novoSaldoE = saldoE - Diff;
            investidor.getCarteira().getMoedas().get(0).setSaldo(reais);
            investidor.getCarteira().getMoedas().get(2).setSaldo(novoSaldoE);
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
    
    public void venderRip(){
        String valorE3 = view.getTxtrip().getText();
        double valor = Double.parseDouble(valorE3);
        double saldoR = investidor.getCarteira().getMoedas().get(0).getSaldo();
        double cotacaoRip = investidor.getCarteira().getMoedas().get(3).getCotas();
        double saldoRi = investidor.getCarteira().getMoedas().get(3).getSaldo();
        double taxaVendaRi = 0.01;
        double reais = saldoR + valor;
        double venda = reais * cotacaoRip;
            if (saldoRi < 0){
                JOptionPane.showMessageDialog(view, "Saldo insuficiente!");
                return;
            }
            double Diff = taxaVendaRi * venda;
            double novoSaldoRi = saldoRi - Diff;
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
