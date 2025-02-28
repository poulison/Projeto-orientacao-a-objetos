/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DAO.InvestidorDAO;
import DAO.Conexao;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Investidor;
import view.Sacar;

/**
 *
 * @author Paulo
 */
public class ControllerSacar {
    private Sacar view;
    private Investidor investidor;
    
    
    public ControllerSacar(Sacar view, Investidor investidor){
        this.view = view;
        this.investidor = investidor;
    }
    public Sacar getView() {
        return view;
    }

    public void setView(Sacar view) {
        this.view = view;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }
    
    
    public void saque(){
        String valorE = view.getTxtsaque().getText();
        double valor = Double.parseDouble(valorE);
        double saldo = investidor.getCarteira().getMoedas().get(0).getSaldo();
        System.out.println("saldo do investidor: " + investidor.getCarteira().getMoedas().get(0).getSaldo());
        double posdeposito = saldo - valor;
        System.out.println(posdeposito);
        if (posdeposito < 0){
            JOptionPane.showMessageDialog(view, "Saldo negativo");
            return;
        }
        else{
        investidor.getCarteira().getMoedas().get(0).setSaldo(posdeposito);
        Conexao conexao = new Conexao();
       try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            dao.atualizar(investidor);
            dao.geraExtratosac(investidor, valor);
            JOptionPane.showMessageDialog(view, "Saque feito!");
       }catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
        }
    
    }
}


