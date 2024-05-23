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
import model.Bitcoin;
import model.Ethereum;
import model.Investidor;
import model.Moedas;
import model.Ripple;
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
        double valorB = valor * cotacaoBit;
        
        Moedas bitItem = investidor.getCarteira().getMoedas().get(1);
        Bitcoin bitcoin = (Bitcoin) bitItem;
        double taxaVendaB = bitcoin.getTaxaVenda();
        
        double reais = saldoR + valor;
        double diff = valorB * (1 + taxaVendaB);
        double novoSaldoB = saldoB - diff;
        if(novoSaldoB < 0){
            JOptionPane.showMessageDialog(view, "Saldo negativo");
        } else {
            investidor.getCarteira().getMoedas().get(0).setSaldo(reais);
            investidor.getCarteira().getMoedas().get(1).setSaldo(novoSaldoB);
            Conexao conexao = new Conexao();
                try{
                    Connection conn = conexao.getConnection();
                    InvestidorDAO dao = new InvestidorDAO(conn);
                    dao.atualizar(investidor);
                    dao.atualizarB(investidor);
                    dao.geraExtratobitV(investidor, valor);
                    JOptionPane.showMessageDialog(view, "Venda realizada!");
                }catch (SQLException e){
                    JOptionPane.showMessageDialog(view, "Erro de conexao!");
                }
        }
    }
    
    
    public void venderEth(){
        String valorEx = view.getTxtbit().getText();
        double valor = Double.parseDouble(valorEx);
        double saldoR = investidor.getCarteira().getMoedas().get(0).getSaldo();
        double cotacaoEth = investidor.getCarteira().getMoedas().get(2).getCotas();
        double saldoE = investidor.getCarteira().getMoedas().get(2).getSaldo();
        double valorE = valor * cotacaoEth;
        
        Moedas ethItem = investidor.getCarteira().getMoedas().get(2);
        Ethereum ethereum = (Ethereum) ethItem;
        double taxaVendaE = ethereum.getTaxaVenda();
        
        double reais = saldoR + valor;
        double diff = valorE * (1 + taxaVendaE);
        double novoSaldoE = saldoE - diff;
        if(novoSaldoE < 0){
            JOptionPane.showMessageDialog(view, "Saldo negativo");
        } else {
            investidor.getCarteira().getMoedas().get(0).setSaldo(reais);
            investidor.getCarteira().getMoedas().get(2).setSaldo(novoSaldoE);
            Conexao conexao = new Conexao();
                try{
                    Connection conn = conexao.getConnection();
                    InvestidorDAO dao = new InvestidorDAO(conn);
                    dao.atualizar(investidor);
                    dao.atualizarE(investidor);
                    dao.geraExtratoethV(investidor, valor);
                    JOptionPane.showMessageDialog(view, "Venda realizada!");
                }catch (SQLException e){
                    JOptionPane.showMessageDialog(view, "Erro de conexao!");
                }
        }
    }
    
    public void venderRip(){
        String valorEx = view.getTxtbit().getText();
        double valor = Double.parseDouble(valorEx);
        double saldoR = investidor.getCarteira().getMoedas().get(0).getSaldo();
        double cotacaoRip = investidor.getCarteira().getMoedas().get(3).getCotas();
        double saldoRi = investidor.getCarteira().getMoedas().get(3).getSaldo();
        double valorRi = valor * cotacaoRip;
        
        Moedas ripItem = investidor.getCarteira().getMoedas().get(3);
        Ripple ripple = (Ripple) ripItem;
        double taxaVendaE = ripple.getTaxaVenda();
        
        double reais = saldoR + valor;
        double diff = valorRi * (1 + taxaVendaE);
        double novoSaldoRi = saldoRi - diff;
        if(novoSaldoRi < 0){
            JOptionPane.showMessageDialog(view, "Saldo negativo");
        } else {
            investidor.getCarteira().getMoedas().get(0).setSaldo(reais);
            investidor.getCarteira().getMoedas().get(3).setSaldo(novoSaldoRi);
            Conexao conexao = new Conexao();
                try{
                    Connection conn = conexao.getConnection();
                    InvestidorDAO dao = new InvestidorDAO(conn);
                    dao.atualizar(investidor);
                    dao.atualizarR(investidor);
                    dao.geraExtratoripV(investidor, valor);
                    JOptionPane.showMessageDialog(view, "Venda realizada!");
                }catch (SQLException e){
                    JOptionPane.showMessageDialog(view, "Erro de conexao!");
                }
        }
    }
}
