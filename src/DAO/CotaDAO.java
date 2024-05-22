/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Random;
import model.Investidor;
import model.Moedas;
/**
 *
 * @author Paulo
 */
public class CotaDAO {
    private Connection conn;
    ArrayList<Moedas> moedas = new ArrayList<Moedas>();
    
    public CotaDAO(Connection conn) {
        this.conn = conn;
    }


    public void atualizarC(Investidor investidor) throws SQLException{
        String sql = "update moedas set bitcoin = ?, ethereum = ?, ripple = ?";
        double cotacaoBit = investidor.getCarteira().getMoedas().get(1).getCotas();
        double cotacaoEth = investidor.getCarteira().getMoedas().get(2).getCotas();
        double cotacaoRip = investidor.getCarteira().getMoedas().get(3).getCotas();
        PreparedStatement statement = conn.prepareStatement(sql);
        Random random = new Random();
        double variacaoBit = random.nextDouble() * 0.1 - 0.05; // Variação de ±5%
        double variacaoEth = random.nextDouble() * 0.1 - 0.05; // Variação de ±5%
        double variacaoRip = random.nextDouble() * 0.1 - 0.05; // Variação de ±5%
        
        double cotacaoBitAtualizada = cotacaoBit * (1 + variacaoBit);
        double cotacaoEthAtualizada = cotacaoEth * (1 + variacaoEth);
        double cotacaoRipAtualizada = cotacaoRip * (1 + variacaoRip);
        
        statement.setDouble(1, cotacaoBitAtualizada);
        statement.setDouble(2, cotacaoEthAtualizada);
        statement.setDouble(3, cotacaoRipAtualizada);
        statement.execute();
        conn.close();
    }
    
    public void gerar(Investidor investidor) throws SQLException{
        String sql1 = "INSERT INTO moedas(\n"+
        "id, bitcoin, ethereum, riple)"+
        "VALUES(1, 358097.15, 19417.20, 2.60);";
        PreparedStatement statement1 = conn.prepareStatement(sql1);
        statement1.execute();
    }

}



